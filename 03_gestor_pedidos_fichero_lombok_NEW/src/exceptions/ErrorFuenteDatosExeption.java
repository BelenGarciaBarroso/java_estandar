package exceptions;

public class ErrorFuenteDatosExeption extends Exception {

	@Override
	public String getMessage() {
		return "No se ha podido acceder al fichero de notas";
	}

}
