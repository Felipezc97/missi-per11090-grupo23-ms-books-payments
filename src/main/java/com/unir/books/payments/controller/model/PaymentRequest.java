package com.unir.books.payments.controller.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

    @NotNull(message = "Date es requerido")
    private Date date;

    @NotNull(message = "Status es requerido")
    @NotEmpty(message = "Status no puede ser vacío")
    private String status;

    @NotNull(message = "Method es requerido")
    @NotEmpty(message = "Method no puede ser vacío")
    private String method;

    @NotNull(message = "Total Amount es requerido")
    private Double totalAmount;

    @NotNull(message = "Books es requerido")
    @NotEmpty(message = "Books no puede ser vacío")
    private List<String> books;
}
