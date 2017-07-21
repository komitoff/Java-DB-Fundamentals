package entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "room")
public class Room {
    private Long roomNumber;
    private RoomType roomType;
    private BedType bedType;
    private RoomStatus roomStatus;
    private Float rate;
    private String note;
    private Set<Occupancy> occupancies;

    public Room () { }

    @Id
    @Column(name = "room_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Long roomNumber) {
        this.roomNumber = roomNumber;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "room")
    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }


    @OneToOne(optional = false, mappedBy = "room")
    public BedType getBedType() {
        return bedType;
    }

    public void setBedType(BedType bedType) {
        this.bedType = bedType;
    }


    @OneToOne(optional = false, mappedBy = "room")
    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @OneToMany(mappedBy = "roomNumber")
    public Set<Occupancy> getOccupancies() {
        return occupancies;
    }

    public void setOccupancies(Set<Occupancy> occupancies) {
        this.occupancies = occupancies;
    }
}
