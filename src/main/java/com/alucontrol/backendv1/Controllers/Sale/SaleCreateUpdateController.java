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
package com.alucontrol.backendv1.Controllers.Sale;


import com.alucontrol.backendv1.Model.Sale;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**This controller is dedicated to endpoints that create and update records
 * It is the responsibility of this layer to receive requests, call methods from the service layer, and return HTTP responses.*/
@RestController
public class SaleCreateUpdateController {
    //Repository for access to Sale data

    //Constructor responsible for injecting the repository

    /**Endpoint responsible to create sales*/
    @PostMapping("/saveSale") //Remember: POST is a method from CRUD used to CREATE data
    public ResponseEntity<?> saveSale(@RequestBody Sale sale){
        //the "?" makes the method be of the generic type or a type that can return different types of response


    }


    /** Endpoint to update sales information */
    @PutMapping("/sales/{id}") //Remember: PUT is a method from CRUD used to UPDATE data
    public ResponseEntity<?> updateSale(@PathVariable Long id, @RequestBody Sale sale){

    }

    
}
