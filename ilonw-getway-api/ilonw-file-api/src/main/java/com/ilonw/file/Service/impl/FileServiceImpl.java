package com.ilonw.file.Service.impl;

import com.ilonw.file.Service.FileService;
import com.ilonw.file.vo.TableFileVO;
import com.ilonw.server.bo.TableFileBO;
import com.ilonw.server.facade.file.SysIlonwTableFileFacade;
import com.server.tools.date.DateUtil;
import com.server.tools.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("fileService")
public class FileServiceImpl implements FileService {

    @Resource
    private SysIlonwTableFileFacade sysIlonwTableFileFacade;

    @Value("${ilonw.view.img}")
    private String ilonwViewImg;

    @Value("${ilonw.default.image}")
    private String ilonwDefaultImage;
    @Value("${ilonw.default.context}")
    private String ilonwDefaultContext;


    @Override
    //@Async
    public String saveFile(TableFileBO tableFile) {
        String Identification = UUIDUtil.getOrderIdByUUId();
        tableFile.setAuther("师奇隆");
        tableFile.setIdentification(Identification);
        tableFile.setPlatform("ilonw");
        tableFile.setCreatetime(DateUtil.getDateTime(new Date()));
        sysIlonwTableFileFacade.saveFile(tableFile);
        return Identification;
    }

    @Override
    public void updateFile(String context,String Identification) {
        TableFileBO tableFile = new TableFileBO();
        tableFile.setIlonw_file_context(context);
        tableFile.setIdentification(Identification);
        sysIlonwTableFileFacade.updateFile(tableFile);
    }

    @Override
    public List<TableFileVO> findFiles() {
        List<TableFileVO> tableFileVO = new ArrayList<>();

        List<TableFileBO> listFile = sysIlonwTableFileFacade.selectFile();
        if(listFile.size() > 0){
            for (TableFileBO bo : listFile){
                TableFileVO vo = new TableFileVO();
                vo.setIlonwFileContext(bo.getIlonw_file_context());
                vo.setFileName(ilonwViewImg+"ilonw/file/"+ DateUtil.formatDate1(new Date())+"/"+bo.getFile_new_name());
                tableFileVO.add(vo);
            }
        }else{
            TableFileVO vo = new TableFileVO();
            vo.setIlonwFileContext(ilonwDefaultContext);
            vo.setFileName(ilonwDefaultImage);
            tableFileVO.add(vo);
        }
       return tableFileVO;
    }
}
