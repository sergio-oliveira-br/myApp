package com.alucontrol.backendv1.Controllers.Product;

import com.alucontrol.backendv1.Model.Product;
import com.alucontrol.backendv1.Service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/update-product")
public class UpdateProductController {

    private final ProductService productService;

    public UpdateProductController(ProductService productService) {
        this.productService = productService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.saveProductChanges(product, id);
    }
}
