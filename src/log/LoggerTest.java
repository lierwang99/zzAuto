/**
 * 
 */
package log;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @author Administrator
 *
 */
public class LoggerTest {

	private static String logFilePath = "H:" + File.separator + "logs" + File.separator;
	private final static Logger logger = Logger.getGlobal();
	private static Level HANDLERLEVEL = Level.ALL;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MyLogger.logToFile(Date.class, "log", "ABC", Level.FINE);

	}
	public static void logToFile(Class<?> c, String MethodName, String message, Level logLevel) {
		FileHandler fileHandler = null;
		java.util.Date date = new java.util.Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String fileName = simpleDateFormat.format(date);
		File file = new File(logFilePath + fileName + ".log");
		// 追加日志信息
		try {
			fileHandler = new FileHandler(file.getAbsolutePath(), true);
			SimpleFormatter simpleFormatter = new SimpleFormatter();
			
//			设置不使用父Handler
			logger.setUseParentHandlers(false);

			LogRecord lr = new LogRecord(logLevel, message);
			lr.setMillis(date.getTime());
			lr.setParameters(new Object[] {111,342});
			// 得到来源类的名
			lr.setSourceClassName(c.getName());
			lr.setSourceMethodName(MethodName);
			simpleFormatter.formatMessage(lr);
			fileHandler.setFormatter(simpleFormatter);
//			设置Handler接受的日志等级
			fileHandler.setLevel(HANDLERLEVEL);
			logger.setLevel(logLevel);
//			publish 方法也会对日志信息进行输出，造成重复输出的现象
//			fileHandler.publish(lr);
			logger.addHandler(fileHandler);

//			设置过滤器
			logger.setFilter(new MyLogFilter());
			logger.log(lr);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Handler[] handlers = logger.getHandlers();
			if (handlers != null) {
				for (Handler h : handlers) {
					h.close();
					logger.removeHandler(h);
				}
			}
		}
	}

}
