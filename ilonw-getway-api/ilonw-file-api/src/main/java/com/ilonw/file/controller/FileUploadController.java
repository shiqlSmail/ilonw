package com.ilonw.file.controller;

import com.alibaba.druid.util.StringUtils;
import com.ilonw.file.Service.FileService;
import com.ilonw.file.base.BaseController;
import com.ilonw.file.vo.IlonwLoginParam;
import com.ilonw.file.vo.TableFileVO;
import com.ilonw.server.bo.user.IlonwUserBO;
import com.ilonw.server.bto.IlonwUserBTO;
import com.ilonw.server.facade.user.IlonwUserFacade;
import com.server.tools.encryption.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 文件上传控制类
 *
 * @author shiqilong
 */
@Controller
@RequestMapping("/oss")
public class FileUploadController extends BaseController {

    @Autowired
    private FileService fileService;

    @Resource
    public IlonwUserFacade ilonwUserFacade;

    @Value("${ilonw.local.reading.img}")
    private String localImgProperties;

    /**
     * 登录页面
     *
     * @return
     */
    @RequestMapping("/login.htm")
    public String login() {
        return "login";
    }

    /**
     * 登录接口
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/toLogin", method = RequestMethod.POST, produces = "application/json")
    public String toLogin(@RequestBody IlonwLoginParam param, HttpSession session) {
        IlonwUserBTO record = new IlonwUserBTO();
        record.setIlonwUserPhone(param.getIlonwUserPhone());
        record.setIlonwUserPassword(MD5Util.MD5Encode(param.getIlonwUserPassword(), "UTF-8"));
        Map<String, Object> map = ilonwUserFacade.loginIlonwUserByPhoneAndEmailAndCode(record);
        // Map<String,Object> resultMap = (Map<String,Object>)map.get("data");
        IlonwUserBO ilonwUserBO = (IlonwUserBO) map.get("data");
        if (ilonwUserBO != null) {
            session.setAttribute("userId", ilonwUserBO.getIlonwUserId());
            return "list";
        } else {
            return "login";
        }
    }

    /**
     * 文件上传页
     *
     * @return
     */
    @RequestMapping(value = "/index.htm")
    public String index(HttpSession session) {
        String username = (String) session.getAttribute("userId");
        if (StringUtils.isEmpty(username)) {
            return "login";
        }
        return "index";
    }

    /**
     * 视频上传页
     *
     * @return
     */
    @RequestMapping(value = "/vido.htm")
    public String vido(HttpSession session) {
        String username = (String) session.getAttribute("userId");
        if (StringUtils.isEmpty(username)) {
            return "login";
        }
        return "vido";
    }

    /**
     * 图片列表页
     *
     * @param modelMap
     * @param request
     * @return
     */
    @RequestMapping("/list.htm")
    public String list(ModelMap modelMap, HttpServletRequest request, HttpSession session) {
        String username = (String) session.getAttribute("userId");
        if (StringUtils.isEmpty(username)) {
            return "login";
        }
        List<TableFileVO> listFile = fileService.findFiles(username);
        if (null != listFile || listFile.size() > 0) {
            modelMap.put("listFiles", listFile);
        } else {
            return "index";
        }
        return "list";
    }

    /**
     * 视频列表页
     *
     * @param modelMap
     * @param request
     * @return
     */
    @RequestMapping("/vidoList.htm")
    public String vidoList(ModelMap modelMap, HttpServletRequest request, HttpSession session) {
        String username = (String) session.getAttribute("userId");
        if (StringUtils.isEmpty(username)) {
            return "login";
        }
        List<TableFileVO> listFile = fileService.findFiles(username);
        if (null != listFile || listFile.size() > 0) {
            modelMap.put("listFiles", listFile);
        } else {
            return "vido";
        }
        return "vidoList";
    }

}