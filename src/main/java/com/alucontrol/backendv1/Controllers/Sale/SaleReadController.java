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
import com.alucontrol.backendv1.Model.Sale;
import com.alucontrol.backendv1.Projection.Product.ItemPriceProjection;
import com.alucontrol.backendv1.Repository.ProductRepository;
import com.alucontrol.backendv1.Repository.SaleRepository;
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
    private final SaleRepository saleRepository;

    //Constructor responsible for injecting the repository
    public SaleReadController(ProductRepository productRepository, SaleRepository saleRepository) {
        this.productRepository = productRepository;
        this.saleRepository = saleRepository;
    }

    /** Endpoint to retrieve all sales */
    @GetMapping("/sale")
    public ResponseEntity<List<Sale>> getAllSales() {
        //Log
        LoggerUtil.info("Looking for all sales records.");

        //Retrieve the data by CRUD
        List<Sale> sale = saleRepository.findAll();

        //Log
        LoggerUtil.info("Fetched " + sale.size() + " sales records"); //Create a log

        return ResponseEntity.ok(sale);
    }
}