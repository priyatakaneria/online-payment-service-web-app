/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webapps2020.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.persistence.EmbeddedId;

/**
 *
 * @author priya
 */

@Entity

@NamedQueries({
    @NamedQuery(name = "findRequests", query = "SELECT NEW webapps2020.jsf.Request(r.id, r.sender, r.receiver, r.senderCurrency, r.senderAmount, r.receiverCurrency, r.receiverAmount) FROM PaymentRequest r WHERE r.receiver LIKE :username"),
    @NamedQuery(name = "findLiteralRequest", query = "SELECT p from PaymentRequest p WHERE p.id = :id")
})

public class PaymentRequest {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    String sender;
    
    @NotNull
    String receiver;

    @NotNull
    String senderCurrency;

    @NotNull
    double senderAmount;

    @NotNull
    String receiverCurrency;
    
    @NotNull
    double receiverAmount;
   

    public PaymentRequest(){
    }

 /**
     * Creates a new instance of Request
     */
    public PaymentRequest(String sender, String receiver, String senderCurrency, double senderAmount, String receiverCurrency, double receiverAmount) {
        this.sender = sender;
        this.receiver = receiver;
        this.senderCurrency = senderCurrency;
        this.senderAmount = senderAmount;
        this.receiverCurrency = receiverCurrency;
        this.senderAmount = senderAmount;
        this.receiverAmount = receiverAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String Receiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

   public String getSenderCurrency() {
        return senderCurrency;
    }
    
    public void setSenderCurrency(String senderCurrency) {
        this.senderCurrency = senderCurrency;
    }
    
    public double getSenderAmount() {
           return senderAmount;
       }

    public void setSenderAmount(double senderAmount) {
        this.senderAmount = senderAmount;
    }

    public String getReceiverCurrency() {
        return receiverCurrency;
    }
    
    public void setReceiverCurrency(String receiverCurrency) {
        this.receiverCurrency = receiverCurrency;
    }
    
    public double getReceiverAmount() {
           return receiverAmount;
    }

    public void setReceiverAmount(double receiverAmount) {
        this.receiverAmount = receiverAmount;
    }
}
