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
import webapps2020.ejb.SendRequest;
import webapps2020.ejb.UserService;
import webapps2020.ejb.CreateTransaction;
import webapps2020.jsf.LoginBean;
import webapps2020.jsf.TransactionBean;
import webapps2020.jsf.Transaction;
import webapps2020.jsf.Request;

/**
 *
 * @author priya
 */

@Named
@Stateless
public class RequestBean implements Serializable {

    @EJB
    SendRequest request;

    @EJB
    UserService user;

    @EJB
    CreateTransaction transaction;

    String sender;
    String receiver;
    String senderCurrency;
    String receiverCurrency;
    double amount;
    Request requestToView;
    HtmlDataTable dataTable;

    public RequestBean(){
    }

    public String createRequest(){
        sender = LoginBean.getCurrentUser();
        senderCurrency = getCurrentUserCurrency();
        receiverCurrency = user.getCurrency(receiver);
        request.sendRequest(sender, receiver, senderCurrency, receiverCurrency, amount);
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

    public List<Request> getRequests(){
        return request.getRequests();
    }
    
    public SendRequest getRequest() {
        return request;
    }

    public void setRequest(SendRequest req) {
        this.request = req;
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
    
    public String acceptRequest() {
        requestToView = (Request) dataTable.getRowData();
        createTransaction(requestToView.getReceiver(), requestToView.getSender(), requestToView.getReceiverCurrency(), requestToView.getSenderCurrency(), requestToView.getReceiverAmount());
        request.deleteRequest(requestToView.getId());
        return "request-accepted";
    }

    public String rejectRequest() {
        requestToView = (Request) dataTable.getRowData();
        request.deleteRequest(requestToView.getId());
        return "request-rejected";
    }

    public String createTransaction(String sender, String receiver, String senderCurrency, String receiverCurrency, double amount) {
        transaction.addTransaction(sender, receiver, senderCurrency, receiverCurrency, amount);
        return "user";
    }

    public HtmlDataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(HtmlDataTable dataTable) {
        this.dataTable = dataTable;
    }
}
