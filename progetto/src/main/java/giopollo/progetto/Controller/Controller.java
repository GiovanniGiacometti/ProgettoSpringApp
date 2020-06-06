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

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
@RestController
public class Controller {
	
	/** The service. */
	@Autowired 
	PrincipalService service;
	
	
	/**
	 * Gets the follower.
	 *
	 * @param user the user
	 * @param number the number
	 * @return the follower
	 */
	@RequestMapping(value = "/follower/data",  method = RequestMethod.GET)
	public ResponseEntity<Object> getFollower(@RequestParam (name ="user",defaultValue = "efrontoni") String user, 
			@RequestParam (name ="number",defaultValue = "20") String number)
	{
		return new ResponseEntity<>(service.getFollower(UrlService.getUrl(user, number)),HttpStatus.OK);
	}
	
	
	/**
	 * Gets the metadata.
	 *
	 * @return the metadata
	 */
	@RequestMapping(value = "/follower/metadata",  method = RequestMethod.GET)
	public ResponseEntity<Object> getMetadata()
	{
		return new ResponseEntity<>(service.getMetadata(),HttpStatus.OK);
	}
	
	
	/**
	 * Gets the data with filter.
	 *
	 * @param user the user
	 * @param number the number
	 * @param filter the filter
	 * @return the data with filter
	 * @throws NoSuchMethodException the no such method exception
	 * @throws InvocationTargetException the invocation target exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	@RequestMapping(value = "/follower/filter",  method = RequestMethod.POST)
	public ResponseEntity<Object> getDataWithFilter(@RequestParam (name ="user",defaultValue = "efrontoni") String user, @RequestParam (name ="number",defaultValue = "10") String number,@RequestBody String filter) throws NoSuchMethodException, InvocationTargetException, ClassNotFoundException
	{
		return new ResponseEntity<>(service.getFilter(UrlService.getUrl(user, number),filter) , HttpStatus.OK);
	}
	
	
	/**
	 * Gets the stats.
	 *
	 * @param user the user
	 * @param number the number
	 * @param stats the stats
	 * @return the stats
	 * @throws NoSuchMethodException the no such method exception
	 * @throws InvocationTargetException the invocation target exception
	 */
	@RequestMapping(value = "/follower/stats",  method = RequestMethod.GET)
	public ResponseEntity<Object> getStats(@RequestParam (name ="user",defaultValue = "efrontoni") String user, @RequestParam (name ="number",defaultValue = "10") String number,@RequestParam (name ="stats",defaultValue = "") List<String> stats) throws NoSuchMethodException, InvocationTargetException
	{
		return new ResponseEntity<>(service.getStats(UrlService.getUrl(user, number) , stats) , HttpStatus.OK);
	}
	
	
	/**
	 * Gets the stats with filter.
	 *
	 * @param user the user
	 * @param number the number
	 * @param filter the filter
	 * @param stats the stats
	 * @return the stats with filter
	 * @throws NoSuchMethodException the no such method exception
	 * @throws InvocationTargetException the invocation target exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	@RequestMapping(value = "/follower/filter/stats",  method = RequestMethod.POST)
	public ResponseEntity<Object> getStatsWithFilter(@RequestParam (name ="user",defaultValue = "efrontoni") String user, @RequestParam (name ="number",defaultValue = "10") String number,@RequestBody String filter,@RequestParam (name ="stats",defaultValue = "") List<String> stats) throws NoSuchMethodException, InvocationTargetException, ClassNotFoundException
	{
		return new ResponseEntity<>(service.getStats(UrlService.getUrl(user, number), stats, filter) , HttpStatus.OK);
	}
	
	
	/**
	 * Handle exception 1.
	 *
	 * @param e the e
	 * @return the string
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
	 * Handle exception 3.
	 *
	 * @param e the e
	 * @return the string
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