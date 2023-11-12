package com.happytrip.petcargo.service;

import java.util.List;

import com.happytrip.petcargo.model.Pet;

public interface PetService {
	 public void savePet(Pet pet);
	   public void removePet(int petId);
	   public void editPet(Pet pet);
	   public Pet fetchPet(int petId);
	   public List<Pet> fetchAllPet();
	   public int fetchPetByUserId(int userId);
}
