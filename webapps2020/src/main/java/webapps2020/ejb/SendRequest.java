/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webapps2020.ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.*;
import javax.annotation.security.DeclareRoles;
import javax.ejb.Stateless;
import webapps2020.jsf.CurrencyBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import webapps2020.entity.SystemUser;
import webapps2020.ejb.UserService;
import webapps2020.entity.PaymentRequest;
import webapps2020.jsf.Request;
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

@DeclareRoles({"admins"})
@Stateless
public class SendRequest {

    @PersistenceContext(unitName = "Webapps2020PU")
    EntityManager em;

    @EJB
    UserService user;

    /**
     * Business logic for creating a Request
     * @param title
     * @param description 
     */     
    public void sendRequest(String sender, String receiver, String senderCurrency, String receiverCurrency, double amount) {
        CurrencyBean cb = new CurrencyBean();
        double receiverAmount = cb.convertCurrency(senderCurrency, receiverCurrency, amount);
        PaymentRequest request = new PaymentRequest(sender, receiver, senderCurrency, amount, receiverCurrency, receiverAmount);
        em.persist(request);
    }

    public void deleteRequest(Long id){
        PaymentRequest request = (PaymentRequest) em.createNamedQuery("findLiteralRequest").setParameter("id", id).getSingleResult();
        em.remove(request);
    }

    public List<Request> getRequests() {

        return em.createNamedQuery("findRequests").setParameter("username", getCurrentUser()).getResultList();
    }

    public static String getCurrentUser() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest r = (HttpServletRequest) context.getExternalContext().getRequest();
        String currentUser = r.getUserPrincipal().getName();
        return currentUser;
    }
}
