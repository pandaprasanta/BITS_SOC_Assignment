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
@Table(name = "PAYMENT")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int paymentId;
	@Column(name = "BANK_NAME")
	private String bankName;
	@Column(name = "CARD_NO")
	private String cardNo;
	@OneToOne
	@JoinColumn(name = "PETBOOKING_ID")
	private PetBooking petBooking;
	@OneToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PetBooking getPetBooking() {
		return petBooking;
	}

	public void setPetBooking(PetBooking petBooking) {
		this.petBooking = petBooking;
	}

}
