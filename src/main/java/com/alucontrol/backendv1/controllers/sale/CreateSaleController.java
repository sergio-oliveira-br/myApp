package com.alucontrol.backendv1.controllers.sale;

import com.alucontrol.backendv1.model.Sale;
import com.alucontrol.backendv1.service.SaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sale")
public class CreateSaleController {

    private final SaleService saleService;

    public CreateSaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping("/create-sale")
    public ResponseEntity<Sale> createSale(@Validated @RequestBody Sale sale) {

        Sale newSale = saleService.saveSale(sale);

        return ResponseEntity.status(HttpStatus.CREATED).body(newSale);
    }
}
