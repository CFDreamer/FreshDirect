package com.yearjane.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yearjane.entity.UserInfo;

/**
 * 
 * @author 
 * 用户信息的Dao
 */
public interface UserInfoDao {
  /**
   * 用户的注册
   * @param userInfo
   */
  public int insertUser(@Param("userInfo") UserInfo userInfo);
  
  /**
   * 用户的查询，不分页
   * @param userInfo
   * @return
   */
  public List<UserInfo> getUserInfoList(@Param("userInfo") UserInfo userInfo);
  
  /**
   * 用户信息的更新
   * @param userInfo
   * @return
   */
  public int udpateUserInfo(@Param("userInfo") UserInfo userInfo);
}
