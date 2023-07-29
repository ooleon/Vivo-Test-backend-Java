package com.challenge.backend.entities;
/* Spring Boot 2.7
import javax.persitence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
*/

/* Spring Boot 3.0
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
*/
import jakarta.persistence.*;

import org.antlr.v4.runtime.atn.SemanticContext.AND;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class PedidoDTO {

	private Long usuarioid;
	private Integer produtoid;


	public Long getUsuarioid() {
		return usuarioid;
	}

	public void setUsuarioid(Long usuarioid) {
		this.usuarioid = usuarioid;
	}

	public Integer getProdutoid() {
		return produtoid;
	}

	public void setProdutoid(Integer produtoid) {
		this.produtoid = produtoid;
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
