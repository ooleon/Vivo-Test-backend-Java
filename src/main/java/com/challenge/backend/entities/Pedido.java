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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "pedido", schema = "public")
public class Pedido {

	@Id
//    @GeneratedValue(generator="system-uuid")
//    @GenericGenerator(name="system-uuid", strategy = "uuid")

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true)
	@UuidGenerator
	private UUID uuid;

	private Long usuarioid;
	private String estado = EstadoPedido.PENDIENTE.etiqueta;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "pedido_id")
//	@JsonIgnore
	private List<DetalhePedido> detalhes = new ArrayList<>();

	@Transient
	private Double precoTotal = 0.0;

	@PostLoad
	private void onLoad() {
		if (this.detalhes != null && this.detalhes.size() > 0) {
			precoTotal = this.detalhes.stream().map(x -> x.getValorParcial())
					.collect(Collectors.summingDouble(Double::doubleValue));
		}
	}

	public Double getPrecoTotal() {
		this.onLoad();
		return precoTotal;
	}

	public UUID getUUID() {
		return this.uuid;
	}

	public Long getUsuarioid() {
		return usuarioid;
	}

	public void setUsuarioid(Long usuarioid) {
		this.usuarioid = usuarioid;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<DetalhePedido> getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(List<DetalhePedido> detalhes) {
		this.detalhes = detalhes;
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
