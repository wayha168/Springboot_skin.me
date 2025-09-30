package com.project.skin_me.service.Cart;

import com.project.skin_me.model.Cart;

import java.math.BigDecimal;

public interface ICartService {

    Cart getCart(Long id);
    void removeCart(Long id);
    BigDecimal getTotalPrice(Long id);

}
