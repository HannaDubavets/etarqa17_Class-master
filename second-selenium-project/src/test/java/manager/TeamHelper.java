package manager;

import model.Team;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeamHelper extends HelperBase{
  private WebDriver wd;

  public TeamHelper(WebDriver wd) {
    super(wd);
  }


  public void clickOnCreateTeamButtonOnNavMenu() {
    click(By.cssSelector("[data-test-id='home-navigation-create-team-button']"));
  }

  public void fillTeamCreationForm(Team team) {
    type(By.id("org-display-name"), team.getTeamName());
    type(By.id("org-desc"), team.getDescription());
  }

  public void submitTeamCreationForm() {
    click(By.xpath("//*[@value='Create']"));
  }

  public void clickOnTeamForDelete(By locator) {
    click(locator);
  }
  public void clickOnSettingsButton() {
    click(By.xpath("//span[contains(text(),'Settings')]"));
  }
  public void ckickOnDeletButton() {
    click(By.xpath("//div[@class='window-module u-gutter']"));

  }

  public void submitDeleteTeam() {
    click(By.xpath("//input[@value='Delete Forever']"));

  }


}
