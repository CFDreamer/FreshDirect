package com.yearjane.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yearjane.basetest.BaseTest;
import com.yearjane.entity.GoodsInfo;
import com.yearjane.entity.OrderDetail;
import com.yearjane.entity.OrderInfo;
import com.yearjane.entity.UserAddress;

public class OrderDaoTest extends BaseTest {
  @Autowired 
  private OrderDao dao;
//  @Test
//  public void  addtest() {
//	  OrderDetail detail=null;
//	  GoodsInfo ginfo=null;
//	  OrderInfo info=new OrderInfo();
//	  UserAddress address=new UserAddress();
//	  List<OrderDetail> list=new ArrayList<OrderDetail>();
//	  address.setAddress_id(1);
//	  info.setAddress(address);
//	  info.setAllprice(50.0);
//	  info.setCreateTime(new Date());
//	  info.setOno("545s432s1534s54ss1");
//	  info.setUid(40);
//	  info.setUpdateTime(new Date());
//	  info.setRemarks("顺丰发货");
//	  
//	  detail=new OrderDetail();
//	  detail.setCount(5);
//	  ginfo=new GoodsInfo();
//	  ginfo.setId(45);
//	  detail.setGid(ginfo);
//	  detail.setOno("5454321534s541");
//	  list.add(detail);
//	  System.out.println(detail);
//	  detail=new OrderDetail();
//	  detail.setCount(10);
//	  ginfo.setId(46);
//	  detail.setGid(ginfo);
//	  detail.setOno("5454321534s541");
//	  list.add(detail);
//	  System.out.println(detail);
//	  detail=new OrderDetail();
//	  detail.setCount(1);
//	  ginfo.setId(47);
//	  detail.setGid(ginfo);
//	  detail.setOno("545432153454s1");
//	  list.add(detail);
//	  System.out.println(detail);
//	  int effect=dao.addOrderDetail(list);
//	  int effect1=dao.addOrderInfo(info);
//	  System.err.println(effect+ "  "+effect1);
//	  
//  }
//  
//  @Test
//  public void testADDAddress() {
//	  
////	  UserAddress search=new UserAddress();
////	  search.setUid(40);
////	  List<UserAddress> list=new ArrayList<UserAddress>();
////	  list=dao.getUserAddress(search);
//	 UserAddress address=new UserAddress();
//		 address.setIsdefault(1);
//		 address.setAddress("松岗sss");
//		 address.setIsdefault(0);
//		 address.setName("chanfrer");
//		 address.setPhone("15871705402");
//		 address.setUid(41);
//	int effect=dao.addUserAddress(address);
//	System.err.println(effect);
//	 
//  }
//  
//  @Test
//  public void testUpdateAddress() {
//	  UserAddress address=new UserAddress();
//	  address.setAddress_id(1);
//	  address.setAddress("松岗,华宇1号");
//	  address.setIsdefault(1);
//	  address.setName("cf");
//	  address.setPhone("15871705403");
//	  address.setUseCount(1);
//	  address.setIsdeleted(1);;
//	  dao.updateUserAddress(address);
//  }
//  
//  @Test
//  public void  getAddrss() {
//	  UserAddress address=new UserAddress();
//	  //address.setIsdefault(1);
//	  //address.setUid(40);
//	  address.setAddress_id(2);
//	  List<UserAddress> list=new ArrayList<UserAddress>();
//	  list=dao.getUserAddress(address);
//	  System.err.println(list);
//  }
//  
//  @Test
//  public void getUpdateDetail() {
//	 OrderDetail detail=new OrderDetail();
//	 detail.setOno("545432153454");
//	 List<OrderDetail> list=new ArrayList<OrderDetail>();
//	 list=dao.getOrderDetails(detail);
//	 System.out.println(list.size());
//  }
//  
//  @Test 
//  public void updateOrderInfo() {
//	  OrderInfo info=new OrderInfo();
//	  info.setId(1);
//	  info.setState(1);
//	  info.setIsdeleted(1);
//	  info.setUpdateTime(new Date());
//	  dao.updateOrderInfo(info);
//  }
//  @Test
//  public void deleteDetail() {
//	  OrderDetail detail=new OrderDetail();
//	  detail.setOno("545432153454");
//	  dao.deleteOrderDetail(detail);
//  }
//  @Test 
//  public void testgetOrder() {
//	  OrderInfo info=new OrderInfo();
//	  List<OrderInfo> list=new ArrayList<OrderInfo>();
//	  info.setUid(40);
//	  info.setState(0);
//	  list=dao.getOrederInfos(info);
//	  System.err.println(list);
//	  System.err.println(list.size());
//  }
//  
 }
