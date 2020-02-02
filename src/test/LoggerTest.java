/**
 * 
 */
package test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import test.baidu.Reflect;

import log.MyLogFilter;
import log.MyLogger;
import project.AncestorImpl;

/**
 * @author Administrator
 *
 */
public class LoggerTest {
	public static void main(String[] args) {
		Level handlerLevel = MyLogger.getHandlerLevel();
		System.out.println(handlerLevel);
		MyLogger.logToFile(LoggerTest.class, "abc", "第一条信息", Level.INFO);
		MyLogger.logToFile(LoggerTest.class, "abc", "第一条信息", Level.CONFIG);
		MyLogger.logToFile(LoggerTest.class, "abc", "第一条信息", Level.SEVERE);
		MyLogger.logToFile(LoggerTest.class, "abc", "第一条信息", Level.FINE);
		
		
	}

}
