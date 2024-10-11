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


import com.alucontrol.backendv1.Model.Sale;
import com.alucontrol.backendv1.Repository.SaleRepository;
import com.alucontrol.backendv1.Service.StockService;
import com.alucontrol.backendv1.Util.LoggerUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**This controller is dedicated to endpoints that create and update records
 * It is the responsibility of this layer to receive requests, call methods from the service layer, and return HTTP responses.*/
@RestController
public class SaleCreateUpdateController {
    //Repository for access to Sale data
    private final SaleRepository saleRepository;
    private final StockService stockService;

    //Constructor responsible for injecting the repository
    public SaleCreateUpdateController(SaleRepository saleRepository, StockService stockService) {
        this.saleRepository = saleRepository;
        this.stockService = stockService;
    }

    /**Endpoint responsible to create sales*/
    @PostMapping("/saveSale") //Remember: POST is a method from CRUD used to CREATE data
    public ResponseEntity<Sale> saveSale(@RequestBody Sale sale){

        //log before saved
        LoggerUtil.info("Starting to create a sale with data: " + sale);

        //Business Logic - subtract the stock
        //stockService.subtractStock(sale.getSaleItem(), sale.getSaleQtyItem());

        //Saving the data into DB
        Sale savedSale = saleRepository.save(sale);

        //log after saved and return
        LoggerUtil.info("Sale created successfully: " + savedSale.toString());
        return ResponseEntity.ok(savedSale);
    }

    /** Endpoint to update a specific Sale by ID */
    @PutMapping("/sale/{id}")
    public ResponseEntity<Sale> updateSale(@PathVariable Long id, @RequestBody Sale sale) {
        LoggerUtil.info("Updating sale record with id: " + id);
        Optional<Sale> existingSale = saleRepository.findById(id);
        if (existingSale.isPresent()) {
            LoggerUtil.info("Updating sale record with id: " + id);
            Sale updatedSale = saleRepository.save(sale);

            LoggerUtil.info("Sale updated successfully: " + updatedSale.toString());
            return ResponseEntity.ok(updatedSale);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
