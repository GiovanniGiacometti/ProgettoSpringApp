package giopollo.progetto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import giopollo.progetto.Exception.E_wordNotFound;
import giopollo.progetto.Model.Request;
import giopollo.progetto.Service.PrincipalService;
import giopollo.progetto.Service.UrlService;

@RestController
public class Controller {
	@Autowired 
	PrincipalService service;
	
	/*
	@RequestMapping(value = "/follower/data",  method = RequestMethod.GET)
	public ResponseEntity<Object> getFollower(@RequestParam (name ="user",defaultValue = "efrontoni") String user, 
			@RequestParam (name ="number",defaultValue = "20") String number)
	{
		return new ResponseEntity<>(service.getFollower(UrlService.getUrl(user, number)),HttpStatus.OK);
	}*/
	
	@RequestMapping(value = "/follower/metadata",  method = RequestMethod.GET)
	public ResponseEntity<Object> getMetadata()
	{
		return new ResponseEntity<>(service.getMetadata(UrlService.URL),HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/follower/occurrences",  method = RequestMethod.GET)
	public ResponseEntity<Object> getOccurrences(@RequestParam (name ="user",defaultValue = "efrontoni") String user, @RequestParam (name ="number",defaultValue = "10") String number)
	{
		
		return new ResponseEntity<> (service.getOcc(UrlService.getUrl(user, number)),HttpStatus.OK);
				
	}
	
	@RequestMapping(value = "/follower",  method = RequestMethod.GET)
	public ResponseEntity<Object> getFollowerFilter(@RequestParam (name ="user",defaultValue = "efrontoni") String user, @RequestParam (name ="number",defaultValue = "10") String number,@RequestParam(name = "filter",defaultValue = "") String filter)
	{
		return new ResponseEntity<>(service.getFilter(UrlService.getUrl(user, number),filter),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/follower",  method = RequestMethod.POST)
	public ResponseEntity<Object> get_Number_of_User_with_a_Word_in_Location(@RequestBody Request req)
	{
		return new ResponseEntity<>(service.getWord(UrlService.getUrl(req.getUser(), req.getNumber()),req.getWord()),HttpStatus.OK);
	}
	
	
	@ExceptionHandler(E_wordNotFound.class)
	public String handleException(E_wordNotFound e) {
	    return e.getMessage();
	}
	
	
	
	
	
}