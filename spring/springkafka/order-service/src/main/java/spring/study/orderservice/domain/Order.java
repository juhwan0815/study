package spring.study.orderservice.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Getter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    private Integer totalPrice;

    private Integer count;

    private Long productId;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public static Order createOrder(int count, int price, Long productId){
        Order order = new Order();
        order.totalPrice = count * price;
        order.count = count;
        order.productId = productId;
        order.status = OrderStatus.PENDING;
        return order;
    }

    public void SuccessOrder(){
        this.status = OrderStatus.ORDER;
    }

    public void cancel(){
        this.status = OrderStatus.CANCEL;
    }

}
