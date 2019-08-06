package com.ilonw.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 文件上传控制类
 * @author shiqilong
 */
@Controller
@RequestMapping("/oss")
public class FileUploadController {

    @RequestMapping("/index.htm")
    public String index(){
        return "index";
    }
}
