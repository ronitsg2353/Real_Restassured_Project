package api.endpoint;

import api.payload.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoint {

    public static Response createUser(User payload){
        Response response=RestAssured.given().contentType("application/json").accept("application/json").body(payload).
                when().post(Routes.post_URL);
        return response;

    }

    public static Response getUser(String username){
       Response response= RestAssured.given().pathParam("username",username).when().get(Routes.get_URL);

       return response;
    }

    public static Response updateUser(String username,User payload){
        Response response=RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).
                pathParam("username",username).body(payload).when().put(Routes.update_URL);

        return response;
    }

    public static Response deleteUser(String username){
       Response response=RestAssured.given().pathParam("username",username).when().delete(Routes.delete_URL);
        return response;
    }
}
