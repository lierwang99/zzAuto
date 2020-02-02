/**
 * 
 */
package test.email;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import project.AncestorImpl;


/**
 * @author Administrator
 *
 */
public class CookieEmail {
//	public static Logger log = Logger.getLogger(SetCookies.class);

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
//		Class c = project.AncestorImpl.class;
		Class<?> c = null;
		try {
			c = Class.forName("project.AncestorImpl");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		Field[] fields = c.getFields();
		Method[] methods = c.getMethods();
	
		for(Field f:fields){
			System.out.println(f.getName());
		}
		
		for(Method m:methods){
			System.out.println(m.getName());
		}
		project.AncestorImpl anc;
		try {
			anc = (AncestorImpl) c.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			
			e.printStackTrace();
		}
	
		
	}


}
