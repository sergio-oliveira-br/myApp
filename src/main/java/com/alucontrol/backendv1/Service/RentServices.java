package com.alucontrol.backendv1.Service;

import com.alucontrol.backendv1.Exception.ResourceNotFoundException;
import com.alucontrol.backendv1.Model.Rent;
import com.alucontrol.backendv1.Repository.RentRepository;
import com.alucontrol.backendv1.Util.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class RentServices {

    private final RentRepository rentRepository;
    private final StockService stockService;

    @Autowired
    public RentServices(RentRepository rentRepository, StockService stockService) {
        this.rentRepository = rentRepository;
        this.stockService = stockService;
    }


    //Metodo de Salvamento,
    public ResponseEntity<Rent> saveRent(Rent rent) {

        String rentStatus = rent.getRentStatus();
        String product = rent.getRentItem();
        int productQty = rent.getRentQtyItem();

        Rent savedRent = rentRepository.save(rent);

        //Verifica o status do rent para substração do estoque,
        if(rentStatus.equals("Em andamento")) {
            stockService.subtractStock(product, productQty);
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

            Rent rent = rentOptional.get();

            String rentStatus = rent.getRentStatus();
            String product = rent.getRentItem();
            int productQty = rent.getRentQtyItem();

            //Verifica o status do rent para substração ou adição do estoque
            if(rentStatus.equals("Em andamento")) {
                stockService.subtractStock(product, productQty);
                LoggerUtil.info("Rent saved successfully: " + updatedRent.toString());

                return ResponseEntity.ok(updatedRent);
            }

            else if(rentStatus.equals("Encerrado")) {
                stockService.addStockByRentalStatusFinished(product, productQty);
                LoggerUtil.info("Rent saved successfully: " + updatedRent.toString());

                return ResponseEntity.ok(updatedRent);
            }

            //Este considereda que o status é "novo"
            LoggerUtil.info("Rent saved successfully: " + updatedRent.toString());
            return ResponseEntity.ok(updatedRent);
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
}
