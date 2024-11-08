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


import com.alucontrol.backendv1.model.Rent;
import com.alucontrol.backendv1.projection.rent.ItemQtyDateProjection;
import com.alucontrol.backendv1.projection.rent.ItemsTotalPriceProjection;
import com.alucontrol.backendv1.projection.rent.TotalRentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface DashboardRepository extends JpaRepository<Rent, Long>
{
    /** This creates a table that display item and your respective total price rented */
    @Query("SELECT RentProjection.rentItem AS rentItem," +
            "SUM(RentProjection.rentTotalPrice) AS rentTotalPrice " +
            "FROM Rent RentProjection " +
            "GROUP BY RentProjection.rentItem")
    List<ItemsTotalPriceProjection> findItemsTotalPrice();


    /**This method will present each item rented */
    @Query("SELECT RentProjection.rentItem AS rentItem, " +
            "RentProjection.rentTotalPrice AS rentTotalPrice " +
            "FROM Rent RentProjection")
    List<ItemsTotalPriceProjection> findRentItems();


    /**This method will present all rent separated by status */
    @Query("SELECT RentProjection.rentPaymentStatus AS rentPaymentStatus," +
            "SUM(RentProjection.rentTotalPrice) AS rentTotalPrice " +
            "FROM Rent RentProjection " +
            "GROUP BY RentProjection.rentPaymentStatus")
    List<TotalRentProjection> findRentByPaymentStatus();

    /** This method will present all quantity of the items rented */
    @Query("SELECT myR.rentItem AS rentItem, SUM(myR.rentQtyItem) AS rentQtyItem FROM Rent myR GROUP BY myR.rentItem")
    List<ItemQtyDateProjection> findQtyItems();

}
