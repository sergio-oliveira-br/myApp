package com.alucontrol.backendv1.Service.Inventory;

import com.alucontrol.backendv1.Exception.ResourceNotFoundException;
import com.alucontrol.backendv1.Model.Product;
import com.alucontrol.backendv1.Repository.ProductRepository;
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
            double item = product.getItemAvailableQty();
            product.setItemAvailableQty(item + returnedQuantity);

            productRepository.save(product);
        }

        throw new ResourceNotFoundException("Product " + itemDescription + " not found");
    }
}
