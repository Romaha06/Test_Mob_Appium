package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static PageObject.Help.TextView;
import static PageObject.Help.app_package_name;

public class PersonalListPage {

    WebDriver driver;

    public By PersonalMenuItem = By.xpath(TextView + "[@text='Personal']");
    public By taskInputPersonal = By.id(app_package_name + "edtTaskName");


    public PersonalListPage(WebDriver driver) {
        this.driver = driver;
    }

    public void  personalMenuItemClick(){
        driver.findElement(PersonalMenuItem).click();
    }

    public void taskInputPersonalSK(){
        driver.findElement(taskInputPersonal).sendKeys("Do massage");
    }
}
