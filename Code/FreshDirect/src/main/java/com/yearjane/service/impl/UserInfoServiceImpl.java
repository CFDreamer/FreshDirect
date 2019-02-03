package com.yearjane.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yearjane.dao.UserInfoDao;
import com.yearjane.dto.FileParams;
import com.yearjane.dto.UserInfoExecution;
import com.yearjane.entity.UserInfo;
import com.yearjane.enums.ResultResponseEnum;
import com.yearjane.global.GlobalParams;
import com.yearjane.service.UserInfoService;
import com.yearjane.util.DESUtil;
import com.yearjane.util.ImageUtil;
import com.yearjane.util.PathUtil;

/**
 * UserInfoServiceImpl
 * 
 * @author
 *
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoDao userInfoDao;
	
	/**
	 * 用户的注册
	 */
	@Override
	@Transactional
	public UserInfoExecution insertUser(UserInfo userInfo, FileParams file) {
		/**
		 * 1.添加用户 2.看是有头像上传 3.没有头像就为用户添加默认头像，有头像就处理头像
		 */
		UserInfoExecution execution = new UserInfoExecution(ResultResponseEnum.SYSTEM_INNER_ERROR, false);
		// 检查用户名是否已经存在
		UserInfo checkUser = new UserInfo();
		checkUser.setUsername(userInfo.getUsername());
		List<UserInfo> list = new ArrayList<UserInfo>();
		list = userInfoDao.getUserInfoList(checkUser);
		if (list.size() != 0) {
			execution = new UserInfoExecution(ResultResponseEnum.USERNAME_EXIT, false);
			return execution;
		}
		Date date = new Date();
		userInfo.setSignTime(date);
		try {
			// 加密密码
			userInfo.setPassword(DESUtil.getEncryString(userInfo.getPassword()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("加密失败");
		}
		userInfo.setUpdateTime(date);
		// 添加用户
		int effectNum = userInfoDao.insertUser(userInfo);
		if (0 >= effectNum) {
			execution = new UserInfoExecution(ResultResponseEnum.USER_INSERT_ERROR, false);
			throw new RuntimeException("注册失败");
		}
		if (null == file) {
			// 如果用户未上传头像，就给用户设定默认头像
			userInfo.setImagePath("/test/test");
		}

		// 否则处理头像
		else {
			try {
				String path = addUserImage(userInfo.getId(), file);
				userInfo.setImagePath(path);
			} catch (Exception e) {
				throw new RuntimeException("头像上传失败");
			}
		}
		int updateEffectNum = userInfoDao.udpateUserInfo(userInfo);
		if (0 >= updateEffectNum) {
			execution = new UserInfoExecution(ResultResponseEnum.USER_INSERT_ERROR, false);
			throw new RuntimeException("更新图片失败");
		}
		execution = new UserInfoExecution(ResultResponseEnum.RESULTOK, true);
		return execution;
	}

	/**
	 * 用户头像的上传
	 * 
	 * @param id
	 * @param file
	 * @return
	 */
	private String addUserImage(Integer id, FileParams file) {

		String realivePath = PathUtil.getUserProfileImagePath(id);
		String path = ImageUtil.savePicture(file, realivePath);
		return path;

	}
	/**
	 * 用户登录
	 */
	@Override
	public UserInfoExecution loginUser(UserInfo userInfo,String phoneNumber, Integer loginType) {
		
		UserInfoExecution execution = new UserInfoExecution(ResultResponseEnum.SYSTEM_INNER_ERROR, false);
		
		//用户名（手机号）密码登录
		if(0==loginType) {
		  userInfo.setIsdeleted(0);
		  String password=userInfo.getPassword();
		  userInfo.setPassword(null);
		  List<UserInfo> list=new ArrayList<UserInfo>();
		  list=userInfoDao.getUserInfoList(userInfo);
		  if(0==list.size()) {
			  execution=new UserInfoExecution(ResultResponseEnum.LOGIN_FAIL, false);
			  return execution;
		  }
		  else
		  {
			  try {
				  //获取解密后的字符串
				if(password.equals(DESUtil.getDecipherString(list.get(0).getPassword())))
				  execution=new UserInfoExecution(ResultResponseEnum.LOGIN_SUCCESS, list.get(0), true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				 execution=new UserInfoExecution(ResultResponseEnum.LOGIN_FAIL, false);
				 return execution;
			}
			  return execution;
		  }
		}
		if(1==loginType) {
			List<UserInfo> list=new ArrayList<UserInfo>();
			UserInfo u=new UserInfo();
			u.setPhone(phoneNumber);
			u.setIsdeleted(0);
			list=userInfoDao.getUserInfoList(u);
			execution=new UserInfoExecution(ResultResponseEnum.LOGIN_SUCCESS, list.get(0), true);
		}
		return execution;
	}
	
	/**
	 * 检验手机号是否注册
	 */
	@Override
	public boolean checkPhoneExist(String phoneNumber) {
		
		List<UserInfo> list=new ArrayList<UserInfo>();
		UserInfo u=new UserInfo();
		u.setIsdeleted(0);
		u.setPhone(phoneNumber);
		list=userInfoDao.getUserInfoList(u);
		if(0==list.size())
	     	return false;
		return true;	
	}
	
	/**
	 * 用户信息的查询
	 */
	@Override
	public UserInfoExecution queryUserInfo(UserInfo userInfo) {
		UserInfoExecution execution = new UserInfoExecution(ResultResponseEnum.SYSTEM_INNER_ERROR, false);
		if(null==userInfo.getIsdeleted())
			userInfo.setIsdeleted(0);
		if(null==userInfo.getIsenable())
			userInfo.setIsenable(1);
		List<UserInfo> list=new ArrayList<UserInfo>();
		list=userInfoDao.getUserInfoList(userInfo);
		//如果查出来的不是一条记录，将出错
		if(1!=list.size()) {
			execution=new UserInfoExecution(ResultResponseEnum.RESULT_FAIL, false);
		}
		else {
			execution=new UserInfoExecution(ResultResponseEnum.RESULTOK, list.get(0), true);
		}
		return execution;
	}
	
	/**
	 * 用户信息的更新
	 */
	@Override
	@Transactional
	public UserInfoExecution updateUserInfo(UserInfo userInfo,FileParams file) {
		UserInfoExecution execution = new UserInfoExecution(ResultResponseEnum.SYSTEM_INNER_ERROR, false);
		userInfo.setUpdateTime(new Date());
		userInfo.setRemarks("用户对信息进行了修改");
		//如果用户有新的上传头像，则需要进行图片处理
		if(null!=file) {
			//进行原图片的删除
			UserInfo queryUser=new UserInfo();
			queryUser.setId(userInfo.getId());
			//获取原头像的路径
			String imagePath=userInfoDao.getUserInfoList(queryUser).get(0).getImagePath();
			//如果用户头像不是默认头像，则进行图片的删除
			if(!imagePath.equals((GlobalParams.DEFAULT_USER_IMAGEPATH))){
				deleteImagPath(imagePath);
			}
			//进行新头像的保存
			String newImagePath=addUserImage(userInfo.getId(),file);
			userInfo.setImagePath(newImagePath);
		}
		//如果密码不为空，则对密码进行加密
		if(null!=userInfo.getPassword()) {
			try {
				userInfo.setPassword(DESUtil.getEncryString(userInfo.getPassword()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new  RuntimeException("加密失败");
			}
		}
		int efectNum=userInfoDao.udpateUserInfo(userInfo);
		if(1!=efectNum) {
			execution=new UserInfoExecution(ResultResponseEnum.USER_UPDATE_FAIL, false);
			throw new  RuntimeException("更新失败");
		}
		UserInfo queryUser=new UserInfo();
		queryUser.setId(userInfo.getId());
		UserInfo resultUserInfo=userInfoDao.getUserInfoList(queryUser).get(0);
		return new UserInfoExecution(ResultResponseEnum.USER_UPDATE_SUCCESS, resultUserInfo, true);
	}
	/**
	 * 图片删除
	 * @param imagePath
	 */
	private void deleteImagPath(String imagePath) {
		File f=new File(PathUtil.getBasePath()+imagePath);
		if(f.exists()) {
		f.delete();
		}
		
	}
	
}
