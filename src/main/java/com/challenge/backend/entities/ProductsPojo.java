package com.challenge.backend.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.criteria.CriteriaBuilder.In;

public class ProductsPojo {

	private Integer id;
	private Double preco;

	
	public ProductsPojo() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public ProductsPojo(Integer id, Double price) {
		super();
		this.id = id;
		this.preco = price;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double price) {
		this.preco = price;
	}

	@Override
	public String toString() {
		return asJsonString(this);
	}

	private static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
