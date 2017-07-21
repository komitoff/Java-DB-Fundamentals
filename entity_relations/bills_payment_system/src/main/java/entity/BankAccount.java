package entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value = "Unicredit")
public class BankAccount extends BillingDetail {

    public static final String BANK_NAME = "UniCredit";

    public static final String SWIFT_CODE = "asjdiqjw1123";
}
