package com.yearjane.util;

import com.yearjane.global.GlobalParams;

public class PathUtil {
	//图片存放的路径
    private static final String basePath=GlobalParams.BASEPATH;
    public static String getBasePath() {
    	return basePath;
    }
    /**
     * 获取用户头像的路径
     * @param userId:用户id
     * @return
     */
    public  static String getUserProfileImagePath(Integer userId) {
    	return "upload/item/user/profile"+"/"+userId;
    }
    /**
     * 获取商品图片路径
     * @param shopId
     * @return
     */
    public static String getShopImagePath(Integer shopId) {
    	return "/upload/item/shop/"+shopId+"/";
    }
}
