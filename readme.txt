URL Page : https://cs425-fire.cfapps.io

docs (folder): Documentation 

credentials:
[student]
u: 980196
p: Wondimu123

[admin]
u: Admin
p: admin123

[faculty]
u: Lu27
p: Lu123

[staff]
u: Staff
p: staff123

Local Setup process 

This is a Spring Boot Web Maven project. You do not need a web server to run this.

To run the project you need to do the following:

1) Go to src/main/resources and edit application.properties and change the following property
	spring.jpa.hibernate.ddl-auto = validate -> spring.jpa.hibernate.ddl-auto = update

2) While in application.properties make sure the database parameters are correct (URL, schema, username and password)

3) From the root package edu.mum.cs.projects.attendance, run the main() in a class named DatabaseLoader.java
This will create all the necessary tables in database and load them with realistic data, and also load the users and passwords table, you can check the user table for username, password details

4) After you successfully create database tables, you need to change the following property back to normal:
	spring.jpa.hibernate.ddl-auto = create -> spring.jpa.hibernate.ddl-auto = validate
	
5) Run the reporting app from root package edu.mum.cs.projects.attendance. Just run the main() in:
AttendanceReport.java

The Excel reports are saved under:
src/main/resources/reports/

