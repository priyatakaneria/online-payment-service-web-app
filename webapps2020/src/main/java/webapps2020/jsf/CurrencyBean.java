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
public class CurrencyBean {

    public CurrencyBean(){
        
    }

    public double convertCurrency(String initialCurrency, String resultantCurrency, double amount){
        double convertedAmount = 0;
        switch(initialCurrency){
        case "GBP":
            switch(resultantCurrency){
            case "GBP": 
                convertedAmount = amount;
                break;
            case "USD":
                convertedAmount = (amount*1.22);
                break;
            case "Euros":
                convertedAmount = (amount*1.12);
                break;
            }
            break;
        case "USD":
            switch(resultantCurrency){
            case "USD":
                convertedAmount = amount;
                break;
            case "GBP":
                convertedAmount = (amount*0.82);
                break;
            case "Euros":
                convertedAmount = (amount*0.92);
                break;
            }
            break;
        case "Euros":
            switch(resultantCurrency){
            case "Euros":
                convertedAmount = amount;
                break;
            case "GBP":
                convertedAmount = (amount*0.9);
                break;
            case "USD":
                convertedAmount = (amount*1.09);
                break;
            }
            break;
        }
        return convertedAmount;
    }
}
