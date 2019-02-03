package com.yearjane.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.yearjane.dto.ErrorMessageExecution;
import com.yearjane.entity.UserInfo;
import com.yearjane.enums.ResultResponseEnum;
import com.yearjane.global.GlobalParams;

/**
 * 用户验证的工具类
 * @author 陈小锋
 *
 */
public class UserValidationUtil {
   public static Map<String,Object> userValidat(HttpServletRequest request,Integer id){
	   Map<String,Object> map=new HashMap<String,Object>();
	   ErrorMessageExecution execution=new ErrorMessageExecution();
	   if(null==request.getSession().getAttribute("userInfo")){
		    execution=new ErrorMessageExecution(ResultResponseEnum.USER_NOLOGIN,false);
		    map.put(GlobalParams.RESULT_MESSAGE, execution);
			return map;
		}
	   UserInfo uInfo=(UserInfo) request.getSession().getAttribute("userInfo");
		if(!id.equals(uInfo.getId())){
			execution=new ErrorMessageExecution(ResultResponseEnum.NO_POWER,false);
		    map.put(GlobalParams.RESULT_MESSAGE, execution);
		}
		return map;
   }
}
