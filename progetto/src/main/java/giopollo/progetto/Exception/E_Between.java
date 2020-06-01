package giopollo.progetto.Exception;

public class E_Between extends E_Project{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage()
	{
		return "Il primo numero è maggiore del secondo!";
	}
}
