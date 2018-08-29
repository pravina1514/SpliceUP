/**
 * 
 */
package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HP
 *
 */
@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewRepository reviewrepo;

	@Override
	public List<Review> getAllReviews() {
		// TODO Auto-generated method stub
		return reviewrepo.findAll();
	}

	@Override
	public Review updateReview(Review c) {
		// TODO Auto-generated method stub
		return reviewrepo.save(c);
	}

}
