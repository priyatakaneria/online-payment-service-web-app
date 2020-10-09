/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webapps2020.jsf;

/**
 *
 * @author priya
 */
public class Request {

    Long id;
    String sender;
    String receiver;
    String senderCurrency;
    String receiverCurrency;
    double senderAmount;
    double receiverAmount;
    String accept = "";
    String[] accepting = {"Accept", "Reject"};

    public Request(){
    
    }

    public Request(Long id, String sender, String receiver, String senderCurrency, double senderAmount, String receiverCurrency, double receiverAmount){
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.receiverCurrency = receiverCurrency;
        this.senderCurrency = senderCurrency;
        this.senderAmount = senderAmount;
        this.receiverAmount = receiverAmount;
    }
    
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
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

    public String getReceiverCurrency() {
        return receiverCurrency;
    }

    public void setReceiverCurrency(String receiverCurrency) {
        this.receiverCurrency = receiverCurrency;
    }

    public String getSenderCurrency() {
        return senderCurrency;
    }

    public void setSenderCurrency(String senderCurrency) {
        this.senderCurrency = senderCurrency;
    }

    public void setSenderAmount(double amount) {
        this.senderAmount = amount;
    }

    public double getSenderAmount(){
        return senderAmount;
    }
    
    public void setReceiverAmount(double amount) {
        this.receiverAmount = amount;
    }

    public double getReceiverAmount(){
        return receiverAmount;
    }

    public void setAccept(String accept){
        this.accept = accept;
    }

    public String getAccept(){
        return accept;
    }
    
    public void setAccepting(String[] accepting){
        this.accepting = accepting;
    }

    public String[] getAccepting(){
        return accepting;
    }


}
