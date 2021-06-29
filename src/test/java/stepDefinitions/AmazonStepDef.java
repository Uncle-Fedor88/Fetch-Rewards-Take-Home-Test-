package stepDefinitions;

import utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import stepDefinitions.methods.AmazonGoldMethods;


public class AmazonStepDef {

    WebDriver driver = Driver.getDriver();
    AmazonGoldMethods amazonGoldMethods = new AmazonGoldMethods();


    @Given("user navigates to {string}")
    public void user_navigates_to(String amazonGoldTaskLink) {
        driver.navigate().to(amazonGoldTaskLink);
    }


    @When("user inserts gold to the left and right bowls and finds empty gold")
    public void user_inserts_gold_to_the_left_and_right_bowls_and_finds_empty_gold() {
        amazonGoldMethods.userInsertsGoldToTheLeftAndRightBowlsAndFindsEmptyGold();
    }


    @Then("user press on empty gold and validates alert message {string}")
    public void user_press_on_empty_gold_and_validates_alert_message(String expectedAlert) {
        amazonGoldMethods.userPressOnEmptyGoldAndValidatesAlertMessage(expectedAlert);
    }
}
