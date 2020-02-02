/**
 * 
 */
package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Administrator
 *
 */
public class PropertiesUtils {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws Exception {

		/*
		 * Scanner sc = new Scanner(System.in, "UTF-8"); while (true) { String next =
		 * sc.next(); // boolean hasNext = sc.hasNextLine(); // if(!hasNext) {
		 * System.out.println("您输入的是：" + next); // }
		 * 
		 * }
		 */

		Properties prop = new Properties();
		System.out.println(prop);//{}
		prop.setProperty("姓名", "张三");
		String property = prop.getProperty("姓名");//张三
		Object object = prop.get("姓名");//张三
		FileInputStream fileInputStream = new FileInputStream("files/123.properties");
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");
		prop.load(inputStreamReader);
		Object object2 = prop.get("name");
		System.out.println(object2);

		prop.setProperty("姓名", "张三");
		prop.setProperty("年龄", "三8");
		prop.setProperty("名", "张2");
		FileWriter fw = null;
		try {
			fw = new FileWriter("files/123.properties", false);
			prop.store(fw, "===");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fw != null) {
				fw.close();
			}

		}
	}

//	public static String getRandom(String src, int len) {
//		String str = "";
//		if (src == null) {
//			return str;
//		}
//		if (len <= 0 || len > src.length()) {
//			return str;
//		}
//		Set<Integer> set = new TreeSet<>();
//		Date date = new Date();
//		long time = date.getTime();
//		Random random = new Random();
//		random.setSeed(time);
//		while (true) {
//			int nextInt = random.nextInt(src.length());
//			set.add(nextInt);
//			if (set.size() == len) {
//				break;
//			}
//		}
//		for (int i : set) {
//			str += src.charAt(i);
//		}
//		return str;
//	}
//
//	public static String getRandom2(String src, int len) {
//		String str = "";
//		if (src == null) {
//			return str;
//		}
//		if (len <= 0 || len > src.length()) {
//			return str;
//		}
//		Set<String> set = new TreeSet<>();
//		Date date = new Date();
//		long time = date.getTime();
//		Random random = new Random();
//		random.setSeed(time);
//		while (true) {
//			int nextInt = random.nextInt(src.length());
//			String temp = String.valueOf(src.charAt(nextInt));
//			set.add(temp);
//			if (set.size() == len) {
//				break;
//			}
//		}
//		for (String i : set) {
//			str += i;
//		}
//		return str;
//	}

}
