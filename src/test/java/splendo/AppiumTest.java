package splendo;

import PageObject.AddBatchMode;
import PageObject.HomeScreenPage;
import PageObject.PersonalListPage;
import PageObject.TaskListScreenPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class AppiumTest extends AndroidSetup {

    HomeScreenPage homeScreen = new HomeScreenPage(driver);
    TaskListScreenPage taskListScreen = new TaskListScreenPage(driver);
    AddBatchMode addBatchMode = new AddBatchMode(driver);
    PersonalListPage personalList = new PersonalListPage(driver);


    @Test(priority = 1)
    public void showTest() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homeScreen.addFirstTaskButtonclick();
        homeScreen.taskInputSendKey();
        homeScreen.dueDateClick();
        homeScreen.doneButtonClick();
        homeScreen.dueTimeClick();
        homeScreen.doneButtonClick();
        homeScreen.repeatButtonClick();
        homeScreen.repeatButtonOnceAWeekClick();
        homeScreen.addToListButtonClick();
        homeScreen.addToListButtonPersonalClick();
        homeScreen.saveTaskclick();

        wait.until(ExpectedConditions.presenceOfElementLocated(taskListScreen.taskName));

        assert driver.findElement(taskListScreen.taskName).isDisplayed();
    }

    // Complete task
    @Test(priority = 2)
    public void completeTask() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        taskListScreen.taskCheckBoxCkick();
        homeScreen.popUpReapeatTaskNoClick();

        wait.until(ExpectedConditions.presenceOfElementLocated(taskListScreen.toolBar));

        taskListScreen.toolBarClick();
        taskListScreen.finishedMenuItemClick();
        assert driver.findElement(taskListScreen.taskName).isDisplayed();
    }

    @Test(priority = 3)
    public void addQuickTask() {
        taskListScreen.toolBarClick();
        taskListScreen.allListsMenuItemClick();
        taskListScreen.quickTaskClick();
        taskListScreen.quickTaskClickSK();
        taskListScreen.doneButtonForQuickTaskClick();
        assert driver.findElement(taskListScreen.taskName).isDisplayed();
    }

    @Test(priority = 4)
    public void addInBatchMode() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        addBatchMode.moreOptionsClick();
        addBatchMode.addInBatchModeClick();
        addBatchMode.whatIsToBeDoneSK();
        homeScreen.dueDateClick();
        homeScreen.doneButtonClick();

        wait.until(ExpectedConditions.presenceOfElementLocated(homeScreen.saveTask));

        homeScreen.saveTaskclick();
        assert driver.findElement(taskListScreen.taskName).isDisplayed();

        taskListScreen.taskCheckBoxCkick();
        assert driver.findElement(taskListScreen.listMain).isDisplayed();
    }

    @Test(priority = 5)
    public void addTaskToPersonalListTest() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        taskListScreen.allListsMenuItemClick();
        personalList.personalMenuItemClick();
        homeScreen.addNewTaskButtonClick();
        personalList.taskInputPersonalSK();
        homeScreen.dueDateClick();
        homeScreen.doneButtonClick();

        wait.until(ExpectedConditions.presenceOfElementLocated(homeScreen.saveTask));
        homeScreen.saveTaskclick();
        assert driver.findElement(taskListScreen.taskName).isDisplayed();

        taskListScreen.taskCheckBoxCkick();

        wait.until(ExpectedConditions.presenceOfElementLocated(taskListScreen.toolBar));

        taskListScreen.toolBarClick();
        taskListScreen.finishedMenuItemClick();
        assert driver.findElement(taskListScreen.taskName).isDisplayed();
    }
}