/**
 * 
 */
package log;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import test.baidu.Reflect;

/**
 * @author Administrator
 *
 */
public class MyLogger {

	private static String logFilePath = "H:" + File.separator + "logs" + File.separator;
//	控制日志打印等级，默认是接收Logger传过来的所有等级日志
	private static Level HANDLERLEVEL = Level.ALL;

//	private static Level logLevel = Level.INFO;
//	private final static Logger logger = Logger.getLogger(AncestorImpl.class.getName());
	private final static Logger logger = Logger.getGlobal();

	/**
	 * 获得日志文件的路径
	 * 
	 * @return
	 */

	public static String getLogFile() {
		return logFilePath;
	}

	/**
	 * 设置日志文件输出路径
	 * 
	 * @param logFilePath
	 */
	public static void setLogFile(String logFilePath) {
		MyLogger.logFilePath = logFilePath;
	}

	/**
	 * 设置Handler接受日志等级
	 */
	public static void setHandlerLevel(Level level) {
		MyLogger.HANDLERLEVEL = level;
	}

	/**
	 * 获得当前Handler 能够接收的日志等级
	 * 
	 * @return
	 */
	public static Level getHandlerLevel() {
		return HANDLERLEVEL;
	}

	/**
	 * 在控制台输出
	 */
	public static void logToConsole(Level logLevel, String message) {
		/**
		 * 自己设置的consoleHandler
		 */
//		ConsoleHandler consoleHandler = new ConsoleHandler();
//		consoleHandler.setLevel(Level.WARNING);
//		logger.addHandler(consoleHandler);

		// 启用父类的handler,true确定使用。
		logger.setUseParentHandlers(true);
		logger.log(logLevel, message);
	}

	/**
	 * 在文件内输出log
	 */
	public static void logToFile(Class<?> c, String MethodName, String message, Level logLevel) {
		FileHandler fileHandler = null;
		Date date = new Date();
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
			// 得到来源类的名
			lr.setSourceClassName(c.getName());
			lr.setSourceMethodName(MethodName);
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

	/**
	 * 这个方法是获取正在运行的方法的名字
	 */
	public static String getCurrentMethodName() {
		StackTraceElement[] stackTrace = new Exception().getStackTrace();
		String methodName;
		if (stackTrace != null && stackTrace.length > 0) {
			methodName = stackTrace[1].getMethodName();
		}
		StackTraceElement[] stackTrace1 = Thread.currentThread().getStackTrace();
		methodName = stackTrace1[2].getMethodName();
		return methodName;
	}
}
