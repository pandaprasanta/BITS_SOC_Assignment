package com.happytrip.petcargo.model;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PETS")
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int petId;
	@Column(name = "PET_NAME")
	private String petName;
	@Column(name = "PET_CATEGORY")
	private String petCategory;
	@Column(name = "LENGTH")
	private double length;
	@Column(name = "BREADTH")
	private double breadth;
	@Column(name = "HEIGHT")
	private double height;
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	// private List<Bin> bins;
	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getPetCategory() {
		return petCategory;
	}

	public void setPetCategory(String petCategory) {
		this.petCategory = petCategory;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getBreadth() {
		return breadth;
	}

	public void setBreath(double breadth) {
		this.breadth = breadth;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	// public List<Bin> getBins() {
	// return bins;
	// }
	// public void setBins(List<Bin> bins) {
	// this.bins = bins;
	// }

}
