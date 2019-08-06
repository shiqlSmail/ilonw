package com.ilonw.server.facadeimpl.file;

import com.ilonw.server.facade.file.SysIlonwTableFileFacade;
import com.ilonw.server.biz.file.SysIlonwTableFileService;
import com.ilonw.server.bo.TableFileBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysIlonwTableFileFacade")
public class SysIlonwTableFileFacadeImpl implements SysIlonwTableFileFacade {
    @Autowired
    private SysIlonwTableFileService SysIlonwTableFileService;

    @Override
    public void saveFile(TableFileBO tableFile) {
        SysIlonwTableFileService.saveFile(tableFile);
    }

    @Override
    public List<TableFileBO> selectFile() {
        return this.SysIlonwTableFileService.selectFile();
    }

    @Override
    public boolean updateFile(TableFileBO tableFile) {
        return this.SysIlonwTableFileService.updateFile(tableFile);
    }

}
