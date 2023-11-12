package com.happytrip.petcargo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.happytrip.petcargo.dao.PaymentDao;
import com.happytrip.petcargo.model.Payment;
import com.happytrip.petcargo.service.PaymentService;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	PaymentDao paymentDao;

	@Override
	public void makePayment(Payment payment) {
		paymentDao.makePayment(payment);
		
	}

	@Override
	public void refundPayment(int userId, int petbookingId) {
		Payment payment=paymentDao.fetchByBookingId(petbookingId);
		paymentDao.refundPayment(payment);
		
	}

	@Override
	public Payment fetchPayment(int paymentId) {
	
		return paymentDao.fetchPayment(paymentId);
	}

	@Override
	public List<Payment> fetchAllPayment() {
		
		return paymentDao.fetchAllPayment();
	}

	@Override
	public Payment fetchByBookingId(int bookingId) {
		return paymentDao.fetchByBookingId(bookingId);
	}

	
	

}
