package com.alucontrol.backendv1.Service;

import com.alucontrol.backendv1.Exception.DataAccessException;
import com.alucontrol.backendv1.Exception.InternalServerException;
import com.alucontrol.backendv1.Exception.ResourceNotFoundException;
import com.alucontrol.backendv1.Model.Sale;
import com.alucontrol.backendv1.Repository.SaleRepository;
import com.alucontrol.backendv1.Service.Inventory.DecreaseStockService;
import com.alucontrol.backendv1.Util.LoggerUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    private final SaleRepository saleRepository;
    private final DecreaseStockService decreaseStockService;

    public SaleService(SaleRepository saleRepository, DecreaseStockService decreaseStockService) {
        this.saleRepository = saleRepository;
        this.decreaseStockService = decreaseStockService;
    }

    //Metodo para salvar uma nova venda
    public Sale saveSale(Sale sale) {

        try {
            Sale savedSale = saleRepository.save(sale);
            decreaseStockService.decreaseStock(sale.getSaleItem(), sale.getSaleQtyItem());
            LoggerUtil.info("Sale saved successfully: " + savedSale);
            return savedSale;
        }
        catch (DataAccessException e){
            LoggerUtil.error("Error while saving sale: " + sale, e);
            throw new InternalServerException("Failed to save sale data. " + e.getMessage());
        }
    }

    //Metodo para atualizar uma venda ja existente no BD atraves do ID.
    public Sale saveSaleChanges(Sale sale, Long id) {

       Optional<Sale> optionalSale = saleRepository.findById(id);

       if (optionalSale.isPresent()) {
           Sale savedSale = saleRepository.save(sale);

           LoggerUtil.info("Sale updated successfully: " + savedSale);
           return savedSale;
       }
       throw new ResourceNotFoundException("Sale ID: " + id + " not found.");
    }

    //Metodo de leitura, buscando todos as vendas na base de dados
    public ResponseEntity<List<Sale>> findAllSales () {

        List<Sale> sales = saleRepository.findAll();
        return ResponseEntity.ok(sales);
    }

    //Metodo de leiteura responsavel por buscar uma venda específica atraves do ID.
    public ResponseEntity<Sale> findSaleById(Long id) {

        Optional<Sale> optionalSale = saleRepository.findById(id);
        if (optionalSale.isPresent()) {
            return ResponseEntity.ok(optionalSale.get());
        }

        throw new ResourceNotFoundException("Venda com ID: " + id + "não encontrada.");
    }

}
