package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserAssertionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.basePath =  "/public/v2";
        response = given()
                .when()
                .get("/users?page=1&per_page=20")
                .then().statusCode(200);
    }

//  1. Verify if the total record is 20
@Test
    public void test001(){
        response.body("size()", equalTo(20));
}

//2. Verify if the name of id = 5914197 is equal to ”Bhilangana Dhawan”
@Test
public void test002(){
    response.body("[0].name", equalTo("Bhishma Joshi"));
}
//3. Check the single ‘Name’ in the Array list (Dandapaani Agarwal)
@Test
    public void test003(){
        response.body("[1].name", equalTo("Dandapaani Agarwal"));
}

//4. Check the multiple ‘Names’ in the ArrayList (Usha Kaul Esq., Akshita Mishra, Chetanaanand Reddy )
@Test
public void test004(){
    response.body("name", hasItems(("Bhishma Joshi"), ("Dandapaani Agarwal"), ("Anshula Joshi")));
}

//5. Verify the email of userid = 5914185 is equal “tandon_iv_aanandinii@prosacco.example”
@Test
public void test005(){
    response.body("[5].email", equalTo("avantika_kaur@welch.test"));
}


//6. Verify the status is “Active” of user name is “Amaresh Rana”
@Test
    public void test006(){
        response.body("[7].status", equalTo("active"));

}
//7. Verify the Gender = male of user name is “Dhanalakshmi Pothuvaal”
@Test
public void test007(){
    response.body("[9].gender", equalTo("male"));
}


}
