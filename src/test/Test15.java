/**
 * 
 */
package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * @author Administrator
 *
 */
//@Listeners(org.uncommons.reportng.HTMLReporter.class)
@Listeners({listener.MyExtendReporter.class})
public class Test15 {
     
    @DataProvider
    public Object[][] dataProvider(){
        return new Object[][]{{1},{2}};
    }
     
    @Test(dataProvider="dataProvider")
    public void testAssert1(int a){
        Assert.assertEquals(1, a);
    }  
     
    @Test
    public void testAssert2(){ 
        Assert.assertEquals("2", "2"); 
    }
    @Test
    public void testAssert3(){ 
        Assert.assertEquals("2", "2"); 
    }
    @Test
    public void testAssert4(){ 
        Assert.assertEquals("2", "6");
        
    }
    @Test(invocationCount = 3)
    public void testAssert5(){ 
        Assert.assertEquals("1", "2"); 
    }
}
