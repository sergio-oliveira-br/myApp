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
package com.alucontrol.backendv1.Repository;

import com.alucontrol.backendv1.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/** This is responsible for managing the persistence of Product data
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
    @Query(value = "SELECT myP.productType," +
            "myP.itemDescription," +
            "myP.itemPrice " +
            "FROM Product myP WHERE myP.productType = :productType")
    List<Product> findProductsByProductType(String productType);


}
