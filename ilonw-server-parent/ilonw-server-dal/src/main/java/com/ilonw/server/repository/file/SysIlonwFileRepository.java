package com.ilonw.server.repository.file;

import com.ilonw.server.bo.file.TableFileBO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SysIlonwFileRepository {

	List<TableFileBO> selectFile(TableFileBO tableFileBO);

	void saveFile(TableFileBO tableFileBO);

	boolean updateFile(TableFileBO tableFile);
}
