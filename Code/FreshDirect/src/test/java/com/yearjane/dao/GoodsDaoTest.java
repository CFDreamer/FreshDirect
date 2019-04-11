package com.yearjane.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yearjane.basetest.BaseTest;
import com.yearjane.entity.GoodsInfo;
import com.yearjane.entity.GoodsType;

public class GoodsDaoTest extends BaseTest{
	@Autowired
    private GoodsDao dao;
	
//	
//	@Test
//	public void test() {
//		GoodsType goodsType=new GoodsType();
//		GoodsType parent=new GoodsType();
//		parent.setTypeid(1);
//		goodsType.setParent(parent);
//		List<GoodsType> list=dao.queryGoodsTypeList(goodsType);
//		System.err.println(list);
//	}
//	@Test
//	public void testUpdate() {
//	    GoodsType goodsType=new GoodsType(); 
//	    goodsType.setTypeid(9);
////	    goodsType.setTypename("新鲜的蔬菜");
////	    goodsType.setOperatorName("chanfrer3");
////	    goodsType.setUpdateTime(new Date());
//	    goodsType.setIsdeleted(0);
//	    System.out.println(dao.updateGoodsType(goodsType));
//	    
//	}
//	@Test
//	public void testAdd() {
//		List<GoodsType> list=new ArrayList<GoodsType>() ;
//		GoodsType parent=new GoodsType();
//		parent.setTypeid(1);
//		GoodsType g=null;
//		g=new GoodsType();
//		g.setTypename("测试新增商品1");
//		g.setOperatorName("chanfrer2");
//		g.setParent(parent);
//		g.setAddTime(new Date());
//		g.setUpdateTime(new Date());
//		list.add(g);
//		
//		parent=new GoodsType();
//		parent.setTypeid(2);
//		
//		g=new GoodsType();
//		g.setTypename("测试新增商品2");
//		g.setOperatorName("chanfrer2");
//		g.setParent(parent);
//		g.setAddTime(new Date());
//		g.setUpdateTime(new Date());
//		list.add(g);
//		
//		g=new GoodsType();
//		g.setTypename("测试新增商品3");
//		g.setOperatorName("chanfrer2");
//		g.setAddTime(new Date());
//		g.setUpdateTime(new Date());
//		list.add(g);
//		
//		g=new GoodsType();
//		g.setTypename("测试新增商品4");
//		g.setOperatorName("chanfrer2");
//		g.setAddTime(new Date());
//		g.setUpdateTime(new Date());
//		list.add(g);
//		
//		g=new GoodsType();
//		g.setTypename("测试新增商品5");
//		g.setOperatorName("chanfrer2");
//		g.setAddTime(new Date());
//		g.setUpdateTime(new Date());
//		list.add(g);
//		
//		dao.addGoodsType(list);
//		
//	}
	/**
	 * 新增商品测试
	 */
//	@Test
//	public void testAddGoodsInfo() {
//		for(int i=0;i<100;i++) {
//		GoodsInfo g=new GoodsInfo();
//		g.setCreateTime(new Date());
//		g.setGoodsname("新增商品1");
//		g.setImagePath("/test/test/test");
//		g.setIntroduce("这是一个测试的商品");
//		g.setNowPrice(100.0);
//		g.setOldPrice(150.0);
//		g.setOperatorName("chanfrer");
//		g.setStock(100);
//		g.setUpdateTime(new Date());
//		GoodsType type=new GoodsType();
//		type.setTypeid(1);
//		g.setGoodstype(type);
//		int effect =dao.addGoodsInfo(g);
//		System.out.println(effect);
//		}
//	}
//
//	/**
//	 * 更新商品测试
//	 */
//	@Test
//	public void testUpdateGoodsInfo() {
//		GoodsInfo g=new GoodsInfo();
//		g.setId(1);
//		g.setGoodsname("更新测试");
//		g.setImagePath("/test/test/测试");
//		g.setNowPrice(100.0);
//		g.setOldPrice(180.0);
//		g.setOperatorName("chanfrer");
//		g.setStock(1000);
//		g.setUpdateTime(new Date());
//		GoodsType type=new GoodsType();
//		type.setTypeid(2);
//		g.setGoodstype(type);
//		int effect =dao.updateGoodsInfo(g);
//		System.out.println(effect);
//	}
//	@Test
//	public void testQueryGoodsInfo() {
//		GoodsInfo goodsInfo=new GoodsInfo();
//		goodsInfo.setId(1);
//		GoodsInfo g=dao.getGoodsInfo(goodsInfo);
//		System.err.println(g);
//	}
//	@Test
//	public void deletedQueryGoodsInfo() {
//		List<Integer> list=new ArrayList<Integer>();
//		list.add(1);
//		list.add(2);
//		System.out.println(dao.deleteGoodsInfo(list));
//	}
	@Test
	public void test() {
		System.out.println(dao.getGoodsInfoByGid(22));
	}
}
