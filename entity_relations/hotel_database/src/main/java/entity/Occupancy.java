package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "occupancy")
public class Occupancy {
    private Long id;
    private Date dateOccupied;
    private Customer accountNumber;
    private Room roomNumber;
    private Float rateApplied;
    private String phoneCharge;
    private String note;

    public Occupancy() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOccupied() {
        return dateOccupied;
    }

    public void setDateOccupied(Date dateOccupied) {
        this.dateOccupied = dateOccupied;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id",
    referencedColumnName = "account_number")
    public Customer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Customer accountNumber) {
        this.accountNumber = accountNumber;
    }

    @ManyToOne
    @JoinColumn(name = "occupancy_id",
    referencedColumnName = "room_number")
    public Room getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Room roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Column(name = "rate_applied")
    public Float getRateApplied() {
        return rateApplied;
    }

    public void setRateApplied(Float rateApplied) {
        this.rateApplied = rateApplied;
    }

    @Column(name = "phone_charge")
    public String getPhoneCharge() {
        return phoneCharge;
    }

    public void setPhoneCharge(String phoneCharge) {
        this.phoneCharge = phoneCharge;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
