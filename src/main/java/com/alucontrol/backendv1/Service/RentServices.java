package com.alucontrol.backendv1.Service;

import com.alucontrol.backendv1.Exception.ResourceNotFoundException;
import com.alucontrol.backendv1.Model.Rent;
import com.alucontrol.backendv1.Repository.RentRepository;
import com.alucontrol.backendv1.Service.Inventory.DecreaseStockService;
import com.alucontrol.backendv1.Service.Inventory.ReturnStockService;
import com.alucontrol.backendv1.Util.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class RentServices {

    private final RentRepository rentRepository;
    private final DecreaseStockService decreaseStockService;
    private final ReturnStockService returnStockService;


    @Autowired
    public RentServices(RentRepository rentRepository, DecreaseStockService decreaseStockService, ReturnStockService returnStockService) {
        this.rentRepository = rentRepository;
        this.decreaseStockService = decreaseStockService;
        this.returnStockService = returnStockService;
    }


    //Metodo de Salvamento,
    public ResponseEntity<Rent> saveRent(Rent rent) {

        String rentStatus = rent.getRentStatus();
        String product = rent.getRentItem();
        int productQty = rent.getRentQtyItem();

        Rent savedRent = rentRepository.save(rent);

        //Verifica o status do rent para substração do estoque,
        if(rentStatus.equals("Em andamento")) {
            decreaseStockService.decreaseStockAfterRental(product, productQty);
            LoggerUtil.info("Rent saved successfully: " + savedRent.toString());

            return ResponseEntity.ok(savedRent);
        }

        LoggerUtil.info("Rent saved successfully: " + savedRent.toString());

        return ResponseEntity.ok(savedRent);
    }

    //Metodo de Atualização de algueis que ja existentem na DB buscando o ID.
    public ResponseEntity<Rent> saveRentChanges(Rent updatedRent, Long id) {

        Optional<Rent> rentOptional = rentRepository.findById(id);

        if(rentOptional.isPresent()) {

            String rentStatus = updatedRent.getRentStatus();
            String product = updatedRent.getRentItem();
            int productQty = updatedRent.getRentQtyItem();

            //Verifica o status do rent para substração ou adição do estoque
            if(rentStatus.equals("Em andamento")) {
                decreaseStockService.decreaseStockAfterRental(product, productQty);
                Rent savedRent = rentRepository.save(updatedRent);
                LoggerUtil.info("Rent saved successfully: " + updatedRent.toString());

                return ResponseEntity.ok(savedRent);
            }

            else if(rentStatus.equals("Encerrado")) {
                returnStockService.returnStockAfterRental(product, productQty);
                Rent savedRent = rentRepository.save(updatedRent);
                LoggerUtil.info("Rent saved successfully: " + updatedRent.toString());

                return ResponseEntity.ok(savedRent);
            }

            //Este considereda que o status é "novo"
            Rent savedRent = rentRepository.save(updatedRent);
            LoggerUtil.info("Rent saved successfully: " + updatedRent.toString());

            return ResponseEntity.ok(savedRent);
        }

      throw new ResourceNotFoundException("Rent with id" + id + " not found");
    }

    //Metodo de Leitura, buscando todos os algueis existentes na base de dados
    public ResponseEntity<List<Rent>> findAllRents() {

        List<Rent> rents = rentRepository.findAll();
        return ResponseEntity.ok(rents);
    }

    //Metodo de leitura para buscar um alguel especifico atraves do ID
    public ResponseEntity<Rent> findRentById (@RequestParam Long id) {

        Optional<Rent> rentOptional = rentRepository.findById(id);

        if (rentOptional.isPresent()) {
            return ResponseEntity.ok(rentOptional.get());
        }

        throw new ResourceNotFoundException("Rent with id" + id + " not found");
    }

    //Metodo de leitura para buscar algueis atraves da data "mes" e "ano"
    public ResponseEntity<List<Rent>> findRentByDate (String year, String month) {

        List<Rent> rents = rentRepository.findByYearAndMonth(year, month);

        if (rents.isEmpty()) {
            throw new ResourceNotFoundException("No Rent found for year" + year + " and month"  + month);
        }
        return ResponseEntity.ok(rents);
    }

    //Metodo de leitura para buscar alugueis atraves do nome do cliente
    public ResponseEntity<List<Rent>> findRentByName (String customerName) {

        List<Rent> rents = rentRepository.findRentByFirstName(customerName);
        if (rents.isEmpty()) {
            throw new ResourceNotFoundException("No Rent found for customer " + customerName);
        }
        return ResponseEntity.ok(rents);
    }

    //Metodo de leitura para buscar alugueis atraves do status do pagamento
    public ResponseEntity<List<Rent>> findRentByPaymentStatus (String paymentStatus) {

        List<Rent> rents = rentRepository.findRentByPaymentStatus(paymentStatus);
        if (rents.isEmpty()) {
            throw new ResourceNotFoundException("No Rent found for payment status " + paymentStatus);
        }
        return ResponseEntity.ok(rents);
    }

    //Metodo de leitura para buscar a quantidade/contar os alugueis de acordo com o status do alugel
    public ResponseEntity<Long> findQtyRentByRentStatus (String rentStatus) {

        Long countRent = rentRepository.countRentByStatus(rentStatus);
        return ResponseEntity.ok(countRent);
    }

    //Metodo de leitura para buscar a quantidade/contar os alugueis de acordo com o status do pagamento
    public ResponseEntity<Long> findQtyRentByPaymentStatus (String paymentStatus) {

        Long countRent = rentRepository.countRentByPaymentStatus(paymentStatus);
        return ResponseEntity.ok(countRent);
    }
}
