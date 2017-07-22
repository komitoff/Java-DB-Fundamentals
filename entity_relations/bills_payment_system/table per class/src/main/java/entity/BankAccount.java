package entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bank_account")
public class BankAccount extends BasicBillingDetails {
    private String swiftCode;
    private String bankName;

    public BankAccount() {}

    @Column(name = "swift_code")
    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    @Column(name = "bank_name")
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
