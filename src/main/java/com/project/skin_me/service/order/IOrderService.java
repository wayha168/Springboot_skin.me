package com.project.skin_me.service.order;

import com.project.skin_me.model.Order;

public interface IOrderService {

    Order placeOrderItem(Long userId);
    Order getOrder(Long orderId);

}
