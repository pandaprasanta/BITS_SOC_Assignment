package com.happytrip.petcargo.service;

import java.util.List;

import com.happytrip.petcargo.model.PetBooking;

public interface PetBookingService {
	public void saveBooking(int userId,int petId,int binId);

	public void cancleBooking(int petId);

	public void editbooked(PetBooking booking);

	public PetBooking fetchbooking(int bookingId);

	public List<PetBooking> fetchAllbooking();
	public PetBooking fetchByPetId(int petId);
}
