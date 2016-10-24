/**
 * 
 */
/**
 * @author samuel
 *
 */
package restTest;

import org.junit.Test;
import static com.jayway.restassured.RestAssured.given;
public class HelloWorldRestAssured {

 @Test
 public void makeSureThatGoogleIsUp() {
     given()
     .when()
     .get("http://api.openweathermap.org/data/2.5/weather?lat=35&lon=139&APPID=2ed755d61444101ba509168ec7a7d706")
     .then()
     .statusCode(200);
 }

}