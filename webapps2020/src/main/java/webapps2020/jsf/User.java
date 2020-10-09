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

public class User{

    String username;
    String userpassword;
    String name;
    String surname;
    String currency;
    double balance;

    public User() {
    }

    public User(String username, String userpassword, String name, String surname, String currency, double balance) {
        this.username = username;
        this.userpassword = userpassword;
        this.name = name;
        this.surname = surname;
        this.currency = currency;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

 }