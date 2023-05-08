package com.example.productorderservice.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public void createProduct(ProductCreateRequest request) {
        Product product = new Product(request.name(), request.price(), request.discountPolicy());
        productRepository.save(product);
    }

}
