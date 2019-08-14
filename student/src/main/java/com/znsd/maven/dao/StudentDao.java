package com.znsd.maven.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znsd.maven.entity.Student;

public interface StudentDao {

	public List<Student> selectStudentList();

	public List<Student> selectStudentLimit(@Param("page") Integer page, @Param("pageSize") Integer limit);

	public void addStudent(Student student);

	public void deleteStudent(Integer stuId);

	public void updateStudent(Student student);

}
