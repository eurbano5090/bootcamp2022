package com.edutecno.jpacrud.modelo;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table
public class Curso {
	
	@Id
	private String codigo_curso;
	
	private Date fecha_inicio;
	
	@Column
	private Date fecha_termno;
	
	@ManyToOne
	@JoinColumn(name = "codigo_comuna", referencedColumnName = "codigo_comuna")
	private Comuna codigo_comuna;
	
	@ManyToOne
	@JoinColumn (name= "codigo_plan_formativo", referencedColumnName = "codigo_plan_formativo")
	private Plan_formativo codigo_plan_formativo;

	public String getCodigo_curso() {
		return codigo_curso;
	}

	public void setCodigo_curso(String codigo_curso) {
		this.codigo_curso = codigo_curso;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_termno() {
		return fecha_termno;
	}

	public void setFecha_termno(Date fecha_termno) {
		this.fecha_termno = fecha_termno;
	}

	public Comuna getCodigo_comuna() {
		return codigo_comuna;
	}

	public void setCodigo_comuna(Comuna codigo_comuna) {
		this.codigo_comuna = codigo_comuna;
	}

	public Plan_formativo getCodigo_plan_formativo() {
		return codigo_plan_formativo;
	}

	public void setCodigo_plan_formativo(Plan_formativo codigo_plan_formativo) {
		this.codigo_plan_formativo = codigo_plan_formativo;
	}

	public Curso() {
		super();
	}

	public Curso(String codigo_curso, Date fecha_inicio, Date fecha_termno, Comuna codigo_comuna,
			Plan_formativo codigo_plan_formativo) {
		super();
		this.codigo_curso = codigo_curso;
		this.fecha_inicio = fecha_inicio;
		this.fecha_termno = fecha_termno;
		this.codigo_comuna = codigo_comuna;
		this.codigo_plan_formativo = codigo_plan_formativo;
	}

	@Override
	public String toString() {
		return "Curso [codigo_curso=" + codigo_curso + ", fecha_inicio=" + fecha_inicio + ", fecha_termno="
				+ fecha_termno + ", codigo_comuna=" + codigo_comuna + ", codigo_plan_formativo=" + codigo_plan_formativo
				+ "]";
	}
	
	
	
}
