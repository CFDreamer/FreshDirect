package com.yearjane.dto;

import java.io.InputStream;
/**
 * 
 * @author 用于文件保存参数
 *
 */
public class FileParams {
    //图片的文件流
	private InputStream inputStream;
	//图片的文件名
	private String fileName;
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
