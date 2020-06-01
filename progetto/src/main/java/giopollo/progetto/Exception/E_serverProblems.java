package giopollo.progetto.Exception;

public class E_serverProblems extends E_Project {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
	return "Problemi di connessione! Prova più tardi";
	}

}
