package com.project.skin_me.service.Cart;

import com.project.skin_me.exception.ResourceNotFoundException;
import com.project.skin_me.model.CartItem;

public interface ICartItemService {
    void addItemToCart(Long cartId, Long productId, int quantity);
    void removeItemFromCart(Long cartId, Long productId);
    void updateItemQuantity(Long cartId, Long productId, int quantity);
}
