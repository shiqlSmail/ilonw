package com.ilonw.server.bo;

import java.io.Serializable;

public class TableFileBO  implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer file_id;
	private String file_name;
	private String file_path;
	private String file_type;
	private String file_size;
	private String file_fixname;
	private String file_new_name;
	private String ilonw_file_title;
	private String ilonw_file_context;
	private String platform;
	private String auther;
	private String createtime;
	private String Identification;

	public Integer getFile_id() {
		return file_id;
	}

	public void setFile_id(Integer file_id) {
		this.file_id = file_id;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public String getFile_type() {
		return file_type;
	}

	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}

	public String getFile_size() {
		return file_size;
	}

	public void setFile_size(String file_size) {
		this.file_size = file_size;
	}

	public String getFile_fixname() {
		return file_fixname;
	}

	public void setFile_fixname(String file_fixname) {
		this.file_fixname = file_fixname;
	}

	public String getFile_new_name() {
		return file_new_name;
	}

	public void setFile_new_name(String file_new_name) {
		this.file_new_name = file_new_name;
	}

	public String getIlonw_file_title() {
		return ilonw_file_title;
	}

	public void setIlonw_file_title(String ilonw_file_title) {
		this.ilonw_file_title = ilonw_file_title;
	}

	public String getIlonw_file_context() {
		return ilonw_file_context;
	}

	public void setIlonw_file_context(String ilonw_file_context) {
		this.ilonw_file_context = ilonw_file_context;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getAuther() {
		return auther;
	}

	public void setAuther(String auther) {
		this.auther = auther;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getIdentification() {
		return Identification;
	}

	public void setIdentification(String identification) {
		Identification = identification;
	}
}