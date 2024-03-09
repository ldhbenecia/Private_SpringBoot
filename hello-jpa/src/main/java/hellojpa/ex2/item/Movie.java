package hellojpa.ex2.item;

import hellojpa.ex2.Item;
import jakarta.persistence.Entity;

@Entity
public class Movie extends Item {

    private String director;
    private String actor;
}
