package StepDefinition;

import Util.RouteReader;
import api.payload.User;
import groovy.transform.stc.POJO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import io.cucumber.messages.types.DataTable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.collections.Maps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static org.hamcrest.Matchers.equalTo;

public class Registration_StepDef  {
    String baseURL;
    Response response;
    Response response1;
    Response response2;
    Response response4;
    Response response3;
    RequestSpecification requestSpecification1;
    RequestSpecification requestSpecification2;
    RequestSpecification requestSpecification3;
    RequestSpecification requestSpecification4;
    JSONObject jo;

    RequestSpecification requestSpecification=RestAssured.given();
    RequestSpecification getRequestSpecification1=requestSpecification.contentType(ContentType.JSON).accept("application/json");


    Properties properties=RouteReader.Route_properties();
    User user=new User();
    JSONObject jsonObject=new JSONObject();



    public Registration_StepDef() throws IOException {
    }


    @Given("open the pet store url {}")
    public void openThePetStoreUrl(String url)  {
       // this.baseURL=url;
     this.baseURL=properties.getProperty(url);


    }

    @Given("Enter the request body of user")
    public void enter_the_request_body_of_user(io.cucumber.datatable.DataTable dataTable) {
        //RequestSpecification requestSpecification1=requestSpecification.contentType(ContentType.JSON).accept("application/json").body(dataTable);

  requestSpecification1=this.getRequestSpecification1.body(dataTable);


  //Post request by method -Json Object
        JSONObject jsonObject1=new JSONObject(dataTable);
        requestSpecification3=this.getRequestSpecification1.body(jsonObject1);


//post request by method-hashMap
       HashMap hashmap_data=new HashMap<>();
        requestSpecification4=this.getRequestSpecification1.body(hashmap_data);




    }

    @When("hit the post request")
    public void hit_the_post_request() {
       response= this.requestSpecification1.when().post(baseURL).then().log().all().extract().response();
    }

    @Then("validate the {int} of post request")
    public void validate_the_of_post_request(Integer Status_code) {
        response.then().statusCode(Status_code).log().all();
    }


    @And("Enter the POJO request body of user")
    public void enterThePOJORequestBodyOfUser() {
        user.setId(0);
        user.setUsername("Ronitsg2353");
        user.setFirstName("Ronit");
        user.setLastName("Gaikwad");
        user.setEmail("ronitsg2353@gmail.com");
        user.setPassword("Ronit@2353");
        user.setPhone("9922922308");
        user.setUserStatus(1);
    }

    @And("Enter POJO request body to the requestSpecc")
    public void enterPOJORequestBodyToTheRequestSpecc() {
        requestSpecification2=this.getRequestSpecification1.body(user);
    }

    @When("hit the post request for POJO")
    public void hitThePostRequestForPOJO() {
       response1= requestSpecification2.when().post(baseURL).then().log().all().extract().response();
    }

    @Then("validate the {} of post POJO request")
    public void validateTheOfPostPOJORequest(int Status_code) {
        response1.then().statusCode(Status_code).log().all();

    }

    @When("hit the post request for JSONBject")
    public void hitThePostRequestForJSONBject() {
        response2=requestSpecification3.post(baseURL).then().log().all().extract().response();

    }

    @Then("validate the {} of JSONobject")
    public void validateTheOfJSONobject(int status_code) {
        response2.then().statusCode(status_code).extract().response();
    }


    @When("hit the post request for map body")
    public void hitThePostRequestForMapBody() {
    response4=this.requestSpecification4.post(baseURL).then().extract().response();
    }

    @Then("validate the {} for map request")
    public void validateTheForMapRequest(int status_code) {
        response4.then().statusCode(status_code).extract().response();
    }

    @And("Enter the request body by external json file")
    public void enterTheRequestBodyByExternalJsonFile() throws FileNotFoundException {
        File f=new File("C:\\Users\\LENOVO\\IdeaProjects\\pava_RestAssured_Framework\\src\\test\\resources\\External Json file\\body.json");
        FileReader fr=new FileReader(f);
        JSONTokener jt=new JSONTokener(fr);

        jsonObject =new JSONObject(jt);


    }

    @When("hit the post request for external json body")
    public void hitThePostRequestForExternalJsonBody() {
       response3= getRequestSpecification1.body(jsonObject).post(baseURL).then().log().all().extract().response();
    }
    @Then("validate the {} for map json_file")
    public void validateTheForMapJson_file(int status_code) {
        response3.then().statusCode(status_code).log().all().extract().response();
    }
}

