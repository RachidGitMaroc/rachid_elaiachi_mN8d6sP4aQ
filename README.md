# rachid_elaiachi_mN8d6sP4aQ
java security test for recuiretement anywr it stand for school management using authentication based on JWT
## Technologies Used
- java version 8
- Backend: Java with Spring Boot framework Version 2.5.5
- Database: H2 to generate shema and update 
- i pute some data for insertion

- Authentication and Authorization: JSON Web Tokens (JWT) with Spring Security
- Testing: JUnit and Mockito for unit testing

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Security](https://spring.io/projects/spring-security)
- [JSON Web Tokens (JWT)](https://jwt.io/)
- [JUnit](https://junit.org/junit5/)
- [Mockito](https://site.mockito.org/)


for testing endpoints :
- i used postmane for testing authentication and retrieve Token using POST Method with uri:http://localhost:8080/api/authenticate and specified the header withe key :Content-Type and value :application/json and Body hold  the folowing json {
  "username": "admin",
  "password": "admin"
}
or 
{
  "username": "user",
  "password": "user"
}
for students navigation and consulating information i used GET Method with uri:http://localhost:8080/api/students on postman according with flowing information respectively in header and params:
- firtly after the authentication the token generated and you can put it on header using flowing example :
- key:Authorization and value :Bearer token
- and also specifing the the Content-Type on key and value :application/json
- for navigating trought students accoording to Filters: Class Name and/or Teacher Full Name
All Students list will be returned in case of no filters value
Paginated
in params i used : the key and values according to data base insert :
key :className value: math ,
key:teacherFullName value:Jane Smith
