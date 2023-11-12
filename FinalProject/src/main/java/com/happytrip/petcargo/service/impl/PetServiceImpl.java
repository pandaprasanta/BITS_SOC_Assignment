package com.happytrip.petcargo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happytrip.petcargo.dao.CategoryDao;
import com.happytrip.petcargo.dao.PetDao;
import com.happytrip.petcargo.model.Pet;
import com.happytrip.petcargo.service.PetService;

@Service
public class PetServiceImpl implements PetService {
	@Autowired
	private PetDao petDao;

	@Override
	public void savePet(Pet pet) {
		
		petDao.savePet(pet);
	}

	@Override
	public void removePet(int petId) {
		Pet pet=new Pet();
		pet=petDao.fetchPet(petId);
		petDao.removePet(pet);
	}

	@Override
	public void editPet(Pet pet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pet fetchPet(int petId) {
		return petDao.fetchPet(petId);
		
	}

	@Override
	public List<Pet> fetchAllPet() {
		
		return petDao.fetchAllPet();
	}

	@Override
	public int fetchPetByUserId(int userId) {
		
		return petDao.fetchPetByUserId(userId);
	}
	
	
}
