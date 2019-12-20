package splendo;

import PageObject.AddBatchMode;
import PageObject.HomeScreen;
import PageObject.PersonalList;
import PageObject.TaskListScreen;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


public class AppiumTest extends AndroidSetup {

    HomeScreen homeScreen = new HomeScreen();
    TaskListScreen taskListScreen = new TaskListScreen();
    AddBatchMode addBatchMode = new AddBatchMode();
    PersonalList personalList = new PersonalList();


    @Test(priority = 1)
    public void showTest() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(homeScreen.addFirstTaskButton).click();
        driver.findElement(homeScreen.taskInput).sendKeys("test task");
        driver.findElement(homeScreen.dueDate).click();
        driver.findElement(homeScreen.doneButton).click();
        driver.findElement(homeScreen.dueTime).click();
        driver.findElement(homeScreen.doneButton).click();
        driver.findElement(homeScreen.repeatButton).click();
        driver.findElement(homeScreen.repeatButtonOnceAWeek).click();
        driver.findElement(homeScreen.addToListButton).click();
        driver.findElement(homeScreen.addToListButtonPersonal).click();
        driver.findElement(homeScreen.saveTask).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(taskListScreen.taskName));

        assert driver.findElement(taskListScreen.taskName).isDisplayed();
    }

    // Complete task
    @Test(priority = 2)
    public void completeTask() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElement(taskListScreen.taskCheckBox).click();
        driver.findElement(homeScreen.popUpReapeatTaskNo).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(taskListScreen.toolBar));

        driver.findElement(taskListScreen.toolBar).click();
        driver.findElement(taskListScreen.finishedMenuItem).click();
        assert driver.findElement(taskListScreen.taskName).isDisplayed();
    }

    @Test(priority = 3)
    public void addQuickTask() {
        driver.findElement(taskListScreen.toolBar).click();
        driver.findElement(taskListScreen.allListsMenuItem).click();
        driver.findElement(taskListScreen.quickTask).click();
        driver.findElement(taskListScreen.quickTask).sendKeys("test task");
        driver.findElement(taskListScreen.doneButtonForQuickTask).click();
        assert driver.findElement(taskListScreen.taskName).isDisplayed();
    }

    @Test(priority = 4)
    public void addInBatchMode() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElement(addBatchMode.moreOptions).click();
        driver.findElement(addBatchMode.addInBatchMode).click();
        driver.findElement(addBatchMode.whatIsToBeDone).sendKeys("test task done");
        driver.findElement(homeScreen.dueDate).click();
        driver.findElement(homeScreen.doneButton).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(homeScreen.saveTask));

        driver.findElement(homeScreen.saveTask).click();
        assert driver.findElement(taskListScreen.taskName).isDisplayed();

        driver.findElement(taskListScreen.taskCheckBox).click();
        assert driver.findElement(taskListScreen.listMain).isDisplayed();
    }

    @Test(priority = 5)
    public void addTaskToPersonalListTest()  {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElement(taskListScreen.allListsMenuItem).click();
        driver.findElement(personalList.PersonalMenuItem).click();
        driver.findElement(homeScreen.addNewTaskButton).click();
        driver.findElement(personalList.taskInputPersonal).sendKeys("Do massage");
        driver.findElement(homeScreen.dueDate).click();
        driver.findElement(homeScreen.doneButton).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(homeScreen.saveTask));
        driver.findElement(homeScreen.saveTask).click();
        assert driver.findElement(taskListScreen.taskName).isDisplayed();

        driver.findElement(taskListScreen.taskCheckBox).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(taskListScreen.toolBar));

        driver.findElement(taskListScreen.toolBar).click();
        driver.findElement(taskListScreen.finishedMenuItem).click();
        assert driver.findElement(taskListScreen.taskName).isDisplayed();
    }
}