package entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {

    private String accountNumber;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emergencyName;
    private String emergencyNumber;
    private Set<Payment> payments;
    private Set<Occupancy> occupancies;

    public Customer () {  }

    @Id
    @Column(name = "account_number")
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "emergency_name")
    public String getEmergencyName() {
        return emergencyName;
    }

    public void setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName;
    }

    @Column(name = "emergency_number")
    public String getEmergencyNumber() {
        return emergencyNumber;
    }

    public void setEmergencyNumber(String emergencyNumber) {
        this.emergencyNumber = emergencyNumber;
    }

    @OneToMany(mappedBy = "accountNumber")
    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    @OneToMany(mappedBy = "accountNumber")
    public Set<Occupancy> getOccupancies() {
        return occupancies;
    }

    public void setOccupancies(Set<Occupancy> occupancies) {
        this.occupancies = occupancies;
    }
}
