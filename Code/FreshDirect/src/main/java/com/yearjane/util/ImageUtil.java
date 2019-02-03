package com.yearjane.util;

import java.io.File;
import java.io.IOException;

import com.yearjane.dto.FileParams;

import net.coobird.thumbnailator.Thumbnails;

/**
 * 图片的工具类
 * @author 陈小锋
 *
 */
public class ImageUtil {
	/**
	 * 
	 * @param file:所需文件的参数
	 * @param targetAddr：图片存放的相对路径
	 * @return
	 */
	public static String savePicture(FileParams file,String targetAddr) {
		//随机生成的文件名
		String reallyName=RandomCodeUtil.getOrderNumber();
		//获取文件的后缀名
		String extension=getFileExtension(file.getFileName());
		//创建目标文件路径
		markDirPath(targetAddr);
		//图片存放的相对路径
		String relativeAddr=targetAddr+reallyName+extension;
		//图片的绝对路径
		String dest=PathUtil.getBasePath()+relativeAddr;
		//保存图片
		try {
			Thumbnails.of(file.getInputStream()).size(200, 200).outputQuality(0.8f).toFile(dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("图片处理错误");
			e.printStackTrace();
		}
		return relativeAddr;
	}
	//创建目标文件夹
	private static void markDirPath(String targetAddr) {
		String reallyFilePath=PathUtil.getBasePath()+targetAddr;
		File f=new File(reallyFilePath);
		if(!f.exists()) {
			f.mkdirs();
		}
		
	}
	//获取文件的扩展名
	private static String getFileExtension(String fileName) {
		// TODO Auto-generated method stub
		return fileName.substring(fileName.lastIndexOf("."));
	}
}
