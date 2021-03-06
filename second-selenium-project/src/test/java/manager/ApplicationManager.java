package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import tests.TestBase;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  SessionHelper sessionHelper;
  BoardHelper boardHelper;
  TeamHelper teamHelper;
  EventFiringWebDriver wd;
  String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void start() {
    if (browser.equals(BrowserType.CHROME)) {
      wd= new EventFiringWebDriver( new ChromeDriver());
    } else if (browser.equals(BrowserType.FIREFOX)) {
      wd = new EventFiringWebDriver(new FirefoxDriver());
    } else if (browser.equals(BrowserType.EDGE)){
      wd = new EventFiringWebDriver(new EdgeDriver());
    } else if (browser.equals(BrowserType.IE)){
      wd = new EventFiringWebDriver(new InternetExplorerDriver());
    }
    wd.register(new TestBase.MyListener());

    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wd.manage().window().maximize();
    openSite("https://trello.com");
    sessionHelper = new SessionHelper(wd);
    boardHelper = new BoardHelper(wd);
    teamHelper = new TeamHelper(wd);
  }

  public void stop() {
    wd.quit();
  }

  public void openSite(String url) {
    wd.get(url);
  }


  public void returnToPreviousPage() {
    wd.navigate().back();
  }

  public void clickOnPlusButtonOnHeader() {
    boardHelper.click(By.cssSelector("div.header-user .icon-add"));
  }

  public BoardHelper getBoardHelper() {
    return boardHelper;
  }

  public TeamHelper getTeamHelper() {
    return teamHelper;
  }

  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }

  //public void clickOnTeamForDelete(By locator) {
  //  boardHelper.click(locator);
 // }

 // public void clickOnSettingsButton() {
   // boardHelper.click(By.xpath("//span[contains(text(),'Settings')]"));
 // }

  //public void ckickOnDeletButton() {
   // boardHelper.click(By.xpath("//div[@class='window-module u-gutter']"));

  //}

 // public void submitDeleteTeam() {
  //  boardHelper.click(By.xpath("//input[@value='Delete Forever']"));

 // }
}
