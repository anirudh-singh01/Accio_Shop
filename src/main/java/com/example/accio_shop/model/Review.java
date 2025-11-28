package com.example.accio_shop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Review {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String comment;

    @Min(value = 1)
    @Max(value = 5)
    @Column
    private int rating;

    @JoinColumn(name = "customer_id")
    @ManyToOne
    @JsonBackReference
    Customer customer;

    @JoinColumn(name = "product_id")
    @ManyToOne
    @JsonIgnore
    Product product;
}
