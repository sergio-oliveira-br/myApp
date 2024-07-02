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
import com.alucontrol.backendv1.Projection.SummaryRentStatusProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/** This is responsible for managing the persistence of Rent data
 *  in the database, providing a simplified interface for CRUD operations
 */
@Repository
public interface RentRepository extends JpaRepository<Rent, Long>
{
    /** Display: on Index.html via HomeController
     *  Item: UNPAID RENT
     *  Method: Counting of unpaid rented records and display on the card
     * */
    @Query(value = "SELECT COUNT(QtyRentStatusUnpaidProjection.rentPaymentStatus) AS rentPaymentStatus " +
            "FROM Rent QtyRentStatusUnpaidProjection " +
            "WHERE rentPaymentStatus = 'Unpaid'")
    Long countUnpaidRents();



    /** Display: on Index.html via HomeController
     *  Item: NEW
     *  Method: Rental count with status of: "NEW"
     * */
    @Query(value = "SELECT COUNT(RentStatusProjection.rentStatus) " +
            "FROM Rent RentStatusProjection " +
            "WHERE RentStatusProjection.rentStatus = 'New'")
    Long countRentStatusNew();


    /** Display: on Index.html via HomeController
     *  Item: In Progress
     *  Method: Rental count with status of: "In Progress"
     * */
    @Query(value = "SELECT COUNT(RentStatusProjection.rentStatus) " +
            "FROM Rent RentStatusProjection " +
            "WHERE RentStatusProjection.rentStatus = 'In Progress'")
    Long countRentStatusInProgress();



    /** Display: on Index.html via HomeController
     * Status: NEW
     * Method: Display a table with ALL Rents witch status is NEW
     * */
    @Query(value = "SELECT RentStatusProjection.id AS id, " +
            "RentStatusProjection.rentFirstName AS rentFirstName, " +
            "RentStatusProjection.rentQtyItem AS rentQtyItem, " +
            "RentStatusProjection.rentAddress AS rentAddress, " +
            "RentStatusProjection.rentPrice AS rentPrice," +
            "RentStatusProjection.rentStarts AS rentStarts," +
            "RentStatusProjection.rentEnds AS rentEnds," +
            "RentStatusProjection.rentDetails AS rentDetails," +
            "RentStatusProjection.rentTotalDays AS rentTotalDays," +
            "RentStatusProjection.rentItem AS rentItem, " +
            "RentStatusProjection.rentPaymentStatus AS rentPaymentStatus," +
            "RentStatusProjection.rentTotalPrice AS rentTotalPrice, " +
            "RentStatusProjection.rentStatus  AS rentStatus " +
            "FROM Rent RentStatusProjection " + //This data came from Projection
            "WHERE rentStatus = 'New'")
    List<SummaryRentStatusProjection> getNewRentsList();



    /** Display: on Index.html via HomeController
     * Status: IN PROGRESS
     * Method: Display a table with ALL Rents witch status is 'In Progress'
     * */
    @Query(value = "SELECT RentStatusProjection.id AS id, " +
            "RentStatusProjection.rentFirstName AS rentFirstName, " +
            "RentStatusProjection.rentQtyItem AS rentQtyItem, " +
            "RentStatusProjection.rentAddress AS rentAddress, " +
            "RentStatusProjection.rentPrice AS rentPrice," +
            "RentStatusProjection.rentStarts AS rentStarts," +
            "RentStatusProjection.rentEnds AS rentEnds," +
            "RentStatusProjection.rentDetails AS rentDetails," +
            "RentStatusProjection.rentTotalDays AS rentTotalDays," +
            "RentStatusProjection.rentItem AS rentItem, " +
            "RentStatusProjection.rentPaymentStatus AS rentPaymentStatus," +
            "RentStatusProjection.rentTotalPrice AS rentTotalPrice, " +
            "RentStatusProjection.rentStatus  AS rentStatus " +
            "FROM Rent RentStatusProjection " + //This data came from Projection
            "WHERE rentStatus = 'In Progress'")
    List<SummaryRentStatusProjection> getInProgressRentsList();


    /** Display: on Index.html via HomeController
     * Status: SOLD
     * Method: Display a table with ALL Rents witch status is 'Sold'
     * */
    @Query(value = "SELECT RentStatusProjection.id AS id, " +
            "RentStatusProjection.rentFirstName AS rentFirstName, " +
            "RentStatusProjection.rentQtyItem AS rentQtyItem, " +
            "RentStatusProjection.rentAddress AS rentAddress, " +
            "RentStatusProjection.rentPrice AS rentPrice," +
            "RentStatusProjection.rentStarts AS rentStarts," +
            "RentStatusProjection.rentEnds AS rentEnds," +
            "RentStatusProjection.rentDetails AS rentDetails," +
            "RentStatusProjection.rentTotalDays AS rentTotalDays," +
            "RentStatusProjection.rentItem AS rentItem, " +
            "RentStatusProjection.rentPaymentStatus AS rentPaymentStatus," +
            "RentStatusProjection.rentTotalPrice AS rentTotalPrice, " +
            "RentStatusProjection.rentStatus  AS rentStatus " +
            "FROM Rent RentStatusProjection " + //This data came from Projection
            "WHERE rentStatus = 'Sold'") //Filter
    List<SummaryRentStatusProjection> getSoldItems();


    /** Display: on Index.html via HomeController
     * Status: UNPAID
     * Method: Display a table with ALL Rents witch status is 'Unpaid'
     * */
    @Query(value = "SELECT RentStatusProjection.id AS id, " +
            "RentStatusProjection.rentFirstName AS rentFirstName, " +
            "RentStatusProjection.rentQtyItem AS rentQtyItem, " +
            "RentStatusProjection.rentAddress AS rentAddress, " +
            "RentStatusProjection.rentPrice AS rentPrice," +
            "RentStatusProjection.rentStarts AS rentStarts," +
            "RentStatusProjection.rentEnds AS rentEnds," +
            "RentStatusProjection.rentDetails AS rentDetails," +
            "RentStatusProjection.rentTotalDays AS rentTotalDays," +
            "RentStatusProjection.rentItem AS rentItem, " +
            "RentStatusProjection.rentPaymentStatus AS rentPaymentStatus," +
            "RentStatusProjection.rentTotalPrice AS rentTotalPrice, " +
            "RentStatusProjection.rentStatus  AS rentStatus " +
            "FROM Rent RentStatusProjection " + //This data came from Projection
            "WHERE rentPaymentStatus = 'Unpaid'") //Filter
    List<SummaryRentStatusProjection> getUnpaidRents();



    /** Display: on Index.html via HomeController
     * Status: PAID
     * Method: Display a table with ALL Rents witch status is 'Paid'
     * */
    @Query(value = "SELECT RentStatusProjection.id AS id, " +
            "RentStatusProjection.rentFirstName AS rentFirstName, " +
            "RentStatusProjection.rentQtyItem AS rentQtyItem, " +
            "RentStatusProjection.rentAddress AS rentAddress, " +
            "RentStatusProjection.rentPrice AS rentPrice," +
            "RentStatusProjection.rentStarts AS rentStarts," +
            "RentStatusProjection.rentEnds AS rentEnds," +
            "RentStatusProjection.rentDetails AS rentDetails," +
            "RentStatusProjection.rentTotalDays AS rentTotalDays," +
            "RentStatusProjection.rentItem AS rentItem, " +
            "RentStatusProjection.rentPaymentStatus AS rentPaymentStatus," +
            "RentStatusProjection.rentTotalPrice AS rentTotalPrice, " +
            "RentStatusProjection.rentStatus  AS rentStatus " +
            "FROM Rent RentStatusProjection " + //This data came from Projection
            "WHERE rentPaymentStatus = 'Paid'") //Filter
    List<SummaryRentStatusProjection> getPaidRents();






    //******************************

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



    //******************************


    /** Display: on Report Page via RentReadController
     *  by Date -> Month and Year (RENT -> RentStarts is the reference)
     *  Method: List all info by selecting the date (Projection is not necessary, 'cause I want all data)
     * */
    @Query("SELECT myR " +
            "FROM Rent myR " +
            "WHERE myR.rentStarts LIKE CONCAT(:year, '-%', :month, '%')") //(meaning: % is a wildcard character that means "anything")
    List<Rent> findByYearAndMonth(String year, String month);

}


