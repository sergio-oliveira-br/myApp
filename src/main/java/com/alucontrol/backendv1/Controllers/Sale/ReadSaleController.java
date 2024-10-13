package com.alucontrol.backendv1.Controllers.Sale;

import com.alucontrol.backendv1.Model.Sale;
import com.alucontrol.backendv1.Service.SaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sale")
public class ReadSaleController {

    private final SaleService saleService;

    public ReadSaleController(SaleService saleService) {
        this.saleService = saleService;
    }


    @GetMapping
    public ResponseEntity<List<Sale>> getAllSales() {
        return saleService.findAllSales();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> getSaleById(@PathVariable Long id) {
        return saleService.findSaleById(id);
    }
}