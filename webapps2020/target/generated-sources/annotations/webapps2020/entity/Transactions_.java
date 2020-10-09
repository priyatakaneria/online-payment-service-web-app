package webapps2020.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-24T22:37:55")
@StaticMetamodel(Transactions.class)
public class Transactions_ { 

    public static volatile SingularAttribute<Transactions, String> senderCurrency;
    public static volatile SingularAttribute<Transactions, Double> senderAmount;
    public static volatile SingularAttribute<Transactions, String> receiver;
    public static volatile SingularAttribute<Transactions, String> sender;
    public static volatile SingularAttribute<Transactions, Long> id;
    public static volatile SingularAttribute<Transactions, String> receiverCurrency;
    public static volatile SingularAttribute<Transactions, Double> receiverAmount;

}