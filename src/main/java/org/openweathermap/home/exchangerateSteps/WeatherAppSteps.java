package org.openweathermap.home.exchangerateSteps;


import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.openweathermap.home.constants.EndPoints;


import java.util.HashMap;


public class WeatherAppSteps {

  ValidatableResponse response;

    @Step("Getting Weather for London Uk")
    public void getAllResponse(String city){
        String authKEY = "08e1844ea1fc70bf21947eb5e9fb817c";
        HashMap<String, Object> queryParameter = new HashMap<>();
        queryParameter.put("q", city);
        queryParameter.put("appid", authKEY);

       response = SerenityRest.rest()
                .given()
                .queryParams(queryParameter).log().all()
                .when()
                .get(EndPoints.GET_WEATHER)
                .then()
                .log().all();
    }

    @Step("Getting 200 status code")
    public int getStatusCode() {
             return response.extract().statusCode();
     }


    @Step("Getting current weather condition at city")
    public String getCurrentWeather() {
     return response.extract().path("weather[0].description");
   }
   @Step("Getting name")
   public String getName(){
        return  response.extract().path("name");
   }

    @Step("getting weather with long and lat ")
    public int currentVisibilityCondition() {
        return response.extract().path("visibility");
    }
}









