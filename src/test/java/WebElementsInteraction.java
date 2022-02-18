import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WebElementsInteraction {

    static WebDriver driver;
    static Actions actions;

    @BeforeAll
    public static void classSetup(){
        System.out.println("Driver setup step for the class");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void testSetup() throws InterruptedException {
        System.out.println("Creating driver instance for the test");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        actions = new Actions(driver);
        Thread.sleep(1000);
    }

    @Test
    public void abTesting() throws InterruptedException {
        getOption("A/B Testing").click();
        Thread.sleep(1000);
    }

    @Test
    public void addRemoveElements() throws InterruptedException {
        getOption("Add/Remove Elements").click();
        Thread.sleep(1000);
    }

    //https://www.browserstack.com/docs/automate/selenium/basic-http-authentication#javascriptexecutor-for-basic-http-authentication
    @Test
    public void basicAuth() throws InterruptedException {
        getOption("Basic Auth").click();
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        Thread.sleep(1000);
    }

    //https://www.lambdatest.com/blog/find-broken-images-using-selenium-webdriver/
    @Test
    public void detectBrokenImages() throws InterruptedException {
        getOption("Broken Images").click();
        List<WebElement> imagesList = driver.findElements(By.xpath("//*[@id=\"content\"]/div/img"));
        imagesList.forEach((image) -> System.out.println(image.getAttribute("naturalWidth")));
        Thread.sleep(1000);
    }

    @Test
    @Disabled
    public void challengingDom(){
        getOption("Broken Images").click();
    }

    //https://www.toolsqa.com/selenium-webdriver/selenium-checkbox/#:~:text=To%20locate%20the%20checkboxes%2C%20we,perform%20select%20or%20click%20operation.&text=the%20web%20page%3A-,This%20way%2C%20we%20can%20select%20a%20Checkbox%20by%20using%20a,using%20the%20%22click%20%22%20operation.
    @Test
    public void checkBoxes() throws InterruptedException {
        getOption("Checkboxes").click();
        //click on first checkbox
        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
        checkboxes.get(0).click();
        //is first checkbox selected
        System.out.println("Is first checkbox selected: "+checkboxes.get(0).isSelected());
        //Is first checkbox displayed
        System.out.println("Is first checkbox displayed: "+checkboxes.get(0).isDisplayed());
        //Is first checkbox enabled
        System.out.println("Is first checkbox enabled: "+checkboxes.get(0).isEnabled());
        Thread.sleep(1000);
    }

    //https://www.guru99.com/double-click-and-right-click-selenium.html#:~:text=Perform%20Right%20Click%20operation%20on,Close%20the%20browser
    @Test
    public void contextMenu() throws InterruptedException {
        getOption("Context Menu").click();
        WebElement hotSpot = driver.findElement(By.id("hot-spot"));
        actions.contextClick(hotSpot).perform();
        Thread.sleep(1000);
    }

    @Test
    public void digestAuthentication() throws InterruptedException {
        getOption("Digest Authentication").click();
        driver.get("http://admin:admin@the-internet.herokuapp.com/digest_auth");
        Thread.sleep(5000);
    }

    @Test
    @Disabled
    public void disappearingElements() throws InterruptedException {
        getOption("Disappearing Elements").click();
        Thread.sleep(1000);
    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        getOption("Drag and Drop").click();
        WebElement elementA = driver.findElement(By.id("column-a"));
        WebElement elementB = driver.findElement(By.id("column-b"));
        //actions.dragAndDrop(elementA,elementB).perform();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
                + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
                + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
                + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
                + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
                + "var dropEvent = createEvent('drop');\n"
                + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                + "var dragEndEvent = createEvent('dragend');\n"
                + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                + "simulateHTML5DragAndDrop(source,destination);", elementA, elementB);
        Thread.sleep(2000);
    }

    //https://www.javatpoint.com/selenium-webdriver-handling-drop-downs
    @Test
    public void dropdown() throws InterruptedException {
        getOption("Dropdown").click();
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(0);
        Thread.sleep(2000);
        dropdown.selectByValue("2");
        Thread.sleep(2000);
        dropdown.selectByVisibleText("Option 1");
        Thread.sleep(2000);
    }

    @Test
    @Disabled
    public void dynamicContent() throws InterruptedException {
        getOption("Dynamic Content").click();
        Thread.sleep(1000);
    }

    @Test
    public void dynamicControls() throws InterruptedException {
        getOption("Dynamic Controls").click();
        WebElement checkbox = driver.findElement(By.id("checkbox"));
        checkbox.click();
        WebElement removeBtn = driver.findElement(By.xpath("//button[contains(text(),'Remove')]"));
        removeBtn.click();
        Thread.sleep(5000);
        WebElement addBtn = driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
        addBtn.click();
        Thread.sleep(5000);
        //checkbox = driver.findElement(By.id("checkbox"));
        checkbox.click();
        Thread.sleep(2000);
    }

    @Test
    @Disabled
    public void dynamicLoading() throws InterruptedException {
        getOption("Broken Images").click();
        Thread.sleep(1000);
    }

    @Test
    public void entryAd() throws InterruptedException {
        getOption("Entry Ad").click();
        Thread.sleep(2000);
        driver.switchTo().activeElement().findElement(By.xpath("//p[contains(text(),'Close')]")).click();
        Thread.sleep(3000);
    }

    @Test
    @Disabled
    public void exitIntent() throws InterruptedException {
        getOption("Broken Images").click();
        Thread.sleep(1000);
    }

    @Test
    @Disabled
    public void fileDownload() throws InterruptedException {
        getOption("Broken Images").click();
        Thread.sleep(1000);
    }

    @Test
    @Disabled
    public void fileUpload() throws InterruptedException {
        getOption("Broken Images").click();
        Thread.sleep(1000);
    }

    @Test
    @Disabled
    public void floatingMenu() throws InterruptedException {
        getOption("Broken Images").click();
        Thread.sleep(1000);
    }

    @Test
    @Disabled
    public void forgotPassword() throws InterruptedException {
        getOption("Broken Images").click();
        Thread.sleep(1000);
    }

    @Test
    @Disabled
    public void formAuthentication() throws InterruptedException {
        getOption("Broken Images").click();
        Thread.sleep(1000);
    }

    @Test
    @Disabled
    public void frames() throws InterruptedException {
        getOption("Broken Images").click();
        Thread.sleep(1000);
    }

    @Test
    @Disabled
    public void geolocation() throws InterruptedException {
        getOption("Broken Images").click();
        Thread.sleep(1000);
    }

    @Test
    @Disabled
    public void horizontalSlider() throws InterruptedException {
        getOption("Broken Images").click();
        Thread.sleep(1000);
    }

    //https://www.browserstack.com/guide/mouse-hover-in-selenium
    @Test
    public void hovers() throws InterruptedException {
        getOption("Hovers").click();
        List<WebElement> images = driver.findElements(By.xpath("//*[@class=\"figure\"]/img"));
        WebElement element = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5"));
        System.out.println(element.isDisplayed());
        actions.moveToElement(images.get(0)).perform();
        Thread.sleep(1000);
        System.out.println(element.isDisplayed());
        Thread.sleep(1000);
        actions.moveToElement(images.get(1)).perform();
        Thread.sleep(1000);
        actions.moveToElement(images.get(2)).perform();
        Thread.sleep(1000);
    }

    @Test
    @Disabled
    public void infiniteScroll() throws InterruptedException {
        getOption("Broken Images").click();
        Thread.sleep(1000);
    }

    @Test
    @Disabled
    public void inputs() throws InterruptedException {
        getOption("Broken Images").click();
        Thread.sleep(1000);
    }

    @Test
    @Disabled
    public void jQueryUIMenus() throws InterruptedException {
        getOption("Broken Images").click();
        Thread.sleep(1000);
    }

    @Test
    @Disabled
    public void javascriptAlerts() throws InterruptedException {
        getOption("JavaScript Alerts").click();
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);
    }

    @Test
    @Disabled
    public void javascriptOnLoadEventError() throws InterruptedException {
        getOption("Broken Images").click();
        Thread.sleep(1000);
    }

    @Test
    @Disabled
    public void keyPresses() throws InterruptedException {
        getOption("Broken Images").click();
        Thread.sleep(1000);
    }

    @Test
    @Disabled
    public void largeAndDeepDOM() throws InterruptedException {
        getOption("Broken Images").click();
        Thread.sleep(1000);
    }

    @Test
    @Disabled
    public void multipleWindows() throws InterruptedException {
        getOption("Broken Images").click();
        Thread.sleep(1000);
    }

    @Test
    @Disabled
    public void nestedFrames() throws InterruptedException {
        getOption("Broken Images").click();
        Thread.sleep(1000);
    }

    @Test
    @Disabled
    public void notificationMessages() throws InterruptedException {
        getOption("Broken Images").click();
        Thread.sleep(1000);
    }

    @Test
    @Disabled
    public void redirectLink() throws InterruptedException {
        getOption("Broken Images").click();
        Thread.sleep(1000);
    }

    @Test
    @Disabled
    public void secureFileDownload() throws InterruptedException {
        getOption("Broken Images").click();
        Thread.sleep(1000);
    }

    @Test
    @Disabled
    public void shadowDom() throws InterruptedException {
        getOption("Broken Images").click();
        Thread.sleep(1000);
    }

    @Test
    @Disabled
    public void shiftingContent() throws InterruptedException {
        getOption("Broken Images").click();
        Thread.sleep(1000);
    }

    @Test
    @Disabled
    public void slowResources() throws InterruptedException {
        getOption("Broken Images").click();
        Thread.sleep(1000);
    }

    @Test
    @Disabled
    public void sortableDataTables() throws InterruptedException {
        getOption("Broken Images").click();
        Thread.sleep(1000);
    }

    @Test
    @Disabled
    public void statusCodes() throws InterruptedException {
        getOption("Broken Images").click();
        Thread.sleep(1000);
    }

    @Test
    @Disabled
    public void typos() throws InterruptedException {
        getOption("Broken Images").click();
        Thread.sleep(1000);
    }

    @Test
    @Disabled
    public void wysiwygEditor() throws InterruptedException {
        getOption("Broken Images").click();
        Thread.sleep(1000);
    }

    @AfterEach
    public void tearDownTest(){
        driver.quit();
        System.out.println("Quiting driver");
    }

    @AfterAll
    public static void tearDownClass() {
        System.out.println("Test class has finished");
    }

    public static WebElement getOption(String text){
        return driver.findElement(By.xpath("//*[text()='"+text+"']"));
    }
}
