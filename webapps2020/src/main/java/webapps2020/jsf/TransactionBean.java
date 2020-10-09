/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webapps2020.jsf;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.*;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.inject.Named;
import webapps2020.ejb.CreateTransaction;
import webapps2020.ejb.UserService;
import webapps2020.jsf.LoginBean;
import webapps2020.jsf.Transaction;

/**
 *
 * @author priya
 */

@Named
@Stateless
public class TransactionBean implements Serializable {

    @EJB
    CreateTransaction transaction;

    @EJB
    UserService user;

    String sender;
    String receiver;
    String senderCurrency;
    String receiverCurrency;
    double amount;

    public TransactionBean(){
    }
    
    //call the injected EJB
    public String createTransaction() {
        sender = LoginBean.getCurrentUser();
        senderCurrency = getCurrentUserCurrency();
        receiverCurrency = user.getCurrency(receiver);
        transaction.addTransaction(sender, receiver, senderCurrency, receiverCurrency, amount);
        return "user";
    }

    public String getCurrentUserCurrency(){
        String currentUser = LoginBean.getCurrentUser();
        String currency = user.getCurrency(currentUser);
        return currency;  
    }

    public String getCurrencySymbol(){
        String currentUser = LoginBean.getCurrentUser();
        String currency = user.getCurrency(currentUser);
        if (currency.equals("GBP"))
        currency = "£";
        else if (currency.equals("USD"))
        currency = "$";
        else if (currency.equals("Euros"))
        currency = "€";
        return currency;
    }
    
    public List<Transaction> getTransactions(){
        return transaction.getTransactions();
    }

    public List<Transaction> getAllTransactions(){
        return transaction.getAllTransactions();
    }
    
    public CreateTransaction getTransaction() {
        return transaction;
    }

    public void setTransaction(CreateTransaction trans) {
        this.transaction = trans;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSenderCurrency() {
        return senderCurrency;
    }

    public void setSenderCurrency(String currency) {
        this.senderCurrency = currency;
    }

    public String getReceiverCurrency() {
        return receiverCurrency;
    }

    public void setReceiverCurrency(String currency) {
        this.receiverCurrency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
   

}
