package com.znsd.maven.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.maven.dao.StudentDao;
import com.znsd.maven.entity.Student;
import com.znsd.maven.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	public List<Student> selectStudentList() {
		return studentDao.selectStudentList();
	}

	public List<Student> selectStudentLimit(Integer page, Integer limit) {
		return studentDao.selectStudentLimit(page, limit);
	}

	public int addStudent(Student student) {
		if (student == null) {
			return 0;
		}
		studentDao.addStudent(student);
		return 1;
	}

	public void deleteStudent(Integer stuId) {
		studentDao.deleteStudent(stuId);
	}

	public void updateStudent(Student student) {
		studentDao.updateStudent(student);
	}

}
