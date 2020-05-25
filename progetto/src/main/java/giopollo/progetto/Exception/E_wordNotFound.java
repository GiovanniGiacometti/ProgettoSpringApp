package giopollo.progetto.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class E_wordNotFound  extends ResponseStatusException {

	private static final long serialVersionUID = 1L;
	
	public String message = null;

	public E_wordNotFound(HttpStatus status, String message) {
		super(status);
		this.message = message;
	}
	
	public String getMessage()
	{
		return this.message;
	}

}
