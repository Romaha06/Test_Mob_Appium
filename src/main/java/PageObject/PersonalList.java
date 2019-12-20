package PageObject;

import org.openqa.selenium.By;

import static PageObject.Help.TextView;
import static PageObject.Help.app_package_name;

public class PersonalList {

    public By PersonalMenuItem = By.xpath(TextView + "[@text='Personal']");
    public By taskInputPersonal = By.id(app_package_name + "edtTaskName");
}
