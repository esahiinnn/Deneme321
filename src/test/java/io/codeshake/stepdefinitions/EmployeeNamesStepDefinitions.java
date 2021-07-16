package io.codeshake.stepdefinitions;

import io.codeshake.pages.*;
import io.codeshake.utilities.ConfigReader;
import io.codeshake.utilities.Driver;
import io.codeshake.utilities.ReusableMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class EmployeeNamesStepDefinitions {
    HomePage homePage = new HomePage();
    CloudWisePage cloudWisePage = new CloudWisePage();
    DepartmentsPage departmentsPage = new DepartmentsPage();
    AllCloudWisersPage allCloudWisersPage = new AllCloudWisersPage();
    Actions actions = new Actions(Driver.getDriver());
    List<String> employeeNames = new ArrayList<>();

    @Given("User goes to codeshake.io webpage {string}")
    public void userGoesToCodeshakeIoWebpage(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));
    }

    @And("User Scroll down to Meet Our Partner section and Visit their page \\(use link Pay them a visit).")
    public void userScrollDownToMeetOurPartnerSectionAndVisitTheirPageUseLinkPayThemAVisit() {
        //ReusableMethods.scrollToElement(homePage.payThemAVisitButton);
        actions.sendKeys(Keys.END).sendKeys(Keys.PAGE_UP).perform();
        homePage.payThemAVisitButton.click();
        ReusableMethods.switchToWindow(ConfigReader.getProperty("title_of_cloudwisepage"));
    }

    @And("User Goes to This is Cloudwise")
    public void userGoesToThisIsCloudwise() {
        cloudWisePage.acceptCookies.click();
        actions.click(cloudWisePage.thisIsCloudwiseSection).perform();
        Driver.wait(2);

    }

    @And("User Goes to All Cloudwisers")
    public void userGoesToAllCloudwisers() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Driver.wait(3);
        /*String javaScript = "var evObj = document.createEvent('MouseEvents');" +
                "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
                "arguments[0].dispatchEvent(evObj);";
        ((JavascriptExecutor)Driver.getDriver()).executeScript(javaScript, cloudWisePage.allCloudwisersSection);*/
        actions.moveToElement(cloudWisePage.allCloudwisersSection).click(cloudWisePage.meetOurTeamButton).build().perform();
        Driver.wait(2);
        //ReusableMethods.waitForClickablility(cloudWisePage.meetOurTeamButton, 5);
        //cloudWisePage.meetOurTeamButton.click();
    }

    @Then("User clicks on all department links one by one and gets Employee names")
    public void userClicksOnAllDepartmentLinksOneByOneAndGetsEmployeeNames() {
        int k = 1;
        for(int i = 0; i < allCloudWisersPage.allDepartmens.size(); i++){
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            actions.moveToElement(allCloudWisersPage.allDepartmentSessions.get(k)).build().perform();
            Driver.wait(2);
            allCloudWisersPage.allDepartmens.get(i).click();
            Driver.wait(2);
            for(int j = 0; j<departmentsPage.employeeNames.size(); j++){
                employeeNames.add(departmentsPage.employeeNames.get(j).getText());
            }
            Driver.getDriver().navigate().back();
            k+=2;
        }
    }

    @And("User lists all employees that have the same name")
    public void userListsAllEmployeesThatHaveTheSameName() {
        for(String w: employeeNames){
            System.out.println(w);
        }
    }

    public static void main(String[] args) {
        String str = "Java code yaz";
        System.out.println(str.substring(8,8));
    }
}
