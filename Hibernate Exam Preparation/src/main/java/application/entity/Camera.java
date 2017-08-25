package application.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "camera")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Camera {
}
