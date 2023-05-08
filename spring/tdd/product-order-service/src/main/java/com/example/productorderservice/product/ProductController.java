package com.example.productorderservice.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<Void> createProduct(@RequestBody ProductCreateRequest request) {
        productService.createProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<ProductResponse> findProduct(@PathVariable Long productId) {
        ProductResponse response = productService.findProduct(productId);
        return ResponseEntity.ok(response);
    }

}
