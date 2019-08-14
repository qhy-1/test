package com.znsd.maven.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.maven.dao.ClazzDao;
import com.znsd.maven.entity.Clazz;
import com.znsd.maven.service.ClazzService;

@Service
public class ClazzServiceImpl implements ClazzService{

	@Autowired
	private ClazzDao clazzDao;
	
	public List<Clazz> selectClazzList() {
		return clazzDao.selectClazzList();
	}
	
}
