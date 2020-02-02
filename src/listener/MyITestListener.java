/**
 * 
 */
package listener;

import java.lang.reflect.Field;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import log.MyLogger;
import project.AncestorImpl;

/**
 * @author Administrator
 *
 */
public class MyITestListener implements ITestListener{
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("ITestListener --suit-- onFinish ！！\n\n");
		MyLogger.logToFile( this.getClass(),MyLogger.getCurrentMethodName() ,"ITestListener -- onFinish ！！", Level.INFO );
	}
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("ITestListener --suit-- onStart ！！\n\n");
		MyLogger.logToFile( this.getClass(),MyLogger.getCurrentMethodName() ,"ITestListener -- onStart ！！", Level.INFO );
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("ITestListener -- onTestFailedButWithinSuccessPercentage ！！");
		MyLogger.logToFile( this.getClass(),MyLogger.getCurrentMethodName() ,"ITestListener -- onTestFailedButWithinSuccessPercentage ！！", Level.INFO );
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("ITestListener -- onTestFailure ！！");
		MyLogger.logToFile( this.getClass(),MyLogger.getCurrentMethodName() ,"ITestListener -- onTestFailure ！！", Level.WARNING );
		StackTraceElement[] stackTrace = result.getThrowable().getStackTrace();
		int len = stackTrace.length;
		StringBuffer errorPathInfo = new StringBuffer(result.getThrowable().getMessage());
		for(int x=0;x<len;x++){
			errorPathInfo = errorPathInfo.append("\n"+stackTrace[x].toString());
		}
		MyLogger.logToFile( this.getClass(),MyLogger.getCurrentMethodName() ,"【 失败信息 】"+errorPathInfo, Level.SEVERE );
		
		System.out.println("失败后开始截图！！");
		MyLogger.logToFile( this.getClass(),MyLogger.getCurrentMethodName() ,"失败后开始截图！！", Level.INFO );
		WebDriver driver = null;
		Field driverField = null;
		String instanceName = result.getInstanceName();
		try {
			Class<?> c = Class.forName(instanceName);
			driverField = c.getDeclaredField("driver");
			driver = (WebDriver)driverField.get(c);
		} catch (Exception e) {
			System.out.println("属性driver并不是WebDriver的对象！\n\n");
			MyLogger.logToFile( this.getClass(),MyLogger.getCurrentMethodName() ,"属性driver并不是WebDriver的对象！", Level.WARNING );
			e.printStackTrace();
		}
		try {
			AncestorImpl ance = new AncestorImpl(driver);
			ance.getScreenshotAs();
			System.out.println("截图失败 !  \n\n");
			MyLogger.logToFile( this.getClass(),MyLogger.getCurrentMethodName() ,"截图成功 ! ", Level.INFO );
		}catch(Exception e1) {
			System.out.println("截图失败 !  \n\n");
			MyLogger.logToFile( this.getClass(),MyLogger.getCurrentMethodName() ,"截图失败 !", Level.WARNING );
		}
	}
	

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("ITestListener -- onTestSkipped ！！\n\n");
		MyLogger.logToFile( this.getClass(),MyLogger.getCurrentMethodName() ,"ITestListener -- onTestSkipped ！！", Level.WARNING );
	}
	
	@Override
	public void	onTestStart(ITestResult result) {
		System.out.println("ITestListener -- onTestStart！！");
		MyLogger.logToFile( this.getClass(),MyLogger.getCurrentMethodName() ,"ITestListener -- onTestStart ！！", Level.INFO );
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("ITestListener -- onTestSuccess ！！\n\n");
		MyLogger.logToFile( this.getClass(),MyLogger.getCurrentMethodName() ,"ITestListener -- onTestSuccess ！！", Level.INFO );
	}
	
}
