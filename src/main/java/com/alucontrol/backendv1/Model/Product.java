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
package com.alucontrol.backendv1.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id //Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String itemDescription;

    @Column(nullable = false)
    private int itemQuantity;

    @Column(nullable = false)
    private double itemAvailableQty;

    @Column(nullable = false)
    private String productType;

    @Column(nullable = false) //this field should be autofilled by js
    private String dateCreated;

    @Column(nullable = false) //this field should be autofilled by js
    private String dateModified;

    @Column(nullable = false) //the purpose of this is to set a unique price
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
    public String getProductType() {return productType;}
    public void setProductType(String productType) {this.productType = productType;}
    public String getDateCreated() {return dateCreated;}
    public void setDateCreated(String dateCreated) {this.dateCreated = dateCreated;}
    public String getDateModified() {return dateModified;}
    public void setDateModified(String dateModified) {this.dateModified = dateModified;}
    public double getItemPrice() {return itemPrice;}
    public void setItemPrice(double itemPrice) {this.itemPrice = itemPrice;}

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
