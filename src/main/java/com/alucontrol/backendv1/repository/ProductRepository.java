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
package com.alucontrol.backendv1.repository;

import com.alucontrol.backendv1.model.Product;
import com.alucontrol.backendv1.projection.product.ItemPriceProjection;
import com.alucontrol.backendv1.projection.product.ProductStockProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/** This is responsible for managing the persistence of product data
 *  in the database, providing a simplified interface for CRUD operations
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>
{
    //Method to find a product by description
    Optional<Product> findByItemDescription(String itemDescription);

    /** Display: in Sales.HTML through Sales Controller
     *  Method: Load the Description and Price into Sales Table
     * */
    @Query("SELECT myP.id AS id, " +
            "myP.productType AS productType," +
            "myP.itemDescription AS itemDescription," +
            "myP.itemPrice AS itemPrice " +
            "FROM Product myP " +
            "WHERE myP.productType = :productType")
    List<ItemPriceProjection> findProductsByProductType(String productType);


    /** Display: in Sales.HTML through Sales Controller
     *  Method: Load the Description and Price into Sales Table
     * */
    @Query("SELECT myP.itemDescription AS itemDescription," +
            "myP.itemAvailableQty AS itemAvailableQty " +
            //"myP.productType AS productType " + I DON'T NEED THE FIELD THAT I WILL USE TO SEARCH
            "FROM Product myP " +
            "WHERE myP.productType = :productType")
    List<ProductStockProjection> findProductsAndQtyByProductType(String productType);


    @Query("SELECT p FROM Product p") // Select all columns from the product table
    List<Product> findAllProducts();


}
