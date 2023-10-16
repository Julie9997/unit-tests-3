package seminars.third.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SomeServiceTest {

    SomeService service;

    @BeforeEach
    void setup() {
        service = new SomeService();
    }

   // 3.1.

    @Test
    void multipleThreeNotFiveReturnsFizz() {
        assertEquals(service.fizzBuzz(12), "Fizz");
    }

    @Test
    void multipleFiveNotThreeReturnsBuzz() {
        assertEquals(service.fizzBuzz(10), "Buzz");
    }

    @Test
    void multipleThreeAndFiveReturnsFizzBuzz() {
        assertEquals(service.fizzBuzz(15), "FizzBuzz");
    }

    @Test
    void otherNumberReturnsStringNumber() {
        assertEquals(service.fizzBuzz(7), "7");
    }

    // 3.2
    @Test
    void first6ReturnsTrue() {
        int[] nums = {6, 7, 3};
        assertEquals(service.firstLast6(nums), true);
    }

    @Test
    void last6ReturnsTrue() {
        int[] nums = {5, 7, 3, 6};
        assertEquals(service.firstLast6(nums), true);
    }

    @Test
    void no6ReturnsFalse() {
        int[] nums = {5, 7, 3};
        assertEquals(service.firstLast6(nums), false);
    }

    @CsvSource({"50, 1000", "100, 0", "0, 2000"})
    @ParameterizedTest
    void correctDiscountCalculatingTest(int num, int res) {
        assertThat(service.calculatingDiscount(2000.0, num))
                .isEqualTo(res);
    }

    /**
     * @apiNote Процент скидки больше 100% или меньше 0%
     * @param discount
     */

    @ParameterizedTest
    @ValueSource(ints = {-10, 110})
    void InsufficientDiscountAmountTest(int discount) {
        assertThatThrownBy(() ->
                service.calculatingDiscount(2000.0, discount))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%");
    }

    @Test
    void luckySumFirstTest() {
        assertEquals(service.luckySum(13, 2, 3), 5);
    }

    @Test
    void luckySumBTest() {
        assertEquals(service.luckySum(3, 13, 3), 6);
    }

    @Test
    void luckySumCTest() {
        assertEquals(service.luckySum(3, 3, 13), 6);
    }

    @Test
    void luckySumTest() {
        assertEquals(service.luckySum(3, 3, 3), 9);
    }

    @Test
    void luckySumDoubleTest() {
        assertEquals(service.luckySum(13, 13, 3), 16);
    }
}