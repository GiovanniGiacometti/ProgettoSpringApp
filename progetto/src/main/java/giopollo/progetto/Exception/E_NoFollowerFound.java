package giopollo.progetto.Exception;

public class E_NoFollowerFound extends E_Project {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Nessun follower trovato!";
	}

}
