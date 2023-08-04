package com.challenge.backend.util;

public enum EstadoPedido {
	PENDIENTE("PENDIENTE"),
	CONCLUIDO("CONCLUIDO");
	
	
    public final String etiqueta;

    private EstadoPedido(String etiqueta) {    	
        this.etiqueta =  etiqueta.toUpperCase();
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return super.toString();
    }

}
