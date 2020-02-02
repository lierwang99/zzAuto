/**
 * 
 */
package test.email;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.TestRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import listener.MyIRetryAnalyzer;

/**
 * @author Administrator
 *
 */
//@Test(retryAnalyzer = MyIRetryAnalyzer.class)
public class Te {
//	int i = 0;
	@Test(priority = 0)
	public void ar() {
		System.out.println("执行、、、");
		Assert.assertEquals(1, 2);
	}

	@Test(priority = 3)
	public void zr() {
		System.out.println("是否为真的！");
		Assert.assertEquals(5, 5);
	}
	
	@AfterMethod(enabled = true)
	public void getMethods(ITestNGMethod im ) {
//		ITestContext tc = new TestRunner(null, null, null, false, null, null);
		

//		int verbose = TestRunner.getVerbose();
//		System.out.println("当前报告等级 ：  "+ verbose);
		System.out.println("当前调用的方法名为： "+im.getMethodName());
	}

}
