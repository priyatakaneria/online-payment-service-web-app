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
import javax.persistence.OneToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.EmbeddedId;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.json.bind.annotation.JsonbTransient;


/**
 *
 * @author priya
 */

@Entity

@NamedQueries({
    @NamedQuery(name = "findTransactions", query = "SELECT NEW webapps2020.jsf.Transaction(t.sender, t.receiver, t.senderCurrency, t.senderAmount, t.receiverCurrency, t.receiverAmount) FROM Transactions t WHERE t.sender LIKE :username OR t.receiver LIKE :username"),
    @NamedQuery(name = "findAllTransactions", query = "SELECT NEW webapps2020.jsf.Transaction(t.sender, t.receiver, t.senderCurrency, t.senderAmount, t.receiverCurrency, t.receiverAmount) FROM Transactions t")
})

public class Transactions implements Serializable {

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

  /**
     * Creates a new instance of Transaction
     */
    public Transactions() {
    }
   
    /**
     * Creates a new instance of Transaction
     */
    public Transactions(String sender, String receiver, String senderCurrency, double amount, String receiverCurrency, double receiverAmount) {
        this.sender = sender;
        this.receiver = receiver;
        this.senderCurrency = senderCurrency;
        this.senderAmount = amount;
        this.receiverCurrency = receiverCurrency;
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
