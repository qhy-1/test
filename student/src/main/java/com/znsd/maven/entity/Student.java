package com.znsd.maven.entity;

public class Student {
	private Integer stuId;
	private String stuName;
	private Integer stuAge;
	private String stuSex;
	private Clazz clazz;

	public Student() {
		super();
	}

	public Student(Integer stuId, String stuName, Integer stuAge, String stuSex, Integer clsId) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuAge = stuAge;
		this.stuSex = stuSex;
		this.clazz = new Clazz();
		clazz.setClsId(clsId);
	}

	public Student(String stuName, String stuSex, Integer stuAge, Integer clsId) {
		super();
		this.stuName = stuName;
		this.stuSex = stuSex;
		this.stuAge = stuAge;
		this.clazz = new Clazz();
		clazz.setClsId(clsId);
	}

	public Integer getStuId() {
		return stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuSex() {
		return stuSex;
	}

	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}

	public Integer getStuAge() {
		return stuAge;
	}

	public void setStuAge(Integer stuAge) {
		this.stuAge = stuAge;
	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + ", stuSex=" + stuSex + ", stuAge=" + stuAge
				+ ", clazz=" + clazz + "]";
	}
}