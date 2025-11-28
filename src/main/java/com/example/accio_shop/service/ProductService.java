package com.example.accio_shop.service;

import com.example.accio_shop.dto.request.ProductRequest;
import com.example.accio_shop.dto.response.ProductResponse;
import com.example.accio_shop.dto.response.SellerResponse;
import com.example.accio_shop.exception.SellerNotFoundException;
import com.example.accio_shop.model.Product;
import com.example.accio_shop.model.Seller;
import com.example.accio_shop.repository.ProductRepository;
import com.example.accio_shop.repository.SellerRepository;
import com.example.accio_shop.transformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SellerRepository sellerRepository;

    public ProductResponse addProduct(int sellerId, ProductRequest productRequest) {

        Optional<Seller> sellerOptional = sellerRepository.findById(sellerId);
        if (sellerOptional.isEmpty()){
            throw new SellerNotFoundException("Invalid Seller Id");
        }

        //1. DTO -> Entity
        Product product = ProductTransformer.productRequestToProduct(productRequest);

        //Set the relationship
        Seller seller = sellerOptional.get();
        seller.getProducts().add(product);
        product.setSeller(seller);

        Seller savedSeller = sellerRepository.save(seller); //seller + product

        //Product response
        int size = savedSeller.getProducts().size();
        Product savedProduct = savedSeller.getProducts().get(size-1);

        return ProductTransformer.productToProductResponse(savedProduct);
    }
}
