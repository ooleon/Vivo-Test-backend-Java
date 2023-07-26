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
	public UUID uuid;

	public BigInteger usuarioid;
	public String estado;

/*	
	@OneToMany     
//	@ToStringExclude
	@JsonIgnore     
	@JoinTable(name = "Attache_Client_Association",            
	joinColumns = @JoinColumn(name = "id"),          
	inverseJoinColumns = @JoinColumn(name = "pedidoid_fk"))    
	public List<Pedido> clientList;
*/
	
	@OneToMany(mappedBy = "pedido")
	private List<DetalhePedido> detalles;

	
	
	public UUID getUUID() {
		return this.uuid;
	}

	public void setUUID(UUID uUID) {
		this.uuid = uUID;
	}

	public BigInteger getUsuarioid() {
		return usuarioid;
	}

	public void setUsuarioid(BigInteger usuarioid) {
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
		StringBuilder builder = new StringBuilder();
		builder.append("Pedido [uuid=");
		builder.append(uuid);
		builder.append(", usuarioid=");
		builder.append(usuarioid);
		builder.append(", estado=");
		builder.append(estado);
		builder.append(", detalles=");
		builder.append(detalles.size());
		builder.append("]");
		return builder.toString();
	}



	
	
	
	
	
	
	
	
}
