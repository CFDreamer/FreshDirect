package com.yearjane.util;

import org.junit.Test;

public class SmsSendUtilTest {
  @Test
  public void testSenfSms() {
	  System.out.println(SmsSendUtil.sendMsg("15871705402", 5002,null));
  }
  @Test
  public void testDes() throws Exception {
	  String mixStr=DESUtil.getEncryString("abc1787690905");
	  System.out.println(mixStr);
	  System.out.println(DESUtil.getDecipherString(mixStr));
  }
}
