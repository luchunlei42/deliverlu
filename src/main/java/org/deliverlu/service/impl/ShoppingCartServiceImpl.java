package org.deliverlu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.deliverlu.entity.ShoppingCart;
import org.deliverlu.mapper.ShoppingCartMapper;
import org.deliverlu.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {
}
