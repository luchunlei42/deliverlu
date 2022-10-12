package org.deliverlu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.deliverlu.entity.User;
import org.deliverlu.mapper.UserMapper;
import org.deliverlu.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
