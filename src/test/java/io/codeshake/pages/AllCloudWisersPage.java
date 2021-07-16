package io.codeshake.pages;

import io.codeshake.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AllCloudWisersPage {
    public AllCloudWisersPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = ("//*[text()='This is Cloudwise']"))
    public WebElement thisIsCloudwiseSection;

    @FindBy(xpath = ("//div[@class='inner']/a"))
    public List<WebElement> allDepartmens;

    @FindBy(xpath = ("//div[@class='inner']"))
    public List<WebElement> allDepartmentSessions;
}
