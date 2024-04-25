package model;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Empleado {
	//@SerializedName(value="nombre")-> se pone delante de cada campo cuando no vaya a coincidir con el nombre del fichero.
	// por ejemplo, si al campo nombre le hubieramos llamado empleado.
	private String nombre;
	private String email;
	private double salario;
	private String departamento;
	

}
