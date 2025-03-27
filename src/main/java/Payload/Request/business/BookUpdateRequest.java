package Payload.Request.business;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder


public class BookUpdateRequest {



    private String bookName;

    private double price;

    private String author;

    private String publisher;

    private String imageUrl;

    private String description;



}
