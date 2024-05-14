package service;

import dao.ClientesDao;
import dao.ClientesDaoFactory;
import model.Cliente;

public class ClientesServiceImpl implements ClientesService {
	
	ClientesDao clientesDao;
	
	public ClientesServiceImpl() {
		clientesDao=ClientesDaoFactory.getClientesDao();
		
	}

	@Override
	public boolean autenticar(String usuario, String password) {
		Cliente cliente= clientesDao.findByCliente(usuario);
		return cliente!=null&&cliente.getPassword().equals(password);
	}
	
	@Override
	public boolean registrar (Cliente cliente) {
		if (clientesDao.findByCliente(cliente.getUsuario())!=null) {
			return false;
		}
		clientesDao.saveCliente(cliente);
		return true;
	}

}
