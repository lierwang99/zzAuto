/**
 * 
 */
package project.baidu;

import org.openqa.selenium.WebDriver;

/**
 * @author Administrator
 *
 */
public class ShipingPage extends Baidu{
	private String xiaoshipingXpath = "" ;
	private WebDriver driver = null ;
	public ShipingPage() {
	}
	public ShipingPage(WebDriver driver) {
		super(driver);
		this.driver = driver ;
	}
}
