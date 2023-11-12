package com.happytrip.petcargo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.happytrip.petcargo.dao.CategoryDao;
import com.happytrip.petcargo.model.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	//SessionFactory sessionFactory=ConnectionHelper.getSessionFactory();
	@Override
	public void addCategory(Category category) {
		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(category);
		transaction.commit();
		session.close();
		//sessionFactory.getCurrentSession().save(category);
		
	}
	@Override
	public void removeCategory(Category category) {
		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.delete(category);
		transaction.commit();
		session.close();
//		sessionFactory.getCurrentSession().delete(category);
	}
	@Override
	public Category fetchCategoryById(int categoryId) {
		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Category category=null;
		category=(Category) session.get(Category.class,categoryId);
		transaction.commit();
		session.close();
		return category;
//		return null;
		//Category category=(Category) sessionFactory.getCurrentSession().find("select t from Category t where t.categoryId=?",categoryId, null).get(0);
		//return category;

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> fetchAllCategory() {
		List<Category> categories=null;
		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery("FROM Category c");
		categories=query.list();
	    transaction.commit();
	    session.close();
		return categories;
		
	}
	@Override
	public int getCategoryBySize(String size) {
		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Category category=null;
		int id=0;
		Query query= session.createQuery("select c from Category c where c.categorySize=:size").setString("size", size);
		category=(Category) query.list().get(0);
		id=category.getCategoryId();
		transaction.commit();
		session.close();
		return id;
	}

}
