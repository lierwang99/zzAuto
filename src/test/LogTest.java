/**
 * 
 */
package test;

import org.openqa.selenium.WebDriver;

import project.AncestorImpl;

/**
 * @author Administrator
 *
 */
public class LogTest extends AncestorImpl  {
	private static WebDriver driver = null;
	public LogTest() {

	}
	public LogTest(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		driver = AncestorImpl.getDriver("https://www.baidu.com");
		LogTest lt = new LogTest(driver);
		lt.sendKeysByXpath("//input[@id='kw']", "jenkins");
		
	}

}
