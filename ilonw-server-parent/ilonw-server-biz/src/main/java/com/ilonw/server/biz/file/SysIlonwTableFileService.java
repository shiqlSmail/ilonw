package com.ilonw.server.biz.file;

import java.util.List;

import com.ilonw.server.bo.TableFileBO;

public interface SysIlonwTableFileService {

    public List<TableFileBO> selectFile();

    public void saveFile(TableFileBO tableFile);

    boolean updateFile(TableFileBO tableFile);
}
