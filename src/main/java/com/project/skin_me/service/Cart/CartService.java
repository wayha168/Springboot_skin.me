package com.project.skin_me.service.Cart;

import com.project.skin_me.exception.ResourceNotFoundException;
import com.project.skin_me.model.Cart;
import com.project.skin_me.repository.CartItemRepository;
import com.project.skin_me.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CartService implements ICartService {
    private final CartRepository cartRespository;
    private final CartItemRepository cartItemRespository;

    @Override
    public Cart getCart(Long id) {
        Cart cart = cartRespository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found"));

        BigDecimal totalAmount = cart.getTotalAmount();
        cart.setTotalAmount(totalAmount);

        return cartRespository.save(cart);
    }

    @Override
    public void removeCart(Long id) {
        Cart cart = getCart(id);
        cartItemRespository.removeAllCartId(id);
        cart.getItems().clear();
        cartRespository.removeById(id);

    }

    @Override
    public BigDecimal getTotalPrice(Long id) {
        Cart  cart = getCart(id);
        return cart.getTotalAmount();
    }
}
