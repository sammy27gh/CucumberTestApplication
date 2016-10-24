package login;
import static com.jayway.restassured.RestAssured.given;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class JsonMapExample {

	
	public void jackson() throws JsonParseException, JsonMappingException, IOException {

	
			ObjectMapper mapper = new ObjectMapper();
			//String json = "{\"name\":\"mkyong\", \"age\":29}";

		String json =	"{\"stAge\":\"150\",\"stId\":\"24\",\"stName\":\"Francis\"}";
			
			Map<String, Object> map = new HashMap<String, Object>();

			// convert JSON string to Map
			map = mapper.readValue(json, new TypeReference<Map<String, String>>(){});

			System.out.println(map);
		given()
        .contentType("application/json")
        .body(map)
        .when()
        .post("http://localhost:8080/test/webresources/student")
        .then()
       .statusCode(200);
        
        //.post("http://localhost:8080/test/webresources/student");
	
	}
	
	
	}
	
	

