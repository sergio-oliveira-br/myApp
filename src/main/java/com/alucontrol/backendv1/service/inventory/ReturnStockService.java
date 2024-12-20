package com.alucontrol.backendv1.service.inventory;

import com.alucontrol.backendv1.exception.ResourceNotFoundException;
import com.alucontrol.backendv1.model.Product;
import com.alucontrol.backendv1.repository.ProductRepository;
import com.alucontrol.backendv1.util.LoggerUtil;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReturnStockService {

    private final ProductRepository productRepository;

    public ReturnStockService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void returnStockAfterRental (String itemDescription, int returnedQuantity) {

        Optional<Product> productOptional = productRepository.findByItemDescription(itemDescription);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            double currentStock = product.getItemAvailableQty();
            product.setItemAvailableQty(currentStock + returnedQuantity);

            LoggerUtil.info("O produto '" + itemDescription + "' teve o estoque retornado em " + returnedQuantity + " un.");

            productRepository.save(product);
            return;
        }

        throw new ResourceNotFoundException("product " + itemDescription + " not found");
    }
}
