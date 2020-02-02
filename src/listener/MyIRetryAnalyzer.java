/**
 * 
 */
package listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author Administrator
 *
 */
public class MyIRetryAnalyzer implements IRetryAnalyzer {
	int reRunTimes = 0 ;
	boolean flag = false ;
	@Override
	public boolean retry(ITestResult result) {
		flag = result.isSuccess();
		if(flag) {
			flag = false ;
		}else {
			if(reRunTimes <1) {
				flag = true ;
				reRunTimes ++ ;
			}
		}
		return flag;
	}
}
