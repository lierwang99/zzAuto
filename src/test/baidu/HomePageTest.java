package test.baidu;

import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import aseertion.MyAssert;
import log.MyLogger;
import project.baidu.Baidu;
import project.baidu.Hao123Page;
import project.baidu.HomePage;
import project.baidu.XinwenPage;

@Listeners({ listener.MyITestListener.class })
public class HomePageTest {

	public static WebDriver driver ;
	public String url = "https://www.baidu.com";
	public HomePage homePage = null;
	public XinwenPage xinwenPage = null;
	public Hao123Page hao123 = null;
	@BeforeMethod(enabled = true)
	public void beforeClass() {
		MyLogger.setHandlerLevel(Level.ALL);
		driver = Baidu.getDriver(url,true);
		homePage = new HomePage(driver);
		System.out.println("\n\n");
	}

	@Test()
	public void getXinwenPageTest() {
		xinwenPage = homePage.getXinwenPage();
		String currentUrl = xinwenPage.getCurrentUrl();
		Assert.assertEquals(currentUrl, "http://news.baidu.com/2", "断言url失败");
	}

	@Test(testName = "pr")
	public void pr() {
		System.out.println("nihao-----------");
	}

	@Test(enabled = false)
	public void getHao123() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		hao123 = homePage.getHao123();
		String currentUrl = hao123.getCurrentUrl();
		MyAssert.assertEquals(currentUrl, "https://www.hao123.com/", "断言url失败");
	}

	@AfterTest
	public void afterClass() {
		System.out.println("\n\n");
		xinwenPage.quit();
	}


}
