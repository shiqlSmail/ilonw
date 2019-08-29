package com.ilonw.server.facadeimpl.file;

import com.ilonw.server.facade.file.SysIlonwTableFileFacade;
import com.ilonw.server.biz.file.SysIlonwTableFileService;
import com.ilonw.server.bo.file.TableFileBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysIlonwTableFileFacade")
public class SysIlonwTableFileFacadeImpl implements SysIlonwTableFileFacade {
    @Autowired
    private SysIlonwTableFileService SysIlonwTableFileService;

    @Override
    public List<TableFileBO> selectFilePath() {
        return SysIlonwTableFileService.selectFilePath();
    }

    @Override
    public void saveFile(TableFileBO tableFileBO) {
        SysIlonwTableFileService.saveFile(tableFileBO);
    }

    @Override
    public List<TableFileBO> selectFile(TableFileBO tableFileBO) {
        return this.SysIlonwTableFileService.selectFile(tableFileBO);
    }

    @Override
    public boolean updateFile(TableFileBO tableFileBO) {
        return this.SysIlonwTableFileService.updateFile(tableFileBO);
    }

}
