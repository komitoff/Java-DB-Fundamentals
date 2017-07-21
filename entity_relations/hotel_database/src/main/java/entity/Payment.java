package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "payment")
public class Payment {

    private Long id;
    private Date paymentDate;
    private String accountNumber;
    private Date firstDateOccupied;
    private Date lastDateOccupied;
    private Integer totalDays;
    private BigDecimal amountCharged;
    private BigDecimal taxRate;
    private BigDecimal taxAmount;
    private BigDecimal payment_total;
    private String note;

    public Payment () {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getFirstDateOccupied() {
        return firstDateOccupied;
    }

    public void setFirstDateOccupied(Date firstDateOccupied) {
        this.firstDateOccupied = firstDateOccupied;
    }

    public Date getLastDateOccupied() {
        return lastDateOccupied;
    }

    public void setLastDateOccupied(Date lastDateOccupied) {
        this.lastDateOccupied = lastDateOccupied;
    }

    public Integer getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(Integer totalDays) {
        this.totalDays = totalDays;
    }

    public BigDecimal getAmountCharged() {
        return amountCharged;
    }

    public void setAmountCharged(BigDecimal amountCharged) {
        this.amountCharged = amountCharged;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getPayment_total() {
        return payment_total;
    }

    public void setPayment_total(BigDecimal payment_total) {
        this.payment_total = payment_total;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
