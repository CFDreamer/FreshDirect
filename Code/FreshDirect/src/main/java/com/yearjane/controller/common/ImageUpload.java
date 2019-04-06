package com.yearjane.controller.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yearjane.dto.ErrorMessageExecution;
import com.yearjane.dto.FileParams;
import com.yearjane.enums.ResultResponseEnum;
import com.yearjane.global.GlobalParams;
import com.yearjane.util.ImageUtil;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/upload")
public class ImageUpload {
	
	@PostMapping("/image/upload")
	@ResponseBody
	public Map<String,Object> imageUpload(@RequestParam(value = "image") MultipartFile image) throws IOException{
		System.out.println(image.getInputStream());
		Map<String,Object> map=new HashMap<String,Object>();
		FileParams file=new FileParams();
		ErrorMessageExecution expection=new ErrorMessageExecution();
		
		try {
			file.setFileName(image.getOriginalFilename());
			file.setInputStream(image.getInputStream());
			String relativeAddr=ImageUtil.savePicture(file, GlobalParams.GOODS_PATH);
			expection=new ErrorMessageExecution(ResultResponseEnum.RESULTSUCCESS,true);
			map.put("imagepath", relativeAddr);
		} catch (Exception e) {
			expection=new ErrorMessageExecution(ResultResponseEnum.RESULT_FAIL,false);
		}
		map.put(GlobalParams.RESULT_MESSAGE, expection);
		return map;
	}
}
