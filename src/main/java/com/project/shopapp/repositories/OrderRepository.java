package com.project.shopapp.repositories;

import com.project.shopapp.models.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    //Tìm các đơn hàng của 1 user nào đó
    List<Order> findByUserId(Long userId);

    @Query("SELECT o from Order o where o.active = true " +
            "and (:keyword is null or :keyword = '' " +
            "or o.fullName like %:keyword% " +
            "or o.address like %:keyword% " +
            "or o.note like %:keyword% " +
            "or o.email like %:keyword%)")
    Page<Order> findByKeyword(String keyword, Pageable pageable);
}
