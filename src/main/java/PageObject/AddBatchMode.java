package PageObject;

import org.openqa.selenium.By;

import static PageObject.Help.TextView;
import static PageObject.Help.app_package_name;

public class AddBatchMode {

    public By moreOptions = By.xpath("//android.widget.ImageView[@content-desc=\"More options\"]");
    public By addInBatchMode = By.xpath(TextView + "[@text='Add in Batch Mode']");
    public By whatIsToBeDone = By.id(app_package_name + "edtTaskName");
}
