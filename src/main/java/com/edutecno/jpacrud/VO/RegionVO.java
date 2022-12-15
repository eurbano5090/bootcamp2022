package com.edutecno.jpacrud.VO;

import java.util.List;

import com.edutecno.jpacrud.modelo.Region;


public class RegionVO extends GenericVO{

	public List<Region> regiones;

	public RegionVO(List<Region> regiones,String mensaje, String codigo) {
		super(mensaje, codigo);
		this.regiones = regiones;
	}

	public RegionVO(List<Region> regiones) {
		super();
		this.regiones = regiones;
	}

	public List<Region> getRegiones() {
		return regiones;
	}

	public void setRegiones(List<Region> regiones) {
		this.regiones = regiones;
	}

	@Override
	public String toString() {
		return "RegionVO [regiones=" + regiones + "]";
	}

	

	
		
}


