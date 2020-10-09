/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webapps2020.ejb;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import webapps2020.entity.SystemUser;
import webapps2020.entity.SystemUserGroup;

/**
 *
 * @author priya
 */
@Startup
@Singleton
public class InitSingleton {

    @PersistenceContext(unitName = "Webapps2020PU")
    EntityManager em;

    /**
     * Initialise database by populating it with user Admin1
     */
    @PostConstruct
    public void dbInit() {

        SystemUser sys_userAdmin = new SystemUser("admin1", encryptPassword("admin1"), "Priyata", "Kaneria", "N/A", true);
        SystemUserGroup sys_user_groupAdmin = new SystemUserGroup("admin1", "admins");

        //registerUser("admin1", "admin1");
        em.persist(sys_userAdmin);
        em.persist(sys_user_groupAdmin);

    }

    /**
     * Implements the business logic of registering a user into the general
     * database. Will be used in the less general classes to complete the
     * registration process
     *
     * @param username
     * @param userPassword
     */
     public void registerUser(String username, String userpassword, String name, String surname, String currency, boolean admin) {
        SystemUser sys_user;

        sys_user = new SystemUser(username, encryptPassword(userpassword), name, surname, currency, admin);
        em.persist(sys_user);
    }

 public String encryptPassword(String password) {

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String passwordToEncrypt = password;
            md.update(passwordToEncrypt.getBytes("UTF-8"));
            byte[] digest = md.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < digest.length; i++) {
                sb.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
            }

            String encryptedPassword = sb.toString();

            return encryptedPassword;
        } catch (NoSuchAlgorithmException ex) {
            System.err.println(ex.getMessage());
            return null;
        } catch (UnsupportedEncodingException ex) {
            System.err.println(ex.getMessage());
            return null;
        }

    }
}

