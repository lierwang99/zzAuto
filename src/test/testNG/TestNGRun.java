/**
 * 
 */
package test.testNG;

import java.util.ArrayList;

import org.testng.TestNG;

/**
 * @author Administrator
 *
 */
public class TestNGRun {
	public static void main(String[] args) {
		TestNG testNG = new TestNG();
		/**
		 * 方法二：TestNG类的使用方法
		 */
//		Class[] classes = new Class[1];
//		classes[0] = test.baidu.HomePageTest.class;
//		testNG.setTestClasses(classes);
//		testNG.run();
		
		/**
		 * 方法一
		 */
//		ArrayList<String> arrayList = new ArrayList<>();
//		arrayList.add("D:\\eclipse\\working\\zzAuto\\src\\BaiduHomePage.xml");
//		testNG.setTestSuites(arrayList);
//		testNG.run();
	}
}
