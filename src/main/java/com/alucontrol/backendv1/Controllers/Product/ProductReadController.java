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

import com.alucontrol.backendv1.Exception.ApiErrorResponse;
import com.alucontrol.backendv1.Exception.ResourceNotFoundException;
import com.alucontrol.backendv1.Model.Product;
import com.alucontrol.backendv1.Projection.Product.ItemPriceProjection;
import com.alucontrol.backendv1.Projection.Product.ItemQtyAvailableProjection;
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

    /**Endpoint to get back product, selecting the Product Type */
    @GetMapping("/productByType")
    public List<ItemPriceProjection> getProductByType(String productType) {
        LoggerUtil.info("Starting looking for Item and Price by Product Type: " + productType);
        try {
            //handling exceptions
            if (productRepository.findProductsByProductType(productType) == null) {
                throw new ResourceNotFoundException("From Product Controller: It was not possible to locate items");
            }
            return productRepository.findProductsByProductType(productType);

        } catch (Exception e) {
            LoggerUtil.error("An error occurred while fetching items." + " | " +
                    "Error: " + e.getMessage(), e);

            throw new ResourceNotFoundException("An error occurred while fetching items. " + " | " +
                    "Error: " + e.getMessage());
        }
    }

    /**Endpoint to get back product, selecting the Product Type */
    @GetMapping("/productQtyByType")
    public List<ItemQtyAvailableProjection> getProductQtyByType(String productType) {
        LoggerUtil.info("Starting looking for Item and Qty Available by Product Type: " + productType);
        try {
            //handling exceptions
            if (productRepository.findProductsAndQtyByProductType(productType) == null) {
                throw new ResourceNotFoundException("From Product Controller: It was not possible to locate items");
            }
            return productRepository.findProductsAndQtyByProductType(productType);

        } catch (Exception e) {
            LoggerUtil.error("An error occurred while fetching items." + " | " +
                    "Error: " + e.getMessage(), e);

            throw new ResourceNotFoundException("An error occurred while fetching items. " + " | " +
                    "Error: " + e.getMessage());
        }
    }


    /** Endpoint to get a specific product by ID*/
    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProductByID(@PathVariable Long id)
    //the "?" above makes the method be of the generic type or a type that can return different types of response
    {
        try {
            Optional<Product> productOptional = productRepository.findById(id);
            if(productOptional.isPresent()) {
                return ResponseEntity.ok(productOptional.get());
            }

            else {
                throw new ResourceNotFoundException("From Product Controller: It was not possible to locate any items");
            }

        } catch (Exception e) {
            ApiErrorResponse apiErrorResponse = new ApiErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Ocorreu um erro ao buscar os dados do produto. Por favor, informe-o para o suporte técnico com fotos." +
                            "Produto: " + id + " | Error: " + e.getMessage() + e);

            LoggerUtil.error("Error: " + apiErrorResponse);

            //Return an internal error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiErrorResponse);
        }
    }

}
