# FullContact Enrichment Assignment By Ajith VM
	
## Prerequisites libs needed
* Java 11
* Maven
* Yarn `https://yarnpkg.com/`
* Node `https://nodejs.org/en/`

after installing these libs proceed to the next step

## Server side

* Used AOP for trimming blank space
* Used Hibernate validator for form validation
* Implemented custom exception handling
* Used Data JPA for saving history

## Client side

* Used Recoil for state management `https://recoiljs.org/`
* Used BootStrap for responsiveness and designing.

## Starting server
	navigate to 
	``` 
	fullcontact-back
	```
	open cmd here and execute  
	``` 
	mvn clean install
	```
	after success full build execute 
	```
	java -jar -jar target/fullcontact-back-0.0.1-SNAPSHOT.jar
	```
	
## Starting client
    navigate to 
	``` 
	fullcontact-frnd
	```
	open cmd here and execute  
	``` 
	yarn install
	```
	after success full build execute 
	```
	yarn run start
	```
