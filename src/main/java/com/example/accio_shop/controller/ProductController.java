package com.example.accio_shop.controller;

import com.example.accio_shop.dto.request.ProductRequest;
import com.example.accio_shop.dto.response.ProductResponse;
import com.example.accio_shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity addProduct(@RequestParam("seller-id") int sellerId,
                                     @RequestBody ProductRequest productRequest){
        ProductResponse response = productService.addProduct(sellerId, productRequest);
    }
}
