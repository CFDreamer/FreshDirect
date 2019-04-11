package com.yearjane.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yearjane.basetest.BaseTest;
import com.yearjane.entity.GoodsInfo;
import com.yearjane.entity.UserShopCar;

public class UserShopCarDaoTest extends BaseTest {
  @Autowired
  private UserShopCarDao dao;
//  @Test
//  public void testadd() {
//	  UserShopCar car=new UserShopCar();
//	  car.setAddTime(new Date());
//	  car.setCount(11);
//	  GoodsInfo info=new GoodsInfo();
//	  info.setId(38);
//	  car.setGoodsInfo(info);
//	  car.setUid(40);
//	  car.setUpdateTime(new Date());
//	  System.err.println(dao.addUserShopCar(car));
//  }
//  
//  @Test
//  public void testupdate() {
//	  UserShopCar car=new UserShopCar();
//	  car.setId(4);
//	  car.setCount(50);
//	  car.setUpdateTime(new Date());
//	  System.err.println(dao.updateUserShopCar(car));
//  }
//  
//  @Test
//  public void testget() {
//	  UserShopCar car=new UserShopCar();
//	 // car.setId(1);
//	  car.setUid(40);
//	  System.err.println(dao.getUserShopCar(car));
//  }
//   @Test
//   public void testdelete() {
//	  List<Integer> list=new ArrayList<Integer>();
//	  list.add(1);
//	  list.add(2);
//	  list.add(4);
//	  System.err.println(dao.deleteUserShopCar(list));
//  }
}
