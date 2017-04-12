package com.test.steps;

import com.test.Pages.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by S430030 on 04/04/2017.
 */
public class HomeSteps {
    private final Logger LOG = LoggerFactory.getLogger(HomeSteps.class);
    HomePage homePage = new HomePage();

    @Given("^User on the login page$")
    public void i_am_on_the_login_page() throws Exception {
        homePage.i_am_on_the_login_page();
    }


    @Then("^User random items to the list$")
    public void iAddRandomItemsToTheList() throws Throwable {
        homePage.iAddRandomItemsToTheList();
    }

    @Then("^User added items should display$")
    public void userAddedItemsShouldDisplay() throws Throwable {
        homePage.userAddedItemsShouldDisplay();
    }

    @When("^User Selects new list \"([^\"]*)\"$")
    public void userSelectsNewList(String arg0) throws Throwable {
        homePage.userSelectsNewList(arg0);
    }
}
