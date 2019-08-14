package com.znsd.maven.service;

import java.util.List;

import com.znsd.maven.entity.Student;

public interface StudentService {

	public List<Student> selectStudentList();

	public List<Student> selectStudentLimit(Integer page, Integer limit);

	public int addStudent(Student student);

	public void deleteStudent(Integer stuId);

	public void updateStudent(Student student);

}
