package com.alucontrol.backendv1.Controllers.Product;

import com.alucontrol.backendv1.Model.Product;
import com.alucontrol.backendv1.Service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class UpdateProductController {

    private final ProductService productService;

    public UpdateProductController(ProductService productService) {
        this.productService = productService;
    }

    @PutMapping("/update-product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {

        Product updatedProduct = productService.saveProductChanges(product, id);
        return ResponseEntity.ok(updatedProduct);
    }
}
