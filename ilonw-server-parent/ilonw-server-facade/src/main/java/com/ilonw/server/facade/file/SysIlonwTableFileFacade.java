package com.ilonw.server.facade.file;

import com.ilonw.server.bo.TableFileBO;

import java.util.List;

public interface SysIlonwTableFileFacade {

    public List<TableFileBO> selectFile();

    public void saveFile(TableFileBO tableFile);

    public boolean updateFile(TableFileBO tableFile);
}
