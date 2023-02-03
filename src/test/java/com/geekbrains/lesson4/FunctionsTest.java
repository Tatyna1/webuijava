package com.geekbrains.lesson4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

import static com.geekbrains.lesson4.Functions.isPalindrome;

public class FunctionsTest {
    private static Logger logger = LoggerFactory.getLogger("FunctionsTest");

    @BeforeAll
    static void beforeAll() {
        logger.info("Метод выплняется один раз перед всеми тестами класса");
    }

    @BeforeEach
    void beforeEach() {
//        WebDriver driver = new ChromeDriver();
        logger.error("Метод выполнится перед каждым тестом класса");
        }

    @Test
    @DisplayName("Метод проверки палиндрома с нечетным количеством символов")
    void givenPalindromeWhenCallisPalindromeMethodThenTrue() {
        boolean result = isPalindrome("1234321");
        Assertions.assertTrue(result);
//        Assertions.assertEquals(true, result);
    }

    @Test
    @DisplayName("Метод проверки палиндрома с четным количеством символов")
    void palindromeTest() {
        boolean result = isPalindrome("123321");
        Assertions.assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123321", "1235321"})
    void isPalindromeTestWithDataProvider(String word){
        boolean result = isPalindrome(word);
        Assertions.assertTrue(result);
    }
    @ParameterizedTest
    @CsvSource({"123, false", "123321, true"})
    void  csvTest(String word, boolean expectedResult) {
        boolean actualResult = isPalindrome(word);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @MethodSource("catAndAgeDataProvider")
    void catEqualAgeTest(Cat cat, Integer age) {
        Assertions.assertEquals(cat.getAge(), age);
    }

    private static Stream<Arguments> catAndAgeDataProvider(){
        return Stream.of(
                Arguments.of(new Cat("Test1", 10), 10),
                Arguments.of(new Cat("Test2", 11), 11),
                Arguments.of(new Cat("Test3", 12), 12)
        );
    }

    @AfterEach
    void afterEach() {
//        driver.quit();
        System.out.println("Метод выполнится 1 раз после каждого теста");
    }

//    @AfterAll
//            System.out.println("Метод выполнится 1 раз после всех типов класса");
//
//    }


}
