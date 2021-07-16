package io.codeshake.pages;

import io.codeshake.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = ("(//span[@class='qodef-btn-text'])[2]"))
    public WebElement payThemAVisitButton;



}
