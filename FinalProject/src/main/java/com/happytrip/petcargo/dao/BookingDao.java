package com.happytrip.petcargo.dao;

import java.util.List;

import com.happytrip.petcargo.model.PetBooking;



public interface BookingDao {
     public boolean saveBooking(PetBooking booking);
     public boolean cancleBooking(PetBooking booking);
     public boolean editbooked(PetBooking booking);
     public PetBooking fetchbooking(int bookingId);
     public PetBooking fetchByPetId(int petId);
     public List<PetBooking> fetchAllbooking();
}
