
package com.example.demo;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
	public List<Payment> getAllUsers();

	public Optional<Payment> getPayment(long gp);

	public Payment updatePayment(Payment p);

}
