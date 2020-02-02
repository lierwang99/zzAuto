/**
 * 
 */
package listener;

import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

/**
 * @author Administrator
 *
 */
public class MyIHookable implements IHookable{

	@Override
	public void run(IHookCallBack callBack, ITestResult testResult) {
		Object[] parameters = callBack.getParameters();
		for(Object obj:parameters) {
			System.out.println("999---->"+obj);
		}
		System.out.println("callBack-->"+callBack);
		System.out.println("testResult-->"+testResult);
	}
}
