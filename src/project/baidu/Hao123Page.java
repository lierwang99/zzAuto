/**
 * 
 */
package project.baidu;

import org.openqa.selenium.WebDriver;

/**
 * @author Administrator
 *
 */
public class Hao123Page extends Baidu{
	private String hao123BrowserXpath = "";
	private WebDriver driver = null ;
	public Hao123Page() {
		
	}
	public Hao123Page(WebDriver driver) {
		super(driver);
		this.driver = driver ;
	}
}
