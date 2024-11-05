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
package com.alucontrol.backendv1.repository;

import com.alucontrol.backendv1.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** This is responsible for managing the persistence of SALE data
 *  in the database, providing a simplified interface for CRUD operations */
@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
}
