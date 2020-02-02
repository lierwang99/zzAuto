/**
 * 
 */
package listener;

import java.util.Date;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

/**
 * @author Administrator
 *
 */
public class MyIInvokedMethodListener implements IInvokedMethodListener{
	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult)  {
		long date = method.getDate();
		System.out.println(new Date(date));
		boolean testMethod = method.isTestMethod();
		System.out.println("是否为测试方法-->"+testMethod);
		if(testMethod) {
			ITestNGMethod testMethod2 = method.getTestMethod();
			String methodName = testMethod2.getMethodName();
			System.out.println("methodName-->"+methodName);
			
		}
	}
	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult)   {
		
	}
}
