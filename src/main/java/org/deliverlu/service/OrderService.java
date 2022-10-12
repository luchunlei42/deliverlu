package org.deliverlu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.deliverlu.entity.Orders;

public interface OrderService extends IService<Orders> {

    public void submit(Orders orders);
}
