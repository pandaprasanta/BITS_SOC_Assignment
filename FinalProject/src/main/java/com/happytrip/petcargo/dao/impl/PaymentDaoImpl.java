package com.happytrip.petcargo.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.happytrip.petcargo.dao.PaymentDao;
import com.happytrip.petcargo.model.Payment;

@Repository
public class PaymentDaoImpl implements PaymentDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean makePayment(Payment payment) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(payment);
		transaction.commit();
		session.close();
		return true;
	}

	@Override
	public boolean refundPayment(Payment payment) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(payment);
		transaction.commit();
		session.close();
		return true;
	}

	@Override
	public Payment fetchPayment(int paymentId) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Payment payment = (Payment) session.get(Payment.class, paymentId);
		transaction.commit();
		session.close();
		return payment;
	}

	@Override
	public List<Payment> fetchAllPayment() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Payment> payments = session.createQuery("from payment").list();
		transaction.commit();
		session.close();
		return payments;
	}

	@Override
	public Payment fetchByBookingId(int bookingId) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Payment payment = (Payment) session.get(Payment.class, bookingId);
		transaction.commit();
		session.close();
		return payment;

	}

}
