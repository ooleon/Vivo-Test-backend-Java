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
import java.util.*;

@Entity
@Table(name = "pedido_produtos", schema = "public")
public class PedidoProdutos {
	
	@Id
//    @GeneratedValue(strategy=SEQUENCE, generator="pedido_artigo_id_seq")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    public Long getId() { return id; }
    
    
    private String pedidoid_fk;
    //private UUID pedidoid_fk;
    private int produtoid;
    private double quantidade;
    private double precounidade;

	public String getPedidoid_fk() {
		return pedidoid_fk;
	}
	public void setPedidoid_fk(String pedidoid_fk) {
		this.pedidoid_fk = pedidoid_fk;
	}
	public int getProdutoid() {
		return produtoid;
	}
	public void setProdutoid(int produtoid) {
		this.produtoid = produtoid;
	}
	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(double quantidade) {
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
		StringBuilder builder = new StringBuilder();
		builder.append("PedidoProdutos [pedidoid_fk=");
		builder.append(pedidoid_fk);
		builder.append(", produtoid=");
		builder.append(produtoid);
		builder.append(", quantidade=");
		builder.append(quantidade);
		builder.append(", precounidade=");
		builder.append(precounidade);
		builder.append("]");
		return builder.toString();
	}


	

}
