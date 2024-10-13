package com.alucontrol.backendv1.Controllers.Sale;

import com.alucontrol.backendv1.Model.Sale;
import com.alucontrol.backendv1.Repository.ProductRepository;
import com.alucontrol.backendv1.Repository.SaleRepository;
import com.alucontrol.backendv1.Service.SaleService;
import com.alucontrol.backendv1.Util.LoggerUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/sales")
public class ReadSaleController {

    private final SaleService saleService;

    public ReadSaleController(SaleService saleService) {
        this.saleService = saleService;
    }


    @GetMapping
    public ResponseEntity<List<Sale>> getAllSales() {
        return saleService.findAllSales();
    }

    /** Endpoint to get a specific SALE by ID (by clicking on Edit into the table)*/
    @GetMapping("/sale/{id}")
    public ResponseEntity<Sale> getSaleById(@PathVariable Long id) {
        LoggerUtil.info("Looking for sale record with id: " + id);

        Optional<Sale> sale = saleRepository.findById(id);
        if (sale.isPresent()) {
            LoggerUtil.info("Fetched sale record with id: " + id);
            return ResponseEntity.ok(sale.get());
        }
        return ResponseEntity.notFound().build();
    }
}