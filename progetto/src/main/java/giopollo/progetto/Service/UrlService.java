package giopollo.progetto.Service;

public class UrlService implements Service{

	public static String getUrl(String user, String number)
	{
		return "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/followers/list.json?cursor=-1&screen_name=" 
				+user +"&skip_status=true&include_user_entities=false&location=true&count="+number;
	}
}
