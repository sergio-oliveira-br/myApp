package com.alucontrol.backendv1.Service.Inventory;

import com.alucontrol.backendv1.Exception.ResourceNotFoundException;
import com.alucontrol.backendv1.Model.Product;
import com.alucontrol.backendv1.Repository.ProductRepository;
import com.alucontrol.backendv1.Util.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DecreaseStockService {

    private final ProductRepository productRepository;

    @Autowired
    public DecreaseStockService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //Este metodo é responsavel por realizar a subtração do item quando um aluguel for realizado
    public void decreaseStock(String itemDescription, int requestedQuantity) {

        Optional<Product> productOptional = productRepository.findByItemDescription(itemDescription);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();

            if(isStockSufficient(itemDescription, requestedQuantity)) {
                product.setItemAvailableQty(product.getItemAvailableQty() - requestedQuantity);

                LoggerUtil.info("O produto " + itemDescription + " foi reduzido em " + requestedQuantity + "un.");

                productRepository.save(product);
                return;
            }

            throw new ResourceNotFoundException("O produto '" + itemDescription + "' não possui a quantidade " +   requestedQuantity + " solicitada em estoque. " +
                    "Atualmente a quantidade disponivel é " + product.getItemAvailableQty());
        }

        throw new ResourceNotFoundException("O produto '" + itemDescription + "' nao existe.");
    }

    //Verifica se a quantiade solicitada é maior que a quantidade disponivel
    public boolean isStockSufficient (String itemDescription, int requestedQuantity) {

        Optional<Product> productOptional = productRepository.findByItemDescription(itemDescription);
        Product product = productOptional.get();

        return product.getItemAvailableQty() >= requestedQuantity;
    }
}
