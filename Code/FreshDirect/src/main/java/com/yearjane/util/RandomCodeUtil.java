package com.yearjane.util;

import java.util.Random;

/**
 * 随机数工具类
 * @author 陈小锋
 *
 */
public class RandomCodeUtil {
   static Random random=new Random();
   /**
    * 随机生成短信验证码
    * @param length：验证码的长度
    */
   public static String getSmsCode(Integer length) {
	   String code="";
	   for(int i=0;i<length;i++) {
		   code=code+random.nextInt(10);
	   }
	   return code;
   }
   
   /**
    * 生成订单编号（时间戳+6位随机数）
    */
   public static String getOrderNumber() {
	   String orederNumber=String.valueOf(System.currentTimeMillis());
	   for(int i=0;i<6;i++) {
		   orederNumber=orederNumber+random.nextInt(10);
	   }
	   return orederNumber;
   }
}
