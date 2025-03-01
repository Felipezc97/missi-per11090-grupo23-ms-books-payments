package com.unir.books.payments.facade.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Book {

    private Long id;
    private String title;
    private String author;
    private Date published;
    private String category;
    private String isbn;
    private Integer rating;
    private Double price;
    private Integer stock;
    private Boolean visible;

}
