package com.ilonw.server.facade.file;

import com.ilonw.server.bo.TableFileBO;

import java.util.List;

public interface SysIlonwTableFileFacade {

    public List<TableFileBO> selectFile(TableFileBO tableFileBO);

    public void saveFile(TableFileBO tableFileBO);

    public boolean updateFile(TableFileBO tableFileBO);
}
