package com.alucontrol.backendv1.Repository.Rent;

import com.alucontrol.backendv1.Model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/** This would focus on queries related to the status of the payment of the Rent by managing the persistence of Rent data. */
@Repository
public interface RentPaymentStatusRepository extends JpaRepository<Rent, Long> {

    /**
     * Display: Index Page
     * Focus: status of the payment of the rent
     * Method: count the number of rent according the PAYMENT STATUS selected
     */
    @Query("SELECT COUNT(myR) " +
            "FROM Rent myR " +
            "WHERE myR.rentPaymentStatus = :rentPaymentStatus")
    Long countRentByPaymentStatus(String rentPaymentStatus); //two options: "pago" and "a receber"

}
