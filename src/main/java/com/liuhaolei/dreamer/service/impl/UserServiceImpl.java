package com.liuhaolei.dreamer.service.impl;

import com.liuhaolei.dreamer.model.User;
import com.liuhaolei.dreamer.mapper.UserMapper;
import com.liuhaolei.dreamer.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
