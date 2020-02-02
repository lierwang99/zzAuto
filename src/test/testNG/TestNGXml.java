/**
 * 
 */
package test.testNG;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

/**
 * @author Administrator
 *
 */
public class TestNGXml {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * 自定义XmlSuite
		 */
		XmlSuite suite = new XmlSuite();
		suite.setName("emailSuite");
		 
		XmlTest test = new XmlTest(suite);
		test.setName("email");
		List<XmlClass> classes = new ArrayList<XmlClass>();
		classes.add(new XmlClass("test.email.Te"));
		test.setXmlClasses(classes) ;

		TestNG testNG = new TestNG();
		ArrayList<XmlSuite> arrayList = new ArrayList<>();
		arrayList.add(suite);
		testNG.setXmlSuites(arrayList);
		testNG.run();
		
	}

}
