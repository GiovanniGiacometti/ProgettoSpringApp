package giopollo.progetto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import giopollo.progetto.Model.Request;
import giopollo.progetto.Service.Service;

@RestController
public class Controller {
	@Autowired 
	Service service;
	
	@RequestMapping(value = "/follower",  method = RequestMethod.GET)
	public ResponseEntity<Object> get_a_Number_of_Follower_of_a_User(@RequestParam (name ="user",defaultValue = "efrontoni") String user, 
			@RequestParam (name ="number",defaultValue = "10") String number)
	{
		return new ResponseEntity<>(service.getFollower("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/followers/list.json?cursor=-1&screen_name=" 
				+user +"&skip_status=true&include_user_entities=false&location=true&count="+number),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/follower/occurrences",  method = RequestMethod.GET)
	public ResponseEntity<Object> getOccurrences(@RequestParam (name ="user",defaultValue = "efrontoni") String user, @RequestParam (name ="number",defaultValue = "10") String number)
	{
		
			return new ResponseEntity<> (service.getOcc("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/followers/list.json?cursor=-1&screen_name=" 
					+user +"&skip_status=true&include_user_entities=false&location=true&count="+number),HttpStatus.OK);
				
	}

	@RequestMapping(value = "/follower",  method = RequestMethod.POST)
	public ResponseEntity<Object> get_Number_of_User_with_a_Word_in_Location(@RequestBody Request req)
	{
		return new ResponseEntity<>(service.getWord("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/followers/list.json?cursor=-1&screen_name="
							+ req.getUser() +"&skip_status=true&include_user_entities=false&location=true&count="+req.getNumber(),req.getWord()),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/follower/metadata",  method = RequestMethod.GET)
	public ResponseEntity<Object> getInteradata()
	{
		return new ResponseEntity<>(service.getMetadata("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com"
				+ "/dev/user/1.1/followers/list.json?cursor=-1&screen_name=efrontoni&skip_status=true&include_user_entities=false&location=true&count=1"),HttpStatus.OK);
	}
	
	
	
	
	
	
	
}