import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@SelectClasses({SkilloTestsPropertiesFile.class,SkilloTestsYamlFile.class})
@ExcludeTags("P1")
@Suite
public class SuiteExample {
}