package com.example.accio_shop.dto.response;

import com.example.accio_shop.enums.Category;
import com.example.accio_shop.model.Seller;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductResponse {

    private String name;

    private int price;

    private Category category;

    private SellerResponse seller;
}
