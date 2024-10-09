package com.alucontrol.backendv1.Controllers.Product;

import com.alucontrol.backendv1.Exception.ResourceNotFoundException;
import com.alucontrol.backendv1.Model.Product;
import com.alucontrol.backendv1.Repository.ProductRepository;
import com.alucontrol.backendv1.Service.ProductService;
import com.alucontrol.backendv1.Util.LoggerUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/create-product")
public class CreateProductController {

    private final ProductRepository productRepository;
    private final ProductService productService;

    public CreateProductController(ProductRepository productRepository, ProductService productService) {
        this.productService = productService;
        this.productRepository = productRepository;
    }


    @PostMapping()
    public ResponseEntity<Product> createProduct(@Validated @RequestBody Product product) {
        return productService.saveProduct(product);
    }



    /** Endpoint to update a specific rent by ID */
    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct)
    {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()){
            //Log
            LoggerUtil.info("Starting to update product with data: " + productOptional.toString());

            Product product = productOptional.get();

            //get to set the fields with the same value
            product.setItemDescription(updatedProduct.getItemDescription());
            product.setItemQuantity(updatedProduct.getItemQuantity());
            product.setItemAvailableQty(updatedProduct.getItemAvailableQty()); //why is this different?
            product.setProductType(updatedProduct.getProductType());
            product.setItemPrice(updatedProduct.getItemPrice());
            product.setDateModified(updatedProduct.getDateModified());//this will get data and time when the item has been changed

            Product savedProduct = productRepository.save(product);

            LoggerUtil.info("Product Updated Successfully: " + savedProduct.toString());
            return ResponseEntity.ok(savedProduct);
        }
        else {
            String errorMsg = "Product with id: " + id + " not found";
            LoggerUtil.error(errorMsg);
            throw new ResourceNotFoundException(errorMsg);
        }
    }
}
