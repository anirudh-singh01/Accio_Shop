package com.example.accio_shop.dto.response;

import com.example.accio_shop.enums.Category;
import com.example.accio_shop.model.Seller;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductResponse {

    private String name;

    private int price;

    Category category;

    SellerResponse seller;
}
