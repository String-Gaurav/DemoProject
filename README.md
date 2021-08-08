# DemoProject
## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [About Test Framework](#about-test-framework)
* [Reporting](#reporting)

## General info
 Outline a brief description of this project.
- Selenium Framework with Cucumber
- BDD framework for automation using Selenium Cucumber and (TestNG used for parallel execution)

	
## Technologies
Project is created with:
* JAVA Version - jdk1.8.0_291
* Selenium-WebDriver version- 3.141.59
* Cucumber Version- 6.9.0
* TestNG Version - 6.14.3

## Setup
- Intall java from - https://www.oracle.com/in/java/technologies/javase/javase-jdk8-downloads.html
Setup JAVA_HOME path
- Install MAVEN- https://maven.apache.org/download.cgi
Setup .M2 and MAVEN_HOME path as per the below screenshot
![image](https://user-images.githubusercontent.com/88622330/128636681-414f6dab-7205-4725-97be-b94fe36d5864.png)

- Add all the mandate dependencies in POM.XML

	
## About Test Framework
The framework has following features

* Maven based framework
* Log4j enabled for logging
* Report Generation in Cucumber Reporting Tool
* Integrated HTML adn PDF report by using Extent Spark lib/plugins
* Centralized Configuration (Using Properties file)
* Hooks for to set execution -- launching the browser, taking screenshot of fail/pass test cases.
* Implmented Thread safe to use driver for parallel execution.

**TO Trigger Test Cases use below command from Command Line or from Any CICD tool like Jenkins**

MAVEN COMMANDS:-

* mvn clean
* mvn compile
* mvn test -Dcucumber.filter.tags="@Positive"
* mvn test -Dcucumber.filter.tags="@Negative"

**FEATURE FILE PATH:- **

**src/test/resources/parallel**

**Feature File Sample: **

```
@Positive

Feature: Test the signup page functionality of MIRO webpage

  Background:
    Given Enter the url of the MIRO Page
    When Verify the title of the page

  Scenario Outline: TC-Pos_01-Validating the sign-up flow
    And Enter the name "<Name>"
    And Enter the work email
    And Enter the password "<Password>"
    And click on Miro Terms checkbox
    And click on Get Started Button
    Then Verify the email address after singing up

    Examples:

      | Name   | Password    |
      | Gaurav | test@123456 |
      
  ```
  
  Can change the properties (chrome/firefox), to launch the specific browser or no-tag to use the browser form the config.properties file 
  
  **Have done the setup of two Runner File:-**
  
 **src/test/java/testrunner/MyTestRunner.java --(This is feature supports sequence execution of test cases)**
 **src/test/java/parallel/ParallelRun.java --(This is feature supports parallel execution of test cases)**
  
  ```
  package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/parallel"},
        glue = {"parallel"}
        ,tags = "@1"
        ,plugin = {"pretty",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "timeline:test-output-thread/"

}
)
public class MyTestRunner {
}
 ``` 
2-
  
    * src/test/java/parallel/ParallelRun.java --(This is feature supports parallel execution of test cases)


  
  ```
  package parallel;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/parallel"},
        glue = {"parallel"},
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread/"
        }

)
public class ParallelRun extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
     return super.scenarios();
    }
}
 ``` 
## Reporting
	
 * 1-Reporting of all the test cases.
 * 2-Can check the error logs.
 * 3-Check the screenshot where the test case is failing.
  
** Extent Reporter Spark for HTML and PDF reporting.**
 * 1-Check the error logs in detail with screenshot
 * 2-See the percentage of pass/fail test cases
 * 3-Date/OS/etc. details
  
  ![image](https://user-images.githubusercontent.com/88622330/128635989-b3d810fb-66be-4c79-8fc9-cc61bdf491be.png)
![image](https://user-images.githubusercontent.com/88622330/128636029-96ff59bf-6947-4484-a085-488e2f7421cf.png)
![image](https://user-images.githubusercontent.com/88622330/128636049-3e5be1c9-d250-4163-a5b8-a10970cd635c.png)
	![image](https://user-images.githubusercontent.com/88622330/128637094-b92376c4-c966-45f7-9714-77385852edaa.png)


```
