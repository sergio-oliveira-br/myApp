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
package com.alucontrol.backendv1.Controllers.Rent;

import com.alucontrol.backendv1.Repository.RentRepository;
import org.springframework.web.bind.annotation.RestController;

/** This controller contains specific methods for custom operations
 *  It is the responsibility of this layer to receive requests, call methods from the service layer, and return HTTP responses*/
@RestController
public class RentStatisticsController
{
    //Repository for access to product data
    private final RentRepository rentRepository;

    //Constructor responsible for injecting the repository
    public RentStatisticsController(RentRepository rentRepository)
    {
        this.rentRepository = rentRepository;
    }


}
