import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Tag("smoke")
public class Tests {

    @Test
    void test1() {
        System.out.println("test_1");
    }

    @ParameterizedTest
    @ValueSource(strings = {"cali", "bali", "dani" })
    void test2(String str) {
        System.out.println("test_2");
        assertTrue(str.endsWith("i"));
    }

    @Test
    @DisplayName("Custom name")
    void test3() {
        System.out.println("test_3");
    }

    @RepeatedTest(value = 5, name = "{currentRepetition}/{totalRepetitions}")
    void test4(RepetitionInfo repInfo, TestInfo testInfo) {
        System.out.println("test_4");
        int i = 3;

        System.out.println(testInfo.getDisplayName() + "-->" + repInfo.getCurrentRepetition());
        assertEquals(1, 1);
//        Assertions.assertEquals(repInfo.getCurrentRepetition(), i);
    }

    @Test
    @Tag("login")
    void test5() {
        System.out.println("test_5");
    }

    @Test
    @Tag("search")
    void test6() {
        System.out.println("test_6");
    }

    @Test
    @Tag("assert")
    void test7() {
        String firstName = null;

        System.out.println("test_7");
        assertEquals(2, 1+1, "error");
        assertTrue(2 == 2, "Error");
        assertAll("Check all names",
                  () -> assertEquals("Jane", "Jane"),
                  () -> assertEquals("Doe", "Doe")
        );

        assertNull(firstName);
        assertNotNull(firstName);

        // The following assertion fails with an error message similar to:
        // execution exceeded timeout of 10 ms by 91 ms
        assertTimeout(ofMillis(10), () -> {
            // Simulate task that takes more than 10 ms.
            Thread.sleep(100);
        });
    }

    @BeforeAll
    static void beforeClass() {
        System.out.println("Before All tests, will be executed once.");
    }

    @BeforeEach
    void beforeEachTest() {
        System.out.println("Before Each Test");
    }

    @AfterEach
    void afterEachTest() {
        System.out.println("After Each Test");
        System.out.println("=====================");
    }
}
