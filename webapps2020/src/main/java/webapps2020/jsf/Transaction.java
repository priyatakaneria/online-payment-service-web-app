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
public class Transaction {

    String sender;
    String receiver;
    String senderCurrency;
    String receiverCurrency;
    double senderAmount;
    double receiverAmount;

    public Transaction(){
    
    }

    public Transaction(String sender, String receiver, String senderCurrency, double senderAmount, String receiverCurrency, double receiverAmount){
        this.sender = sender;
        this.receiver = receiver;
        this.receiverCurrency = receiverCurrency;
        this.senderCurrency = senderCurrency;
        this.senderAmount = senderAmount;
        this.receiverAmount = receiverAmount;
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
}
