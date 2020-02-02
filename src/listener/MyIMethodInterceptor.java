/**
 * 
 */
package listener;

import java.util.Iterator;
import java.util.List;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

/**
 * @author Administrator
 *
 */
public class MyIMethodInterceptor implements IMethodInterceptor{

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		Iterator<IMethodInstance> iterator = methods.iterator();
		while(iterator.hasNext()) {
			IMethodInstance next = iterator.next();
			System.out.println("IMethodInstance--->"+next);
		}
		
		
		
		return methods;
	}

}
