package com.znsd.maven.entity;

public class Clazz {
	private Integer clsId;
	private String clsName;
	public Integer getClsId() {
		return clsId;
	}
	public void setClsId(Integer clsId) {
		this.clsId = clsId;
	}
	public String getClsName() {
		return clsName;
	}
	public void setClsName(String clsName) {
		this.clsName = clsName;
	}
	@Override
	public String toString() {
		return "Clazz [clsId=" + clsId + ", clsName=" + clsName + "]";
	}
}