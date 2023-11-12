package com.happytrip.petcargo.service;

import java.util.List;

import com.happytrip.petcargo.model.Payment;

public interface PaymentService {
	 public void makePayment(Payment payment);
	    public void refundPayment(int userId,int petbookingId);
	    public Payment fetchPayment(int paymentId);
	    public List<Payment> fetchAllPayment();
	    public Payment fetchByBookingId(int bookingId);
}
