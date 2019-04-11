package com.yearjane.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yearjane.dao.OrderDao;
import com.yearjane.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
  @Autowired
  private OrderDao oDao;
}
