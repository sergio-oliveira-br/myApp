/**
 * National College of Ireland - NCI
 *    Higher Diploma in Computing
 *         Final Project
 *              ---
 * Author: Sergio Vinicio da Silva Oliveira
 * ID: x23170981@student.ncirl.ie
 * Project Commencing May 2024
 * Version: 2.0
 */
package com.alucontrol.backendv1.Repository.Rent;

import com.alucontrol.backendv1.Model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/** This would focus on queries related to the status of the Rent by managing the persistence of Rent data. */
@Repository
public interface RentStatusRepository extends JpaRepository<Rent, Long> {

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
