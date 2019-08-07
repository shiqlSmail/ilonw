package com.ilonw.file.controller;

import com.ilonw.file.Service.FileService;
import com.ilonw.file.vo.TableFileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 文件上传控制类
 *
 * @author shiqilong
 */
@Controller
@RequestMapping("/oss")
public class FileUploadController {

    @Autowired
    private FileService fileService;

    @RequestMapping("/index.htm")
    public String index() {
        return "index";
    }

    @RequestMapping("/list.htm")
    public String list(ModelMap modelMap) {
        List<TableFileVO> listFile = fileService.findFiles();
        modelMap.put("listFiles",listFile);
        return "list";
    }
}