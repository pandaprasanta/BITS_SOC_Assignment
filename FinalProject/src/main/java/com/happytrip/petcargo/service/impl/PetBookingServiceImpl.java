package com.happytrip.petcargo.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happytrip.petcargo.controller.PetBookingController;
import com.happytrip.petcargo.dao.BinDao;
import com.happytrip.petcargo.dao.BookingDao;
import com.happytrip.petcargo.dao.PetDao;
import com.happytrip.petcargo.dao.UserDao;
import com.happytrip.petcargo.model.PetBooking;
import com.happytrip.petcargo.service.PetBookingService;

@Service
@Transactional
public class PetBookingServiceImpl implements PetBookingService {

	@Autowired
	BookingDao bookingDao;
	@Autowired
	UserDao userDao;
	@Autowired
	PetDao petDao;
	@Autowired
	BinDao binDao;
	
	@Override
	public void saveBooking(int userId, int petId, int binId) {
		PetBooking booking=new PetBooking();
		booking.setUser(userDao.fetchUser(userId));
		booking.setPet(petDao.fetchPet(petId));
		booking.setBin(binDao.fetchBinById(binId));
		booking.setDate(new Date());
		bookingDao.saveBooking(booking);
		
	}

	@Override
	public void cancleBooking(int petId) {
		PetBooking booking=new PetBooking();
		 booking=bookingDao.fetchbooking(petId);
		bookingDao.cancleBooking(booking);
		
	}

	@Override
	public void editbooked(PetBooking booking) {
		
		
	}

	@Override
	public PetBooking fetchbooking(int bookingId) {
		
		return bookingDao.fetchbooking(bookingId);
	}

	@Override
	public List<PetBooking> fetchAllbooking() {
		return bookingDao.fetchAllbooking();
	}

	@Override
	public PetBooking fetchByPetId(int petId) {
		
		return bookingDao.fetchByPetId(petId);
	}
	

}
