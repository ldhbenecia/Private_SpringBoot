package hellojpa.ex2.item;

import hellojpa.ex2.Item;
import jakarta.persistence.Entity;

@Entity
public class Book extends Item {

    private String author;
    private String isbn;
}
