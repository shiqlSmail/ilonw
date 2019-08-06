package com.ilonw.server.bizimpl.file;

import com.ilonw.server.biz.file.SysIlonwTableFileService;
import com.ilonw.server.bo.TableFileBO;
import com.ilonw.server.repository.file.SysIlonwFileRepository;
import com.server.tools.date.DateUtil;
import com.server.tools.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

	@Override
	public boolean updateFile(TableFileBO tableFile) {
		return this.sysIlonwFileRepository.updateFile(tableFile);
	}
}
