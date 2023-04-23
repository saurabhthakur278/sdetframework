package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoint.userEndpoints;
import api.endpoint.userEndpoints2;
import api.payload.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserTest2 {

	Faker faker;
	User userpayload;
	
	@BeforeTest
	public void setupdata() {
		
		faker=new Faker();
		userpayload=new User();
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setEmail(faker.internet().emailAddress());
		userpayload.setPassword(faker.internet().password(5,10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
		
	}
	
	@Test(priority = 1)
	public void postUser() {
		RestAssured.useRelaxedHTTPSValidation();
		Response  response=userEndpoints2.createuser(userpayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	} 
	
	
	@Test(priority = 2)
	public void getUser() {
		RestAssured.useRelaxedHTTPSValidation();
		Response  response=userEndpoints2.getuser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	
   @Test(priority = 3)
	public void updateuser() {
		RestAssured.useRelaxedHTTPSValidation();
		
		
		userpayload.setLastName(faker.name().lastName());
		userpayload.setFirstName(faker.name().firstName());
		
		
		Response  response=userEndpoints2.updateuser(this.userpayload.getUsername(),userpayload);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
//		
//		Response  responseget=userEndpoints.getuser(this.userpayload.getUsername());
//		
//		Assert.assertEquals(response.getStatusCode(), 200);

	}
	
	@Test(priority = 4)
	public void deleteuser() {
		Response  response=userEndpoints2.deleteuser(this.userpayload.getUsername());
		
		
		Assert.assertEquals(response.getStatusCode(), 200);

	}
	
	
	
	
}

