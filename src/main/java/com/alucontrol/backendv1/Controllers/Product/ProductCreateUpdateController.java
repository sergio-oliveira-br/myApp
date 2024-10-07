/**
 * National College of Ireland - NCI
 *    Higher Diploma in Computing
 *         Final Project
 *              ---
 * Author: Sergio Vinicio da Silva Oliveira
 * ID: x23170981@student.ncirl.ie
 * Project Commencing May 2024
 * Version: 1.0
 */
package com.alucontrol.backendv1.Controllers.Product;

import com.alucontrol.backendv1.Exception.ProblemDetails;
import com.alucontrol.backendv1.Exception.ResourceNotFoundException;
import com.alucontrol.backendv1.Model.Product;
import com.alucontrol.backendv1.Repository.ProductRepository;
import com.alucontrol.backendv1.Util.LoggerUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**This controller is dedicated to endpoints that create and update records
 * It is the responsibility of this layer to receive requests, call methods from the service layer, and return HTTP responses */
@RestController
public class ProductCreateUpdateController
{
    //Repository for access to product data
    private final ProductRepository productRepository;

    //Constructor responsible for injecting the repository
    public ProductCreateUpdateController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /** Endpoint to send Products to my DB*/
    @PostMapping("/saveProduct")
    public ResponseEntity<?> saveProduct(@RequestBody Product product)
    //the "?" above makes the method be of the generic type or a type that can return different types of response
    {
        try
        {
            //Log
            LoggerUtil.info("Starting to save product with data: " + product);

            //Initialize itemAvailableQty with the same itemQuantity value
            product.setItemAvailableQty(product.getItemQuantity());

            //Save
            Product savedProduct = productRepository.save(product);

            //Log
            LoggerUtil.info("Product saved successfully: " + savedProduct.toString());

            return ResponseEntity.ok(savedProduct);
        }
        catch (Exception e) {
            //Log
            LoggerUtil.error("An error occurred while saving product data." +
                    "Product: " + product.toString() + " | " +
                    "Error: " + e.getMessage(), e);

            ProblemDetails problemDetails = new ProblemDetails(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "An error has been discovered during this operation. | " +
                            "Please report it to technical support with pictures. | " +
                            "Error: " + e.getMessage() + e);

            //Return an internal error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(problemDetails);
        }
    }



    /** Endpoint to update a specific rent by ID */
    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct)
    {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()){
            //Log
            LoggerUtil.info("Starting to update product with data: " + productOptional.toString());

            Product product = productOptional.get();

            //get to set the fields with the same value
            product.setItemDescription(updatedProduct.getItemDescription());
            product.setItemQuantity(updatedProduct.getItemQuantity());
            product.setItemAvailableQty(updatedProduct.getItemAvailableQty()); //why is this different?
            product.setProductType(updatedProduct.getProductType());
            product.setItemPrice(updatedProduct.getItemPrice());
            product.setDateModified(updatedProduct.getDateModified());//this will get data and time when the item has been changed

            Product savedProduct = productRepository.save(product);

            LoggerUtil.info("Product Updated Successfully: " + savedProduct.toString());
            return ResponseEntity.ok(savedProduct);
        }
        else {
            String errorMsg = "Product with id: " + id + " not found";
            LoggerUtil.error(errorMsg);
            throw new ResourceNotFoundException(errorMsg);
        }
    }
}
