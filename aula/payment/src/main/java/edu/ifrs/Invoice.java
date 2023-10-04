package edu.ifrs;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Invoice extends PanacheEntity {

    @NotEmpty
    private String cardNumber;
    @NotEmpty
    private String value;
    
    private boolean payment;

    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    public boolean isPayment() {
        return payment;
    }
    public void setPayment(boolean payment) {
        this.payment = payment;
    }

    
    
}
