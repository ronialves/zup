- Technologies and frameworks used : 

JDK 8
Gradle
Spring Boot
Spring Data MongoDB
MongoDB
Spring Security 
Spring Initializer
JWT
Angular 8
Eclipse and VSCode


- Solution : in the project i used a simple angular interface project (appAngularZup) to create with the user information a JWT tolken , in the other way i created a spring project (spring-angular-auth) that received all the rest request : 
	- for the user login and register the spring project saves the info in the mongodb , after the login with success , the form is redirect to the next page that with the provided information send again for the spring project.


	- for the spring project after the login , was developed a rest service "/payment"( "AuthController" class , method "payment") to process the payment and send it to another API's. 

- To run (with the mongodb running): 

	- enter in the main directory for the angular project "appAngularZup" open the terminal and put the command : 
		- ng serve 

	- enter  in the main directory for the spring project "spring-angular-auth" open the terminal and put the command: 
		- gradle bootRun 

After that open a brownser and login to url : 

http://localhost:4200/login

Inside the url just click in the register to create a user , after that login to next page and send tha required fields. 


