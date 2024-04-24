package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

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
	
	public double media() {
		try {
			return 	Files.lines(pt)//Stream<String>
				.collect(Collectors.averagingDouble(n->Double.parseDouble(n)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return (0);
		}
			
	}
	
	public double max() {
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
			return (0);
		}
		
	}
	
	public double min() {
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
			return (0);
		}
	}
	
	public ArrayList<Double> obtenerNotas() {
		ArrayList<Double> aux=new ArrayList<Double>();
		String linea;
		try(FileReader fr=new FileReader(fichero);
				BufferedReader bf=new BufferedReader(fr);){
			//mientras haya una nota que leer
			while((linea=bf.readLine())!=null) {
				
				aux.add(Double.parseDouble(linea));
			}
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		return aux;
	}
}
