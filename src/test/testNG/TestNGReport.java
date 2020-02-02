/**
 * 
 */
package test.testNG;

import java.util.ArrayList;

import org.testng.ITestNGListener;
import org.testng.TestNG;

/**
 * @author Administrator
 *
 */
public class TestNGReport {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TestNG testNG = new TestNG();
		testNG.setVerbose(3);
		testNG.setTestClasses(new Class[] { test.email.Te.class, test.baidu.HomePageTest.class });
//		testNG.setGroups("dependGroup1");// 此处可以设置多个group名称，以逗号分隔
		testNG.setDefaultSuiteName("china");
		testNG.setDefaultTestName("anhui");
		ArrayList<Class<? extends ITestNGListener>> arrayList = new ArrayList<>();
		arrayList.add(listener.MyITestListener.class);
		testNG.setListenerClasses(arrayList);
		testNG.setOutputDirectory("H:\\reports");// 设置输出目录
		testNG.run();
	}
}