package io.codeshake.pages;

import io.codeshake.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CloudWisePage {
    public CloudWisePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = ("//*[text()='This is Cloudwise']"))
    public WebElement thisIsCloudwiseSection;

    @FindBy(xpath = ("//*[text()='Meet our team']"))
    public WebElement meetOurTeamButton;

    @FindBy(xpath = ("(//div[@class='inner'])[1]"))
    public WebElement allCloudwisersSection;

    @FindBy(id = "CybotCookiebotDialogBodyLevelButtonAccept")
    public WebElement acceptCookies;


}
