package com.yearjane.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.yearjane.dao.TestDao;
import com.yearjane.entity.Student;
import com.yearjane.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	@Autowired
	private TestDao dao;

	@Override
	@Cacheable(value="redisCacheManager",key="'redis_student_info'")
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return dao.getStudents();
	}

}
