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

import com.alucontrol.backendv1.Exception.ErrorResponse;
import com.alucontrol.backendv1.Model.Product;
import com.alucontrol.backendv1.Repository.ProductRepository;
import com.alucontrol.backendv1.Util.LoggerUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/** This controller is dedicated to endpoints that read data */
@RestController
public class ProductReadController
{
    //Repository for access to product data
    private final ProductRepository productRepository;

    //Constructor responsible for injecting the repository
    public ProductReadController(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    /** Endpoint to get back all products */
    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProduct()
    {
        List<Product> products = productRepository.findAll(); //findAll() is method inherited from CrudRepository
        return ResponseEntity.ok(products);
    }


    /** Endpoint to get a specific product by ID*/
    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProductByID(@PathVariable Long id)
    //the "?" above makes the method be of the generic type or a type that can return different types of response
    {
        try
        {
            Optional<Product> productOptional = productRepository.findById(id);
            if(productOptional.isPresent()) {
                return ResponseEntity.ok(productOptional.get());
            }

            else {
                return ResponseEntity.notFound().build();
            }

        } catch (Exception e) {
            //Log
            LoggerUtil.error("An error occurred while fetching product data." +
                    "Product: " + id+ " | " +
                    "Error: " + e.getMessage(), e);

            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "An error has been discovered during this operation. " +
                            "Please report it to technical support with pictures.");

            //Return an internal error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

}
