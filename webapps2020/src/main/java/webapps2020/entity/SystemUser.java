package webapps2020.entity;

import webapps2020.jsf.CurrencyBean;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.validation.constraints.NotNull;

/**
 *
 * @author priya
 */
@NamedQueries({
    @NamedQuery(name = "findUser", query = "SELECT NEW webapps2020.jsf.User(s.username, s.userpassword, s.name, s.surname, s.currency, s.balance) FROM SystemUser s WHERE s.username LIKE :username"),
    @NamedQuery(name = "findUsers", query = "SELECT NEW webapps2020.jsf.User(s.username, s.userpassword, s.name, s.surname, s.currency, s.balance) FROM SystemUser s WHERE s.username NOT LIKE :username AND s.currency NOT LIKE :currency"),
    @NamedQuery(name = "findUserLiteral", query = "SELECT s FROM SystemUser s WHERE s.username LIKE :username")

})

@Entity
public class SystemUser implements Serializable {
    // here on could use Bean Validation annotations to enforce specific rules - this could be alternatively implemented when validating the form in the web tier
    // for now we check only for Null values
    @Id
    @NotNull
    String username;
    String userpassword;

    @NotNull
    String name;

    @NotNull
    String surname;

    @NotNull
    String currency;

    @NotNull
    double balance;

    public SystemUser() {
    }

    public SystemUser(String username, String userpassword, String name, String surname, String currency, boolean admin) {
        double balance;
        this.username = username;
        this.userpassword = userpassword;
        this.name = name;
        this.surname = surname;
        this.currency = currency;
        CurrencyBean cb = new CurrencyBean();  
        if (admin)
        balance = 0;
        else
        balance = cb.convertCurrency("GBP", currency, 1000);
        this.balance = balance;
    }

//    public Long getId() {
//        return id;
//    }

//    public void setId(Long id) {
//        this.id = id;
//    }

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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.username);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SystemUser other = (SystemUser) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }

}
