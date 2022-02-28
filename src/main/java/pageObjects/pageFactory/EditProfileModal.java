package pageObjects.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EditProfileModal {

    WebDriver driver;

    public EditProfileModal(WebDriver driver){
        this.driver=driver;
        //Initialise Elements Page Factory
        PageFactory.initElements(driver, this);
    }
}
