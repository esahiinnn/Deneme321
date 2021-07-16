package io.codeshake.pages;

import io.codeshake.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DepartmentsPage {

    public DepartmentsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = ("//div[@class='inner']/h3"))
    public List<WebElement> employeeNames;


}
