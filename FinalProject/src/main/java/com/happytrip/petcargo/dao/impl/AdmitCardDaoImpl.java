package com.happytrip.petcargo.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.happytrip.petcargo.dao.AdmitCardDao;
import com.happytrip.petcargo.model.AdmitCard;


@Repository
public class AdmitCardDaoImpl implements AdmitCardDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean createAdmitCard(AdmitCard admitCard) {
		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(admitCard);
		transaction.commit();
		session.close();
		return true;
	}

	@Override
	public boolean destroyAdmitCard(AdmitCard admitCard) {
		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.delete(admitCard);
		transaction.commit();
		session.close();
		return true;
	}

	@Override
	public boolean recreateAdmitCard(AdmitCard admitCard) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AdmitCard fetchAdmitCard(int admitcardId) {
		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		AdmitCard admitCard=(AdmitCard) session.get(AdmitCard.class, admitcardId);
		transaction.commit();
		session.close();
		return admitCard;
	}

	@Override
	public AdmitCard fetchByBookingId(int petbookingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdmitCard> fetchAllAdmitCard() {
		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		List<AdmitCard> admitCards=null;
		Query query=session.createQuery("from AdmitCard");
		admitCards=query.list();
		return admitCards;
	}
	

}
