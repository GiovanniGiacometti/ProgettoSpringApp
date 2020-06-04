package giopollo.progetto.Exception;

public class E_IncorrectFilterMethod extends E_Project {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Il body del filtro non è valido! Ricontrolla!";
	}

}
