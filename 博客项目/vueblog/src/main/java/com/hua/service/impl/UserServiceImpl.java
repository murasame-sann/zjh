package com.hua.service.impl;

import com.hua.entity.User;
import com.hua.mapper.UserMapper;
import com.hua.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hua
 * @since 2021-08-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
