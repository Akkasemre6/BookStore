package Entity.business;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class Book {

    @Id
    private long id;

    private String bookName;

    private double price;

    private String author;

    private String publisher;

    private String imageUrl;

    private String description;



}
