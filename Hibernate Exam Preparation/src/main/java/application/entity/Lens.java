package application.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "lenses")
public class Lens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "make")
    @Enumerated(EnumType.STRING)
    private Enum make;

    @Column(name = "max_aperture", precision = 1)
    private Double maxAperture;

    @Column(name = "focal_length")
    private Integer focalLength;

    @Column(name = "compatible_with")
    @Enumerated(EnumType.STRING)
    private Enum compatibleWith;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id",
    referencedColumnName = "id")
    private Photographer owner;

    public Lens( ) {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Enum getMake() {
        return make;
    }

    public void setMake(Enum make) {
        this.make = make;
    }

    public Double getMaxAperture() {
        return maxAperture;
    }

    public void setMaxAperture(Double maxAperture) {
        this.maxAperture = maxAperture;
    }

    public Integer getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(Integer focalLength) {
        this.focalLength = focalLength;
    }

    public Enum getCompatibleWith() {
        return compatibleWith;
    }

    public void setCompatibleWith(Enum compatibleWith) {
        this.compatibleWith = compatibleWith;
    }

    public Photographer getOwner() {
        return owner;
    }

    public void setOwner(Photographer owner) {
        this.owner = owner;
    }
}
