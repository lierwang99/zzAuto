/**
 * 
 */
package test.baidu;

import org.openqa.selenium.WebDriver;

import project.AncestorImpl;
import project.baidu.Zengrong;

/**
 * @author Administrator
 *
 */
public class ZengrongTest {
	public static void main(String[] args) {
		WebDriver driver2 = AncestorImpl.getDriver("file:///H:/Desktop/javascript/zr.html", false);
//		System.out.println(driver2==null);
		Zengrong zengrong = new Zengrong(driver2);
		System.out.println("zengrong: "+(zengrong==null));
		zengrong.setSelectLabelValueByObject("//*[@id=\"aaa\"]", "国");
		System.out.println("------------------------------------------------");
	}
}
