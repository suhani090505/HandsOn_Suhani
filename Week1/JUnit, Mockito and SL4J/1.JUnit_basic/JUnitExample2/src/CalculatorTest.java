import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    Calculator cal=new Calculator();
    @Test
    public void testAdd(){
        assertEquals(50,cal.add(20,30));
    }
    @Test
    public void testSub(){
        assertEquals(10,cal.sub(30,20));
    }
    @Test
    public void testMul(){
        assertEquals(60,cal.mul(2,30));
    }
    @Test
    public void testDiv(){
        assertEquals(2,cal.div(30,30));
    }
}
