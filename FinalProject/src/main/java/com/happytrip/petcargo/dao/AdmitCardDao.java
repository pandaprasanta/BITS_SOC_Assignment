package com.happytrip.petcargo.dao;

import java.util.List;
import com.happytrip.petcargo.model.AdmitCard;

public interface AdmitCardDao {
   public boolean createAdmitCard(AdmitCard admitCard);
   public boolean destroyAdmitCard(AdmitCard admitCard);
   public boolean recreateAdmitCard(AdmitCard admitCard);
   public AdmitCard fetchAdmitCard(int admitcardId);
   public AdmitCard fetchByBookingId(int petbookingId);
   public List<AdmitCard> fetchAllAdmitCard();
}
