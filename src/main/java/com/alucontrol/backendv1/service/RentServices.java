package com.alucontrol.backendv1.service;

import com.alucontrol.backendv1.exception.DataAccessException;
import com.alucontrol.backendv1.exception.InternalServerException;
import com.alucontrol.backendv1.exception.ResourceNotFoundException;
import com.alucontrol.backendv1.model.Rent;
import com.alucontrol.backendv1.repository.RentRepository;
import com.alucontrol.backendv1.service.rentstatus.RentStatusHandler;
import com.alucontrol.backendv1.service.rentstatus.StatusComparator;
import com.alucontrol.backendv1.util.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

                LoggerUtil.info("rent saved successfully: " + savedRent);
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

            LoggerUtil.info("rent updated successfully: " + updatedRent);
            return savedRent;
        }

      throw new ResourceNotFoundException("rent ID:" + id + " not found");
    }

    //Metodo de Leitura, buscando todos os algueis existentes na base de dados
    public List<Rent> findAllRents() {

        return rentRepository.findAll();
    }

    //Metodo de leitura para buscar um alguel especifico atraves do ID
    public Rent findRentById (Long id) {

        Optional<Rent> rentOptional = rentRepository.findById(id);

        if (rentOptional.isPresent()) {
            return rentOptional.get();
        }

        throw new ResourceNotFoundException("rent ID:" + id + " not found");
    }

    //Metodo de leitura para buscar algueis atraves da data "mes" e "ano"
    public List<Rent> findRentByDate (String year, String month) {

        List<Rent> rents = rentRepository.findByYearAndMonth(year, month);

        if (rents.isEmpty()) {
            throw new ResourceNotFoundException("No rent found for year" + year + " and month"  + month);
        }
        return rents;
    }

    //Metodo de leitura para buscar alugueis atraves do nome do cliente
    public List<Rent> findRentByName (String customerName) {

        List<Rent> rentsFound = rentRepository.findRentByFirstName(customerName);

        if (rentsFound.isEmpty()) {
            throw new ResourceNotFoundException("No rent found for customer " + customerName);
        }
        return rentsFound;
    }

    //Metodo de leitura para buscar alugueis atraves do status do pagamento
    public List<Rent> findRentByPaymentStatus (String paymentStatus) {

        List<Rent> rentsFound = rentRepository.findRentByPaymentStatus(paymentStatus);

        if (rentsFound.isEmpty()) {
            throw new ResourceNotFoundException("No rent found for payment status " + paymentStatus);
        }
        return rentsFound;
    }

    //Metodo de leitura para buscar alugueis atraves do status do aluguel
    public List<Rent> findRentByStatus (String rentStatus) {

        List<Rent> rents = rentRepository.findRentByStatus(rentStatus);

        if (rents.isEmpty()) {
            throw new ResourceNotFoundException("No rent found for rent status " + rentStatus);
        }
        return rents;
    }


    //Metodo de leitura para buscar a quantidade/contar os alugueis de acordo com o status do alugel
    public Long findQtyRentByRentStatus (String rentStatus) {

        return rentRepository.countRentByStatus(rentStatus);
    }

    //Metodo de leitura para buscar a quantidade/contar os alugueis de acordo com o status do pagamento
    public Long findQtyRentByPaymentStatus (String paymentStatus) {

        return rentRepository.countRentByPaymentStatus(paymentStatus);
    }
}
