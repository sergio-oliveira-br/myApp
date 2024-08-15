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
package com.alucontrol.backendv1.Model;

import jakarta.persistence.*;

//Indicates that this class is a JPA entity and will be mapped to a table in the database
@Entity

//Specifies the name of the table in the database to which the entity will be mapped
@Table(name = "sale")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String saleFirstName;

    @Column(nullable = true)
    private String saleAddress;

    @Column(nullable = false)
    private String saleItem;

    @Column(nullable = false)
    private double salePrice;

    @Column(nullable = false)
    private int saleQtyItem;

    @Column(nullable = false)
    private String saleDate;

    @Column(nullable = false)
    private double saleTotalPrice;

    @Column(nullable = false)
    private String salePaymentStatus;

    @Column(nullable = true)
    private String saleDetails;

    //setters and getters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSaleFirstName() {
        return saleFirstName;
    }

    public void setSaleFirstName(String saleFirstName) {
        this.saleFirstName = saleFirstName;
    }

    public String getSaleAddress() {
        return saleAddress;
    }

    public void setSaleAddress(String saleAddress) {
        this.saleAddress = saleAddress;
    }

    public String getSaleItem() {
        return saleItem;
    }

    public void setSaleItem(String saleItem) {
        this.saleItem = saleItem;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public int getSaleQtyItem() {
        return saleQtyItem;
    }

    public void setSaleQtyItem(int saleQtyItem) {
        this.saleQtyItem = saleQtyItem;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public double getSaleTotalPrice() {
        return saleTotalPrice;
    }

    public void setSaleTotalPrice(double saleTotalPrice) {
        this.saleTotalPrice = saleTotalPrice;
    }

    public String getSalePaymentStatus() {
        return salePaymentStatus;
    }

    public void setSalePaymentStatus(String salePaymentStatus) {
        this.salePaymentStatus = salePaymentStatus;
    }

    public String getSaleDetails() {
        return saleDetails;
    }

    public void setSaleDetails(String saleDetails) {
        this.saleDetails = saleDetails;
    }

    //ToString
    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", saleFirstName='" + saleFirstName + '\'' +
                ", saleAddress='" + saleAddress + '\'' +
                ", saleItem='" + saleItem + '\'' +
                ", salePrice=" + salePrice +
                ", saleQtyItem=" + saleQtyItem +
                ", saleDate='" + saleDate + '\'' +
                ", saleTotalPrice=" + saleTotalPrice +
                ", salePaymentStatus='" + salePaymentStatus + '\'' +
                ", saleDetails='" + saleDetails + '\'' +
                '}';
    }
}
