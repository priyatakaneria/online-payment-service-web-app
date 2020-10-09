/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webapps2020.ejb;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.ejb.Stateless;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import webapps2020.entity.Transactions;
import webapps2020.entity.SystemUser;
import webapps2020.jsf.CurrencyBean;
import webapps2020.ejb.UserService;
import webapps2020.jsf.Transaction;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;


/**
 *
 * @author priya
 */
@DeclareRoles({"users", "admins"})
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CreateTransaction {
    
    @PersistenceContext(unitName = "Webapps2020PU")
    EntityManager em;

    @EJB
    UserService user;

    /**
     * Business logic for creating a transaction
     * @param title
     * @param description 
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void addTransaction(String sender, String receiver, String senderCurrency, String receiverCurrency, double amount) {
        CurrencyBean cb = new CurrencyBean();
        double receiverAmount = cb.convertCurrency(senderCurrency, receiverCurrency, amount);
        Transactions transaction = new Transactions(sender, receiver, senderCurrency, amount, receiverCurrency, receiverAmount);
        em.persist(transaction);
        double senderBalance = user.getBalance(sender);
        double receiverBalance = user.getBalance(receiver);
        double senderNewBalance = senderBalance - amount;
        double receiverNewBalance = receiverBalance + receiverAmount;
        
        SystemUser updateSender = (SystemUser) em.createNamedQuery("findUserLiteral").setParameter("username", sender).getSingleResult();
        SystemUser updateReceiver = (SystemUser) em.createNamedQuery("findUserLiteral").setParameter("username", receiver).getSingleResult();
        updateSender.setBalance(senderNewBalance);
        updateReceiver.setBalance(receiverNewBalance);
      
        em.merge(updateSender);
        em.merge(updateReceiver);
    }

    
    public List<Transaction> getTransactions() {

        return em.createNamedQuery("findTransactions").setParameter("username", getCurrentUser()).getResultList();

    }

    public List<Transaction> getAllTransactions() {

        return em.createNamedQuery("findAllTransactions").getResultList();

    }

    public static String getCurrentUser() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest r = (HttpServletRequest) context.getExternalContext().getRequest();
        String currentUser = r.getUserPrincipal().getName();
        return currentUser;
    }

}
