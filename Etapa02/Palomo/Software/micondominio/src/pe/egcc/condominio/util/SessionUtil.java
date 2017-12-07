package pe.egcc.condominio.util;

import javax.servlet.http.HttpSession;

public class SessionUtil {
	public SessionUtil() {
	}
	
	 public static void set(HttpSession session, 
		      String key, Object value){
		    session.setAttribute(key, value);
	}
		  
    public static Object get(HttpSession session, String key){
		   return session.getAttribute(key);        
    }
}
