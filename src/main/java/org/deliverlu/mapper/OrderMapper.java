package org.deliverlu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.deliverlu.entity.Orders;

@Mapper
public interface OrderMapper extends BaseMapper<Orders> {
}
