package in.swiggy.teststeps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import in.swiggy.pages.SwiggyMain;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class SwiggyTestSteps {
    private SwiggyMain swiggyMain;

    @Given("I am on the Swiggy website")
    public void openSwiggyWebsite() {
        swiggyMain = new SwiggyMain();
        
    }

    @When("I enter my delivery location as {string}")
    public void enterDeliveryLocation(String location) {
        swiggyMain.enterDeliveryLocation(location);
    }
    @And("I select a restaurant")
    public void selectRestaurant() {
        swiggyMain.selectRestaurant();
    }

    @And("I select the first dish available")
    public void selectFirstDish() {
        swiggyMain.selectFirstDish();
    }

    @And("I add the dish to the cart")
    public void addToCart() {
        swiggyMain.addToCart();
    }

    @And("I click on the cart icon to check out")
    public void clickCheckout() {
        swiggyMain.clickCheckout();
    }

    @Then("I should see the message to log in or sign up")
    public void verifyLoginSignUpMessage() {
        swiggyMain.verifyLoginSignUpMessage();
    }
}


	

