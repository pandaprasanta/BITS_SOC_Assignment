package com.happytrip.petcargo.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.happytrip.petcargo.dao.BookingDao;
import com.happytrip.petcargo.model.PetBooking;


@Repository
public class BookingDaoImpl implements BookingDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean saveBooking(PetBooking booking) {
		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(booking);
	    transaction.commit();
	    session.close();
		return true;
	}

	@Override
	public boolean cancleBooking(PetBooking booking) {
		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.delete(booking);
	    transaction.commit();
	    session.close();
		return false;
	}

	@Override
	public boolean editbooked(PetBooking booking) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PetBooking fetchbooking(int bookingId) {
		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		PetBooking petBooking=(PetBooking) session.get(PetBooking.class, bookingId);
	    transaction.commit();
	    session.close();
		return petBooking;
	}

	@Override
	public PetBooking fetchByPetId(int petId) {
		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery(" from PetBooking where pet.petId=:temp");
		query.setParameter("temp", petId);
		PetBooking petBooking=(PetBooking) query.list().get(0);
	    transaction.commit();
	    session.close();
		return petBooking;
	}

	@Override
	public List<PetBooking> fetchAllbooking() {
		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		List<PetBooking> petBookings=session.createQuery("from PetBooking").list();
	    transaction.commit();
	    session.close();
		return petBookings;
	}

	
	
}