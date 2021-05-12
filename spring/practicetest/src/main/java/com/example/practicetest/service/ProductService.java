package com.example.practicetest.service;

import com.example.practicetest.domain.Product;
import com.example.practicetest.exception.MemberException;
import com.example.practicetest.exception.ProductException;
import com.example.practicetest.model.product.ProductSaveRequest;
import com.example.practicetest.model.product.ProductUpdateRequest;
import com.example.practicetest.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public Product saveProduct(ProductSaveRequest productSaveRequest) {

        Product product = Product.createProduct(productSaveRequest.getName(),
                                                productSaveRequest.getStockQuantity(),
                                                productSaveRequest.getPrice());

        Product savedProduct = productRepository.save(product);
        return savedProduct;

    }

    @Transactional
    public Product updateProduct(Long productId, ProductUpdateRequest productUpdateRequest) {
        Product findProduct = productRepository.findById(productId)
                .orElseThrow(() -> new ProductException("존재하지 않는 상품입니다."));

        findProduct.updateProduct(productUpdateRequest.getPrice(),
                                  productUpdateRequest.getStockQuantity());
        return findProduct;
    }

    @Transactional
    public void deleteProduct(Long productId) {
        Product findProduct = productRepository.findById(productId)
                .orElseThrow(() -> new ProductException("존재하지 않는 상품입니다."));

        findProduct.changeStatus();
    }

    public Product findProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new MemberException());
    }

    public List<Product> findProducts() {
        return productRepository.findAll();
    }
}
