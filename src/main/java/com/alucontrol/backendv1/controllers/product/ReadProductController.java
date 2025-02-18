package com.alucontrol.backendv1.controllers.product;

import com.alucontrol.backendv1.model.Product;
import com.alucontrol.backendv1.projection.product.ItemPriceProjection;
import com.alucontrol.backendv1.projection.product.ProductStockProjection;
import com.alucontrol.backendv1.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ReadProductController {

    private final ProductService productService;

    public ReadProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct() {

        List<Product> productsFound = productService.findAllProducts();

        return ResponseEntity.ok(productsFound);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){

        Product productFound = productService.findProductById(id);

        return ResponseEntity.ok(productFound);
    }

    @GetMapping("/product-by-type")
    public ResponseEntity<List<ItemPriceProjection>> getProductByType(String productType) {

        List<ItemPriceProjection> productsFound = productService.findProductByType(productType);

        return ResponseEntity.ok(productsFound);
    }

    @GetMapping("/qty/product-by-type")
    public ResponseEntity<List<ProductStockProjection>> getProductQtyByType(String productType) {

        List<ProductStockProjection> productsFound = productService.findProductStockByType(productType);

        return ResponseEntity.ok(productsFound);
    }
}
