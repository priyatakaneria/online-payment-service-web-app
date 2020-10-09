package webapps2020.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-24T22:37:55")
@StaticMetamodel(PaymentRequest.class)
public class PaymentRequest_ { 

    public static volatile SingularAttribute<PaymentRequest, String> senderCurrency;
    public static volatile SingularAttribute<PaymentRequest, Double> senderAmount;
    public static volatile SingularAttribute<PaymentRequest, String> receiver;
    public static volatile SingularAttribute<PaymentRequest, String> sender;
    public static volatile SingularAttribute<PaymentRequest, Long> id;
    public static volatile SingularAttribute<PaymentRequest, String> receiverCurrency;
    public static volatile SingularAttribute<PaymentRequest, Double> receiverAmount;

}