/**
 * 
 */
package test.baidu;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import project.baidu.AboutBaiduPage;
import project.baidu.Baidu;

/**
 * @author Administrator
 *
 */
public class PageFactoryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver = Baidu.getDriver("http://ir.baidu.com/", false);
		AboutBaiduPage abp = PageFactory.initElements(driver, project.baidu.AboutBaiduPage.class);
		List<WebElement> catalogs = abp.catalogs;
		for(WebElement catalog :catalogs) {
		System.out.println(catalog.getText());
		}
		
		
//		WebDriver driver = Baidu.getDriver(HomePage.homeUrl, false);
//		HomePage homePage = new HomePage(driver);
//		AboutBaiduPage aboutBaiduPage = homePage.getAboutBaiduPage();
//		List<WebElement> findElementsByXpath = aboutBaiduPage.findElementsByXpath("//li[contains(text(),'HOME')]/a");
//		for(WebElement ele : findElementsByXpath) {
//			System.out.println(ele.getText());
//		}
	}

}
