package com.znsd.maven.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znsd.maven.service.ClazzService;

@Controller
public class ClassController {

	@Autowired
	private ClazzService clazzService;

	@ResponseBody
	@RequestMapping(value = "/clazzSelect", method = RequestMethod.POST)
	public Map<String, Object> clazzSelect() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", clazzService.selectClazzList());
		return map;
	}

}
