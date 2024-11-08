package com.alucontrol.backendv1.controllers.product;

import com.alucontrol.backendv1.model.Product;
import com.alucontrol.backendv1.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/product")
public class CreateProductController {

    private final ProductService productService;

    public CreateProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create-product")
    public ResponseEntity<Product> createProduct(@Validated @RequestBody Product product) {

        Product savedProduct = productService.saveProduct(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }
}
