package giopollo.progetto.Service;

public class UrlService{
	
	public final static String URL = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/followers/list.json?cursor=-1&screen_name=efrontoni&skip_status=true&include_user_entities=false&location=true&count=1";
	public static String getUrl(String user, String number)
	{
		return "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/followers/list.json?cursor=-1&screen_name=" 
				+user +"&skip_status=true&include_user_entities=false&location=true&count="+number;
	}
}
