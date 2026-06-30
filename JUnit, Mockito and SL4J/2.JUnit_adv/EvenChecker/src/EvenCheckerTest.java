import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EvenCheckerTest {

    EvenChecker evenChecker = new EvenChecker();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 7, 10})
    void testEvenNumbers(int number) {
        assertTrue(evenChecker.isEven(number));
    }
}