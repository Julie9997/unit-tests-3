package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainHWTest {
    MainHW mainHW;

    @BeforeEach
    void setup() {
        mainHW = new MainHW();
    }

    // 3.1
    @Test
    void evenNumberTrueTest() {
        assertTrue(mainHW.evenOddNumber(8));
    }

    @Test
    void evenNumberFalseTest() {
        assertFalse(mainHW.evenOddNumber(9));
    }

    // 3.2
    @ParameterizedTest
    @ValueSource(ints = {25, 70, 100})
    void numberInIntervalTrueTest(int n) {
        assertTrue(mainHW.numberInInterval(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {24, 101})
    void numberInIntervalFalseTest(int n) {
        assertFalse(mainHW.numberInInterval(n));
    }
}
