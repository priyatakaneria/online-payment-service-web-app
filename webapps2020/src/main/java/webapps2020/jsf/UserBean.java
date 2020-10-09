/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webapps2020.jsf;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.inject.Named;
import webapps2020.ejb.UserService;
import webapps2020.jsf.LoginBean;

/**
 *
 * @author priya
 */
@Named
@SessionScoped
public class UserBean implements Serializable{

    @EJB
    UserService user;

    public double getCurrentUserBalance(){
        String currentUser = LoginBean.getCurrentUser();
        return user.getBalance(currentUser);
    }

    public String getCurrentUserCurrency(){
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

    public String getCurrentUserName(){
        String currentUser = LoginBean.getCurrentUser();
        return user.getName(currentUser);
    }

    public List<String> getUsernames() {
        String currentUser = LoginBean.getCurrentUser();
        List<User> us = user.getUsers(currentUser);
        List<String> usernames = new ArrayList<String>();
        for(int i = 0; i < us.size(); i++){
            User u = us.get(i);
            usernames.add(u.getUsername());
        }
        return usernames;
    }

    public List<User> getUsers() {
        String currentUser = LoginBean.getCurrentUser();
        List<User> us = user.getUsers(currentUser);
        return us;
    }

    public double getBalance(String username){
        return user.getBalance(username);
    }
}
