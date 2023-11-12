package com.happytrip.petcargo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ADMITCARD")
public class AdmitCard {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cardId;
	@Column(name = "BARCODE_NO")
	private long barcodeNo;
	@OneToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	@OneToOne
	@JoinColumn(name = "PETBOOKING_ID")
	private PetBooking petBooking;

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public long getBarcodeNo() {
		return barcodeNo;
	}

	public void setBarcodeNo(long barcodeNo) {
		this.barcodeNo = barcodeNo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PetBooking getBooking() {
		return petBooking;
	}

	public void setBooking(PetBooking petBooking) {
		this.petBooking = petBooking;
	}
}
