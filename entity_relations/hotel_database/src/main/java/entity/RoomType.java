package entity;

import javax.persistence.*;

@Entity
@Table(name = "room_type")
public class RoomType {
    private Long id;
    private String roomType;
    private String note;
    private Room room;

    public RoomType () {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @OneToOne
    @JoinColumn(name = "room_id", referencedColumnName = "room_number")
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
