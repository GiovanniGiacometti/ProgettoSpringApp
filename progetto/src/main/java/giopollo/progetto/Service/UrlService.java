package giopollo.progetto.Service;

/**
 * Classe che gestisce l'url
 * @author Giovanni Giacometti
 * @author Lorenzo Pollonara
 */

public class UrlService{
	
	/** The Constant URL. */
	public final static String URL = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/followers/list.json?cursor=-1&screen_name=efrontoni&skip_status=true&include_user_entities=false&location=true&count=1";
	
	/**
	 * Completare l'url con il nome dell'account e il numero di follower da analizzare.
	 *
	 * @param user username dell'utente
	 * @param number numero di follower che si vogliono visionare
	 * @return String
	 */
	public static String getUrl(String user, String number)
	{
		return "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/followers/list.json?cursor=-1&screen_name=" 
				+user +"&skip_status=true&include_user_entities=false&location=true&count="+number;
	}
}
