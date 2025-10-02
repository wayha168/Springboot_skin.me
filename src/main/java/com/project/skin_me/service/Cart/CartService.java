package com.project.skin_me.service.Cart;

import com.project.skin_me.exception.ResourceNotFoundException;
import com.project.skin_me.model.Cart;
import com.project.skin_me.repository.CartItemRepository;
import com.project.skin_me.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class CartService implements ICartService {

    private final CartRepository cartRespository;
    private final CartItemRepository cartItemRespository;
    private final AtomicLong cartIdGenerator = new AtomicLong(0);

    @Override
    public Cart getCart(Long id) {
        return cartRespository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found"));
    }

    @Override
    public void removeCart(Long id) {
        Cart cart = getCart(id);
        cartItemRespository.deleteByCartId(id);
        cart.getItems().clear();
        cartRespository.deleteById(id);

    }

    @Override
    public BigDecimal getTotalPrice(Long id) {
        Cart cart = getCart(id);
        return cart.getTotalAmount();
    }

    @Override
    public Long initializeNewCart() {
        Cart newCart = new Cart();
        Long newCartId = cartIdGenerator.incrementAndGet();
        newCart.setId(newCartId);
        return cartRespository.save(newCart).getId();

    }
}
