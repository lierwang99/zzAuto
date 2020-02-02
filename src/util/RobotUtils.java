/**
 * 
 */
package util;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

/**
 * @author Administrator
 *
 */
public class RobotUtils {
	
	/**
	 * robot类键盘操作，可以传任意参数
	 * 
	 * @param keys
	 */
	public static void robotOperateKeys(int... keys) {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		for (int x = 0; x < keys.length; x++) {
			robot.keyPress(keys[x]);
			robot.delay(500);
		}

		for (int y = 0; y < keys.length; y++) {
			robot.keyRelease(keys[y]);
			robot.delay(200);
		}
	}
	
	/**
	 * 前提条件：必须把鼠标移动到可以滚动的页面上。
	 * 通过robot类滚动轴，当wheelAmt的值大于零表示向下滚动，值越大向下滚动的越多。 反之向上
	 * @param wheelAmt
	 */
	public static void mouseWheelY(int wheelAmt, int coordinateX, int coordinateY) {
		try {
			Robot rb = new Robot();
			rb.mouseMove(coordinateX, coordinateY);
			rb.delay(500);
			rb.mouseWheel(wheelAmt);
			rb.delay(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过Robot实现的
	 * 以时间命名的截图照片
	 */
	public static void 	createScreenCapture(){
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS");
		String format = simpleDateFormat.format(date);
		File file = new File("H:\\imgs\\"+format+".png");
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(dimension);
		Robot rb = null ;
		try {
			rb = new Robot();
			BufferedImage createScreenCapture = rb.createScreenCapture(rectangle);
			ImageIO.write(createScreenCapture, "png", file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
