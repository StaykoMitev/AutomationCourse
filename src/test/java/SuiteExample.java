import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@SelectClasses({Tests.class})
@IncludeTags("smoke")
@Suite
public class SuiteExample {
}