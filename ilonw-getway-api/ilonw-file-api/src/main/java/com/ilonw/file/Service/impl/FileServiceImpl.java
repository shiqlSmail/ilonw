package com.ilonw.file.Service.impl;

import com.ilonw.file.Service.FileService;
import com.ilonw.server.bo.TableFileBO;
import com.ilonw.server.facade.file.SysIlonwTableFileFacade;
import com.server.tools.date.DateUtil;
import com.server.tools.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service("fileService")
public class FileServiceImpl implements FileService {

    @Resource
    private SysIlonwTableFileFacade sysIlonwTableFileFacade;

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

    //测试线程池
    @Override
    @Async
    public void testthread(){
        SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");

        for (int i = 0; i < 100; i++) {
            System.out.println("多线程异步执行"+i+"  "+Thread.currentThread().getName()+"  "+format.format(new Date()));
            /*try {
                //Thread.sleep(10000);
                System.out.println("多线程异步执行"+i+"  "+Thread.currentThread().getName()+"  "+format.format(new Date()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }

    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl();
        fileService.testthread();
    }
}
