/**
 * 
 */
package project.baidu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Administrator
 *
 */
public class HomePage extends Baidu{
	public static String homeUrl= "https://www.baidu.com/";
	private String shurukuangXpath = "";
	private String baiduyixiaXpath = "";
	private String xinwenXpath = "//div[@id='u1']/a[1]";
	private String hao123Xpath = "//*[@id='u1']/a[2]";
	private String dituXpath = "";
	private String shipingXpath = "";
	private String tiebaXpath = "";
	private String xueshuXpath = "";
	private String dengluXpath = "";
	private String shezhiXpath = "";
	private String gengduochanpinXpath = "";
	private String baidushezhuyeXpath = "";
	private String guanyubaiduXpath = "";
	private String AboutBaiduXpath = "//p[@id='lh']/a[3]";
	private WebDriver driver = null ;
	private String xiazaiApp = "//div[@id='qrcode']//p[@class='title']";
	public  String name = "曾容";
	
	@FindBy(how = How.XPATH,using="//div[@id='qrcode']//p[@class='title']")
	public WebElement eleXiazaiApp;
	
	@FindBy(xpath="//div[@id='qrcode']//p[@class='title']")
	public WebElement eleXiazaiApp2;
	

	
	public HomePage() {
		
	}
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver ;
		System.out.println("我是有参构造方法！！");
	}
	
	public XinwenPage getXinwenPage() {
		clickByXpath(xinwenXpath);
		XinwenPage xp = new XinwenPage(driver);
		return xp;
	}
	public void pr() {
		System.out.println("我是HomePage类的方法！！！！");
	}
	public Hao123Page getHao123() {
		clickByXpath(hao123Xpath);
		Hao123Page hao123 = new Hao123Page(driver);
		return hao123;
	}
	public DituPage getDituPage() {
		clickByXpath(dituXpath);
		DituPage ditu = new DituPage(driver);
		return ditu;
	}
	public ShipingPage getShipingPage() {
		clickByXpath(dituXpath);
		ShipingPage shiping = new ShipingPage(driver);
		return shiping;
	}
	public AboutBaiduPage getAboutBaiduPage() {
		clickByXpath(AboutBaiduXpath);
		AboutBaiduPage aboutBaiduPage = PageFactory.initElements(driver, AboutBaiduPage.class);
		return aboutBaiduPage;
	}
}
