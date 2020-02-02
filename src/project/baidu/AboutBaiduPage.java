/**
 * 
 */
package project.baidu;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

/**
 * @author Administrator
 *
 */
public class AboutBaiduPage extends Baidu{
	private WebDriver driver;
	public AboutBaiduPage() {
		
	}
	public AboutBaiduPage(WebDriver driver) {
		super(driver);
		this.driver = driver ;
	}

	@FindBy(xpath = "//*[@class = 'side-menu__item']/a")
	public List<WebElement> catalogs;
}
