package api.endpoint;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.apache.poi.sl.usermodel.ObjectMetaData.Application;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import api.payload.User;



//userEndpoints.java
//for perfor CRUD opration to the user


public class userEndpoints {

	public static Response createuser(User payload){
		
		Response res=given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)
		
		.when().post(Routes.post_url);
		
		return res;
	}
	
public static Response getuser(String userName){
		
		Response res=given().pathParam("username", userName)
		
		.when().get(Routes.get_URL);
		
		return res;
	}
	

public static Response updateuser(String userName, User payload){
	
	Response res=given().contentType(ContentType.JSON).accept(ContentType.JSON).pathParam("username", userName).body(payload)
	
	.when().post(Routes.update_URL);
	
	return res;
}


public static Response deleteuser(String userName){
	
	Response res=given().pathParam("username", userName)
	
	.when().get(Routes.deleteURL);
	
	return res;
}


	
}
