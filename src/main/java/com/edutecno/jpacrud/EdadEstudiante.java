package com.edutecno.jpacrud;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class EdadEstudiante {

	public static void main(String[] args) {
		
		Calendar fechahoy= Calendar.getInstance();
		Calendar fechanacimiento = Calendar.getInstance();
		
		fechanacimiento.set(1976, 3, 1);
		
		Date fecha=fechanacimiento.getTime();
		long diferenciamilisegundos=Math.abs(fechahoy.getTimeInMillis()-fecha.getTime());
		
		long horas=TimeUnit.MILLISECONDS.toDays(diferenciamilisegundos);
		System.out.println("la diferencia en dias es "+ (horas/365)+ "años");
	}

}
