package api.payload;

import api.endpoint.UserEndPoint;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class DDTest {

    @Test(priority = 1,dataProvider ="Data",dataProviderClass = DataProviders.class)
    public void testPostUser(int userid,String UserName,String Fname,String LName,String pwd,String ph,String gmail){
        User userPayload=new User();
        userPayload.setId(userid);
        userPayload.setUsername(UserName);
        userPayload.setFirstName(Fname);
        userPayload.setLastName(LName);
        userPayload.setEmail(gmail);
        userPayload.setPassword(pwd);
        userPayload.setPhone(ph);


        Response response=UserEndPoint.createUser(userPayload);
        response.then().log().all();
    }

}
