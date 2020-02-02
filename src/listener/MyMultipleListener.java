/**
 * 
 */
package listener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import project.AncestorImpl;
import util.RobotUtils;

/**
 * @author Administrator
 *
 */
public class MyMultipleListener implements ITestListener,IInvokedMethodListener{
	
	public static Logger log = Logger.getLogger(MyMultipleListener.class.getName());
	@Override
	public void onFinish(ITestContext context) {
		Date endDate = context.getEndDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
		String stringDate = sdf.format(endDate);
		log.info("\n\n\n");
		log.info("ITestListener -- onFinish 【 "+stringDate+" 】 ！！\n\n");
	}
	
	@Override
	public void onStart(ITestContext context) {
		ITestNGMethod[] allTestMethods = context.getAllTestMethods();
		Date startDate = context.getStartDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
		String stringDate = sdf.format(startDate);
		log.info("suite -- onStart : "+stringDate+"  ！！");
		log.info("本次测试包含的测试方法共 【 "+allTestMethods.length+" 】 个如下：");
		for(ITestNGMethod itm : allTestMethods) {
			String qualifiedName = itm.getQualifiedName();
			log.info("【 "+qualifiedName+" 】");
		}
		log.info("\n\n\n");
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		log.info("ITestListener -- onTestFailedButWithinSuccessPercentage ！！");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		Object[] parameters = result.getParameters();
		System.out.println("-----------------------------------------------------");
		for(Object obj:parameters) {
			System.out.println(obj);
		}
		System.out.println("-----------------------------------------------------");
		String name = result.getName();
		log.info("ITestListener -- onTestFailure 方法名为【 "+ name+" 】！！\n\n");
		RobotUtils.createScreenCapture();
	}
	

	@Override
	public void onTestSkipped(ITestResult result) {
		log.info("ITestListener -- onTestSkipped ！！\n\n");
	}
	
	@Override
	public void	onTestStart(ITestResult result) {
//		log.info("ITestListener -- onTestStart , testName【  】 ！！");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Object[] parameters = result.getParameters();
		System.out.println("-----------------------------------------------------");
		for(Object obj:parameters) {
			System.out.println(obj);
		}
		System.out.println("-----------------------------------------------------");
		String name = result.getName();
		log.info("ITestListener -- onTestSuccess 方法名为【 "+ name+" 】！！\n\n");
	}
	
	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult)  {
		
	}
	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult)   {
		
		String methodName = method.getTestMethod().getMethodName();
		log.info("正在测试的方法名为【 "+methodName+" 】");
	}
}
