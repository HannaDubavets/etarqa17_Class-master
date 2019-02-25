package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.TestBase;

public class TeamDeleteTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getSessionHelper().isUserLoggedIn()) {
            app.getSessionHelper().login();
        }
    }

    @Test
    public void TeamDeleteFromLeftNavMenu() {

        //int before = app.getBoardHelper().PersonalBoardsCount();

        app.getTeamHelper().clickOnTeamForDelete(By.xpath("//div//nav[@class='home-left-sidebar-container']//div[2]//ul[1]//li[1]//a[1]//span[2]  \n"));
        app.getTeamHelper().clickOnSettingsButton();
        app.getTeamHelper().ckickOnDeletButton();
        app.getTeamHelper().submitDeleteTeam();
        //app.getTeamHelper().clickOnPageBack();

        //int after1 = app.getBoardHelper().PersonalBoardsCount();

        //Assert.assertEquals(after1, before-1);

    }


}
