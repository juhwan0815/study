package spring.study.productservice.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer stock;

    private Integer price;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public static Product createProduct(String name, int stock, int price) {
        Product product = new Product();
        product.name = name;
        product.stock = stock;
        product.price = price;
        return product;
    }

    public void minusStock(int changeStock) {
        if ((stock - changeStock) < 0) {
            throw new IllegalStateException();
        }
        this.stock -= changeStock;
    }

    public void plusStock(int changeStock){
        this.stock += changeStock;
    }
}
