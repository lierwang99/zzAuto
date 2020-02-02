/**
 * 
 */
package log;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

/**
 * @author Administrator
 *
 */
public class MyLogFilter implements Filter{

	@Override
	public boolean isLoggable(LogRecord lr) {
		boolean flag = false ;
		if(lr.getMessage().contains("123")) {
			return flag ;
		}
		return !flag;
	}

}
