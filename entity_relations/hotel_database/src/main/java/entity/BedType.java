package entity;

import javax.persistence.*;

@Entity
@Table(name = "bed_type")
public class BedType {
    private Long id;
    private String bedType;
    private String note;
    private Room room;

    public BedType() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
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
