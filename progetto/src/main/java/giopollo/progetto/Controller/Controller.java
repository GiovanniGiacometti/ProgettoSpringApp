package giopollo.progetto.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import giopollo.progetto.Exception.E_wordNotFound;
import giopollo.progetto.Service.PrincipalService;
import giopollo.progetto.Service.UrlService;

@RestController
public class Controller {
	@Autowired 
	PrincipalService service;
	
	
	@RequestMapping(value = "/follower/data",  method = RequestMethod.GET)
	public ResponseEntity<Object> getFollower(@RequestParam (name ="user",defaultValue = "efrontoni") String user, 
			@RequestParam (name ="number",defaultValue = "20") String number)
	{
		return new ResponseEntity<>(service.getFollower(UrlService.getUrl(user, number)),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/follower/metadata",  method = RequestMethod.GET)
	public ResponseEntity<Object> getMetadata()
	{
		return new ResponseEntity<>(service.getMetadata(UrlService.URL),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/follower/filter",  method = RequestMethod.GET)
	public ResponseEntity<Object> getDataWithFilter(@RequestParam (name ="user",defaultValue = "efrontoni") String user, @RequestParam (name ="number",defaultValue = "10") String number,@RequestParam(name = "filter",defaultValue = "") String filter)
	{
		return new ResponseEntity<>(service.getFilter(UrlService.getUrl(user, number),filter),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/follower/stats",  method = RequestMethod.GET)
	public ResponseEntity<Object> getStatss(@RequestParam (name ="user",defaultValue = "efrontoni") String user, @RequestParam (name ="number",defaultValue = "10") String number,@RequestParam (name ="stats",defaultValue = "") List<String> stats)
	{
		return new ResponseEntity<>(service.getStats(UrlService.getUrl(user, number) , stats),HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/follower/filter/stats",  method = RequestMethod.GET)
	public ResponseEntity<Object> getStatsWithFilter(@RequestParam (name ="user",defaultValue = "efrontoni") String user, @RequestParam (name ="number",defaultValue = "10") String number,@RequestParam(name = "filter",defaultValue = "") String filter,@RequestParam (name ="stats",defaultValue = "") List<String> stats)
	{
		return new ResponseEntity<>(service.getStats(UrlService.getUrl(user, number), stats, filter),HttpStatus.OK);
	}
	
	
	

	
	@ExceptionHandler(E_wordNotFound.class)
	public String handleException(E_wordNotFound e) {
	    return e.getMessage();
	}
	
	
	
	
	
}