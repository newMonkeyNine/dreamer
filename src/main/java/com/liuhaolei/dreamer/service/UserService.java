package com.liuhaolei.dreamer.service;

import com.liuhaolei.dreamer.common.ResponseModel;
import com.liuhaolei.dreamer.common.req.UserReq.userModel;
import com.liuhaolei.dreamer.model.User;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liuhaolei
 * @since 2018-09-11
 */
public interface UserService extends IService<User> {

	ResponseModel saveUser(userModel userModel);

	ResponseModel logingUser(userModel userModel);

}
