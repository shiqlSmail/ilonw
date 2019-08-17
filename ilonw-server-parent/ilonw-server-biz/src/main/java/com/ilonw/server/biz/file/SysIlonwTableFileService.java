package com.ilonw.server.biz.file;

import java.util.List;

import com.ilonw.server.bo.file.TableFileBO;

public interface SysIlonwTableFileService {

    public List<TableFileBO> selectFile(TableFileBO tableFileBO);

    public void saveFile(TableFileBO tableFileBO);

    boolean updateFile(TableFileBO tableFileBO);
}
