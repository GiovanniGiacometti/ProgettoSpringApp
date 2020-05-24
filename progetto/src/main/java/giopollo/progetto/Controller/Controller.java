package giopollo.progetto.Controller;

import java.util.HashMap;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import giopollo.progetto.Model.Follower;
import giopollo.progetto.Model.Request;
import giopollo.progetto.Service.Service;

@RestController
public class Controller {
	
	@RequestMapping(value = "/follower",  method = RequestMethod.GET)
	public List<Follower> get_a_Number_of_Follower_of_a_User(@RequestParam (name ="user",defaultValue = "efrontoni") String user, 
			@RequestParam (name ="number",defaultValue = "10") String number)
	{
		return Service.getFollower("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/followers/list.json?cursor=-1&screen_name=" 
				+user +"&skip_status=true&include_user_entities=false&location=true&count="+number);
	}
	
	@RequestMapping(value = "/follower/occurrences",  method = RequestMethod.GET)
	public HashMap<String,Integer> getOccurrences(@RequestParam (name ="user",defaultValue = "efrontoni") String user, @RequestParam (name ="number",defaultValue = "10") String number)
	{
		return Service.getOcc("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/followers/list.json?cursor=-1&screen_name=" 
				+user +"&skip_status=true&include_user_entities=false&location=true&count="+number);
	}

	@RequestMapping(value = "/follower",  method = RequestMethod.POST)
	public List<String> get_Number_of_User_with_a_Word_in_Location(@RequestBody Request req)
	{
		return Service.getWord("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/followers/list.json?cursor=-1&screen_name="
							+ req.getName() +"&skip_status=true&include_user_entities=false&location=true&count="+req.getNumber(),req.getWord());
	}
	
	
	
	
	
	
	
	
	
}