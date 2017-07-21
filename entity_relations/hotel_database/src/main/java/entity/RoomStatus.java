package entity;

import javax.persistence.*;

@Entity
@Table(name = "room_status")
public class RoomStatus {

    private Long id;
    private String roomStatus;
    private String note;
    private Room room;

    public RoomStatus() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    @Column
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @OneToOne
    @JoinColumn(name = "room_id",
    referencedColumnName = "room_number")
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
