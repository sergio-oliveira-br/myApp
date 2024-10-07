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
package com.alucontrol.backendv1.Controllers.Dashboard;

import com.alucontrol.backendv1.Projection.Rent.ItemQtyDateProjection;
import com.alucontrol.backendv1.Projection.Rent.ItemsTotalPriceProjection;
import com.alucontrol.backendv1.Projection.Rent.TotalRentProjection;
import com.alucontrol.backendv1.Repository.DashboardRepository;
import com.alucontrol.backendv1.Util.LoggerUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** This controller contains specific methods for custom operations
 * It is the responsibility of this layer to receive requests, call methods from the service layer, and return HTTP responses */
@RestController
public class DashboardController
{
    //Repository for access to Dash data
    private final DashboardRepository dashboardRepository;

    //Constructor responsible for injecting the repository
    public DashboardController(DashboardRepository dashboardRepository)
    {
        this.dashboardRepository = dashboardRepository;
    }


    /** Endpoint to get items and SUM of total prices
     * Pointing to dashboardScript.js */
    @GetMapping("/items-total-price")
    //Remember: A Projection interface aims to determine
    //which fields of an entity or dataset are to be selected or projected during a query
    public List<ItemsTotalPriceProjection> retrieveItemsWithTotalPrices()
    {
        try{
            //handling exceptions
            if(dashboardRepository.findItemsTotalPrice() == null)
            {
                throw new ResourceNotFoundException("From DashboardController: It was not possible to locate " +
                                                        "items to calculate the total price");
            }
            return dashboardRepository.findItemsTotalPrice();
        }
        catch (Exception e)
        {
            LoggerUtil.error("An error occurred while fetching items and their total prices: " + e.getMessage(), e);
            throw new ResourceNotFoundException("Failed to retrieve items and their total prices");
        }
    }


    /** Endpoint to get the quantity of items grouped by item
     * Pointing to dashboardScript.js */
    @GetMapping("/item-quantity")
    //A Projection interface aims to determine which fields of an entity or dataset are to be selected or projected during a query
    public List<ItemQtyDateProjection> retrieveQtyItemsRented()
    {
        try {
            //exception handling
            if(dashboardRepository.findQtyItems() == null)
            {
                throw new ResourceNotFoundException("From DashboardController: Rent items not found");
            }
            return dashboardRepository.findQtyItems();
        }
        catch (Exception e)
        {
            LoggerUtil.error("An error occurred while fetching rent items: " + e.getMessage(), e);
            throw new ResourceNotFoundException("Failed to retrieve rent items");
        }
    }

    /** Endpoint to get all rent separated by status payment status "paid or unpaid"
     * Pointing to dashboardScript.js */
    @GetMapping("/rent-payment-status")
    //A Projection interface aims to determine which fields of an entity or dataset are to be selected or projected during a query
    public List<TotalRentProjection> retrieveRentByPaymentStatus()
    {
        try
        {
            if(dashboardRepository.findRentByPaymentStatus() == null)
            {
                throw new ResourceNotFoundException("From DashboardController: Rent payment status not found");
            }
            return dashboardRepository.findRentByPaymentStatus();
        }
        catch (Exception e)
        {
            LoggerUtil.error("An error occurred while fetching rent payment: " + e.getMessage(), e);
            throw new ResourceNotFoundException("Failed to retrieve rent payment");
        }
    }
}
