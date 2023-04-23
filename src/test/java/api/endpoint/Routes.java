package api.endpoint;

//swagger URI-https://petstore.swagger.io
//post-https://petstore.swagger.io/v2/user
//get-https://petstore.swagger.io/v2/user/{username}
//put-https://petstore.swagger.io/v2/user/{username}
//delete-https://petstore.swagger.io/v2/user/{username}
public class Routes {
	
public static String baseURL= "https://petstore.swagger.io/v2";
	
//user module
public static String post_url=baseURL+"/user";
public static String get_URL=baseURL+"/user/{username}";
public static String update_URL=baseURL+"/user/{username}";
public static String deleteURL=baseURL+"/user/{username}";




}
