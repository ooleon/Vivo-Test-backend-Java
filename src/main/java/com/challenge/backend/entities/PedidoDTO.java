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

import com.challenge.backend.util.EstadoPedido;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class PedidoDTO {
//	private static final long serialVersionUID = 4442583257355549384L;

	private UUID uuid;
	
	private Long usuarioid;
//	private String estado; //EstadoPedido.PENDIENTE.etiqueta
	private EstadoPedido estado; //EstadoPedido.PENDIENTE.etiqueta

	private List<ProductsPojo> produtos;


	public List<ProductsPojo> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProductsPojo> produtos) {
		this.produtos = produtos;
	}


	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	

	/*
	public PedidoDTO(Long usuarioid, ProductsPojo produtos) {
		super();
		this.usuarioid = usuarioid;
		this.produtos = produtos;
	}

	public Long getUsuarioid() {
		return usuarioid;
	}

	public void setUsuarioid(Long usuarioid) {
		this.usuarioid = usuarioid;
	}

	public ProductsPojo getProdutos() {
		return produtos;
	}

	public void setProdutos(ProductsPojo produtos) {
		this.produtos = produtos;
	}
	*/





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

	public Long getUsuarioid() {
		return usuarioid;
	}

	public void setUsuarioid(Long usuarioid) {
		this.usuarioid = usuarioid;
	}

	public PedidoDTO(Long usuarioid, List<ProductsPojo> listProdutoId) {
		super();
		this.usuarioid = usuarioid;
		this.produtos = listProdutoId;
	}

	public EstadoPedido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}

	/*
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	*/




	
}
