package com.alucontrol.backendv1.Service;

import com.alucontrol.backendv1.Exception.ResourceNotFoundException;
import com.alucontrol.backendv1.Util.LoggerUtil;
import com.alucontrol.backendv1.Model.Product;
import com.alucontrol.backendv1.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockService {

    private final ProductRepository productRepository;

    public StockService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }




    /** Used: Product Create Update Controller
     *  Method: Adding (item) stock when closing a rental.*/
    public void addStockByRentalStatusFinished(String itemDescription, int quantity) {
        //Log
        LoggerUtil.info("Start addStockByRentalStatusFinished: " + itemDescription + " Quantity: " + quantity);

        //Search the product by ID
        //Optional: Used to imply that a value may be present or absent in a given circumstance
        Optional<Product> productOptional = productRepository.findByItemDescription(itemDescription);

        //Check if the product was found
        if(productOptional.isPresent()) {
            //Retrieve the value contained in the Optional and allocate it to a Product variable
            Product product = productOptional.get();

            //Add quantity to available stock
            product.setItemAvailableQty(product.getItemAvailableQty() + quantity);
            LoggerUtil.info("The new Qty Available is: " + product.getItemAvailableQty());
            productRepository.save(product);
        }
        //Exception: ID incorrect, product was not found
        else {
            throw new ResourceNotFoundException("The product '" + itemDescription+ "' was not found");
        }
    }
}
