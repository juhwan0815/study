package com.example.practicetest.controller;

import com.example.practicetest.domain.Product;
import com.example.practicetest.model.product.ProductResponse;
import com.example.practicetest.model.product.ProductSaveRequest;
import com.example.practicetest.model.product.ProductUpdateRequest;
import com.example.practicetest.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<Void> saveProduct(@RequestBody ProductSaveRequest productSaveRequest){
        productService.saveProduct(productSaveRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/products/{productId}")
    public ResponseEntity<Void> updateProduct(@PathVariable Long productId,
                                              @RequestBody ProductUpdateRequest productUpdateRequest){
        productService.updateProduct(productId,productUpdateRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId){
        productService.deleteProduct(productId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<ProductResponse> findProductById(@PathVariable Long productId){
        Product product = productService.findProductById(productId);
        return ResponseEntity.ok(new ProductResponse(product));
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductResponse>> findProducts(){
        List<Product> products = productService.findProducts();
        List<ProductResponse> productResponseList = products.stream()
                .map(product -> new ProductResponse(product))
                .collect(Collectors.toList());
        return ResponseEntity.ok(productResponseList);
    }
}
