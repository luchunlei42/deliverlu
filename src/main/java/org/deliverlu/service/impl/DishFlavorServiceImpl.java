package org.deliverlu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.deliverlu.entity.DishFlavor;
import org.deliverlu.service.DishFlavorService;
import org.deliverlu.mapper.DishFlavorMapper;
import org.springframework.stereotype.Service;

@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
