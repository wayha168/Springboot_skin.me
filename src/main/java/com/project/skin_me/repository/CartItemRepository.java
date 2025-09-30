package com.project.skin_me.repository;

import com.project.skin_me.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
    void removeAllCartId(Long id);
}
