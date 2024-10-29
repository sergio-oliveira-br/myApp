package com.alucontrol.backendv1.Service;

import com.alucontrol.backendv1.Exception.DataAccessException;
import com.alucontrol.backendv1.Exception.InternalServerException;
import com.alucontrol.backendv1.Exception.ResourceNotFoundException;
import com.alucontrol.backendv1.Model.Rent;
import com.alucontrol.backendv1.Repository.RentRepository;
import com.alucontrol.backendv1.Service.RentStatus.RentStatusHandler;
import com.alucontrol.backendv1.Service.RentStatus.StatusComparator;
import com.alucontrol.backendv1.Util.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RentServices {

    private final RentRepository rentRepository;
    private final Map<String, RentStatusHandler> rentStatusHandlers;
    private final StatusComparator statusComparator;


    @Autowired
    public RentServices(RentRepository rentRepository, Map<String, RentStatusHandler> handlerMap) {
        this.rentRepository = rentRepository;
        this.rentStatusHandlers = handlerMap;
        this.statusComparator = new StatusComparator();
    }


    //Metodo de Salvamento,
    public Rent saveRent(Rent rent) {

        String rentStatus = rent.getRentStatus();

        try{
            RentStatusHandler rentStatusHandler = rentStatusHandlers.get(rentStatus);
            Rent savedRent = rentRepository.save(rent);

            //Verifica o rentStatus do rent para para fazer o ajuste necessario
            if(rentStatusHandler != null ){
                rentStatusHandler.handleRentStatusUpdate(rent);

                LoggerUtil.info("Rent saved successfully: " + savedRent);
                return savedRent;
            }

            throw new InternalServerException("Não foi possivel salvar o aluguel. Erro relacioado ao Status");

        }catch (DataAccessException e){
            LoggerUtil.error("Error while saving rent: " + rent, e);
            throw new InternalServerException("Failed to save rent data. " + e.getMessage());
        }
    }

    //Metodo de Atualização de algueis que ja existentem na DB buscando o ID.
    public Rent saveRentChanges(Rent updatedRent, Long id) {

        Optional<Rent> rentOptional = rentRepository.findById(id);

        if(rentOptional.isPresent()) {

            Rent existingRent = rentOptional.get(); //Carrega o aluguel existente, sem a alteração

            if(statusComparator.hasStatusChangedRent(existingRent, updatedRent)){
                String updatedRentStatus = updatedRent.getRentStatus();
                RentStatusHandler rentStatusHandler = rentStatusHandlers.get(updatedRentStatus);

                //Verifica o status do rent para substração ou adição do estoque
                if(rentStatusHandler != null) {
                    rentStatusHandler.handleRentStatusUpdate(updatedRent);
                }

            } else {
                LoggerUtil.info("There has been no modification to the status of the rental ID: " + id);
            }

            Rent savedRent = rentRepository.save(updatedRent);

            LoggerUtil.info("Rent updated successfully: " + updatedRent);
            return savedRent;
        }

      throw new ResourceNotFoundException("Rent ID:" + id + " not found");
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

    //Metodo de leitura para buscar alugueis atraves do status do aluguel
    public ResponseEntity<List<Rent>> findRentByStatus (String rentStatus) {

        List<Rent> rents = rentRepository.findRentByStatus(rentStatus);
        if (rents.isEmpty()) {
            throw new ResourceNotFoundException("Não foi encontrado nenhum aluguel para status " + rentStatus);
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
