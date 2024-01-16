package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserExtractionTest {
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
// 1. Extract the All Ids
@Test
public void test001() {

    List<Integer> id = response.extract().path("id");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The list of ID are : " + id);
    System.out.println("------------------End of Test---------------------------");

}

//2. Extract the all Names
@Test
public void test002() {
    List<String> name = response.extract().path("name");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The list of name are : " + name);
    System.out.println("------------------End of Test---------------------------");
}
//3. Extract the name of 5th object
@Test
public void test003() {
    String name = response.extract().path("[4].name");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The list of name are : " + name);
    System.out.println("------------------End of Test---------------------------");
}


//4. Extract the names of all object whose status = inactive
@Test
public void test004() {
    List<?> inactiveNames = response.extract().path("findAll{it.status=='inactive'}.name");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The list of name are : " + inactiveNames);
    System.out.println("------------------End of Test---------------------------");
}

//5. Extract the gender of all the object whose status = active
@Test
public void test005() {
    List<?> gender = response.extract().path("findAll{it.status=='active'}.gender");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The list of name are : " + gender);
    System.out.println("------------------End of Test---------------------------");
}

//6. Print the names of the object whose gender = female
@Test
public void test006() {
    List<?> genderFemale = response.extract().path("findAll{it.gender=='female'}.name");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The list of name are : " + genderFemale);
    System.out.println("------------------End of Test---------------------------");
}

//7. Get all the emails of the object where status = inactive
@Test
public void test007() {
    List<?> emails = response.extract().path("findAll{it.status=='inactive'}.email");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The list of name are : " + emails);
    System.out.println("------------------End of Test---------------------------");
}
//8. Get the ids of the object where gender = male
@Test
public void test008() {
    List<?> id = response.extract().path("findAll{it.gender=='male'}.id");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The list of name are : " + id);
    System.out.println("------------------End of Test---------------------------");
}

//9. Get all the status
@Test
public void test009() {
    List<?> status = response.extract().path("status");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The list of status are : " + status);
    System.out.println("------------------End of Test---------------------------");
}

//10. Get email of the object where name = Lal Dwivedi
@Test
public void test010() {
   String email = response.extract().path("[7].email");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The email of Tanirika Ahulwalia : " + email);
    System.out.println("------------------End of Test---------------------------");
}


//11. Get gender of id = 5914148
@Test
public void test011() {
    String gender= response.extract().path("[7].gender");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The gender is: " + gender);
    System.out.println("------------------End of Test---------------------------");
}


}
