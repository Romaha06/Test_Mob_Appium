package PageObject;

import org.openqa.selenium.By;

import static PageObject.Help.TextView;
import static PageObject.Help.app_package_name;

public class TaskListScreen {

    public By taskName = By.id(app_package_name + "task_name");
    public By taskCheckBox = By.id(app_package_name + "checkDone");
    public By toolBar = By.id(app_package_name + "spinnerToolbar");
    public By finishedMenuItem = By.xpath(TextView + "[@text='Finished']");

    public By quickTask = By.id(app_package_name + "etQuickTask");
    public By doneButtonForQuickTask = By.id(app_package_name + "ivAddQuickTask");
    public By allListsMenuItem = By.xpath(TextView + "[@text='All Lists']");
    public By listMain = By.id(app_package_name + "listMain");
}
