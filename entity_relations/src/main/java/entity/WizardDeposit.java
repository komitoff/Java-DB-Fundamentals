package entity;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "wizard_deposit")
public class WizardDeposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", length = 50)
    private String firstName;
    @Column(name = "last_name", length = 60, nullable = false)
    private String lastName;
    @Column(name = "notes", length = 1000)
    private String notes;
    @Column(nullable = false)
    private Integer age;
    @Column(name = "magic_wand_creator", length = 100)
    private String magicWandCreator;
    @Column(name = "magic_wand_size")
    private Integer magicWandSize;
    @Column(name = "deposit_group", length = 20)
    private String depositGroup;
    @Column(name = "deposit_start_date")
    private Date depositStartDate;
    @Column(name = "deposit_amount")
    private Double depositAmount;
    @Column(name = "deposit_interest")
    private Double depositInterest;
    @Column(name = "deposit_charge")
    private Double depositCharge;
    @Column(name = "deposit_expiration_date")
    private Date depositExpirationDate;
    @Column(name = "is_deposit_expired")
    private Boolean isDepositExpired;

    public WizardDeposit() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMagicWandCreator() {
        return magicWandCreator;
    }

    public void setMagicWandCreator(String magicWandCreator) {
        this.magicWandCreator = magicWandCreator;
    }

    public Integer getMagicWandSize() {
        return magicWandSize;
    }

    public void setMagicWandSize(Integer magicWandSize) {
        this.magicWandSize = magicWandSize;
    }

    public String getDepositGroup() {
        return depositGroup;
    }

    public void setDepositGroup(String depositGroup) {
        this.depositGroup = depositGroup;
    }

    public Date getDepositStartDate() {
        return depositStartDate;
    }

    public void setDepositStartDate(Date depositStartDate) {
        this.depositStartDate = depositStartDate;
    }

    public Double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(Double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public Double getDepositInterest() {
        return depositInterest;
    }

    public void setDepositInterest(Double depositInterest) {
        this.depositInterest = depositInterest;
    }

    public Double getDepositCharge() {
        return depositCharge;
    }

    public void setDepositCharge(Double depositCharge) {
        this.depositCharge = depositCharge;
    }

    public Date getDepositExpirationDate() {
        return depositExpirationDate;
    }

    public void setDepositExpirationDate(Date depositExpirationDate) {
        this.depositExpirationDate = depositExpirationDate;
    }

    public Boolean getIsDepositExpired() {
        return isDepositExpired;
    }

    public void setIsDepositExpired(Boolean depositExpired) {
        isDepositExpired = depositExpired;
    }
}
