# rachid_elaiachi_mN8d6sP4aQ
java security test for recuiretement anywr it stand for school management using authentication based on JWT
Technologies Used
Java version 8

Backend: Java with Spring Boot framework Version 2.5.5

Database: H2 for generating schema and updates

Data insertion: Some sample data has been included

Authentication and Authorization: JSON Web Tokens (JWT) with Spring Security

Testing: JUnit and Mockito for unit testing

Technologies/Frameworks
Spring Boot
Spring Security
JSON Web Tokens (JWT)
JUnit
Mockito
Testing Endpoints
For testing authentication and retrieving a token, I used Postman with the following steps:

Send a POST request to http://localhost:8080/api/authenticate to retrieve the token.
Set the following header:
Key: Content-Type
Value: application/json
Set the request body as JSON with either of the following examples:
Example 1:
json
Copy code
{
  "username": "admin",
  "password": "admin"
}
Example 2:
json
Copy code
{
  "username": "user",
  "password": "user"
}
For navigating and retrieving student information, I used a GET request to http://localhost:8080/api/students with the following configurations:

Set the following headers:
Key: Authorization
Value: Bearer token (Replace token with the actual token obtained from authentication)
Key: Content-Type
Value: application/json
Set the query parameters according to the desired filters:
Key: className
Value: math
Key: teacherFullName
Value: Jane Smith
All student records will be returned if no filter values are provided. The results are paginated for easier navigation.

Please note that you may need to modify the endpoint URL (http://localhost:8080) based on your local setup.

If you have any further questions or need additional information, please let me know.
