package com.liuhaolei.dreamer.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.liuhaolei.dreamer.common.CommonString;
import com.liuhaolei.dreamer.common.ResponseModel;
import com.liuhaolei.dreamer.common.ResultStatus;
import com.liuhaolei.dreamer.common.req.UserReq.userModel;
import com.liuhaolei.dreamer.mapper.UserMapper;
import com.liuhaolei.dreamer.model.User;
import com.liuhaolei.dreamer.service.UserService;
import com.liuhaolei.dreamer.util.EncryptionUtil;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuhaolei
 * @since 2018-09-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public ResponseModel saveUser(userModel userModel) {
	
		String newPassword = userModel.getPassWord().trim();
		String encPassword = EncryptionUtil.md5(newPassword + CommonString.SALT);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("user_name", userModel.getUserName());
		params.put("pass_word", userModel.getPassWord());
		List<User> userList = userMapper.selectByMap(params);
		if(userList != null || userList.size() >= 0) {
			return ResponseModel.failApi(ResultStatus.ALREADY_REGISTERED);
		}
		
		User user = new User();
		user.setUserName(userModel.getUserName().trim());
		user.setMale(userModel.getMale());
		user.setPassWord(encPassword);
		user.setCreateAt(new Date());
		user.setUpdateAt(new Date());
		
		userMapper.insert(user);
		return ResponseModel.successApi(ResultStatus.SUCCESS, null);
	}

	
	@Override
	public ResponseModel logingUser(userModel userModel) {
	Map<String, Object> params = new HashMap<String, Object>();
		params.put("user_name", userModel.getUserName());
		String newPassword = userModel.getPassWord().trim();
		String encPassword = EncryptionUtil.md5(newPassword + CommonString.SALT);
		params.put("pass_word", encPassword);
		
		List<User> userList = userMapper.selectByMap(params);
		
		if(userList == null || userList.size() <= 0) {
			return ResponseModel.failApi(ResultStatus.EMPTY_DATA);
		}
		return ResponseModel.successApi(ResultStatus.SUCCESS,userList.get(0));
	}
}
