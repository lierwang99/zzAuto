/**
 * 
 */
package project;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Administrator
 *
 */
public interface Ancestor {
	public void clickByXpath(String xpath);
	
	public void clickByXpathWaitTime(String xpath);
	
	public void clickListByXpath(List<String> list);	

	public WebElement findElementByCss(String css);
	
	public abstract WebElement findElementByXpath(String xpath);
	
	public abstract java.util.List<WebElement> findElementsByXpath(String xpath);
	
	public String getCurrentUrl();
	
	public String getTitle();

	public void getScreenshotAs() ;
	
	public WebDriver getWebDriver();
	
	public String getTableCellText(String tableXpath, String tag, int row, int column);
	
	public void sendKeysByXpath(String xpath, String content);
	
	public void sendKeyMapByXpath(Map<java.lang.Enum<? extends Enum<?>>, String> map);
	
	public void setSelectLabelValueByObject(String selectLabelXpath,Object textOrValueOrOrderNumber);
	
	public void setNotSelectLabelValue(String fatherXpath,String sonXpath,String value);

	public WebDriver switchToFrame(java.lang.Object object);
	
	public WebDriver switchWindowHandle();
	
	public void setElementAttribute(String eleCss, String attributeName, String attributeValue);
	
	public void removeReadonly(String eleCss);
	
	public void removeElementAttribute(String eleCss, String attributeName);
	
	
	
	public void scrollInY(int start, int end);
	
	public void quit();


}
