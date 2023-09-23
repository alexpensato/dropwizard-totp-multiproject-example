# dropwizard-totp-multiproject-example
Dropwizard TOTP Authenticator example

Introduction
---
This is a simple example of how to implement TOTP authenticator in a Dropwizard application, 
including a simple web page to generate QR-Code for the TOTP authenticator.

This example uses the wstrange's GoogleAuth library.
The official repository for this library can be found here: https://github.com/wstrange/GoogleAuth

It also uses Google's xzing library for QR-Code generation.
The official xzing library can be found here: https://github.com/zxing/zxing/wiki/Getting-Started-Developing


How to start the application
---

1. Run `mvn clean install` to build your application
2. Start application with `java -jar main-project/target/dropwiztotp-main-1.0.0.jar`
3. To check that your application is running enter url `http://localhost:8080/my-ip`
4. Other possible urls are: `http://localhost:8080/users/alex` and `http://localhost:8080/users/qrcode/alex`


Troubleshooting
---
For errors that occur during the building stage of the application:
To see the full stack trace of the errors, run Maven with the -e switch: `mvn clean install -e`
To enable the full debug logging, run Maven with the -X switch: `mvn clean install -X`


Health Check
---

To see your application health enter url `http://localhost:8081/healthcheck`


Creating the Project
---

This project was created using an old version of Dropwizard (2.1.6) with the following command:
mvn archetype:generate -DarchetypeGroupId=io.dropwizard.archetypes -DarchetypeArtifactId=java-simple -DarchetypeVersion=2.1.6

Follow this tutorial to create a new project with a more current version of Dropwizard:
https://www.dropwizard.io/en/latest/getting-started.html


Docs
---
https://www.dropwizard.io/en/latest/manual/core.html
https://www.dropwizard.io/en/latest/manual/configuration.html
https://www.dropwizard.io/en/latest/manual/core.html#filters

