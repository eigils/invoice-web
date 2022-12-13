package com.mycompany.invoice.invoiceweb.form;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class InvoiceForm {
    private String number;

    @NotBlank(message="le nom du client est obligatoire")
    private String customerName;

    @Size(min=10,max=13,message="Le numéro de commande n''a pas la bonne longueur")
    private String orderNumber;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
