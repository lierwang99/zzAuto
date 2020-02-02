/**
 * 
 */
package project.baidu;

import org.openqa.selenium.WebDriver;

import project.AncestorImpl;

/**
 * @author Administrator
 *
 */
public class Baidu extends AncestorImpl{
	
	private WebDriver driver;
	public Baidu() {
	
	}
	public Baidu(WebDriver driver) {
		super(driver);
		this.driver = driver ;
	}

}
