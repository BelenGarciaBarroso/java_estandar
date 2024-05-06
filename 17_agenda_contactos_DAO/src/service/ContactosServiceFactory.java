package service;

public class ContactosServiceFactory {
	public ContactosService getContactosService() {
		return new ContactosServiceImpl();
	}

}
