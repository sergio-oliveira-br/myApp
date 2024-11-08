package com.alucontrol.backendv1.service;

import com.alucontrol.backendv1.exception.DataAccessException;
import com.alucontrol.backendv1.exception.InternalServerException;
import com.alucontrol.backendv1.exception.ResourceNotFoundException;
import com.alucontrol.backendv1.model.Sale;
import com.alucontrol.backendv1.repository.SaleRepository;
import com.alucontrol.backendv1.service.inventory.DecreaseStockService;
import com.alucontrol.backendv1.util.LoggerUtil;
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
            LoggerUtil.info("sale saved successfully: " + savedSale);
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

           LoggerUtil.info("sale updated successfully: " + savedSale);
           return savedSale;
       }
       throw new ResourceNotFoundException("sale ID: " + id + " not found.");
    }

    //Metodo de leitura, buscando todos as vendas na base de dados
    public List<Sale> findAllSales () {

        return saleRepository.findAll();
    }

    //Metodo de leiteura responsavel por buscar uma venda específica atraves do ID.
    public Sale findSaleById(Long id) {

        Optional<Sale> saleFound = saleRepository.findById(id);
        if (saleFound.isPresent()) {
            return saleFound.get();
        }
        throw new ResourceNotFoundException("sale ID: " + id + " not found.");
    }
}
