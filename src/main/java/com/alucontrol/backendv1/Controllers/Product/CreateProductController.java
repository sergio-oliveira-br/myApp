package com.alucontrol.backendv1.Controllers.Product;

import com.alucontrol.backendv1.Model.Product;
import com.alucontrol.backendv1.Service.ProductService;
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
        return productService.saveProduct(product);
    }
}
