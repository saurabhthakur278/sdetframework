package api.endpoint;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.ResourceBundle;

import org.apache.poi.sl.usermodel.ObjectMetaData.Application;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import api.payload.User;



//userEndpoints.java
//for perfor CRUD opration to the user

//method crating for getting url from propertis file
public class userEndpoints2 {
	
	
	static ResourceBundle geturl(){
		ResourceBundle rout=ResourceBundle.getBundle("routes");
		return rout;
	}
	
	
	
	

	public static Response createuser(User payload){
		
		String post_url= geturl().getString("post_url");
		
		Response res=given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)
		
		.when().post(post_url);
		
		return res;
	}
	
public static Response getuser(String userName){
		
	String get_url= geturl().getString("get_URL");
	
		Response res=given().pathParam("username", userName)
		
		.when().get(get_url);
		
		return res;
	}
	

public static Response updateuser(String userName, User payload){
	
	
	String update_url= geturl().getString("update_URL");
	
	Response res=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", userName)
			.body(payload)
	
	.when().post(update_url);
	
	return res;
}


public static Response deleteuser(String userName){
	String deleteURL= geturl().getString("deleteURL");
	Response res=given().pathParam("username", userName)
	
	.when().get(deleteURL);
	
	return res;
}


	
}
