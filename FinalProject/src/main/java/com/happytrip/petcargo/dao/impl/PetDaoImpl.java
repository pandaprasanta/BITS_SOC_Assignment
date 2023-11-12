package com.happytrip.petcargo.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.happytrip.petcargo.dao.PetDao;
import com.happytrip.petcargo.model.Pet;

@Repository
public class PetDaoImpl implements PetDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public boolean savePet(Pet pet) {
		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(pet);
	    transaction.commit();
	    session.close();
	 
		return true;
	}

	@Override
	public boolean removePet(Pet pet) {
		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.delete(pet);
	    transaction.commit();
	    session.close();
		return false;
	}

	@Override
	public boolean editPet(Pet pet) {
		
		return false;
	}

	@Override
	public Pet fetchPet(int petId) {
		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Pet pet=(Pet) session.get(Pet.class, petId);
	    transaction.commit();
	    session.close();
		return pet;
	}

	@Override
	public List<Pet> fetchAllPet() {
		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		List<Pet> pets=session.createQuery("from pet").list();
	    transaction.commit();
	    session.close();
		return pets;
	}

	@Override
	public int fetchPetByUserId(int userId) {
		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		int x=(int) session.createQuery("select t.petId from Pet t where t.user.userId='"+userId+"'").list().get(0);
	    transaction.commit();
	    session.close();
		return x;
	}
	


}
