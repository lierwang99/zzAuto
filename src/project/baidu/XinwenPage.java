/**
 * 
 */
package project.baidu;

import org.openqa.selenium.WebDriver;

/**
 * @author Administrator
 *
 */
public class XinwenPage extends Baidu{
	private String gengduoxinwenXpath = "" ;
	private WebDriver driver = null ;
	public XinwenPage() {
	}
	public XinwenPage(WebDriver driver) {
		super(driver);
		this.driver = driver ;
	}
	
	
	
	
	
}
