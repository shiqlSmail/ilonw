package com.ilonw.file.Service;

import com.ilonw.file.vo.TableFileVO;
import com.ilonw.server.bo.file.TableFileBO;

import java.util.List;

public interface FileService {

    String saveFile(TableFileBO tableFile,String ilonwUserId);

    void updateFile(String context, String Identification);

    public List<TableFileVO> findFiles(String auther);

}
