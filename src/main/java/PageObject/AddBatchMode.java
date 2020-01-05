package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static PageObject.Help.TextView;
import static PageObject.Help.app_package_name;

public class AddBatchMode {

    WebDriver driver;

    public By moreOptions = By.xpath("//android.widget.ImageView[@content-desc=\"More options\"]");
    public By addInBatchMode = By.xpath(TextView + "[@text='Add in Batch Mode']");
    public By whatIsToBeDone = By.id(app_package_name + "edtTaskName");

    public AddBatchMode(WebDriver driver){
        this.driver = driver;
    }

    public void moreOptionsClick(){
        driver.findElement(moreOptions).click();
    }

    public void addInBatchModeClick(){
        driver.findElement(addInBatchMode).click();
    }

    public void whatIsToBeDoneSK() {
        driver.findElement(whatIsToBeDone).sendKeys("test task done");
    }
}
