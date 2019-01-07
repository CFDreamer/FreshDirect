package com.yearjane.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yearjane.service.TestService;
@Controller
@RequestMapping("/test")
public class TestController {
  @Autowired
  private TestService service;
  
  @RequestMapping("/test")
  @ResponseBody
  public Map<String,Object> test(){
	  Map<String,Object> map=new HashMap<String,Object>();
	  map.put("message",service.getStudents());
	  return map;
  }
}
