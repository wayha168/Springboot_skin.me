package com.project.skin_me.service.Cart;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartItemService implements ICartItemService {
    @Override
    public void addItemToCart(Long cartId, Long productId, int quantity) {

    }

    @Override
    public void removeItemFromCart(Long cartId, Long productId) {

    }

    @Override
    public void updateItemQuantity(Long cartId, Long productId, int quantity) {

    }
}
