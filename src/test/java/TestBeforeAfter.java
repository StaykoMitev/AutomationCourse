import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utilities.PropertiesLoader;

@Tag("smoke")
public class TestBeforeAfter {
    @Test
    @Tag("P1")
    void test1() {
        System.out.println("test_1");
    }

    @Test
    @Tag("P1")
    void test2() {
        System.out.println("test_2");
    }


    @Test
    @Tag("hr")
    @Tag("people")
    @Tag("P2")
    @Tag("TL-123")
    void test3() {
        System.out.println("test_3");
    }

    @Test
    @Tag("hr")
    void test4() {
        System.out.println("test_4");
    }

    @Test
    @Tag("hr")
    @Tag("onboarding")
    void test5() {
        System.out.println("test_5");
    }

    @Test
    @Tag("hr")
    @Tag("onboarding")
    void test6() {
        System.out.println("test_6");
    }

    @BeforeEach
    void beforeMethod() {
        System.out.println("Will be executed before each method");
        PropertiesLoader.loadProperties();
        String brrowser = PropertiesLoader.prop.getProperty("browser");
        System.out.println("Browser is: "+brrowser);
    }

    @AfterEach
    void afterMethod() {
        System.out.println("Will be executed after each method");
    }

    @BeforeAll
    static void beforeClass() {
        System.out.println("Will be executed only ONCE in the beginning of the execution.");
    }

    @AfterAll
    static void afterClass() {
        System.out.println("Will be executed only ONCE after all the tests.");
    }
}
