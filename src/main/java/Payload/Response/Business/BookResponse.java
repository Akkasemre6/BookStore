package Payload.Response.Business;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class BookResponse {

    private long id;

    private String bookName;

    private double price;

    private String author;

    private String publisher;

    private String imageUrl;

    private String description;




}
