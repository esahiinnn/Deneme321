package io.codeshake.runner;

import io.codeshake.utilities.Driver;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"html:target/default-cucumber-reports"},
        features="src/test/resources/features",
        glue= "stepdefinitions",
        dryRun = false
)

public class Runner {

    public void deleteChars(WebElement element){
        Actions actions = new Actions(Driver.getDriver());
        for(int i = 0; i<element.getText().length(); i++){
            actions.sendKeys(Keys.DELETE).perform();
        }
    }
}


