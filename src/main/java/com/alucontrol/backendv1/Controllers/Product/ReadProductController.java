package com.alucontrol.backendv1.Controllers.Product;

import com.alucontrol.backendv1.Exception.ResourceNotFoundException;
import com.alucontrol.backendv1.Model.Product;
import com.alucontrol.backendv1.Projection.Product.ItemPriceProjection;
import com.alucontrol.backendv1.Projection.Product.ItemQtyAvailableProjection;
import com.alucontrol.backendv1.Repository.ProductRepository;
import com.alucontrol.backendv1.Service.ProductService;
import com.alucontrol.backendv1.Util.LoggerUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/product")
public class ReadProductController {

    private final ProductRepository productRepository;
    private final ProductService productService;

    public ReadProductController(ProductRepository productRepository, ProductService productService) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProduct() {
        return productService.findAllProducts();
    }

    /**Endpoint to get back product, selecting the Product Type */
    @GetMapping("/productByType")
    public List<ItemPriceProjection> getProductByType(String productType) {
        LoggerUtil.info("Starting looking for Item and Price by Product Type: " + productType);
        try {
            //handling exceptions
            if (productRepository.findProductsByProductType(productType) == null) {
                throw new ResourceNotFoundException("From Product Controller: It was not possible to locate items");
            }
            return productRepository.findProductsByProductType(productType);

        } catch (Exception e) {
            LoggerUtil.error("An error occurred while fetching items." + " | " +
                    "Error: " + e.getMessage(), e);

            throw new ResourceNotFoundException("An error occurred while fetching items. " + " | " +
                    "Error: " + e.getMessage());
        }
    }

    /**Endpoint to get back product, selecting the Product Type */
    @GetMapping("/productQtyByType")
    public List<ItemQtyAvailableProjection> getProductQtyByType(String productType) {
        LoggerUtil.info("Starting looking for Item and Qty Available by Product Type: " + productType);
        try {
            //handling exceptions
            if (productRepository.findProductsAndQtyByProductType(productType) == null) {
                throw new ResourceNotFoundException("From Product Controller: It was not possible to locate items");
            }
            return productRepository.findProductsAndQtyByProductType(productType);

        } catch (Exception e) {
            LoggerUtil.error("An error occurred while fetching items." + " | " +
                    "Error: " + e.getMessage(), e);

            throw new ResourceNotFoundException("An error occurred while fetching items. " + " | " +
                    "Error: " + e.getMessage());
        }
    }


    /** Endpoint to get a specific product by ID*/
    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProductByID(@PathVariable Long id){

        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()) {
            return ResponseEntity.ok(productOptional.get());
        }
        else {
            throw new ResourceNotFoundException("From Product Controller: It was not possible to locate any items");
        }
    }
}
