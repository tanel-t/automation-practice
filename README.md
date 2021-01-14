# automation-practice

## 1. Project

Project contains 5 automated test cases for [Selenium Frameworks practice web page](http://automationpractice.com/index.php). Test cases are described in Cucumber format in .feature file. Two of the test cases are intended to result in a failure.

## 2. Requirements

* Java SE (JDK)
* Gradle
* Google Chrome

## 3. Running the tests
* Clone the repository
* Execute the following command in project root from command line
>gradle cucumber

## 4. Generating report
Cucumber is creating a .json file as a result in build/cucumber/json folder. After test run a html report will also be created in build/cucumber-html-reports folder.
Report generation can also be manually triggered using following command via command line.
>gradle generatereport

