package org.deliverlu.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.deliverlu.common.BaseContext;
import org.deliverlu.common.R;
import org.deliverlu.dto.OrderDto;
import org.deliverlu.entity.OrderDetail;
import org.deliverlu.entity.Orders;
import org.deliverlu.service.OrderDetailService;
import org.deliverlu.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;

    @PostMapping("/submit")
    public R<String> submit(@RequestBody Orders orders){
        orderService.submit(orders);
        return R.success("下单成功");
    }

    @GetMapping("/userPage")
    public R<Page> page(int page, int pageSize){
        Page<Orders> pageInfo = new Page(page, pageSize);
        LambdaQueryWrapper<Orders> queryWrapper = new LambdaQueryWrapper<>();
        Long userId = BaseContext.getCurrentId();
        queryWrapper.eq(Orders::getUserId,userId);
        orderService.page(pageInfo, queryWrapper);
        Page<OrderDto> orderDtoPage = new Page<>(page,pageSize);
        BeanUtils.copyProperties(pageInfo,orderDtoPage,"records");
        List<Orders> records = pageInfo.getRecords();
        List<OrderDto> orderDtoList = records.stream().map(item->{
            OrderDto orderDto = new OrderDto();
            BeanUtils.copyProperties(item,orderDto);
            LambdaQueryWrapper<OrderDetail> queryWrapper1 = new LambdaQueryWrapper<>();
            queryWrapper1.eq(OrderDetail::getOrderId,item.getId());
            List<OrderDetail> orderDetails = orderDetailService.list(queryWrapper1);
            orderDto.setOrderDetails(orderDetails);
            return orderDto;
        }).collect(Collectors.toList());
        orderDtoPage.setRecords(orderDtoList);
        return R.success(orderDtoPage);
    }
}
