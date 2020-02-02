/**
 * 
 */
package test.baidu;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import project.AncestorImpl;
import project.baidu.Baidu;

/**
 * @author Administrator
 *
 */
public class SwitchHandleTest extends Baidu{
	public WebDriver driver ;
	public SwitchHandleTest() {
		
	}
	public SwitchHandleTest(WebDriver driver) {
		super(driver);
		this.driver = driver ;
	}
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		String url = "file:///H:/Desktop/API.html";
		WebDriver driver2 = AncestorImpl.getDriver(url);
		SwitchHandleTest sht = new SwitchHandleTest(driver2);
		String testNGXpath = "//*[contains(text(),'TestNG')]";
//		driver2.findElement(By.xpath(testNGXpath)).click();
//		Thread.sleep(15000);
//		ArrayList<String> tabs = new ArrayList<String> (driver2.getWindowHandles());
//		driver2 = driver2.switchTo().window(tabs.get(1));
//		driver2.switchTo().frame("classFrame");
//		WebElement ele = driver2.findElement(By.xpath("//h1[@class='title']"));
		
		
		sht.clickByXpath(testNGXpath);
//		Thread.sleep(15000);
		sht.switchWindowHandle();
		sht.switchToFrame("classFrame");
		String text = sht.findElementByXpath("//h1[@class='title']").getText();
//		WebDriver driver3 = sht.switchWindowHandle();
////		SwitchHandleTest sht2 = new SwitchHandleTest(driver3);
////		driver3 = sht2.switchToFrame("classFrame");
//		driver3 = driver3.switchTo().defaultContent();
//		driver3.switchTo().frame("classFrame");
//		WebElement ele = driver3.findElement(By.xpath("//h1[@class='title']"));
////		WebElement ele = sht2.findElementByXpath("//h1[@class='title']");
		System.out.println(text);
	}

}
