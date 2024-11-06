package api.test;

import api.endpoint.Routes;
import api.endpoint.UserEndPoint;
import api.endpoint.UserEndPoint1;
import api.payload.User;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class UserTest {
    Faker faker;
    User userPayload;

    @BeforeClass
    public void setData() {
        faker = new Faker();
        userPayload = new User();

        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password(5, 9));
        userPayload.setPhone(faker.phoneNumber().cellPhone());
        userPayload.setUserStatus(faker.number().hashCode());


    }

    @Test (priority = 1)
    public void test_PostUser() {
        Response response = UserEndPoint.createUser(this.userPayload);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority = 2)
    public void test_GetUser() {
        Response response = UserEndPoint.getUser(this.userPayload.getUsername());
        response.then().log().all();

    }

//    @Test
//    public void test_post(){
//        Response response= RestAssured.given().contentType("application/json").accept("application/json").body(this.userPayload).
//                when().post("https://petstore.swagger.io/v2/user").then().statusCode(200).log().all().extract().response();

//    }

    @Test(priority = 3)
    public void updateUser() {
        Response response = UserEndPoint.updateUser(this.userPayload.getUsername(), this.userPayload);
        response.then().log().all();
    }

//    @Test
//    public void test_update(){
//       Response response= RestAssured.given().contentType("application/json").accept("application/json").
//                body(this.userPayload).when().put("https://petstore.swagger.io/v2/user/ronitgaik").
//               then().log().all().extract().response();
//    }


@Test(priority = 4)
public void deleteUser(){
        Response response=UserEndPoint.deleteUser(this.userPayload.getUsername());
        response.then().statusCode(200).log().all();
}
}