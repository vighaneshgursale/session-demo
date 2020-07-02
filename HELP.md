# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

Steps to run application:
1. Modify the **application.yml** file change the location of database
2. Perform **mvn clean install** from the root directory of project
3. Once application started go to [http://localhost:8080/signup](http://localhost:8080/signup)
4. Register one user
5. Once you have registered the user go to [http://localhost:8080/login](http://localhost:8080/login)
6. Enter the credentials
7. To open **/dummy** page change url in the browser to [http://localhost:8080/dummy](http://localhost:8080/dummy)
8. The session will stay active based on user activity if user inactive time crosses the specified timeout
user will be automatically logged out on next refresh
