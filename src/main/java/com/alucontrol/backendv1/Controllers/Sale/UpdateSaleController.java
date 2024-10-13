package com.alucontrol.backendv1.Controllers.Sale;

import com.alucontrol.backendv1.Model.Sale;
import com.alucontrol.backendv1.Service.SaleService;
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
    public ResponseEntity<Sale> updateSale(@Validated @RequestBody Sale sale, @PathVariable("id") Long id){
        return saleService.saveSaleChanges(sale, id);
    }
}
