package com.alucontrol.backendv1.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "products")
public class Product {
    @Id //Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "A descrição do item é um campo obrigatorio e não pode ser vazio ou branco")
    private String itemDescription;

    @NotNull(message = "A qtd é um campo importante para o gerenciamento do estoque, por isso deve ser preenchido")
    private int itemQuantity;

    @NotNull(message = "A qty disponível auxilia o controle de estoque, por isso não pode ser nulo")
    private double itemAvailableQty;

    @NotBlank(message = "O tipo não pode ser um campo em branco")
    private String productType;

    private String dateCreated;

    private String dateModified;

    @NotNull(message = "O preço é um campo obrigatorio, e deve ser preenchido")
    private double itemPrice;

    //Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public double getItemAvailableQty() {return itemAvailableQty;}

    public void setItemAvailableQty(double itemAvailableQty) {this.itemAvailableQty = itemAvailableQty;}

    //This make part of version 2.0, where I will improve the traceability, and segregate the rent and sale responsibility
    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getDateModified() {
        return dateModified;

    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }
    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return "Product {" +
                "id= " + id +
                ", itemDescription= " + itemDescription +
                ", itemPrice= " + itemPrice +
                ", itemQuantity= " + itemQuantity +
                ", itemAvailableQty= " + itemAvailableQty +
                ", productType= " + productType +
                ", dateCreated= " + dateCreated +
                ", dateModified= " + dateModified +
                '}';
    }
}
