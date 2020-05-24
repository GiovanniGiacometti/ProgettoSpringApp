package giopollo.progetto.Exception;

public class E_wordNotFound  extends Exception {

	private static final long serialVersionUID = 1L;
	
	public String message = null;

	public E_wordNotFound(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage()
	{
		return this.message;
	}

}
