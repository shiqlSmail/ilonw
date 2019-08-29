package com.ilonw.manager.controller.api;

import com.alibaba.fastjson.JSONArray;
import com.ilonw.manager.base.BaseController;
import com.ilonw.manager.domain.SysDeptBO;
import com.ilonw.manager.service.SysDeptService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "/loop")
public class ApiLoopController extends BaseController {
    @Autowired
    private SysDeptService sysDeptService;

    @Value("${loop.upload}")
    private String loopUpload;
    @Value("${loop.show}")
    private String loopShow;

    @Value("${loop.save.url}")
    private String saveUrl;
    @Value("${loop.find.url}")
    private String findUrl;
    @Value("${loop.edit.utl}")
    private String editUrl;
    @Value("${loop.delete.url}")
    private String deleteUrl;



    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/selectAll", produces = "application/json",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> selectAll() {
        Map<String,Object> map = new HashMap<>();

        String response = toSendPost(findUrl,null);
        JSONObject jsonObject = JSONObject.fromObject(response);
        String resData = jsonObject.getString("respData");
        JSONObject json = JSONObject.fromObject(resData);
        String data = json.getString("data");

        map.put("data", JSONArray.parse(data));
        return map;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/update", produces = "application/json",method = RequestMethod.POST)
    @ResponseBody
    public int update(@RequestBody SysDeptBO sysDeptBO, HttpServletRequest request) {
        String loopId = request.getParameter("loopId");
        String loopName = request.getParameter("loopName");
        String loopStatus = request.getParameter("loopStatus");
        String loopIndex = request.getParameter("loopIndex");

        int returnCount = 0;
        int resultCount = sysDeptService.updateByPrimaryKeySelective(sysDeptBO);
        if(resultCount > 0){
            returnCount = resultCount;
        }
        return returnCount;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public String add(Map<String,String> map, @RequestParam("loopPic") MultipartFile loopPic, HttpServletRequest request) throws IOException {
        String loopName = request.getParameter("loopName");
        String loopIndex = request.getParameter("loopIndex");

        //得到图片上传完成后的新名字
        String image = getFileUpload(loopPic);
        map.put("loopName",loopName);
        map.put("loopIndex",loopIndex);
        map.put("loopPic",image);

        //调用接口，保存轮播图
        return toSendPost(saveUrl,map);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public String delete( Map<String,String> map,HttpServletRequest request) {
        String loopId = request.getParameter("loopId");
        map.put("loopId",loopId);
        String response = toSendPost(deleteUrl,map);
        return response;
    }

    /**
     * 轮播图上传公共类
     * @param loopPic
     * @return
     * @throws IOException
     */
    public String getFileUpload(MultipartFile loopPic) throws IOException {
        MultipartFile blFile = loopPic;
        String path = loopUpload;
        String fileName = loopPic.getOriginalFilename();
        String newFileName = UUID.randomUUID() + fileName;

        File file = new File(path,newFileName);
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        blFile.transferTo(file);
        return newFileName;
    }
}
