package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import exceptions.ErrorFuenteDatosExeption;

public class NotasService {
	String fichero="notas.txt";
	Path pt=Path.of(fichero);
	
	public void borrarNotas() {
		try {
			Files.deleteIfExists(pt);
		} 
		catch(IOException ex) {
			ex.printStackTrace();
		}	
	}
	
	public void agregarNota(double nota) {
			try {
				
				//Files.writeString(pt, String.valueOf(nota),StandardOpenOption.APPEND,StandardOpenOption.CREATE);
				Files.writeString(pt, nota+System.lineSeparator(),StandardOpenOption.APPEND,StandardOpenOption.CREATE); // Igual que anterior, si a un doble 
				//o int se le añade con + otra cadena se convierte directamente en String
				
			} 
			catch(IOException ex) {
				ex.printStackTrace();
			}	
	}
	
	public double media() throws ErrorFuenteDatosExeption {
		try {
			return 	Files.lines(pt)//Stream<String>
				.collect(Collectors.averagingDouble(n->Double.parseDouble(n)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ErrorFuenteDatosExeption();
		}
			
	}
	
	public double max() throws ErrorFuenteDatosExeption {
		try {
			return
					Files.lines(pt)
					.max(Comparator.comparingDouble((n->Double.parseDouble(n))))
					.map(n->Double.parseDouble(n))
					.orElse(0.0);			
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ErrorFuenteDatosExeption();
		}
		
	}
	
	public double min() throws ErrorFuenteDatosExeption {
		try {
			return
					Files.lines(pt)
					.min(Comparator.comparingDouble((n->Double.parseDouble(n))))
					.map(n->Double.parseDouble(n))
					.orElse(0.0);			
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ErrorFuenteDatosExeption();
		}
	}
	
	public List<Double> obtenerNotas() throws ErrorFuenteDatosExeption {
		try {
			return Files.lines(pt) //Stream<String>
					.map(s->Double.parseDouble(s))//Stream<Double>
					.toList();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ErrorFuenteDatosExeption();
		}
	}
}
