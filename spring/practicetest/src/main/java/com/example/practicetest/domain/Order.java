package com.example.practicetest.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "orders")
public class Order extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "order_id")
    private Long id;

    private int count;

    private int totalPrice;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    public static Order createOrder(int count,Member member,Product product){
        Order order = new Order();
        order.count = count;
        order.totalPrice = count * product.getPrice();
        order.member = member;
        order.product = product;
        order.status = OrderStatus.ORDER;
        product.minusStockQuantity(count);
        return order;
    }

    public void cancel() {
        this.status = OrderStatus.CANCEL;
        this.product.plusStockQuantity(count);
    }
}
