package entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private String billingDetails;
}
