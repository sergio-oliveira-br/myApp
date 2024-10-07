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

import com.alucontrol.backendv1.Exception.ProblemDetails;
import com.alucontrol.backendv1.Util.LoggerUtil;
import com.alucontrol.backendv1.Model.Rent;
import com.alucontrol.backendv1.Repository.RentRepository;
import com.alucontrol.backendv1.Service.StockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**This controller is dedicated to endpoints that create and update records
 * It is the responsibility of this layer to receive requests, call methods from the service layer, and return HTTP responses.*/
@RestController
public class RentCreateUpdateController
{
    //Repository for access to product data
    private final RentRepository rentRepository;

    private final StockService stockService;

    //Constructor responsible for injecting the repository
    public RentCreateUpdateController(RentRepository rentRepository, StockService stockService)
    {
        this.rentRepository = rentRepository;
        this.stockService = stockService;
    }

    /** Endpoint to send rent */
    @PostMapping("/saveRent")
    public ResponseEntity<?> saveRent( @RequestBody Rent rent){
    //the "?" makes the method be of the generic type or a type that can return different types of response
        try
        {
            //Log
            LoggerUtil.info("Starting to save Rent with data: " + rent.toString());

            //Save into DB
            Rent savedRent = rentRepository.save(rent);

            //The stock will be subtracted based on the user's input
            //Status "New" will not subtract the stock, 'cause supposedly it has not started yet
            if(rent.getRentStatus().equals("Novo")) {
                //log
                LoggerUtil.info("Rent Status: NEW. Your Rent has not started yet, so your stock has not been changed.");
            }

            else {
                //When a rental is created, make a call to subtract inventory
                stockService.subtractStock(rent.getRentItem(), rent.getRentQtyItem());
            }

            LoggerUtil.info("Alguel salvo com sucesso: " + savedRent.toString());
            return ResponseEntity.ok(savedRent);

        }
        catch (Exception e) {
            //Log
            LoggerUtil.error("Ocorreu um erro ao salvar os dados de aluguel." +
                    "Aluguel: " + rent.toString() + " | " +
                    "Error: " + e.getMessage(), e);

            ProblemDetails problemDetails = new ProblemDetails(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Um erro foi descoberto durante esta operação. " +
                            "Por favor, informe-o para o suporte técnico com fotos." + " | " +
                            "Error: " + e.getMessage());

            ResponseEntity.internalServerError().body(problemDetails);

            return ResponseEntity.internalServerError().body(problemDetails);
        }
    }



//    /** Endpoint to update rent status (by selecting the option "Finished" on Rent.html)*/
//    @PutMapping("/rent/status/{id}")
//    public ResponseEntity<Rent> updateRentStatus(@PathVariable Long id,
//                                                 @RequestParam("rentStatus") String rentStatus)
//    {
//        //Create a log
//        LoggerUtil.info("Updating rent status for ID: " + id + " with status: " + rentStatus);
//
//        //Search the product by ID
//        //Optional: Used to imply that a value may be present or absent in a given circumstance
//        Optional<Rent> rentOptional = rentRepository.findById(id);
//
//        //Check if the product was found
//        if(rentOptional.isPresent())
//        {
//            Rent rent = rentOptional.get();
//            rent.setRentStatus(rentStatus);
//            Rent savedRent = rentRepository.save(rent);
//            LoggerUtil.info("Dados antes de ser salvo: " + rent);
//
//            if("Encerrado".equals(rentStatus))
//            {
//                //Local Variable: These take the values passed as parameters.
//                //The values are copied, which means that if the Rent object is modified, the values of the local variables are not affected.
//                int quantityReturned = rent.getRentQtyItem();
//                String itemDescription = rent.getRentItem();
//
//                //Create a log
//                LoggerUtil.info("O status do aluguel foi atualizado com sucesso. ID: " + id + " | Qtd retornada: " + quantityReturned + " | Item: " + itemDescription);
//
//                //Execute the method to return the qyt to the stock
//                rentService.addStockByRentalStatusFinished(itemDescription, quantityReturned);
//            }
//
//            //If the status changed from new to in progress, then the stock have to decrease
//            else if ("Em andamento".equals(rentStatus))
//            {
//                String rentItem = rent.getRentItem();
//                int rentQtyItem = rent.getRentQtyItem();
//
//                //create a log
//                LoggerUtil.info("Rent updated successfully. ID: " + id +
//                        "Rent Item: " + rentItem +
//                        " | Qty Decreased: " + rentQtyItem +
//                        " | Rent Status: " + rentStatus);
//
//                //When a rental is created, make a call to subtract inventory
//                rentService.subtractStock(rentItem, rentQtyItem);
//            }
//            LoggerUtil.info("Dados apos serem salvos: " + savedRent);
//            return ResponseEntity.ok(savedRent);
//        }
//        //Exception: ID incorrect, product was not found
//        else {
//            LoggerUtil.error("Rent not found for ID: " + id);
//            return ResponseEntity.notFound().build();
//        }
//    }


    /** Endpoint to get a specific rent by ID (by clicking on Edit into the table)*/
    @GetMapping("/rent/{id}")
    public ResponseEntity<Rent> getRentById(@PathVariable Long id) {
        Optional<Rent> rentOptional = rentRepository.findById(id);
        if (rentOptional.isPresent()) {
            return ResponseEntity.ok(rentOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    /** Endpoint to update a specific rent by ID */
    @PutMapping("/rent/{id}")
    public ResponseEntity<Rent> updateRent(@PathVariable Long id, @RequestBody Rent updatedRent) {
        LoggerUtil.info("Starting to update rent with data: " + updatedRent.toString());

        Optional<Rent> rentOptional = rentRepository.findById(id);
        if (rentOptional.isPresent()) {

            Rent rent = rentOptional.get();

            rent.setRentFirstName(updatedRent.getRentFirstName());
            //rent.setRentLastName(updatedRent.getRentLastName());
            rent.setRentAddress(updatedRent.getRentAddress());
            rent.setRentItem(updatedRent.getRentItem());
            rent.setRentPrice(updatedRent.getRentPrice());
            rent.setRentQtyItem(updatedRent.getRentQtyItem());
            rent.setRentStarts(updatedRent.getRentStarts());
            rent.setRentEnds(updatedRent.getRentEnds());
            rent.setRentTotalDays(updatedRent.getRentTotalDays());
            rent.setRentTotalPrice(updatedRent.getRentTotalPrice());
            rent.setRentDetails(updatedRent.getRentDetails());
            rent.setRentPaymentStatus(updatedRent.getRentPaymentStatus());
            rent.setRentStatus(updatedRent.getRentStatus());

            if(updatedRent.getRentStatus().equals("Novo")) {
                //Create a log
                LoggerUtil.info("Status: Novo -> Nenhuma alteraçao no estoque foi realizada!");
            }

            else if (updatedRent.getRentStatus().equals("Em andamento")) {
                 //If the status changed from new to in progress, then the stock have to decrease
                stockService.subtractStock(updatedRent.getRentItem(), updatedRent.getRentQtyItem());
            }
            else if (updatedRent.getRentStatus().equals("Encerrado")) {
                //Execute the method to return the qyt to the stock
                stockService.addStockByRentalStatusFinished(updatedRent.getRentItem(), updatedRent.getRentQtyItem());
            }
            Rent savedRent = rentRepository.save(rent);
            LoggerUtil.info("Rent updated: " + savedRent.toString());
            return ResponseEntity.ok(savedRent);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
