package com.happytrip.petcargo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BINS")
public class Bin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int binId;

	@Column(name = "BIN_NAME")
	private String binName;

	@Column(name = "SIZE")
	private String binSize;

	@Column(name = "QUANTITY")
	private int quantity;
	
	@Column(name="PRICE")
	private float price;

	@ManyToOne
	@JoinColumn(name="CATEGORY_ID")
	private Category category;

	public int getBinId() {
		return binId;
	}

	public void setBinId(int binId) {
		this.binId = binId;
	}

	public String getBinName() {
		return binName;
	}

	public void setBinName(String binName) {
		this.binName = binName;
	}

	public String getBinSize() {
		return binSize;
	}

	public void setBinSize(String binSize) {
		this.binSize = binSize;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
}
