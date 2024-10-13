package com.alucontrol.backendv1.Controllers.Product;

import com.alucontrol.backendv1.Exception.ResourceNotFoundException;
import com.alucontrol.backendv1.Model.Product;
import com.alucontrol.backendv1.Projection.Product.ItemPriceProjection;
import com.alucontrol.backendv1.Projection.Product.ProductStockProjection;
import com.alucontrol.backendv1.Repository.ProductRepository;
import com.alucontrol.backendv1.Service.ProductService;
import com.alucontrol.backendv1.Util.LoggerUtil;
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
        return productService.findAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        return productService.findProductById(id);
    }

    @GetMapping("/product-by-type")
    public ResponseEntity<List<ItemPriceProjection>> getProductByType(String productType) {
        return productService.findProductByType(productType);
    }

    @GetMapping("/qty/product-by-type")
    public ResponseEntity<List<ProductStockProjection>> getProductQtyByType(String productType) {
        return productService.findProductStockByType(productType);
    }
}
