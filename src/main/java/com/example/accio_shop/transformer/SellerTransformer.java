package com.example.accio_shop.transformer;

import com.example.accio_shop.dto.request.SellerRequest;
import com.example.accio_shop.dto.response.SellerResponse;
import com.example.accio_shop.model.Seller;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;

@UtilityClass
public class SellerTransformer {

    public Seller sellerRequestToSeller(SellerRequest sellerRequest){
        return Seller.builder()
                .name(sellerRequest.getName())
                .panCard(sellerRequest.getPanCard())
                .email(sellerRequest.getEmail())
                .products(new ArrayList<>())
                .build();
    }

    public SellerResponse sellerToSellerResponse(Seller seller){
        return SellerResponse.builder()
                .name(seller.getName())
                .email(seller.getEmail())
                .build();
    }
}
