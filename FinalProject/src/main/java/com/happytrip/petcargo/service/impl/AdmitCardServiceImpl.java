package com.happytrip.petcargo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happytrip.petcargo.dao.AdmitCardDao;
import com.happytrip.petcargo.model.AdmitCard;
import com.happytrip.petcargo.service.AdmitCardService;

@Service
@Transactional
public class AdmitCardServiceImpl implements AdmitCardService{

	@Autowired
	AdmitCardDao admitCardDao;
	
	@Override
	public boolean createAdmitCard(AdmitCard admitCard) {
	   admitCardDao.createAdmitCard(admitCard);	
		return true;
	}

	@Override
	public boolean destroyAdmitCard(AdmitCard admitCard) {
		admitCardDao.destroyAdmitCard(admitCard);
		return false;
	}

	@Override
	public boolean recreateAdmitCard(AdmitCard admitCard) {
		
		return false;
	}

	@Override
	public AdmitCard fetchAdmitCard(int admitcardId) {
		
		return admitCardDao.fetchAdmitCard(admitcardId);
	}

	@Override
	public AdmitCard fetchByBookingId(int petbookingId) {
		
		return admitCardDao.fetchAdmitCard(petbookingId);
	}

	@Override
	public List<AdmitCard> fetchAllAdmitCard() {
		
		return admitCardDao.fetchAllAdmitCard();
	}

}
