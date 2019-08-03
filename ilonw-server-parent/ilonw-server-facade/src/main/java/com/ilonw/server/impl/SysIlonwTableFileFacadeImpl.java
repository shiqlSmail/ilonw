package com.ilonw.server.impl;

import com.ilonw.server.SysIlonwTableFileFacade;
import com.ilonw.server.SysIlonwTableFileService;
import com.ilonw.server.bo.TableFileBO;
import com.ilonw.server.bo.TableIlonwFileBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysIlonwTableFileFacade")
public class SysIlonwTableFileFacadeImpl implements SysIlonwTableFileFacade {
	@Autowired
	private SysIlonwTableFileService SysIlonwTableFileService;

	@Override
	public TableIlonwFileBO selectIlonwFile() {
		return this.SysIlonwTableFileService.selectIlonwFile();
	}
	
	@Override
	public void saveUploadFile(TableIlonwFileBO tableFile) {
		this.SysIlonwTableFileService.saveUploadFile(tableFile);
	}

	@Override
	public void saveFile(TableFileBO tableFile) {
		this.SysIlonwTableFileService.saveFile(tableFile);
	}

	@Override
	public List<TableFileBO> selectFile() {
		return this.SysIlonwTableFileService.selectFile();
	}

}
