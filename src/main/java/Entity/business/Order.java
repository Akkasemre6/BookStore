package Entity.business;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import Entity.User.User;

import java.util.List;

@Entity
public class Order {

    @Id
    private long id;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "order")
    private List<Book> order;

    private double price;
}
