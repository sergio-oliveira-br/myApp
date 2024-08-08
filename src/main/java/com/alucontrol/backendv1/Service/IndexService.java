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
package com.alucontrol.backendv1.Service;

import com.alucontrol.backendv1.Exception.ResourceNotFoundException;
import com.alucontrol.backendv1.Repository.RentRepository;
import com.alucontrol.backendv1.Util.LoggerUtil;
import org.springframework.stereotype.Service;

/**This Service Class has methods that contain business logic.*/
@Service
public class IndexService
{

    //Repository for access to Rent data
    private final RentRepository rentRepository;

    //Constructor responsible for injecting the repository
    public IndexService(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    /** Method: get back the number of rent UNPAID from DB
     *  Pointing to indexScript.js*/
    public Long getQtyRentUnpaid()
    {
        try
        {
            //call the repository method, witch has the info about the RENT
            Long qtyRentUnpaid = rentRepository.countUnpaidRents();

            if(qtyRentUnpaid == null)
            {
                throw new ResourceNotFoundException("Oops! The database does not contain any Unpaid Rent");
            }
            return qtyRentUnpaid;
        }
        catch (Exception e)
        {
            LoggerUtil.error("While searching for unpaid rentals, an error occurred. " + e.getMessage());
            throw new ResourceNotFoundException("Could not find a number of unpaid rentals");
        }
    }



    /**
     * Method: get the number of rent witch has the status "NEW"
     * Pointing to indexScript.js
     */
    public Long getQtyRentStatusNew() {
        try
        {
            //call the repository method, witch has the info about the RENT
            Long qtyRentStatusNew = rentRepository.countRentStatusNew();

            //exception handling
            if (qtyRentStatusNew == null) {
                throw new ResourceNotFoundException("Oops! There are no new Rents in the database");
            }
            return qtyRentStatusNew; //return the number of rent witch has the status "NEW"

        } catch (Exception e) {
            LoggerUtil.error("While searching for new status rentals, an error occurred. " + e.getMessage());
            throw new ResourceNotFoundException("Could not find a number of new status rentals");
        }
    }



    /**
     * Method: get the number of rent witch has the status "IN PROGRESS"
     * Pointing to indexScript.js
     */
    public Long getQtyRentStatusInProgress()
    {
        try
        {
            //Call the repository method, witch has the info about the RENT
            Long qtyRentStatusInProgress = rentRepository.countRentStatusInProgress();

            //exception handling
            if (qtyRentStatusInProgress == null)
            {
                throw new ResourceNotFoundException("Oops! There are no rents in progress the database");
            }

            return qtyRentStatusInProgress; //return a number of rent witch has the status "IN PROGRESS"
        }
        catch (Exception e)
        {
            LoggerUtil.error("While searching for rentals in progress, an error occurred. " + e.getMessage());
            throw new ResourceNotFoundException("Could not find a number of rentals in progress");
        }
    }
}
