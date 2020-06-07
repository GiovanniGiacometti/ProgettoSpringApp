package giopollo.progetto.Controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import giopollo.progetto.Exception.E_Project;
import giopollo.progetto.Service.PrincipalService;
import giopollo.progetto.Service.UrlService;

/**
 * Controller Spring per gestire le richieste dell'utente
 * @author Giovanni Giacometti
 * @author Lorenzo Pollonara
 */
@RestController
public class Controller {
	
	/** l'annotazione @Autowired lancia automaticamente il costruttore all'avvio di Spring */
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
	 * @return List di stringhe
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
	 * Metodo per gestire eccezione 
	 *
	 * @param e
	 * @return String
	 */
	@ExceptionHandler(NoSuchMethodException.class)
	public String handleException1(NoSuchMethodException e) {
	    return "Non trovato! Controlla di aver scritto bene!";
	}
	
	/**
	 * Handle exception 2.
	 *
	 * @param e the e
	 * @return the string
	 */
	@ExceptionHandler(InvocationTargetException.class)
	public String handleException2(InvocationTargetException e) {
	    return e.getCause().getMessage();
	}
	
	/**
	 * Metodo per gestire eccezione se viene immesso un filtro errato
	 *
	 * @param e
	 * @return String
	 */
	@ExceptionHandler(ClassNotFoundException.class)
	public String handleException3(ClassNotFoundException e) {
	    return "Non esiste questo filtro!";
	}
	
	
	/**
	 * Handle exception 4.
	 *
	 * @param e the e
	 * @return the string
	 */
	@ExceptionHandler(E_Project.class)
	public String handleException4(E_Project e) {
	    return e.getMessage();
	}

	
	
}