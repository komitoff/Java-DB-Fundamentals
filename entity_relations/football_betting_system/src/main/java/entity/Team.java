package entity;

import javax.persistence.*;

@Entity
@Table(name = "team")
public class Team {
    private Long id;
    private String name;
    private String logo;
    private String initials;
    private Color primaryKitColor;
    private Color secondaryKitColor;
    private Town town;

    public Team() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "logo")
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Column(name = "initials")
    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    @ManyToOne
    @JoinColumn(name = "primary_kit_color",
    referencedColumnName = "id")
    public Color getPrimaryKitColor() {
        return primaryKitColor;
    }

    public void setPrimaryKitColor(Color primaryKitColor) {
        this.primaryKitColor = primaryKitColor;
    }

    @ManyToOne
    @JoinColumn(name = "secondary_kit_color",
    referencedColumnName = "id")
    public Color getSecondaryKitColor() {
        return secondaryKitColor;
    }

    public void setSecondaryKitColor(Color secondaryKitColor) {
        this.secondaryKitColor = secondaryKitColor;
    }

    @ManyToOne
    @JoinColumn(name = "town_id",
    referencedColumnName = "id")
    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}
