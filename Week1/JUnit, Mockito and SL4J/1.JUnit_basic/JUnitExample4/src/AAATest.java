import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AAATest {

    Calculator calculator;

    // Setup Method
    @Before
    public void setUp() {
        System.out.println("Setup: Creating Calculator object");
        calculator = new Calculator();
    }

    // Test Method using AAA Pattern
    @Test
    public void testAddition() {

        // Arrange
        int a = 10;
        int b = 20;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(30, result);
    }

    @Test
    public void testSubtraction() {

        // Arrange
        int a = 20;
        int b = 10;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(10, result);
    }

    // Teardown Method
    @After
    public void tearDown() {
        System.out.println("Teardown: Test Completed");
    }
}