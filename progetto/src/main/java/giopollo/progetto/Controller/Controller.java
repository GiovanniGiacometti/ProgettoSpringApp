package giopollo.progetto.Controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import giopollo.progetto.Exception.E_Project;
import giopollo.progetto.Exception.ExceptionError;
import giopollo.progetto.Service.PrincipalService;
import giopollo.progetto.Service.UrlService;

/**
 * Controller Spring per gestire le richieste dell'utente
 * @author Giovanni Giacometti
 * @author Lorenzo Pollonara
 */
@RestController
public class Controller {
	
	/** 
	 * l'annotazione @Autowired lancia automaticamente il costruttore all'avvio di Spring 
	 */
	@Autowired 
	PrincipalService service;
	
	
	/**
	 * Metodo per gestire la richiesta GET alla rotta "/follower/data", restituendo l'intero dataset
	 *
	 * @param user username dell'utente
	 * @param number numero di follower che si vogliono visionare
	 * @return List di oggetti Follower 
	 */
	@RequestMapping(value = "/follower/data",  method = RequestMethod.GET)
	public ResponseEntity<Object> getFollower(@RequestParam (name ="user",defaultValue = "efrontoni") String user, 
			@RequestParam (name ="number",defaultValue = "20") String number)
	{
		return new ResponseEntity<>(service.getFollower(UrlService.getUrl(user, number)),HttpStatus.OK);
	}
	
	
	/**
	 * Metodo per gestire la richiesta GET alla rotta "/follower/metadata", restituendo tutti i metadati
	 *
	 * @return HashMap<String,String>
	 */
	@RequestMapping(value = "/follower/metadata",  method = RequestMethod.GET)
	public ResponseEntity<Object> getMetadata()
	{
		return new ResponseEntity<>(service.getMetadata(),HttpStatus.OK);
	}
	
	
	/**
	 * Metodo per gestire la richiesta GET alla rotta "/follower/filter", restituendo la lista di follower filtrata
	 *
	 * @param user username dell'utente
	 * @param number numero di follower che si vogliono visionare
	 * @param filter filtro 
	 * @return List di oggetti Follower
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws ClassNotFoundException
	 */
	@RequestMapping(value = "/follower/filter",  method = RequestMethod.POST)
	public ResponseEntity<Object> getDataWithFilter(@RequestParam (name ="user",defaultValue = "efrontoni") String user, @RequestParam (name ="number",defaultValue = "10") String number,@RequestBody String filter) throws NoSuchMethodException, InvocationTargetException, ClassNotFoundException
	{
		return new ResponseEntity<>(service.getFilter(UrlService.getUrl(user, number),filter) , HttpStatus.OK);
	}
	
	
	/**
	 * Metodo per gestire la richiesta GET alla rotta "/follower/stats", restituendo la lista di statistiche
	 *
	 * @param user username dell'utente
	 * @param number numero di follower che si vogliono visionare
	 * @param stats statistiche che si vogliono visionare
	 * @return HashMap di stringhe e numeri
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 */
	@RequestMapping(value = "/follower/stats",  method = RequestMethod.GET)
	public ResponseEntity<Object> getStats(@RequestParam (name ="user",defaultValue = "efrontoni") String user, @RequestParam (name ="number",defaultValue = "10") String number,@RequestParam (name ="stats",defaultValue = "") List<String> stats) throws NoSuchMethodException, InvocationTargetException
	{
		return new ResponseEntity<>(service.getStats(UrlService.getUrl(user, number) , stats) , HttpStatus.OK);
	}
	
	
	/**
	 * Metodo per gestire la richiesta GET alla rotta "/filter/stats", restituendo la lista di statistiche applicando anche i filtri
	 *
	 * @param user username dell'utente
	 * @param number numero di follower che si vogliono visionare
	 * @param filter filtro 
	 * @param stats statistiche che si vogliono visionare
	 * @return HashMap di stringhe e numeri
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws ClassNotFoundException
	 */
	@RequestMapping(value = "/follower/filter/stats",  method = RequestMethod.POST)
	public ResponseEntity<Object> getStatsWithFilter(@RequestParam (name ="user",defaultValue = "efrontoni") String user, @RequestParam (name ="number",defaultValue = "10") String number,@RequestBody String filter,@RequestParam (name ="stats",defaultValue = "") List<String> stats) throws NoSuchMethodException, InvocationTargetException, ClassNotFoundException
	{
		return new ResponseEntity<>(service.getStats(UrlService.getUrl(user, number), stats, filter) , HttpStatus.OK);
	}
	
	/**
	 * Metodo per gestire eccezione quando il metodo del filtro è errato 
	 *
	 * @param e eccezione da gestire
	 * @return oggetto di tipo ExceptionError
	 */
	@ExceptionHandler(NoSuchMethodException.class)
	public ResponseEntity<Object> handleNoSuchMethodException(NoSuchMethodException e) {
		ExceptionError error = new ExceptionError(Calendar.getInstance() , HttpStatus.BAD_REQUEST , e.getClass().getCanonicalName() ,"Controlla di aver scritto bene!");
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}

	/**
	 * Metodo per gestire eccezione se viene immesso un filtro errato
	 *
	 * @param e eccezione da gestire
	 * @return oggetto di tipo ExceptionError
	 */
	@ExceptionHandler(ClassNotFoundException.class)
	public ResponseEntity<Object> handleClassNotFoundException(ClassNotFoundException e) {
		ExceptionError error = new ExceptionError(Calendar.getInstance() , HttpStatus.BAD_REQUEST , e.getClass().getCanonicalName() , "Filtro non corretto!");
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Metodo per gestire eccezioni lanciate dai metodi dei filtri
	 *
	 * @param e eccezione da gestire
	 * @return oggetto di tipo ExceptionError
	 */
	@ExceptionHandler(InvocationTargetException.class)
	public ResponseEntity<Object> handleInvocationTargetException(InvocationTargetException e) {
		ExceptionError error = new ExceptionError(Calendar.getInstance() , HttpStatus.BAD_REQUEST , e.getCause().getClass().getCanonicalName(), e.getCause().getMessage());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	

	/**
	 * Metodo per gestire le eccezioni personalizzate
	 *
	 * @param e eccezione da gestire
	 * @return oggetto di tipo ExceptionError
	 */
	@ExceptionHandler(E_Project.class)
	public ResponseEntity<Object> handleE_Project(E_Project e) {
		ExceptionError error = new ExceptionError(Calendar.getInstance() , HttpStatus.BAD_REQUEST , e.getClass().getCanonicalName() , e.getMessage());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}

	
	
}