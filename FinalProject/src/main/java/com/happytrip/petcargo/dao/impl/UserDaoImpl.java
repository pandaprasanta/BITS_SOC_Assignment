package com.happytrip.petcargo.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.happytrip.petcargo.dao.UserDao;
import com.happytrip.petcargo.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public boolean createUser(User user) {
		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(user);
		 transaction.commit();
		 session.close();
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(User user) {
		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.delete(user);
		transaction.commit();
		 session.close();
		return false;
	}

	@Override
	public User fetchUser(int userId) {
		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		User user=(User) session.get(User.class, userId);
		transaction.commit();
		 session.close();
		
		return user;
	}

	@Override
	public List<User> fetchAllUser() {
		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		List<User> users=session.createQuery("from user").list();
		transaction.commit();
		 session.close();
		return users;
	}
	
	
	
}
