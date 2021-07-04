# rest_assured_api_automation

src/main/java - in this folder we have created pojo package, in this package we have created pojo classes for our payloads used in framework using serialization concept.

src/test/java - in this folder we have created below packages:

	- cucumber.Options - in this package we have created TestRunner class which used to run feature file, in this class we have used @RunWith which is used to tell to cucumber to run this class and we have used @CucumberOptions in which we have mentioned location of features "features", location of stepdefination package "glue" and plugin where cucummber generate json report.
	
	- features - in this package we have created features files.
	- resources - we have created below multiple files
		- APIResource - This is our enum class to define all the API resources.
		- TestDataBuild - This class used to create payloads using pojo classes created under pojo package.
		- Utils - This class is used for creating common/reusable functions.(We have used RequestLoggingFilter and ResponseLoggingFilter to log the request and response in log file)
		- global.properties - To define the constants like baseUri.
	stepDefinations - In this package we have created below files
		- Hooks - This class used to create hooks in cucumber, hooks mainly used to run pre-condition or post-condition for an API. For example in this framework we have created DeletePlaceAPI, so if we run alone DeletePlaceAPI then there is a precondition for this i.e. AddPlaceAPI, so for running AddPlaceAPI code mentioned Hooks class.
		- StepDefination - this class is used to write implementation of all scenarios mention in features files.
pom.xml
	- for maven cucumber html report we have used maven-surefire-plugin
	
		