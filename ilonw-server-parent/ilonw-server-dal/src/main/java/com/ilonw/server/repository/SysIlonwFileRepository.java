package com.ilonw.server.repository;

import com.ilonw.server.bo.TableFileBO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SysIlonwFileRepository {

	List<TableFileBO> selectFile();
	
	void saveFile(TableFileBO tableFile);
}
