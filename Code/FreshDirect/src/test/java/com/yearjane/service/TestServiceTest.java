package com.yearjane.service;



import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yearjane.basetest.BaseTest;


public class TestServiceTest  extends BaseTest{
  @Autowired
  private TestService service;
  @Test
  public void test() {
	  System.err.println(service.getStudents());
  }
}
