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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;


@Entity
@Table(name = "pedido_detalhe", schema = "public")
public class DetalhePedido {

	@Id
//  @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    public Long getId() { return id; }
    

	

    @ManyToOne ( fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
    @JsonIgnore
    public Pedido pedido;
    
    
    private int produtoid;
    
    private int quantidade;
    
    private double precounidade;

/*
    private UUID pedido_id;

	public UUID getPedido_id() {
		return pedido_id;
	}
	public void setPedido_id(UUID pedido_id) {
		this.pedido_id = pedido_id;
	}
*/


	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public int getProdutoid() {
		return produtoid;
	}
	public void setProdutoid(int produtoid) {
		this.produtoid = produtoid;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getPrecounidade() {
		return precounidade;
	}
	public void setPrecounidade(double precounidade) {
		this.precounidade = precounidade;
	}

	@Override
	public String toString() {
	/*
		return "{" + 
				"produtoid=" + produtoid + 				
				", quantidade=" + quantidade +
				", precounidade=" + precounidade +
				"}";
		*/
		return asJsonString(this);
	}

	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}


	




	

}
