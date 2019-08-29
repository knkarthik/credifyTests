A sample testing framework that supports both UI and API automated tests. 

Highlights:
 - 
 - Framework supports both UI and API testing
 - Highly extensible with minimal maintenance required
 - CI/CD ready, just run the gradle task
 - Auto downloads chrome/firefox driver binary files

Pre-requisites:

 - Operating System: Windows 10 (other OS' should also work)
 - JDK 1.8 
 - Selenium java 3.141.59
 - Chromedriver 2.44 
 - Selenium-chrome-driver 3.141.59 
  - Selenium-firefox-driver 3.141.59 
  - Chrome Version 76.0.3809 
  - TestNG
  - RESTAssured 3.0.6
   - Gradle 5.5.1

 
 Project Structure:
   -

>     └───src
>            ├───main
>            │   ├───java
>            │   │   ├───clients
>            │   │   │       BaseClient.java
>            │   │   │       CredifyClient.java
>            │   │   │
>            │   │   ├───Constants
>            │   │   │       LoanPurpose.java
>            │   │   │       ValidStates.java
>            │   │   │
>            │   │   ├───entities
>            │   │   │       BaseResponse.java
>            │   │   │
>            │   │   ├───properties
>            │   │   │       CredifyProperties.java
>            │   │   │       Properties.java
>            │   │   │       PropertiesReader.java
>            │   │   │
>            │   │   ├───ServiceEndpoints
>            │   │   │   │   INSTRUCTIONS.md
>            │   │   │   │
>            │   │   │   ├───core
>            │   │   │   │   ├───entity
>            │   │   │   │   │       Param.java
>            │   │   │   │   │       RequestBody.java
>            │   │   │   │   │
>            │   │   │   │   ├───template
>            │   │   │   │   │       HttpMethod.java
>            │   │   │   │   │       IServiceEndpoint.java
>            │   │   │   │   │       UserType.java
>            │   │   │   │   │
>            │   │   │   │   └───utility
>            │   │   │   │           CurlBuilder.java
>            │   │   │   │           Header.java
>            │   │   │   │           RequestHandler.java
>            │   │   │   │
>            │   │   │   └───serviceEndpoints
>            │   │   │       │   dummy
>            │   │   │       │
>            │   │   │       └───status
>            │   │   │               GetStatusEndpoint.java
>            │   │   │               GetStatusResponse.java                         // POJO response class
>            │   │   │
>            │   │   └───utils
>            │   │           Commons.java
>            │   │           CredfyCategories.java
>            │   │
>            │   └───resources
>            │           integration.properties
>            │
>            └───test
>                ├───java
>                │   ├───pages                                         // POM classes
>                │   │       BasePage.java
>                │   │       OffersPage.java
>                │   │       PersonalInformationPage.java
>                │   │       RateCheckPage.java
>                │   │       SignInPage.java
>                │   │
>                │   ├───testBases
>                │   │       UIBaseTest.java
>                │   │
>                │   └───tests
>                │       ├───api                                          // API tests
>                │       │       VoucherSmokeTests.java
>                │       │
>                │       └───ui                                            // UI tests
>                │               CheckRateTests.java
>                │
>                └───resources

To run all UI tests in chrome: `gradlew clean build runTests -Dtag=UI -Dbrowser=chrome`.

Replace browser to `firefox` to use firefox.

To run all API tests: `gradlew clean build runTests -Dtag=API`.


After the run you can view the HTML report at `build/<tag>`.