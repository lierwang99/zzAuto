/**
 * 
 */
package test.baidu;

import java.lang.reflect.Field;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Administrator
 *
 */
public class Reflect {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws Exception {
//		Class<?> cla = Class.forName("project.baidu.HomePage");
//		Object obj = cla.newInstance(); System.out.println(obj);
//		Field[] fields = cla.getDeclaredFields();
//
//		
//		Field declaredField = cla.getDeclaredField("name");
//		declaredField.setAccessible(true);// 允许输出受保护的属性了
//		Object object = declaredField.get(obj);
//		System.out.println("declaredField: "+declaredField);
//		System.out.println("object: "+object);
		
		
		/*
//		 * 调用有参构造方法
		 * Constructor<?> con = cla.getConstructor(WebDriver.class);
		 * System.setProperty("webdriver.chrome.driver", ".\\tools\\chromedriver.exe");
		 * WebDriver driver = new ChromeDriver(); Object newInstance =
		 * con.newInstance(driver); project.baidu.HomePage home =
		 * (project.baidu.HomePage)newInstance; home.pr();
		 */
		
		/*
//		 * 调用无参构造
		 *  Object obj = cla.newInstance(); System.out.println(obj);
		 * project.baidu.HomePage home = (project.baidu.HomePage)obj; home.pr();
		 */
		
		System.setProperty("webdriver.chrome.driver", ".\\tools\\chromedriver.exe");
		WebDriver  driver  = new ChromeDriver();
		
		int width = (int) ((JavascriptExecutor) driver).executeScript("return +"
				+ "Math.max(document.body.scrollWidth,+"
				+ "document.ssbody.offsetWidth,+"
				+ "document.documentElement.clientWidth,+"
				+ "document.documentElement.scrollWidth,+"
				+ "document.documentElement.offsetWidth);");
		
		System.out.println(width);
				 
//		int height = browser.execute_script("return Math.max(document.body.scrollHeight, +"
//				+ "document.body.offsetHe,+"
//				+ " document.documentElement.clientHeight,"
//				+ "document.documentElement.scrollHeight, "
//				+ "document.documentElement.offsetHeight);")
		
		
	}

}
