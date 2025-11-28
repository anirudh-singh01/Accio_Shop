package com.example.accio_shop.transformer;

import com.example.accio_shop.dto.request.ProductRequest;
import com.example.accio_shop.dto.response.ProductResponse;
import com.example.accio_shop.model.Product;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;

@UtilityClass
public class ProductTransformer {

    public Product productRequestToProduct(ProductRequest productRequest){
        return Product.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .category(productRequest.getCategory())
                .reviews(new ArrayList<>())
                .orders(new ArrayList<>())
                .build();
    }

    public ProductResponse productToProductResponse(Product product){
        return ProductResponse.builder()
                .name(product.getName())
                .price(product.getPrice())
                .category(product.getCategory())
                .seller(SellerTransformer.sellerToSellerResponse(product.getSeller()))
                .build();
    }
}
