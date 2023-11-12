package com.happytrip.petcargo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytrip.petcargo.dao.BinDao;
import com.happytrip.petcargo.model.Bin;
import com.happytrip.petcargo.model.Category;

@Repository
public class BinDaoImpl implements BinDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addBin(Bin bin,int id) {
		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		System.out.println(id);
		Category cat=(Category)session.get(Category.class,id);
		bin.setCategory(cat);
		//cat.getBin().add(bin);
	    //session.update(cat);
		session.save(bin);
	    transaction.commit();
	    session.close();
	}
		
	@Override
	public List<Bin> searchBin(int categoryId) {
		Session session= sessionFactory.openSession();
		List<Bin> bins=new ArrayList<Bin>();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery("select t from  Bin t where t.category.categoryId="+categoryId);
		bins=query.list();
		transaction.commit();
		session.close();
		return bins;
//		return null;
		//return session.find("select t from BINS t where t.category=?",categoryId);
	}
	
	@Override
	public Bin fetchBinById(int binId) {
		Bin bin=null;
		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		bin=(Bin) session.get(Bin.class,binId);
		transaction.commit();
		session.close();
		return bin;
	}
	@Override
	public void removeBin(Bin bin) {
			Session session= sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.delete(bin);
			transaction.commit();
			session.close();
	}
	@Override
	public List<Bin> fetchAllBins() {
		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		List<Bin> bins=null;
		Query query=session.createQuery("FROM Bin b");
		bins=query.list();
		transaction.commit();
		session.close();
		return bins;
	}
}
