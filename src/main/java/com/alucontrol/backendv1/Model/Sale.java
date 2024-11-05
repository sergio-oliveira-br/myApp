package com.alucontrol.backendv1.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "sale")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "O nome do cliente deve ser associado a esta venda, por isso nao pode estar em branco")
    private String saleFirstName;

    private String saleAddress;

    @NotBlank(message = "O item é um campor obrigatorio")
    private String saleItem;

    private double salePrice;

    @NotBlank(message = "A qtd deve ser mencionada para controle de estoque")
    private int saleQtyItem;

    @NotBlank(message = "A data é uma informação que irá auxiliar em análises futuras, por isso deve ser preenchida")
    private String saleDate;

    private double saleTotalPrice;

    @NotBlank(message = "Informe o status do pagamento, este campo é um campo obrigatorio")
    private String salePaymentStatus;

    private String saleDetails;

    //setters and getters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSaleItem() {
        return saleItem;
    }

    public int getSaleQtyItem() {
        return saleQtyItem;
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
