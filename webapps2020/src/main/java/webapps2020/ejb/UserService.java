package webapps2020.ejb;

import webapps2020.entity.SystemUser;
import webapps2020.entity.SystemUserGroup;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import webapps2020.entity.SystemUser;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import webapps2020.jsf.LoginBean;
import webapps2020.jsf.User;


/**
 *
 * @author priya
 */

@DeclareRoles({"users", "admins"})
@Stateless
public class UserService {

    @PersistenceContext(unitName = "Webapps2020PU")
    EntityManager em;

    public UserService() {
    }

   /**
     * Business logic for retrieving a user
     * @param username
     * @return User
     */
    public User getUser(String username) {
        return (User) em.createNamedQuery("findUser").setParameter("username", username).getSingleResult();
    }    

    public List<User> getUsers(String currentUser) {
        return em.createNamedQuery("findUsers").setParameter("username", currentUser).setParameter("currency", "N/A").getResultList();
    }    

    public double getBalance(String username){
        User us = getUser(username);
        return us.getBalance();
    }

    public String getName(String username){
        User us = getUser(username);
        return us.getName();
    }

    public String getCurrency(String username){
        User us = getUser(username);
        return us.getCurrency();
    }

    public void registerUser(String username, String userpassword, String name, String surname, String currency, boolean admin) {
        try {
            SystemUser sys_user;
            SystemUserGroup sys_user_group;

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String passwd = userpassword;
            md.update(passwd.getBytes("UTF-8"));
            byte[] digest = md.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < digest.length; i++) {
                sb.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
            }
            String paswdToStoreInDB = sb.toString();

            // apart from the default constructor which is required by JPA
            // you need to also implement a constructor that will make the following code succeed
            sys_user = new SystemUser(username, paswdToStoreInDB, name, surname, currency, admin);

            if(admin)
            sys_user_group = new SystemUserGroup(username, "admins");
            else
            sys_user_group = new SystemUserGroup(username, "users");

            em.persist(sys_user);
            em.persist(sys_user_group);

        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
