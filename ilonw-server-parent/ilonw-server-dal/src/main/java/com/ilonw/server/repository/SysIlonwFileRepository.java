package com.ilonw.server.repository;

import com.ilonw.server.bo.TableFileBO;
import com.ilonw.server.bo.TableIlonwFileBO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SysIlonwFileRepository {
	TableIlonwFileBO selectIlonwFile();
	
	void saveUploadFile(TableIlonwFileBO tableFile);
	
	List<TableFileBO> selectFile();
	
	void saveFile(TableFileBO tableFile);
}
