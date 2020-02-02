/**
 * 
 */
package listener;

import org.testng.ISuite;
import org.testng.ISuiteListener;

/**
 * @author Administrator
 *
 */
public class MyISuiteListener implements ISuiteListener {
	@Override
	public void onFinish(ISuite suite) {
		System.out.println("suite - onFinish！！\n\n");
	}
	@Override
	public void onStart(ISuite suite) {
		System.out.println("suite - onStart！！\n\n");
	}
}
