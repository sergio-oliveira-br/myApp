package com.alucontrol.backendv1.Controllers.Sale;

import com.alucontrol.backendv1.Model.Sale;
import com.alucontrol.backendv1.Service.SaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sales")
public class CreateSaleController {

    private final SaleService saleService;

    public CreateSaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping("/create-sale")
    public ResponseEntity<Sale> createSale(@Validated @RequestBody Sale sale) {
        return saleService.saveSale(sale);
    }
}
