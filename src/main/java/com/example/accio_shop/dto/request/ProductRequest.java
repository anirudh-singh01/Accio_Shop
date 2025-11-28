package com.example.accio_shop.dto.request;

import com.example.accio_shop.enums.Category;
import com.example.accio_shop.model.Seller;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductRequest {

    private String name;

    private int price;

    private Category category;

}
