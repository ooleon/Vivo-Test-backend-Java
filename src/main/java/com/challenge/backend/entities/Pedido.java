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
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
	private String estado;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "pedido")
	@JsonIgnore
	private List<DetalhePedido> detalles = new ArrayList<>();

	
	
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

	public List<DetalhePedido> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalhePedido> detalles) {
		this.detalles = detalles;
	}

	
	@Override
	public String toString() {
		return "{uuid=" + uuid +
				", usuarioid=" + usuarioid + 
				", estado=" + estado + 
				", detalles=" + detalles +
				"}";
//		return asJsonString(this);
	}

	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}



	
	
	
	
	
	
	
	
}
