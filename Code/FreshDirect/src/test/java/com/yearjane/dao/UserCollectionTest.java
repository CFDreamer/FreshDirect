package com.yearjane.dao;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yearjane.basetest.BaseTest;
import com.yearjane.entity.GoodsInfo;
import com.yearjane.entity.UserCollections;

public class UserCollectionTest  extends BaseTest{
  @Autowired
  private UserCollectionDao dao;
//  
//  @Test
//  public void testget() {
//	  UserCollections u=new UserCollections();
//	  //u.setId(1);
//	  u.setUid(40);
//	  GoodsInfo g=new GoodsInfo();
//	  g.setId(15);
//	  u.setGid(g);
//	  System.err.println(dao.getUserCollections(u));
//  }
//  
//  @Test
//  public void testadd() {
//	  UserCollections u=new UserCollections();
//	  //u.setId(1);
//	  u.setUid(40);
//	  GoodsInfo g=new GoodsInfo();
//	  g.setId(80);
//	  u.setGid(g);
//	  u.setAddTime(new Date());
//	  System.err.println(dao.addUserCollections(u));
//  }
//  
//  @Test
//  public void testupdate() {
//	  UserCollections u=new UserCollections();
//	  u.setUid(40);
//	  GoodsInfo g=new GoodsInfo();
//	  g.setId(80);
//	  u.setGid(g);
//	  System.err.println(dao.deletedUserCollections(u));
//  }
}
