package com.znsd.maven.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znsd.maven.entity.Student;
import com.znsd.maven.service.StudentService;

@Controller
public class StudentController {

	@RequestMapping("/stuList")
	public String stuList() {
		return "stuList";
	}

	@Autowired
	private StudentService studentService;

	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> stulist(Integer page, Integer limit) {
		List<Student> list = studentService.selectStudentLimit((page - 1) * limit, limit);
		List<Map<String, Object>> maplist = new ArrayList<Map<String, Object>>();
		for (Student student : list) {
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("stuId", student.getStuId());
			map1.put("stuName", student.getStuName());
			map1.put("stuSex", student.getStuSex());
			map1.put("stuAge", student.getStuAge());
			map1.put("clsId", student.getClazz().getClsId());
			map1.put("clsName", student.getClazz().getClsName());
			maplist.add(map1);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", studentService.selectStudentList().size());
		map.put("msg", "");
		map.put("code", 0);
		map.put("data", maplist);
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/studentAdd", method = RequestMethod.POST)
	public String addStu(HttpServletRequest request) {
		Student student = new Student(request.getParameter("stuName"), request.getParameter("stuSex"),
				Integer.parseInt(request.getParameter("stuAge")), Integer.parseInt(request.getParameter("clazz")));
		int result = studentService.addStudent(student);
		if (result > 0) {
			return "true";
		} else {
			return "false";
		}
	}

	@ResponseBody
	@RequestMapping(value = "/studentDelete", method = RequestMethod.POST)
	public String deleteStu(Integer stuId) {
		studentService.deleteStudent(stuId);
		return "true";
	}

	@ResponseBody
	@RequestMapping(value = "/studentUpdate", method = RequestMethod.POST)
	public String updateStu(HttpServletRequest request) {
		Student student = new Student(Integer.parseInt(request.getParameter("stuId")), request.getParameter("stuName"),
				Integer.parseInt(request.getParameter("stuAge")), request.getParameter("stuSex"),
				Integer.parseInt(request.getParameter("clazz")));
		studentService.updateStudent(student);
		return "true";

	}

}