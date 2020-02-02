/**
 * 
 */
package listener;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

/**
 * @author Administrator
 *
 */
public class MyIAnnotationTransformer implements IAnnotationTransformer {
	@Override
	public void transform(ITestAnnotation annotation, java.lang.Class testClass,java.lang.reflect.Constructor testConstructor, java.lang.reflect.Method testMethod) {
		String name = testMethod.getName();
		System.out.println("正在调用的方法：" + name);
		if(name.contains("pr")) {
			annotation.setEnabled(false);
		}

	}
}
