package com.ilonw.file.controller;

import com.ilonw.file.base.BaseController;
import com.ilonw.server.SysIlonwTableFileFacade;
import com.ilonw.server.bo.TableFileBO;
import com.ilonw.server.bo.TableIlonwFileBO;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.server.tools.date.DateUtil;
import com.server.tools.ftp.SFTPChannel;
import com.server.tools.ftp.SFTPUtil;
import com.server.tools.result.APIBaseResult;
import com.server.tools.util.UUIDUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/uploadFile")
public class UploadController extends BaseController {

	@Resource
	private SysIlonwTableFileFacade sysIlonwTableFileFacade;
	
	//获取ip地址  
    @Value("${FTP_ADDRESS}")  
    private String FTP_ADDRESS;  
    //端口号  
    @Value("${FTP_PORT}")  
    private String FTP_PORT;  
    //用户名  
    @Value("${FTP_USERNAME}")  
    private String FTP_USERNAME;  
    //密码  
    @Value("${FTP_PASSWORD}")  
    private String FTP_PASSWORD;  
    //基本路径  
    @Value("${FTP_BASEPATH}")  
    private String FTP_BASEPATH;  
	
	public SFTPChannel getSFTPChannel() {
        return new SFTPChannel();
    }
	
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/addfishcontent", method = RequestMethod.POST)
	@ApiOperation(value="保存文件基本信息接口", notes="文件基本信息接口详细描述")
	public APIBaseResult addFishContent(String title, String context,HttpServletRequest requestIp) throws Exception {
		long now = System.currentTimeMillis();
		TableIlonwFileBO tableFile = new TableIlonwFileBO();
		tableFile.setIlonw_file_title(title);
		tableFile.setIlonw_file_context(context);
		tableFile.setAuther("师奇隆");
		tableFile.setIdentification(UUIDUtil.getOrderIdByUUId());
		tableFile.setPlatform("ilonw");
		tableFile.setCreatetime(DateUtil.format(new Date()));
		sysIlonwTableFileFacade.saveUploadFile(tableFile);
		return getIntefaceData(requestIp,"", "/uploadFile", "/addfishcontent",now,tableFile,"文件基本信息接口详细描述");
	}
	
	
	/** 
	 * String title,String context, 
	 * 
	 * 一次上传多张图片 
	 * @throws IOException 
	 * @throws JSchException 
	 * @throws SftpException 
	 */  
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ApiOperation(value="多张图片上传接口", notes="文件上传接口详细描述")
	public APIBaseResult fileUpload(@RequestParam(value = "file",required = true) CommonsMultipartFile files[],
	        HttpServletRequest request) throws IOException, JSchException, SftpException {
		long now = System.currentTimeMillis();
		TableFileBO tableFile = new TableFileBO();
	    // 获得项目的路径  
	    ServletContext sc = request.getSession().getServletContext();  
	    // 上传位置  
	    String path = sc.getRealPath("/") +"ilonw-oss-"+DateUtil.format(new Date())+"/"; // 设定文件保存的目录
	   
	   File f = new File(path);  
	    if (!f.exists())  
	        f.mkdirs();
	    
	    for (int i = 0; i < files.length; i++) {  
	        // 获得原始文件名  2
	        String fileName = files[i].getOriginalFilename();  
	        //获取后缀名
	        String fixname = fileName.substring(fileName.lastIndexOf(".")+1);
	        // 新文件名  
	        String newFileName = UUID.randomUUID() + fileName;  
	        if (!files[i].isEmpty()) {  
	            try {  
	                FileOutputStream fos = new FileOutputStream(path + newFileName);  
	                InputStream in = files[i].getInputStream();  
	                
	                int b = 0;  
	                while ((b = in.read()) != -1) {  
	                    fos.write(b);  
	                }  
	                fos.close();  
	                in.close();  
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }  
	        }  
            
	        SFTPUtil sftp = new SFTPUtil(FTP_USERNAME,FTP_PASSWORD, FTP_ADDRESS, Integer.parseInt(FTP_PORT));
	        sftp.login();  
	        InputStream is = new FileInputStream(new File(path+newFileName));  
	          
	        sftp.upload(FTP_BASEPATH, newFileName, is);  

	        sftp.logout();  
	        
        	TableIlonwFileBO ilonwfile = sysIlonwTableFileFacade.selectIlonwFile();
 	        tableFile.setFile_fixname("."+fixname);
 	        tableFile.setFile_name(fileName);
 	        tableFile.setFile_new_name(newFileName);
 	        tableFile.setFile_path(path);
 	        tableFile.setFile_size("");
 	        tableFile.setFile_type(fixname);
 	        tableFile.setIlonw_file_id(ilonwfile.getIlonw_file_id());
			sysIlonwTableFileFacade.saveFile(tableFile);
	    }  
	   /* boolean result = getDeleteFile(request);
	    System.out.println(result);
	    if(result){
	    	System.out.println("删除文件夹成功");
	    }else{
	    	System.out.println("删除文件夹失败");
	    }*/
	   /* File file = new File(path.substring(0, path.length()-1));
	    deleteAllFilesOfDir(file);*/

		return getIntefaceData(request,"", "/uploadFile", "/upload",now,tableFile,"文件上传接口详细描述");
	}
	
	//文件上传成功，删除本地文件
	public static void deleteAllFilesOfDir(File path) {  
	    if (!path.exists())  
	        return;  
	    if (path.isFile()) {  
	        path.delete();  
	        return;  
	    }  
	    File[] files = path.listFiles();  
	    for (int i = 0; i < files.length; i++) {  
	        deleteAllFilesOfDir(files[i]);  
	    }  
	    path.delete();  
	}
	//执行删除文件夹
	public boolean getDeleteFile(HttpServletRequest request){
		try {
			 ServletContext sc = request.getSession().getServletContext();  
		    // 上传位置  
		    String path = sc.getRealPath("/") +"ilonw-oss-"+DateUtil.format(new Date())+"/"; // 设定文件保存的目录
			File file = new File(path.substring(0, path.length()-1));
			 deleteAllFilesOfDir(file);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
		 
	}
}
