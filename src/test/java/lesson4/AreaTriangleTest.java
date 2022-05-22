package lesson4;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AreaTriangleTest {
    private static final Logger logger = LoggerFactory.getLogger(AreaTriangleTest.class);

    @BeforeAll
    static void beforeAll() {
        logger.info("INFO");
    }

    @ParameterizedTest
    @DisplayName("Позитивные тесты вычисления площади")
    @CsvSource({
            "16, 22, 16, 127.80845042484475",
            "3, 4, 5, 6.0",
            "200, 0, 200, 0.0",
            "169, 202, 136, 11385.17955227321",
            "1, 3, 4, 0.0"
    })
    void givenCorrectDataForAreaCalculation(int a, int b, int c, double squ) {
        Assertions.assertEquals(AreaTriangle.heronsFormula(a, b, c), squ);
    }

    @ParameterizedTest
    @DisplayName("Негативные тесты вычисления площади")
    @CsvSource({
            "16, 22, -16",
            "-300, -150, -200",
            "169, -202, -136",
            "3, 4, 34",
            "1, 0, 2"
    })
    void givenIncorrectDataForAreaCalculation(int a, int b, int c) {
        Assertions.assertTrue(Double.isNaN(AreaTriangle.heronsFormula(a, b, c)));
    }
}
