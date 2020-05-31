package giopollo.progetto.Exception;

public class E_Between extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public String getMessage()
	{
		return "Il primo numero è maggiore del secondo!";
	}
}
