package giopollo.progetto.Exception;

import java.util.Calendar;

import org.springframework.http.HttpStatus;

/**
 * Modello degli errori dovuti ad eccezioni 
 * 
 * @author Giovanni Giacometti
 * @author Lorenzo Pollonara
 */
public class ExceptionError {
	
	private Calendar date;
	private HttpStatus httpStatus;
	private String exception;
	private String message;
	
	/**
	 * Costruttore di ExceptionError con parametri
	 *
	 * @param date orario della richiesta
	 * @param httpStatus 
	 * @param exception l'eccezione generata
	 * @param message messaggio dell'eccezione
	 */
	public ExceptionError(Calendar date, HttpStatus httpStatus, String exception, String message) {
		super();
		this.date=date;
		this.httpStatus = httpStatus;
		this.exception = exception;
		this.message = message;
	}
	

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public Calendar getDate() {
		return date;
	}


	public void setC(Calendar date) {
		this.date = date;
	}


	public String getException() {
		return exception;
	}


	public void setException(String exception) {
		this.exception = exception;
	}



	
	
}
