package entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Occupancy {
    private Long id;
    private Date dateOccupied;
    private String accountNumber;
    private String roomNumber;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Float getRateApplied() {
        return rateApplied;
    }

    public void setRateApplied(Float rateApplied) {
        this.rateApplied = rateApplied;
    }

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
