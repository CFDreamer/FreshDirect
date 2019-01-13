package com.yearjane.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.junit.Test;

import com.yearjane.dto.FileParams;

public class SmsSendUtilTest {
  @Test
  public void testSenfSms() {
	  System.out.println(SmsSendUtil.sendMsg("15871705402", 5001,null));
  }
  @Test
  public void testDes() throws Exception {
	  String mixStr=DESUtil.getEncryString("abc1787690905");
	  System.out.println(mixStr);
	  System.out.println(DESUtil.getDecipherString(mixStr));
  }
  /**
   * 测试图片上传
   * @throws Exception
   */
  @Test
  public void tetsUploadImage() throws Exception {
	  File f=new File("F:/image/kobe.png");
	  InputStream iStream= new FileInputStream(f);
	  String relativePath=PathUtil.getShopImagePath(1);
	  FileParams params=new FileParams();
	  params.setFileName(f.getName());
	  params.setInputStream(iStream);
	  ImageUtil.savePicture(params, relativePath);
  }
}
