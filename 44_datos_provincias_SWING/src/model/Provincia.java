package model;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Tenemos que sobreescribir el método toString para que solo nos muestre el nombre de la pronvincia
// Hay que quitar el @Data e incluir @getter y @Setter
// Sobreescribir el mètodo, botón derecho, soruce, override, tostring.
@NoArgsConstructor
@AllArgsConstructor
//@Data
@Setter
@Getter
public class Provincia {
	@SerializedName("CODPROV")
	private String codigoProvincia;
	@SerializedName("NOMBRE_PROVINCIA")
	private String nombreProvincia;
	@SerializedName("COMUNIDAD_CIUDAD_AUTONOMA")
	private String comunidadAutonoma;
	@Override
	
	public String toString() {
		// TODO Auto-generated method stub
		return nombreProvincia;
	}
	
	
}
