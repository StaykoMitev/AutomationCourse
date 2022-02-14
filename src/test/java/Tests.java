import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Tests {

    @Test
    void test1() {
        System.out.println("test_1");
    }

    @ParameterizedTest
    @ValueSource(strings = {"cali", "bali", "dani" })
    void test2(String str) {
        assertTrue(str.endsWith("i"));
    }

    @Test
    @DisplayName("Custom name")
    void test3() {
        System.out.println("test_3");
    }

    @RepeatedTest(value = 5, name = "{currentRepetition}/{totalRepetitions}")
    void test4(RepetitionInfo repInfo, TestInfo testInfo) {
        int i = 3;

        System.out.println(testInfo.getDisplayName() + "-->" + repInfo.getCurrentRepetition());
        Assertions.assertEquals(1, 1);
//        Assertions.assertEquals(repInfo.getCurrentRepetition(), i);
    }

//    @BeforeEach
    void beforeEachTest() {
        System.out.println("Before Each Test");
    }

//    @AfterEach
    void afterEachTest() {
        System.out.println("After Each Test");
        System.out.println("=====================");
    }
}
