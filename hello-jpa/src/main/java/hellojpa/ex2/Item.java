package hellojpa.ex2;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @OneToMany(mappedBy = "order_item")
    private List<OrderItem> orderItems = new ArrayList<>();

    private String name;
    private int price;
    private int stockQuantity;
}
