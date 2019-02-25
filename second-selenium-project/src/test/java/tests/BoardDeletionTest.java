package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTest extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getSessionHelper().isUserLoggedIn()) {
            app.getSessionHelper().login();
        }
    }

    @Test
    public void BoardDeletionfromBody(){

        int before = app.getBoardHelper().PersonalBoardsCount();

        app.getBoardHelper().clickOnBoardForDeletion();
        app.getBoardHelper().clickOnMoreButton();
        app.getBoardHelper().clickOnCloseBoardButton();
        app.getBoardHelper().clickOnConfirmDeletionBoard();
        app.returnToPreviousPage();

        int after = app.getBoardHelper().PersonalBoardsCount();

        Assert.assertEquals(after, before-1);


    }
}
