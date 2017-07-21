package entity;

import javax.persistence.*;

@Entity
@Table(name = "billing_detail")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BillingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Basic
    private Long number;

    @Basic
    private User owner;

    protected BillingDetail() {}


}
