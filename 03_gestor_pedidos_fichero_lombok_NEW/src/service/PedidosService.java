package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;

import exceptions.ErrorFuenteDatosExeption;
import model.Pedido;
import utilidades.Util;

public class PedidosService {
	String fichero="pedidos.csv";
	Path pt=Path.of(fichero);

	//*****************************************************************************
	public void borrarPedidos() {
		try {
			Files.deleteIfExists(pt);
		} 
		catch(IOException ex) {
			ex.printStackTrace();
		}	
	}
	
	//*******************************************************************************
	public void nuevoPedido(Pedido pedido) {
		try {
			Files.writeString(pt, pedido.getProducto()+","+pedido.getUnidades()+","+pedido.getFechaPedido()+System.lineSeparator(),StandardOpenOption.APPEND,StandardOpenOption.CREATE);
			//Files.writeString(pt, Util.convertirPedidoACadena(pedido)+System.lineSeparator(),StandardOpenOption.APPEND,StandardOpenOption.CREATE);
		} 
		catch(IOException ex) {
			ex.printStackTrace();
		}	
	}
	
	//**********************************************************************************
	public Pedido pedidoMasReciente(){

		try {
			return Files.lines(pt)//Stream<String>
					.map(n->Util.convertirCadenaAPedido(n)) //Stream <Pedido>
					.max(Comparator.comparing(p->p.getFechaPedido()))
					.orElse(null);
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return (null);
		}	
	}
	
	//**********************************************************************************
	public List<Pedido> pedidosEntreFechas(LocalDate f1, LocalDate f2) {
		try {
			return Files.lines(pt)//Stream<String>
					.map(n->Util.convertirCadenaAPedido(n)) //Stream <Pedido>
					.filter(p->p.getFechaPedido().compareTo(f1)>=0&&p.getFechaPedido().compareTo(f2)<=0)
					.toList();
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return (null);
		}	
	}
	
	//****************************************************************************************
	public Pedido pedidoProximoFecha(LocalDate fecha) throws ErrorFuenteDatosExeption {
		try {
			return Files.lines(pt)//Stream<String>
					.map(n->Util.convertirCadenaAPedido(n)) //Stream <Pedido>
					.min(Comparator.comparingLong(n->Math.abs(ChronoUnit.DAYS.between(n.getFechaPedido(), fecha))))
					.orElse(null);
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}	
	}
		
	//********************************************************************************************
	public void eliminarPedido(String producto) {
		try {
			List<String> pedidos= Files.lines(pt)
					.map(Util::convertirCadenaAPedido)//Stream<Pedido>
					.filter(p->!p.getProducto().equals(producto))//Stream<Pedido>
					.map(n->Util.convertirPedidoACadena(n)+System.lineSeparator())//Stream<String>
					.toList();
			Files.write(pt, pedidos);

		}
		catch(IOException ex) {
			ex.printStackTrace();
		}	
	}
	
	//**********************************************************************************************
	public List<Pedido> listaPedidos() {
		try {
			return Files.lines(pt)//Stream<String>
				.map(n->Util.convertirCadenaAPedido(n)) //Stream <Pedido>
				.toList();
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return (null);
		}	
	
	}
}
