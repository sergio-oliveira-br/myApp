/**
 * National College of Ireland - NCI
 *    Higher Diploma in Computing
 *         Final Project
 *              ---
 * Author: Sergio Vinicio da Silva Oliveira
 * ID: x23170981@student.ncirl.ie
 * Project Commencing May 2024
 * Version: 2.0
 */
package com.alucontrol.backendv1.Controllers.Sale;

import com.alucontrol.backendv1.Model.Product;
import com.alucontrol.backendv1.Repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** This controller is dedicated to endpoints that read data related a Sales */
@RestController
public class SaleReadController {
    //Repository for access to product data
    private final ProductRepository productRepository;

    //Constructor responsible for injecting the repository
    public SaleReadController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**Endpoint to get back product, selecting the Product Type */
    @GetMapping("productByType")
    List<Product> findProductsByProductType(String productType) {
        return productRepository.findProductsByProductType(productType);
    }
}
