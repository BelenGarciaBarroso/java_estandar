package service;

import model.Alumno;

public interface AlumnosService {

	boolean guardarAlumno(Alumno alumno);
	
	static AlumnosService of() {
		return new AlumnosServiceImpl();
		
	}

}