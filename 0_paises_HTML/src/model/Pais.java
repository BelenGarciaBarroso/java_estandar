package model;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Pais {
	@SerializedName(value="name")
	private String nombre;
	@SerializedName(value="region")
	private String continente;
	private String capital;
	@SerializedName(value="population")
	private int habitantes;
	
}
