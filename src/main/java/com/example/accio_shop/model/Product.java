package com.example.accio_shop.model;

import com.example.accio_shop.enums.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private int price;

    @Enumerated(value = EnumType.STRING)
    @Column
    Category category;

    @JoinColumn(name = "seller_id")
    @ManyToOne
    Seller seller;

    @OneToMany(mappedBy = "product")
    List<Review> reviews = new ArrayList<>();

    @ManyToMany(mappedBy = "products")
    List<OrderEntity> orders = new ArrayList<>();
}
