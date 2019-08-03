package com.ilonw.server;

import com.ilonw.server.bo.TableFileBO;
import com.ilonw.server.bo.TableIlonwFileBO;

import java.util.List;

public interface SysIlonwTableFileFacade {
    public TableIlonwFileBO selectIlonwFile();

    public void saveUploadFile(TableIlonwFileBO tableFile);

    public List<TableFileBO> selectFile();

    public void saveFile(TableFileBO tableFile);
}
