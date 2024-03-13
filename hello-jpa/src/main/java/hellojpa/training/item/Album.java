package hellojpa.training.item;

import hellojpa.training.Item;
import jakarta.persistence.Entity;

@Entity
public class Album extends Item {

    private String artist;
    private String etc;
}
