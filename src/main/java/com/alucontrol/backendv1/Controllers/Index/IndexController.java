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
package com.alucontrol.backendv1.Controllers.Index;

import com.alucontrol.backendv1.Repository.RentRepository;
import com.alucontrol.backendv1.Service.IndexService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** This controller is dedicated to endpoints that will display information on indexPage
 *  It is the responsibility of this layer to receive requests, call methods from the service layer, and return HTTP responses*/
@RestController
public class IndexController
{
    //Repository for access to Rent data
    private final IndexService indexService;
    private final RentRepository rentRepository;

    //Constructor responsible for injecting the repository
    public IndexController(IndexService indexService, RentRepository rentRepository)
    {
        this.indexService =  indexService;
        this.rentRepository = rentRepository;
    }

//    /** Main endpoint for the home page, indicating that the endpoint is active  */
//    @GetMapping("/")
//    public String home()
//    {
//        return "index";
//    }


    /** Endpoint to get back the number of rent UNPAID from DB
     *  Pointing to indexScript.js*/
//    @GetMapping("/qtyRentUnpaid")
//    public Long getQtyRentUnpaid()
//    {
//        return indexService.getQtyRentUnpaid();
//    }

//
//    /** Endpoint to get the number of rent witch has the status "NEW"
//     *  Pointing to indexScript.js */
//    @GetMapping("/qtyRentStatusNew")
//    public ResponseEntity<Long> getQtyRentStatusNew()
//    {
//        Long qtyRentStatusNew = indexService.getQtyRentStatusNew();
//        return ResponseEntity.ok(qtyRentStatusNew);
//    }
//
//    /** Endpoint to get the number of rent witch has the status "IN PROGRESS"
//     *  Pointing to indexScript.js */
//    @GetMapping("/qtyRentStatusInProgress")
//    public ResponseEntity<Long> getQtyRentStatusInProgress()
//    {
//       Long qtyRentStatusInProgress = indexService.getQtyRentStatusInProgress();
//       return ResponseEntity.ok(qtyRentStatusInProgress);
//    }
}
