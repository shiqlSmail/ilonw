package com.ilonw.server;

import java.util.List;

import com.ilonw.server.bo.TableFileBO;
import com.ilonw.server.bo.TableIlonwFileBO;

public interface SysIlonwTableFileService {
    public TableIlonwFileBO selectIlonwFile();

    public void saveUploadFile(TableIlonwFileBO tableFile);

    public List<TableFileBO> selectFile();

    public void saveFile(TableFileBO tableFile);
}
