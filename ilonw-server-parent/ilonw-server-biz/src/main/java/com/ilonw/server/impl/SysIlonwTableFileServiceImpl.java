package com.ilonw.server.impl;

import com.ilonw.server.SysIlonwTableFileService;
import com.ilonw.server.bo.TableFileBO;
import com.ilonw.server.repository.SysIlonwFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("sysIlonwTableFileService")
public class SysIlonwTableFileServiceImpl implements SysIlonwTableFileService {
	@Autowired
	private SysIlonwFileRepository sysIlonwFileRepository;

	@Override
	public void saveFile(TableFileBO tableFile) {
		this.sysIlonwFileRepository.saveFile(tableFile);
	}

	@Override
	public List<TableFileBO> selectFile() {
		return this.sysIlonwFileRepository.selectFile();
	}

}
