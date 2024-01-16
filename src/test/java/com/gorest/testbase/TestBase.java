package com.gorest.testbase;

import com.gorest.utils.TestUtils;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

/**
 * Created by Jay Vaghani
 */
public class TestBase extends TestUtils {

    @BeforeClass
    public void inIt() {
        RestAssured.baseURI = "http://gorest.co.in/public/v2;";

    }
}
