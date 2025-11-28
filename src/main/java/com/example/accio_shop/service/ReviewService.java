package com.example.accio_shop.service;

import com.example.accio_shop.exception.ReviewNotFoundException;
import com.example.accio_shop.model.Review;
import com.example.accio_shop.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    public Review getReviewsById(int id) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if(reviewOptional.isEmpty()) {
            throw new ReviewNotFoundException("Invalid review id");
        }
        return reviewOptional.get();
    }
}
