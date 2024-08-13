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

import com.alucontrol.backendv1.Exception.ResourceNotFoundException;
import com.alucontrol.backendv1.Model.Product;
import com.alucontrol.backendv1.Projection.Product.ItemPriceProjection;
import com.alucontrol.backendv1.Repository.ProductRepository;
import com.alucontrol.backendv1.Util.LoggerUtil;
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
    public List<ItemPriceProjection> getProductByType(String productType) {
        LoggerUtil.info("Starting looking for Item and Price by Product Type: " + productType);
        try {
            //handling exceptions
            if (productRepository.findProductsByProductType(productType) == null) {
                throw new ResourceNotFoundException("From Sales Controller: It was not possible to locate items");
            }
            return productRepository.findProductsByProductType(productType);

        } catch (Exception e) {
            LoggerUtil.error("Ann error occurred while fetching items." + " | " +
                    "Error: " + e.getMessage(), e);

            throw new ResourceNotFoundException("Ann error occurred while fetching items. " + " | " +
                    "Error: " + e.getMessage());
        }
    }
}