package org.deliverlu.dto;

import lombok.Data;
import org.deliverlu.entity.OrderDetail;
import org.deliverlu.entity.Orders;

import java.util.List;

@Data
public class OrderDto extends Orders {
    List<OrderDetail> orderDetails;
}
