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

import com.alucontrol.backendv1.Model.Expense;
import com.alucontrol.backendv1.Model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/** This is responsible for managing the persistence of Rent data
 *  in the database, providing a simplified interface for CRUD operations
 */
@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {

    /** Display: on Index.html via HomeController
     * Method: Display a table with ALL Rents witch by selecting the Payment Status
     * */
    @Query("SELECT myRPaymentStatus " +
            "FROM Rent myRPaymentStatus " +
            "WHERE myRPaymentStatus.rentPaymentStatus = :paymentStatus")
    List<Rent> findRentByPaymentStatus(String paymentStatus);



    /** Display: on Index.html via HomeController
     * Method: Display a table with ALL Rents witch by selecting the Status
     * */
    @Query("SELECT myRStatus " +
            "FROM Rent myRStatus " +
            "WHERE myRStatus.rentStatus = :rentStatus")
    List<Rent> findRentByStatus(String rentStatus);


    /** Display: on Report Page via RentReadController
     *  by Date -> Month and Year (RENT -> RentStarts is the reference)
     *  Method: List all info by selecting the date (Projection is not necessary, 'cause I want all data)
     * */
    @Query("SELECT myR " +
            "FROM Rent myR " +
            "WHERE myR.rentStarts LIKE CONCAT(:year, '-%', :month, '%')") //(meaning: % is a wildcard character that means "anything")
    List<Rent> findByYearAndMonth(String year, String month);



    /** Display: on Index Page via RentReadController
     *  by Name -> Customer Name (RENT -> RentFirstName is the reference)
     *  Method: List all info by selecting the Customer Name (Projection is not necessary, 'cause I want all data)
     * */
    @Query("SELECT myR " +
            "FROM Rent myR " +
            "WHERE myR.rentFirstName LIKE :name") //Finds any values that start with "name"
    List<Rent> findRentByFirstName(String name);


    /**
     * Display: Index Page
     * Focus: status of the payment of the rent
     * Method: count the number of rent according the PAYMENT STATUS selected
     */
    @Query("SELECT COUNT(myR) " +
            "FROM Rent myR " +
            "WHERE myR.rentPaymentStatus = :rentPaymentStatus")
    Long countRentByPaymentStatus(String rentPaymentStatus); //two options: "pago" and "a receber"


    /**
     * Display: Index Page
     * Focus: status of the rent
     * Method: count the number of rent according the status selected
     */
    @Query("SELECT COUNT(myR.rentStatus) AS rentStatus " +
            "FROM Rent myR " +
            "WHERE myR.rentStatus = :rentStatus")
    Long countRentByStatus(String rentStatus);

}


