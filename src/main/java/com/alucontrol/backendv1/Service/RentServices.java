package com.alucontrol.backendv1.Service;

import com.alucontrol.backendv1.Model.Rent;
import com.alucontrol.backendv1.Repository.RentRepository;
import com.alucontrol.backendv1.Util.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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


    //Metodo de Leitura,

}
