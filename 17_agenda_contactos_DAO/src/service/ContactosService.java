package service;

import java.util.List;

import model.Contacto;

public interface ContactosService {

	// AGREGAR CONTACTO No se admiten contactos con email duplicado ***********************************************************
	boolean nuevoContacto(Contacto contacto);

	//devuelve el contacto eliminado. Si no se ha eliminado ninguno, devuelve null**********************************	
	Contacto eliminarContacto(String email);

	// Actualizar contacto
	boolean actualizarContacto(String email, int nuevaEdad);

	//Buscar un contacto dando su id
	Contacto buscarContactoPorId(int id);

	List<Contacto> getContactos();


}