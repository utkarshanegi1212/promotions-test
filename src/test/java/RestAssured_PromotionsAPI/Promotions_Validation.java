package RestAssured_PromotionsAPI;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class Promotions_Validation {
	
	// Assigning the API URL
	public  String baseURI= "https://api.intigral-ott.net/popcorn-api-rs-7.9.17/v1/promotions?apikey=";
	
	// Assigning the apiKey value
	public String apiKey="webB2BGDMSTGExy0sVDlZMzNDdUyZ";
	
	//Fetching the API response 
	public Response response = //GIVEN
								given()
								 // WHEN 
										.when().get(baseURI+apiKey);
	
	@Test(description="To validate the response code of api")
	public void validateStatusCode() {
		
		response
		//THEN
		.then().statusCode(200); // Sending the expected status code
		
	}
	
	@Test(description ="To validate Promotion API Json response with assertions")
	public void verifyGetPromotionDetails()
	{
		response
		//THEN
		.then()
		 //Validating the json properties 
			// assert for show price should have boolean value
		 	.assertThat().body("promotions.showPrice", hasItems(true,false))
		 	// assert for OrderId shouldn't be null
		 	.assertThat().body("promotions.orderId", is(notNullValue()))
		 	// assert for promoArea shouldn't be null
		 	.assertThat().body("promotions.promoArea", is(notNullValue()))
		 	// assert for PromoType shouldn't be null
		 	.assertThat().body("promotions.promoType",is(notNullValue()))
		 	// assert for show text should have boolean value 
		 	.assertThat().body("promotions.showText", hasItems(true,false))
		 	// assert for localized text Should Exist with “ar” and “en”  objects)
		 	.assertThat().body("promotions.localizedTexts", hasItem(allOf(hasKey("ar"), hasKey("en"))));
	 	
	}
	
	@Test(description ="To validate that promotion ID has string value")
	public void validatePromotionIdIsString()
	{
		
		response
		//THEN
		.then()
		 // assert for validating the promotion IDs have string value
		 	.assertThat().body("promotions.promotionId",hasItem(allOf(isA(String.class))));
			
	}
	
	@Test(description ="To validate that programType contain any Episode/Movie/Series/Season ID  value")
	public void validateProgramType()
	{
		response
		//THEN
		.then()
			// assert o validate that programType contain any Episode/Movie/Series/Season ID  value
			.assertThat().body("promotions.properties.programType", hasItem(hasItem(is(oneOf("movie","episode","season","series",null)))));
	
	}
	
	@Test(description ="To validate the API response by passing Invalid API key")
	public void validateWithInvalidKey()
	{
		 apiKey="invalid-api-key";
		 //GIVEN
		 given()
		 //WHEN
		 .when().get(baseURI+apiKey)
		 //THEN
		 .then()
		 //validate status code 
		 .statusCode(403)
		 //Request Id should not be null
		 	.assertThat().body("error.requestId",CoreMatchers.notNullValue())
		 //Validating message
		 	.assertThat().body("error.message",CoreMatchers.equalTo("invalid api key"))
		 //Validating code 
		 	.assertThat().body("error.code",CoreMatchers.equalTo("8001"));
	
	}
	
		
}
