package com.ilonw.file.controller;

import com.ilonw.file.Service.FileService;
import com.ilonw.file.base.BaseController;
import com.ilonw.file.util.FileEntity;
import com.ilonw.file.util.FileUploadTool;
import com.ilonw.server.bo.file.TableFileBO;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.server.tools.date.DateUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * 视频上传
 */
@RestController
@RequestMapping("/uploadFile")
public class UploadVidoController extends BaseController {

    @Autowired
    private FileService fileService;

    @Value("${ilonw.local.update.img}")
    private String localImgProperties;

    /**
     * 一次上传多张图片
     *
     * @throws IOException
     * @throws JSchException
     * @throws SftpException
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/vidos", method = RequestMethod.POST)
    @ApiOperation(value = "多视频上传接口", notes = "视频上传接口详细描述")
    public String fileUpload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, HttpSession session) {
        String ilonwUserId = (String)session.getAttribute("userId");

        TableFileBO tableFile = new TableFileBO();
        String Identification = "";
        FileUploadTool fileUploadTool = new FileUploadTool();
        String logoPathDir = localImgProperties+ DateUtil.formatDate1(new Date())+"/";
        try {
            if (null != file) {
                FileEntity entity = fileUploadTool.createFile(file, request,logoPathDir);
                if (entity != null) {
                    String fileName = file.getOriginalFilename();
                    String fixname = fileName.substring(fileName.lastIndexOf(".") + 1);
                    String newFileName = UUID.randomUUID() + fileName;

                    tableFile.setIlonw_file_title(DateUtil.getDateTime(new Date())); //标题以上传时间代替
                    tableFile.setIlonw_file_context("");
                    tableFile.setFile_fixname("." + fixname);
                    tableFile.setFile_name(fileName);
                    tableFile.setFile_new_name(newFileName);
                    tableFile.setFile_path(entity.getPath());
                    tableFile.setFile_size(entity.getSize());
                    tableFile.setFile_type(fixname);
                    tableFile.setAuther((String)session.getAttribute("userId"));
                    Identification = fileService.saveFile(tableFile,ilonwUserId);
                } else {
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Identification;
    }
}
