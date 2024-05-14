package dao;

import model.Cliente;

public interface ClientesDao {
	Cliente findByCliente (String usuario);
	void saveCliente(Cliente cliente);
	

}
