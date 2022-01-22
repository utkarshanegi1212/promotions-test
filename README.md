# PromotionsTest

> Promotions API testing through automation using RestAssured with TestNG framework .

## <a id="assignment" style="color: black;">Assignment</a>

Given API Endpoint:
http://api.intigral-ott.net/popcorn-api-rs-7.9.17/v1/promotions?apikey=GDMSTGExy0sVDlZMzNDdUyZ
This is a Rest API please automate it in any tool, we will prefer Rest Assured or Cucumber BDD with Junit or Testing frameworks.

> Validate the JSON response as per following and add assertions respectively.
> Response HTTP Status code should be 200
> Assert following json properties present in the response for each object
> {
> "promotions": [ (Should Exist)
> {
> "promotionId": (Should Exist)
> "orderId": (Should Exist)
> "promoArea": [] (Should Exist)
> "promoType": (Should Exist)
> "showPrice": (can have value as True or false)
> "showText": (can have value as True or false)  
>  "localizedTexts": { (Should Exist with “ar” and “en” json objects)
> "ar":[],
> "en": []
> },
> Perform following assertions
> Example:
> promotionId: any string value,
> programType: EPISODE or MOVIE or SERIES or SEASON
> Validate the response for a request with invalid value passed for “apikey” query parameter.
> HTTP Status code 403
> “requestId” should not be null
> “code” should be “8001” and "message" should be "invalid api key"

> Request: mentioned above
> Response:
> {  
> "error":
> {  
> "message": "invalid api key",  
> "code": "8001",  
> "requestId": "1cccf683-7793-4a9d-a2d7-52db4d2c1d6f"  
> }
> }

This validation need to be applied for all success response test cases.
Please add whatever cases you think for testing this API in your suite.

Once Implemented:

You need to execute this and record execution video
Create a document with the steps about how to execute this project.
Please share the complete project along with above mentioned details

Important Points:

You need to implement this assignment in Rest Assured or Cucumber BDD framework
During implementation please make sure you use any automation framework and it should generate proper test execution reports.
You need to reply to email within 48 hours.

## <a id="tested-with" style="color: black;">Tested With</a>

- **Rest Assured** - for testing the REST Api
- **TestNG** - for test automation framework
- **Maven** - for POM.xml and to add dependencies
- **BDD Approach** - to use given(),when(), then() method to write down test cases in a structured way.

## <a id="maven-dependencies" style="color: black;">Maven dependencies</a>

- **rest-assured 4.0.0**
- **testng 7.4.0**
- **hamcrest-all 1.3**

## <a id="test-cases" style="color: black;">Test Cases</a>

- To validate the response code of Promotions API
- To validate Promotion API Json response with assertions
- To validate that promotion ID has string value
- To validate that programType contain any Episode/Movie/Series/Season ID
- To validate the API response by passing Invalid API key

## <a id="whats-not-included" style="color: black;">How to execute the test project in Eclipse</a>

- Import the project in eclipse
- Make sure your JDK version is 1.8.0
- Go to the test file
  `promotions-test/src/test/java/RestAssured_PromotionsAPI/Promotions_Validation.java`
- Click on run project or right click on the file and run as > testng test
- It will generate test reports inside test-output folder
