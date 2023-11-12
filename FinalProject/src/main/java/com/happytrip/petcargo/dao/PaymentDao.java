package com.happytrip.petcargo.dao;

import java.util.List;

import com.happytrip.petcargo.model.Payment;


public interface PaymentDao {
    public boolean makePayment(Payment payment);
    public boolean refundPayment(Payment payment);
    public Payment fetchPayment(int paymentId);
    public List<Payment> fetchAllPayment();
    public Payment fetchByBookingId(int bookingId);
}
