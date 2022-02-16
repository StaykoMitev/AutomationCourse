import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@SelectClasses({TestBeforeAfter.class, Tests.class})
@IncludeTags("smoke")
@Suite
public class SuiteExample {
}