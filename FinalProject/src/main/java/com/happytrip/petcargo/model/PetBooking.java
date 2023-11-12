package com.happytrip.petcargo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PETBOOKINGS")
public class PetBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	@OneToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	@OneToOne
	@JoinColumn(name = "PET_ID")
	private Pet pet;
	@Column(name = "DATE")
	private Date date;
	@OneToOne
	@JoinColumn(name = "BIN_ID")
	private Bin bin;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date2) {
		this.date =  date2;
	}

	public Bin getBin() {
		return bin;
	}

	public void setBin(Bin bin) {
		this.bin = bin;
	}

}
