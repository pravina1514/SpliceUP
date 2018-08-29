/**
 * 
 */
package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HP
 *
 */
@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentRepository payrepo;

	@Override
	public List<Payment> getAllUsers() {
		// TODO Auto-generated method stub
		return payrepo.findAll();
	}

	@Override
	public Optional<Payment> getPayment(long gp) {
		// TODO Auto-generated method stub
		return payrepo.findById(gp);

	}

	@Override
	public Payment updatePayment(Payment p) {
		// TODO Auto-generated method stub
		return payrepo.save(p);

	}

}
