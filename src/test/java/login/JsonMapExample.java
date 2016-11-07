package login;
import static com.jayway.restassured.RestAssured.given;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonParseException;





public class JsonMapExample {

	@Test
	public void jackson() throws com.fasterxml.jackson.core.JsonParseException, JsonMappingException, IOException  {
            ObjectMapper mapper = new ObjectMapper();
			String json =	"{\"stAge\":\"980\",\"stId\":\"581\",\"stName\":\"wow885ancis\"}";
			Map<String, Object> map = new HashMap<String, Object>();
			// convert JSON string to Map
			map = mapper.readValue(json, new TypeReference<Map<String, String>>(){});
			//System.out.println(json);
				given()
        .contentType("application/json")
        .body(json)
        .when()
         .post("http://localhost:8080/test/webresources/student")
        //.delete("http://localhost:8080/test/webresources/student/")
        .then()
       .statusCode(200);
        
        //.post("http://localhost:8080/test/webresources/student");
	
	}
	
	
	}
	
	

