package com.project.skin_me.service.Cart;

import com.project.skin_me.model.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CartService implements ICartService {

    @Override
    public Cart getCart(Long id) {
        return null;
    }

    @Override
    public void removeCart(Long id) {

    }

    @Override
    public BigDecimal getTotalPrice(Long id) {
        return null;
    }
}
