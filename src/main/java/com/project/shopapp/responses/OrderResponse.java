package com.project.shopapp.responses;

import com.project.shopapp.models.Order;
import com.project.shopapp.models.OrderDetail;
import lombok.*;
import org.aspectj.weaver.ast.Or;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {
    private Long id;
    private Long userId;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String address;
    private String note;
    private LocalDate orderDate;
    private String status;
    private double totalMoney;
    private String shippingMethod;
    private String shippingAddress;
    private LocalDate shippingDate;
    private String paymentMethod;
    private List<OrderDetail> orderDetails;
    public static OrderResponse fromOrder(Order order){
        return OrderResponse
                .builder()
                .id(order.getId())
                .userId(order.getUser().getId())
                .fullName(order.getFullName())
                .phoneNumber(order.getPhoneNumber())
                .email(order.getEmail())
                .address(order.getAddress())
                .note(order.getNote())
                .orderDate(order.getOrderDate())
                .status(order.getStatus())
                .totalMoney(order.getTotalMoney())
                .shippingMethod(order.getShippingMethod())
                .shippingAddress(order.getShippingAddress())
                .shippingDate(order.getShippingDate())
                .paymentMethod(order.getPaymentMethod())
                .orderDetails(order.getOrderDetails())
                .build();
    }
}
