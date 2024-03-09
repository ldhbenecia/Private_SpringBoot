package hellojpa.ex2.item;

import hellojpa.ex2.Item;
import jakarta.persistence.Entity;

@Entity
public class Album extends Item {

    private String artist;
    private String etc;
}
