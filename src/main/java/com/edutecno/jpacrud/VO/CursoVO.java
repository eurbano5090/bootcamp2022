package com.edutecno.jpacrud.VO;

import java.util.List;

import com.edutecno.jpacrud.modelo.Curso;




public class CursoVO extends GenericVO{

	public List<Curso> cursos;

	public CursoVO(List<Curso> cursos,String mensaje, String codigo) {
		super(mensaje, codigo);
		this.cursos = cursos;
	}

	
	public CursoVO() {
		super();
	}


	public CursoVO(List<Curso> cursos) {
		super();
		this.cursos = cursos;
	}


	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}


	@Override
	public String toString() {
		return "CursoVO [cursos=" + cursos + "]";
	}

		

}


