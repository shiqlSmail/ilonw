package com.ilonw.file.Service;

import com.ilonw.file.vo.TableFileVO;
import com.ilonw.server.bo.TableFileBO;

import java.util.List;

public interface FileService {

    String saveFile(TableFileBO tableFile);

    void updateFile(String context, String Identification);

    public List<TableFileVO> findFiles();

}
