package com.ilonw.server;

import com.ilonw.server.bo.TableFileBO;

import java.util.List;

public interface SysIlonwTableFileFacade {

    public List<TableFileBO> selectFile();

    public void saveFile(TableFileBO tableFile);
}
