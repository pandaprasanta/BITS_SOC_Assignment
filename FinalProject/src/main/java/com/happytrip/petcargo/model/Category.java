package com.happytrip.petcargo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="CATEGORIES")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
    private int categoryId;
	@Column(name="CATEGORY_SIZE")
	private String categorySize;
	@OneToMany
	private List<Bin> bin=new ArrayList<Bin>();
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategorySize() {
		return categorySize;
	}
	public void setCategorySize(String categorySize) {
		this.categorySize = categorySize;
	}
	public List<Bin> getBin() {
		return bin;
	}
	public void setBin(List<Bin> bin) {
		this.bin = bin;
	}
	
     
     
}
