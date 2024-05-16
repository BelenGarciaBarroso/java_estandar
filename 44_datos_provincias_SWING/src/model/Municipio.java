package model;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Municipio {
	@SerializedName("CODIGOINE")
	private String codigo;
	@SerializedName("NOMBRE")
	private String nombreMunicipio;
	@SerializedName("POBLACION_MUNI")
	private String poblacion;
	@SerializedName("ALTITUD")
	private String altitud;
	@SerializedName("SUPERFICIE")
	private double superficie;
}
