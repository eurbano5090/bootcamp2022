package com.edutecno.jpacrud.VO;

public class NumberVO extends GenericVO{

	long valor;

	public NumberVO(long valor) {
		super();
		this.valor = valor;
	}

	public NumberVO() {
		super();
	}

	public long getValor() {
		return valor;
	}

	public void setValor(long valor) {
		this.valor = valor;
	}

	public NumberVO(long valor,String mensaje, String codigo) {
		super(mensaje, codigo);
		this.valor=valor;
	}
	
	
}
