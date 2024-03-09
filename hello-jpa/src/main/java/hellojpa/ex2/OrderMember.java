package hellojpa.ex2;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class OrderMember {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_member_id")
    private Long id;

    private String name;
    private String city;
    private String street;
    private String zipcode;

    @OneToMany(mappedBy = "orderMember")
    private List<Order> orders = new ArrayList<>();
}
