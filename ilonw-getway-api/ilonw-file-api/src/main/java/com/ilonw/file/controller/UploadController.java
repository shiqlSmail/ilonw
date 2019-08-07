package com.ilonw.file.controller;

import com.ilonw.file.Service.FileService;
import com.ilonw.file.base.BaseController;
import com.ilonw.server.bo.TableFileBO;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.server.tools.date.DateUtil;
import com.server.tools.util.ImageTools;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;

@RestController
@RequestMapping("/uploadFile")
public class UploadController extends BaseController {

	@Autowired
	private FileService fileService;

	@Value("${ilonw.local.update.img}")
	private String localImgProperties;

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
		String path = localImgProperties+DateUtil.formatDate1(new Date())+"/";
		File f = new File(path);
		if (!f.exists())
			f.mkdirs();

		if (files.length != 0) {
			for (int i = 0; i < files.length; i++) {
				String fileName = files[i].getOriginalFilename();
				String fixname = fileName.substring(fileName.lastIndexOf(".")+1);
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
