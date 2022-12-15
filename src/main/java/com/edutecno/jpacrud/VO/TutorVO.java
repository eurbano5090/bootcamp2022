package com.edutecno.jpacrud.VO;

import java.util.List;

import com.edutecno.jpacrud.modelo.Tutor;

public class TutorVO extends GenericVO{

public List<Tutor> tutores;

	
	public TutorVO(List<Tutor> tutores) {
		super();
		this.tutores = tutores;
	}
	
	
	public TutorVO(List<Tutor> tutores,String mensaje,String codigo) {
		super(mensaje, codigo);
		this.tutores = tutores;
	}

	public List<Tutor> getTutores() {
		return tutores;
	}

	public void setTutores(List<Tutor> tutores) {
		this.tutores = tutores;
	}

	@Override
	public String toString() {
		return "TutorVO [tutores=" + tutores + "]";
	}
	
	
}


