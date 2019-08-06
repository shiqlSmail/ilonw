package com.ilonw.file.controller;

import com.ilonw.file.Service.FileService;
import com.ilonw.file.base.BaseController;
import com.ilonw.server.bo.TableFileBO;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.server.tools.date.DateUtil;
import com.server.tools.util.ImageTools;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/uploadFile")
public class UploadController extends BaseController {

	@Autowired
	private FileService fileService;

	/**
	 *
	 * 一次上传多张图片 
	 * @throws IOException 
	 * @throws JSchException 
	 * @throws SftpException 
	 */  
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ApiOperation(value="多张图片上传接口", notes="文件上传接口详细描述")
	public String fileUpload(@RequestParam(value = "file",required = true) CommonsMultipartFile files[]) throws IOException{
		TableFileBO tableFile = new TableFileBO();
		String Identification = "";
		// 构建上传文件的存放路径
		String path = "D://ilonw//upload//"+DateUtil.formatDate(new Date())+"/";

		// 判断路径是否存在，不存在则新创建一个
		File f = new File(path);
		if (!f.exists())
			f.mkdirs();

		// 如果文件不为空，写入上传路径，进行文件上传
		if (files.length != 0) {
			for (int i = 0; i < files.length; i++) {
				// 获得原始文件名  2
				String fileName = files[i].getOriginalFilename();
				//获取后缀名
				String fixname = fileName.substring(fileName.lastIndexOf(".")+1);
				// 新文件名
				String newFileName = UUID.randomUUID() + fileName;
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

                tableFile.setIlonw_file_title(DateUtil.getDateTime(new Date())); //标题以上传时间代替
                tableFile.setIlonw_file_context("");
				tableFile.setFile_fixname("."+fixname);
				tableFile.setFile_name(fileName);
				tableFile.setFile_new_name(newFileName);
				tableFile.setFile_path(path);
				tableFile.setFile_size(ImageTools.getImgSize(new File(path+newFileName)));
				tableFile.setFile_type(fixname);
				Identification = fileService.saveFile(tableFile);
			}
		} else {
			return null;
		}
		//return getIntefaceData(request,"", "/uploadFile", "/upload",now,tableFile,"文件上传接口详细描述");
		return Identification;
	}

	/**
	 * 更新文件信息 主要更新文件context，方便展示用
	 * @param context
	 * @throws Exception
	 */
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value="/updateFile", method = RequestMethod.POST)
	@ResponseBody
	public void addFishContent(String context,String Identification){
		fileService.updateFile(context,Identification);
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
}
