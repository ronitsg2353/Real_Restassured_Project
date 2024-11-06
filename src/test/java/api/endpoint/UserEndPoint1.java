package api.endpoint;

import api.payload.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

import static java.util.ResourceBundle.getBundle;

public class UserEndPoint1 {

    static ResourceBundle getUrl() {

        ResourceBundle resourceBundle= ResourceBundle.getBundle("Route");
        return resourceBundle;
    }


    @Test
    public static Response createUser(User payload){

        String POST_URL=getUrl().getString("post_URL");

        Response response= RestAssured.given().contentType("application/json").accept("application/json").body(payload).
                when().post(POST_URL);
        return response;

    }


    @Test
    public static Response getUser(String username){
       String GET_URL= getUrl().getString("get_URL");


        Response response= RestAssured.given().pathParam("username",username).when().get(GET_URL);

        return response;
    }


    @Test
    public static Response updateUser(String username,User payload){
        String UPDATE_URL=getUrl().getString("update_URL");


        Response response=RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).
                pathParam("username",username).body(payload).when().put(UPDATE_URL);

        return response;
    }


    @Test
    public static Response deleteUser(String username){
        String DELETE_USER=getUrl().getString("delete_URL");

        Response response=RestAssured.given().pathParam("username",username).when().delete(DELETE_USER);
        return response;
    }
}
