package org.openweathermap.home.testbase;


import io.restassured.RestAssured;

import org.junit.BeforeClass;
import org.openweathermap.home.constants.Path;
import org.openweathermap.home.propertyreader.PropertyReader;


public class TestBase {
    public static PropertyReader propertyReader;

    @BeforeClass
    public static void init() {
        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("baseUrl");
        RestAssured.basePath = Path.BASE;

     }
   }

