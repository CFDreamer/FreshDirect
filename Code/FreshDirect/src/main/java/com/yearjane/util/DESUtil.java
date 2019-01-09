package com.yearjane.util;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@SuppressWarnings("restriction")
public class DESUtil {
	private static Key key;
	// 设置密匙key
	private static String KEY_STR = "myKey";
	private static String CHARSETNAME = "UTF-8";
	private static String ALGORITHM = "DES";
	private  Set<Integer> insertIndex =null;
	private  Random random=null;
	static {

		try {
			// 生成DES算法对象
			KeyGenerator generator = KeyGenerator.getInstance(ALGORITHM);
			// 运用SHA1安全策略
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			// 设上密匙种子
			secureRandom.setSeed(KEY_STR.getBytes());
			// 初始化SHA1算法对象
			generator.init(secureRandom);
			// 生成密匙对象
			key = generator.generateKey();
			generator = null;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获取加密后的信息
	 */
	private static String getEncryptString(String str) {
		// 基于BASE64编码，接收byte[] 并转化为String
		BASE64Encoder base64Encoder = new BASE64Encoder();

		try {
			// 按UTF-8编码
			byte[] bytes = str.getBytes(CHARSETNAME);
			// 获取加密对象
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			// 初始化密码信息
			cipher.init(Cipher.ENCRYPT_MODE, key);
			// 加密
			byte[] doFinal = cipher.doFinal(bytes);
			// 返回加密好的信息
			return base64Encoder.encode(doFinal);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

	}

	/**
	 * 获取解密信息
	 */
	private static String getDecryptString(String str) {
		// 基于BASE64编码，接收byte[] 并转化为String
		BASE64Decoder base64Decoder = new BASE64Decoder();
		try {
			//将字符串转化为byte
			byte[] bytes=base64Decoder.decodeBuffer(str);
			//获取解密对象
			Cipher cipher=Cipher.getInstance(ALGORITHM);
			//初始化解密对象
			cipher.init(Cipher.DECRYPT_MODE, key);
			//解密
			byte[] doFinal=cipher.doFinal(bytes);
			//返回解密之后的信息
			return new String(doFinal,CHARSETNAME);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 随机生成63位数
	 */
	private  String getStringRandom() {
		String str="";
		List<String> list=new ArrayList<String>();
		for(int i=0;i<10;i++)
			list.add(String.valueOf(i));
		for(int i=65;i<91;i++)
			list.add(String.valueOf((char)i));
		for(int i=97;i<123;i++)
			list.add(String.valueOf((char)i));
		//System.out.println(list.size());
	     random=new Random();
		for(int i=0;i<63;i++) {
			str=str+list.get(random.nextInt(62));
		}
		return str;
	}
	/**
	 * 随机生成密文在63位字符串中的插入位置(位置不重复)
	 * 
	 * @str 加密后的字符串
	 */
	
	@SuppressWarnings("unused")
	private  void getInsertIndex(String str){
		insertIndex=new TreeSet<Integer>();
		random=new Random();
		for(int i=0;i<str.length();i++)
			insertIndex.add((2*i)+1);

	}
	/**
	 *生成混合密文
	 * @param desStr 加密后的字符串
	 * @param randomStr 随机生成的63位字符串
	 * @return
	 */
	private String insertDESIndex(String desStr,String randomStr) {
		String str="";
		List<String> chars=new ArrayList<String>();
		//将随机生成的63位字符串存到动态数组中
		for(int i=0;i<randomStr.length();i++) {
			chars.add(randomStr.substring(i, i+1));
		}
		getInsertIndex(desStr);
		//迭代插入的位置
		Iterator<Integer> it=insertIndex.iterator();
		int m=0;
		//在指定位置出入密文
		while(it.hasNext()) {
			chars.add(it.next(), desStr.substring(m,m+1));
			m++;
		}
		for(int i=0;i<chars.size();i++)
		{
			str=str+chars.get(i);
		}
		return str;
		
	}
	/**
	 * 取出密文
	 * @param args
	 */
	private String getDES(String mixStr) {
		String str="";
		//迭代密文在随机数中插入的位置
		Set<Integer> set=new TreeSet<Integer>();
		for(int i=0;i<mixStr.length()-63;i++)
			set.add((2*i)+1);
		Iterator<Integer> it=set.iterator();
		//从该位置，逐一取出密文
		while(it.hasNext()) {
			int j=it.next();
			str=str+mixStr.substring(j, j+1);
		}
		return str;
		
	}
	
	
	/**
	 * 
	 * @param str 传入要加密的字符串
	 * @return
	 */
	public static String getEncryString(String str) throws Exception{
		DESUtil desUtil=new DESUtil();
		//生成密文
		String desStr=getEncryptString(str);
		//获取63位随机字符串
		String randomStr=desUtil.getStringRandom();
		//生成密文与随机数字符串的混合字符串
		String mixStr=desUtil.insertDESIndex(desStr,randomStr);
		//返回该混合字符串
		return mixStr;
	}
	
	/**
	 * 获取解密后的字符串
	 */
	public static String getDecipherString(String mixStr)  throws Exception{
		DESUtil desUtil=new DESUtil();
		//从混合的字符串中取出密文
		String str=desUtil.getDES(mixStr);
		//解密返回
		return getDecryptString(str);
	}
}
