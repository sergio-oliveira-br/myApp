package com.alucontrol.backendv1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "rent")
public class Rent {

    @Id //Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "O nome do cliente deve ser informado")
    private String rentFirstName;

    private String rentLastName;

    private String rentAddress;

    @NotBlank(message = "O item deve ser informado para ser associado ao aluguel")
    private String rentItem;

    private double rentPrice;

    private int rentQtyItem;

    @NotBlank(message = "As datas são informações que precisam ser preenchidas")
    private String rentStarts;

    @NotBlank(message = "As datas são informações que precisam ser preenchidas")
    private String rentEnds;

    private int rentTotalDays;

    private double rentTotalPrice;

    private String rentDetails;

    @NotBlank(message = "A cituação do pagamento é um campo obrigatório, e deve ser preenchido")
    private String rentPaymentStatus;

    @NotBlank(message = "O status irá auxiliar no controle dos aluguéis, por isso não pode ser vazio")
    private String rentStatus;


    // Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRentFirstName() {
        return rentFirstName;
    }

    public void setRentFirstName(String rentFirstName) {
        this.rentFirstName = rentFirstName;
    }
    
    public String getRentAddress() {
        return rentAddress;
    }

    public void setRentAddress(String rentAddress) {
        this.rentAddress = rentAddress;
    }

    public String getRentItem() {
        return rentItem;
    }

    public void setRentItem(String rentItem) {
        this.rentItem = rentItem;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public int getRentQtyItem() {
        return rentQtyItem;
    }

    public void setRentQtyItem(int rentQtyItem) {
        this.rentQtyItem = rentQtyItem;
    }

    public String getRentStarts() {
        return rentStarts;
    }

    public void setRentStarts(String rentStarts) {
        this.rentStarts = rentStarts;
    }

    public String getRentEnds() {
        return rentEnds;
    }

    public void setRentEnds(String rentEnds) {
        this.rentEnds = rentEnds;
    }

    public int getRentTotalDays() {
        return rentTotalDays;
    }

    public void setRentTotalDays(int rentTotalDays) {
        this.rentTotalDays = rentTotalDays;
    }

    public double getRentTotalPrice() {
        return rentTotalPrice;
    }

    public void setRentTotalPrice(double rentTotalPrice) {
        this.rentTotalPrice = rentTotalPrice;
    }

    public String getRentDetails() {
        return rentDetails;
    }

    public void setRentDetails(String rentDetails) {
        this.rentDetails = rentDetails;
    }

    public String getRentPaymentStatus() {
        return rentPaymentStatus;
    }

    public void setRentPaymentStatus(String paymentStatus) {
        this.rentPaymentStatus = paymentStatus;
    }

    public String getRentStatus() {return rentStatus;}

    public void setRentStatus(String rentStatus) {this.rentStatus = rentStatus;}

    @Override
    public String toString() {
        return "rent{" +
                "id=" + id +
                ", rentFirstName='" + rentFirstName + '\'' +
                ", rentLastName='" + rentLastName + '\'' +
                ", rentAddress='" + rentAddress + '\'' +
                ", rentItem='" + rentItem + '\'' +
                ", rentPrice=" + rentPrice +
                ", rentQtyItem=" + rentQtyItem +
                ", rentStarts='" + rentStarts + '\'' +
                ", rentEnds='" + rentEnds + '\'' +
                ", rentTotalDays=" + rentTotalDays +
                ", rentTotalPrice=" + rentTotalPrice +
                ", rentDetails='" + rentDetails + '\'' +
                ", rentPaymentStatus='" + rentPaymentStatus + '\'' +
                ", rentStatus='" + rentStatus + '\'' +
                '}';
    }
}
