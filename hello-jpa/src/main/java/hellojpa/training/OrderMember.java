package hellojpa.training;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class OrderMember extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @Embedded
    private Period period;

    @OneToMany(mappedBy = "orderMember")
    private List<Order> orders = new ArrayList<>();
}
