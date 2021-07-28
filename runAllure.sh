#!/bin/sh
project_path="/Volumes/Coding/Automation FC Elearning/course-automation-test-framework"
cd "$project_path"
java -javaagent:"$project_path/libAllure/aspectjweaver-1.8.10.jar" -classpath "$project_path/bin:$project_path/libAllure/*:$project_path/libExtentV3/*:$project_path/libLogging/*:$project_path/libraries/*:$project_path/libReportNG/*:$project_path/libWebDriverManager/*" org.testng.TestNG "$project_path/bin/runNopCommerceUserGuruTCs.xml"
source ~/.bash_profile
allure serve ./allure-json/
