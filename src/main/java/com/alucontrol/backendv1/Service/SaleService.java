package com.alucontrol.backendv1.Service;

import com.alucontrol.backendv1.Exception.ResourceNotFoundException;
import com.alucontrol.backendv1.Model.Sale;
import com.alucontrol.backendv1.Repository.SaleRepository;
import com.alucontrol.backendv1.Util.LoggerUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SaleService {

    private final SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    //Metodo para salvar uma nova venda
    public ResponseEntity<Sale> saveSale(Sale sale) {

        Sale savedSale = saleRepository.save(sale);
        LoggerUtil.info("Venda salva com sucesso. ID: " + savedSale.toString());
        return ResponseEntity.ok(savedSale);
    }

    //Metodo para atualizar uma venda ja existente no BD atraves do ID.
    public ResponseEntity<Sale> saveSaleChanges(Sale sale, Long id) {

       Optional<Sale> optionalSale = saleRepository.findById(id);
       if (optionalSale.isPresent()) {
           Sale savedSale = saleRepository.save(sale);

           LoggerUtil.info("Venda salva com sucesso. ID: " + savedSale.toString());
           return ResponseEntity.ok(savedSale);
       }

       throw new ResourceNotFoundException("Venda ID: " + id + " não encontrada.");
    }
}
