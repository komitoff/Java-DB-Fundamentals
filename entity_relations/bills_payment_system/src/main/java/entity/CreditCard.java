package entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "credit_card")
public class CreditCard extends BillingDetail {

    public static final String CARD_TYPE = "Credit Card";

    public static final String EXPIRATION_DATE = "12/12";

    public static final String EXPIRATION_YEAR = "2017";


}
