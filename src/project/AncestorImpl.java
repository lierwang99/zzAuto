/**
 * 
 */
package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream.Filter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import log.MyLogFilter;
import log.MyLogger;

/**
 * @author Administrator
 *
 */
public class AncestorImpl implements Ancestor {
	private WebDriver driver = null;
	private long timeOutInSeconds = 20;
	private long sleepInMillis = 100;
	
	private Level handlerLevel = Level.INFO;

	private Level logLevel = Level.INFO;

//	private final static Logger logger = Logger.getLogger(AncestorImpl.class.getName());
	private final static Logger logger = Logger.getGlobal();

	public AncestorImpl() {

	}

	public AncestorImpl(WebDriver driver) {
		this.driver = driver;
	}

	public long getTimeOutInSeconds() {
		return timeOutInSeconds;
	}

	public Level getHandlerLevel() {
		return handlerLevel;
	}

	public void setHandlerLevel(Level handlerLevel) {
		this.handlerLevel = handlerLevel;
	}

	public Level getLogLevel() {
		return logLevel;
	}

	public void setLogLevel(Level logLevel) {
		this.logLevel = logLevel;
	}

	public void setTimeOutInSeconds(long timeOutInSeconds) {
		logger.info("重新设置超时时间【" + timeOutInSeconds + " 秒】");
		MyLogger.logToFile( this.getClass(),MyLogger.getCurrentMethodName() , "重新设置超时时间【\" + timeOutInSeconds + \" 秒】", Level.INFO);
		this.timeOutInSeconds = timeOutInSeconds;
	}

	public long getSleepInMillis() {
		return sleepInMillis;
	}

	public void setSleepInMillis(long sleepInMillis) {
		logger.info("重新设置轮询（查找）时间【" + sleepInMillis + " 毫秒】");
		MyLogger.logToFile(this.getClass(),MyLogger.getCurrentMethodName() , "重新设置轮询（查找）时间【" + sleepInMillis + " 毫秒】", Level.INFO);
		this.sleepInMillis = sleepInMillis;
	}

	public String getCurrentUrl() {
		logger.info("得到当前的url");
		MyLogger.logToFile( this.getClass(),MyLogger.getCurrentMethodName() , "得到当前的url", Level.INFO);
		String currentUrl = this.driver.getCurrentUrl();
		return currentUrl;
	}

	public String getTitle() {
		logger.info("得到当前的title");
		MyLogger.logToFile( this.getClass(),MyLogger.getCurrentMethodName() , "得到当前的title", Level.INFO);
		String title = this.driver.getTitle();
		return title;
	}

	public static WebDriver getDriver(String url) {
		WebDriver driver2 = getDriver(url, false);
		return driver2;
	}

	public static WebDriver getDriver(String url, boolean isHeadless) {
		logger.info("通过静态方法，获取driver");
		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", ".\\tools\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setHeadless(isHeadless);
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//		chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
		driver = new ChromeDriver(chromeOptions);
		driver.get(url.trim());
		logger.info("最大化窗口");
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(2000, 1200));
		return driver;
	}

	@Override
	public WebElement findElementByCss(String css) {
		logger.info("找元素，css的表达式为【" + css + "】 ");
		MyLogger.logToFile( this.getClass(),MyLogger.getCurrentMethodName() , "找元素，css的表达式为【\" + css + \"】 ", Level.INFO);
		WebElement findElement = null;
		try {
//		timeOutInSeconds等待最大时间为10秒，sleepInMillis此线程休息100毫秒。
			WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutInSeconds, sleepInMillis);
			ExpectedCondition<WebElement> voel = ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css));
			// 返回值根据泛型传值类型返回
			findElement = webDriverWait.until(voel);
		} catch (Exception e) {
			logger.info("找元素失败了，css的表达式为【" + css + "】 ");
			MyLogger.logToFile(this.getClass(),MyLogger.getCurrentMethodName() , "找元素失败了，css的表达式为【\" + css + \"】\n\r" + e.getMessage(),Level.WARNING);
			e.printStackTrace();
		}
		return findElement;
	}

	/**
	 * 找
	 */
	@Override
	public WebElement findElementByXpath(String xpath) {
//		logger.info("找元素，xpath 的表达式为【" + xpath + "】 ");
		WebElement findElement = null;
		try {
//		timeOutInSeconds等待最大时间为10秒，sleepInMillis此线程休息100毫秒。
			WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutInSeconds, sleepInMillis);
			ExpectedCondition<WebElement> voel = ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath));
			// 返回值根据泛型传值类型返回
			findElement = webDriverWait.until(voel);
		} catch (Exception e) {
			logger.info("找元素失败了，xpath 的表达式为【" + xpath + "】 ");
			MyLogger.logToFile(this.getClass() ,MyLogger.getCurrentMethodName() , "找元素失败了，xpath 的表达式为【\" + xpath + \"】\n\r" + e.getMessage(), Level.WARNING);
			e.printStackTrace();
		}
		return findElement;
	}

	@Override
	public List<WebElement> findElementsByXpath(String xpath) {
		logger.info("找一组元素，xpath 的表达式为【" + xpath + "】 ");
		MyLogger.logToFile( this.getClass(),MyLogger.getCurrentMethodName() , "找一组元素，xpath 的表达式为【\" + xpath + \"】", Level.INFO);
		List<WebElement> list = null;
		try {
			WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutInSeconds, sleepInMillis);
			ExpectedCondition<List<WebElement>> poaelb = ExpectedConditions
					.presenceOfAllElementsLocatedBy(By.xpath(xpath));
			list = webDriverWait.until(poaelb);
		} catch (Exception e) {
			logger.info("找一组元素失败了，xpath 的表达式为【" + xpath + "】 ");
			MyLogger.logToFile(this.getClass(),MyLogger.getCurrentMethodName() , "找一组元素失败了，xpath 的表达式为【\" + xpath + \"】\n\r" + e.getMessage() ,Level.WARNING);
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void clickByXpath(String xpath) {
		WebElement findElement = findElementByXpath(xpath);
		// 加上强制睡眠可以解决：org.openqa.selenium.StaleElementReferenceException异常
		try {
			findElement.click();
		} catch (Exception e) {
			logger.info("点击元素失败，xpath 的表达式为【" + xpath + "】 ");
			MyLogger.logToFile(this.getClass() , MyLogger.getCurrentMethodName() , "找一组元素失败了，xpath 的表达式为【\" + xpath + \"】\n\r" + e.getMessage(), Level.WARNING);
			e.printStackTrace();
		}
	}

	@Override
	public void clickByXpathWaitTime(String xpath) {
		WebElement findElement = findElementByXpath(xpath);
		// 加上强制睡眠可以解决：org.openqa.selenium.StaleElementReferenceException异常
		try {
			logger.info("点击元素，xpath 的表达式为【" + xpath + "】 ");
			Thread.sleep(2000);
			findElement.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void clickListByXpath(List<String> list) {
		if (list == null) {
			logger.info("元素xpath有问题，list为空 ");
			MyLogger.logToFile( this.getClass() , MyLogger.getCurrentMethodName() ,"元素xpath有问题，list为空" , Level.INFO);
			return;
		}
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String xpath = it.next();
			clickByXpath(xpath);
		}
	}

	@Override
	public void sendKeysByXpath(String xpath, String content) {
		WebElement findElement = findElementByXpath(xpath);
		logger.info("开始传值" + content);
		MyLogger.logToFile( this.getClass(),MyLogger.getCurrentMethodName() , "开始传值" + content, Level.INFO);
		findElement.sendKeys(content);
	}

	@Override
	public void sendKeyMapByXpath(Map<Enum<? extends Enum<?>>, String> map) {
		if (map == null) {
			logger.warning("map为空");
			MyLogger.logToFile( this.getClass(),MyLogger.getCurrentMethodName() , "map为空", Level.WARNING);
			return;
		}
		logger.info("元素传值，map 的表达式为【" + map + "】 ");
		MyLogger.logToFile( this.getClass(),MyLogger.getCurrentMethodName() , "元素传值，map 的表达式为【\" + map + \"】", Level.INFO);
		Set<Map.Entry<Enum<? extends Enum<?>>, String>> se = map.entrySet();
		Iterator<Entry<Enum<? extends Enum<?>>, String>> ite = se.iterator();
		while (ite.hasNext()) {
			Entry<Enum<? extends Enum<?>>, String> next = ite.next();
			String xpath = next.getKey().toString();
			String value = next.getValue();
			sendKeysByXpath(xpath, value);
		}
	}

	/**
	 * 判断页面是那种类型的frame，然后进行切换frame
	 */
	@Override
	public WebDriver switchToFrame(Object object) {
		org.openqa.selenium.WebDriver driver2 = null;
		System.out.println("driver---->" + (driver == null));
		WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutInSeconds, sleepInMillis);

		if (object == null) {
			logger.warning("frame参数为空！");
			MyLogger.logToFile( this.getClass(),MyLogger.getCurrentMethodName() , "frame参数为空！" ,Level.WARNING);
			return driver2;
		}
		logger.info("切换frame ，object 的表达式为【" + object + "】 ");
		MyLogger.logToFile( this.getClass(),MyLogger.getCurrentMethodName() , "切换frame ，object 的表达式为【" + object + "】", Level.INFO);
		if (object instanceof java.lang.Integer) {
			logger.info("通过int切换frame");
			MyLogger.logToFile( this.getClass(),MyLogger.getCurrentMethodName() , "通过int切换frame", Level.INFO);
			int index = (int) object;
			try {
				ExpectedCondition<WebDriver> ft = ExpectedConditions.frameToBeAvailableAndSwitchToIt(index);
				driver2 = webDriverWait.until(ft);
			} catch (Exception e) {
				logger.info("frame切换失败！");
				MyLogger.logToFile( this.getClass(),MyLogger.getCurrentMethodName() , "【frame切换失败】！\n\r" + e.getMessage() ,Level.WARNING);
				e.printStackTrace();
			}
		}
		if (object instanceof java.lang.String) {
			logger.info("通过String切换frame");
			MyLogger.logToFile( this.getClass(),MyLogger.getCurrentMethodName() , "通过String切换frame", Level.INFO);
			java.lang.String nameOrId = (String) object;
			try {
				ExpectedCondition<WebDriver> ft = ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOrId);
				driver2 = webDriverWait.until(ft);
			} catch (Exception e) {
				logger.info("frame切换失败！");
				MyLogger.logToFile( this.getClass(),MyLogger.getCurrentMethodName() , "【frame切换失败】！\n\r" + e.getMessage() ,Level.WARNING);
				e.printStackTrace();
			}
		}
		if (object instanceof org.openqa.selenium.WebElement) {
			logger.info("通过WebElement切换frame");
			MyLogger.logToFile( this.getClass(),MyLogger.getCurrentMethodName() , "通过WebElement切换frame", Level.INFO);
			org.openqa.selenium.WebElement frameElement = (WebElement) object;
			try {
				ExpectedCondition<WebDriver> ft = ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement);
				driver2 = webDriverWait.until(ft);
			} catch (Exception e) {
				logger.info("frame切换失败！");
				MyLogger.logToFile( this.getClass(),MyLogger.getCurrentMethodName() , "【frame切换失败】！\n\r" + e.getMessage() , Level.WARNING);
				e.printStackTrace();
			}
		}
		return driver2;
	}

	/**
	 * 如不是input的日期输入框，解决方法：移除原有属性
	 */
	@Override
	public void removeReadonly(String eleCss) {
		if (eleCss == null) {
			logger.info("要移除readonly属性的元素的css参数为空！");
			MyLogger.logToFile( this.getClass(),MyLogger.getCurrentMethodName() , "要移除readonly属性的元素的css参数为空！", Level.WARNING);
			return;
		}
		WebElement ele = findElementByCss(eleCss);
		if (ele != null) {
			String attribute = ele.getAttribute("readonly");
			if (attribute != null) {
				String js = "document.querySelector('" + eleCss + "').removeAttribute('readonly')"; // 原生js，移除属性
				((JavascriptExecutor) driver).executeScript(js); // 将driver强制转换为JavascriptExecutor类型
			}
		}
	}

	/**
	 * 移除元素属性
	 */
	@Override
	public void removeElementAttribute(String eleCss, String attributeName) {
		if (eleCss == null) {
			logger.info("要移除【 " + attributeName + " 】属性的元素的css参数为空！");
			MyLogger.logToFile( this.getClass(),MyLogger.getCurrentMethodName() , "要移除【 \" + attributeName + \" 】属性的元素的css参数为空！", Level.WARNING);
			return;
		}
		WebElement ele = findElementByCss(eleCss);
		if (ele != null) {
			String js = "document.querySelector('" + eleCss + "').removeAttribute('" + attributeName.trim() + "')"; // 原生js，移除属性
			((JavascriptExecutor) driver).executeScript(js); // 将driver强制转换为JavascriptExecutor类型
		}
	}

	/**
	 * 已处置后要设置成可以输入的框就以下方法：
	 */
	@Override
	public void setElementAttribute(String eleCss, String attributeName, String attributeValue) {
		WebElement ele = findElementByCss(eleCss);
		if (ele != null) {
			String js = "document.querySelector('" + eleCss + "').setAttribute('" + attributeName.trim() + "','"
					+ attributeValue + "')";
			((JavascriptExecutor) driver).executeScript(js);
		}
	}

	/**
	 * 滚动轴的定义
	 */
	@Override
	public void scrollInY(int start, int end) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String str1 = "window.scrollTo(" + start + "," + end + ")";
		js.executeScript(str1);
	}

	/**
	 * selenium截图
	 */
	@Override
	public void getScreenshotAs() {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS");
		String format = simpleDateFormat.format(date);
		File targetFile = new File("H:\\imgs\\" + format + ".png");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		FileInputStream in = null;
		FileOutputStream out = null;
		int x = 0;
		try {
			in = new FileInputStream(srcFile);
			out = new FileOutputStream(targetFile);
			while ((x = in.read()) != -1) {
				out.write(x);
			}
		} catch (Exception e) {
			logger.info("截图失败！！！");
			MyLogger.logToFile( this.getClass(),MyLogger.getCurrentMethodName() , "截图失败！！！\n\r" + e.getMessage(), Level.WARNING);
			e.printStackTrace();
		}
	}

	@Override
	public void quit() {
		if (driver != null) {
			try {
				logger.info("关闭浏览器????");
				MyLogger.logToFile( this.getClass(),MyLogger.getCurrentMethodName() , "浏览器将在3秒后关闭 ！！！", Level.WARNING);
				Thread.sleep(3000);
				driver.quit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			logger.info("driver为空,浏览器关闭失败！！！");
			MyLogger.logToFile( this.getClass(),MyLogger.getCurrentMethodName() , "driver为空,浏览器关闭失败！！！", Level.SEVERE);
		}
	}

	@Override
	public WebDriver getWebDriver() {
		logger.info("获取对象的driver");
		MyLogger.logToFile( this.getClass(),MyLogger.getCurrentMethodName() , "获取对象的driver" ,Level.INFO);
		return this.driver;
	}

	/**
	 * 
	 */
	public void setSelectLabelValueByObject(String selectLabelXpath, Object textOrValueOrOrderNumber) {
		clickByXpath(selectLabelXpath);
		String sonLabelXpath = null;
		if (textOrValueOrOrderNumber == null) {
			return;
		}
		if (textOrValueOrOrderNumber instanceof Integer) {
			sonLabelXpath = selectLabelXpath + "//option[" + textOrValueOrOrderNumber + "]";
		} else if (textOrValueOrOrderNumber instanceof String) {
//			进入之后首先把textOrValueOrOrderNumber当成text去找
			sonLabelXpath = selectLabelXpath + "//option[contains(.,'" + textOrValueOrOrderNumber + "')]";
			WebElement findElementByXpath = findElementByXpath(sonLabelXpath);
			if (findElementByXpath == null) {
				sonLabelXpath = selectLabelXpath + "//option[@value='" + textOrValueOrOrderNumber + "']";
			}
		} else {
			return;
		}
		try {
			clickByXpath(sonLabelXpath);
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			clickByXpath(selectLabelXpath);
		}
	}

	/**
	 * Handle并且切换
	 */
	@Override
	public WebDriver switchWindowHandle() {
//		得到所有页面句柄
		Set<String> wHS = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<String>(wHS);
		driver = driver.switchTo().window(tabs.get(1));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html")));
//		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		return driver;
	}

	/**
	 * 这个是表格的xpath //*[@id="maincontent"]/div[9]/table/tbody/tr[1]/th[1]
	 */
	@Override
	public String getTableCellText(String tableXpath, String tag, int row, int column) {
		if (!("td".equals(tag) || "th".equals(tag))) {
			return null;
		}
		String cellXpath = tableXpath + "/tbody/tr[" + row + "]/" + tag + "[" + column + "]";
		String text = driver.findElement(By.xpath(cellXpath)).getText();
		return text;
	}

	/**
	 * 处理非select选择项 ,fatherXpath 为准确的 ，sonXpath 为正则表达Xpath ，value为包含即可
	 */
	@Override
	public void setNotSelectLabelValue(String fatherXpath, String sonXpath, String value) {
		clickByXpath(fatherXpath);
		List<WebElement> valueAll = findElementsByXpath(sonXpath);
		for (WebElement valueOne : valueAll) {
			if (valueOne.getText().contains(value)) {
				valueOne.click();
				break;
			}
		}
	}
}