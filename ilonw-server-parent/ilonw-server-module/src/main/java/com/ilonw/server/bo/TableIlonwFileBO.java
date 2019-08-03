package com.ilonw.server.bo;

import java.io.Serializable;

public class TableIlonwFileBO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer ilonw_file_id;
	private String ilonw_file_title;
	private String ilonw_file_context;
	private String platform;
	private String auther;
	private String createtime;
	private String Identification;
	
	public Integer getIlonw_file_id() {
		return ilonw_file_id;
	}
	public void setIlonw_file_id(Integer ilonw_file_id) {
		this.ilonw_file_id = ilonw_file_id;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Identification == null) ? 0 : Identification.hashCode());
		result = prime * result + ((auther == null) ? 0 : auther.hashCode());
		result = prime * result + ((createtime == null) ? 0 : createtime.hashCode());
		result = prime * result + ((ilonw_file_context == null) ? 0 : ilonw_file_context.hashCode());
		result = prime * result + ((ilonw_file_id == null) ? 0 : ilonw_file_id.hashCode());
		result = prime * result + ((ilonw_file_title == null) ? 0 : ilonw_file_title.hashCode());
		result = prime * result + ((platform == null) ? 0 : platform.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TableIlonwFileBO other = (TableIlonwFileBO) obj;
		if (Identification == null) {
			if (other.Identification != null)
				return false;
		} else if (!Identification.equals(other.Identification))
			return false;
		if (auther == null) {
			if (other.auther != null)
				return false;
		} else if (!auther.equals(other.auther))
			return false;
		if (createtime == null) {
			if (other.createtime != null)
				return false;
		} else if (!createtime.equals(other.createtime))
			return false;
		if (ilonw_file_context == null) {
			if (other.ilonw_file_context != null)
				return false;
		} else if (!ilonw_file_context.equals(other.ilonw_file_context))
			return false;
		if (ilonw_file_id == null) {
			if (other.ilonw_file_id != null)
				return false;
		} else if (!ilonw_file_id.equals(other.ilonw_file_id))
			return false;
		if (ilonw_file_title == null) {
			if (other.ilonw_file_title != null)
				return false;
		} else if (!ilonw_file_title.equals(other.ilonw_file_title))
			return false;
		if (platform == null) {
			if (other.platform != null)
				return false;
		} else if (!platform.equals(other.platform))
			return false;
		return true;
	}
	public TableIlonwFileBO(Integer ilonw_file_id, String ilonw_file_title, String ilonw_file_context, String platform,
							String auther, String createtime, String identification) {
		super();
		this.ilonw_file_id = ilonw_file_id;
		this.ilonw_file_title = ilonw_file_title;
		this.ilonw_file_context = ilonw_file_context;
		this.platform = platform;
		this.auther = auther;
		this.createtime = createtime;
		Identification = identification;
	}
	public TableIlonwFileBO() {
		super();
	}
	
	
}