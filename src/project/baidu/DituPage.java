/**
 * 
 */
package project.baidu;

import org.openqa.selenium.WebDriver;

/**
 * @author Administrator
 *
 */
public class DituPage extends Baidu{
	
	private String hendadituXpath = "444";
	private WebDriver driver = null ;
	public DituPage() {
		
	}
	public DituPage(WebDriver driver) {
		super(driver);
		this.driver = driver ;
	}
	
	public String getHendadituXpath() {
		return hendadituXpath;
	}
	public void setHendadituXpath(String hendadituXpath) {
		this.hendadituXpath = hendadituXpath;
	}

}
