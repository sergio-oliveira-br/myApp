package com.alucontrol.backendv1.controllers.sale;

import com.alucontrol.backendv1.model.Sale;
import com.alucontrol.backendv1.service.SaleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sale")
public class UpdateSaleController {

    private final SaleService saleService;

    @Autowired
    public UpdateSaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PutMapping("/update-sale/{id}")
    public ResponseEntity<Sale> updateSale(@Validated @RequestBody Sale sale,
                                           @Valid @PathVariable("id") Long id){

        Sale updatedSale = saleService.saveSaleChanges(sale, id);

        return ResponseEntity.ok(updatedSale);
    }
}
