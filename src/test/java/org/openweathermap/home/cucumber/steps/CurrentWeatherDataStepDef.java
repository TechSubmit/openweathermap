package org.openweathermap.home.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import org.junit.Assert;
import org.openweathermap.home.exchangerateSteps.WeatherAppSteps;

public class CurrentWeatherDataStepDef {
    @Steps
    WeatherAppSteps weatherAppSteps;
    @Given("^I am on Weather Website$")
    public void iAmOnWeatherWebsite() {
        System.out.println("I am on Weather Website");
    }
    @When("^I can get weather of \"([^\"]*)\" city$")
    public void iCanGetWeatherOfCity(String arg0)  {
        weatherAppSteps.getAllResponse(arg0);
    }
    @Then("^I can get status code (\\d+)$")
    public void iCanGetStatusCode(int statusCode) {
        int actualCode = weatherAppSteps.getStatusCode();
        Assert.assertEquals(actualCode, statusCode);
    }
    @And("^I should get weather of london city$")
    public void iShouldGetWeatherOfLondonCity() {
        weatherAppSteps.getCurrentWeather();
    }
    @And("^I can get current visibility condition at london city$")
    public void iCanGetCurrentVisibilityConditionAtLondonCity() {
        System.out.println("visibility="+ weatherAppSteps.currentVisibilityCondition());
    }
    @And("^I can get name of the city$")
    public void iCanGetNameOfTheCity() {
        System.out.println("name="+weatherAppSteps.getName());
    }
}
