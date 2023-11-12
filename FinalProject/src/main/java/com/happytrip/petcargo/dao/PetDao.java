package com.happytrip.petcargo.dao;


import java.util.List;

import com.happytrip.petcargo.model.Pet;


public interface PetDao {
   public boolean savePet(Pet pet);
   public boolean removePet(Pet pet);
   public boolean editPet(Pet pet);
   public Pet fetchPet(int petId);
   public List<Pet> fetchAllPet();
   public int fetchPetByUserId(int userId);
}
