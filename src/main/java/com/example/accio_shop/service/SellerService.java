package com.example.accio_shop.service;

import com.example.accio_shop.dto.request.SellerRequest;
import com.example.accio_shop.dto.response.SellerResponse;
import com.example.accio_shop.model.Seller;
import com.example.accio_shop.repository.SellerRepository;
import com.example.accio_shop.transformer.SellerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;

    public SellerResponse addSeller(SellerRequest sellerRequest) {
        //1. DTO -> Entity
        Seller seller = SellerTransformer.sellerRequestToSeller(sellerRequest);
        Seller savedSeller = sellerRepository.save(seller);
        return SellerTransformer.sellerToSellerResponse(savedSeller);
    }
}
