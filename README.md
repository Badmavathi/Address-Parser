# Address-Parser
Address Parser application
## Address line
An address provider returns addresses only with concatenated street names and numbers. Our own system on the other hand has separate fields for street name and street number.

Input: string of address

Output: string of street and string of street-number as JSON object

Write a simple program that does the task for the most simple cases, e.g.

"Winterallee 3" -> {"street": "Winterallee", "housenumber": "3"}
"Musterstrasse 45" -> {"street": "Musterstrasse", "housenumber": "45"}
"Blaufeldweg 123B" -> {"street": "Blaufeldweg", "housenumber": "123B"}
Consider more complicated cases

"Am Bächle 23" -> {"street": "Am Bächle", "housenumber": "23"}
"Auf der Vogelwiese 23 b" -> {"street": "Auf der Vogelwiese", "housenumber": "23 b"}
Consider other countries (complex cases)

"4, rue de la revolution" -> {"street": "rue de la revolution", "housenumber": "4"}
"200 Broadway Av" -> {"street": "Broadway Av", "housenumber": "200"}
"Calle Aduana, 29" -> {"street": "Calle Aduana", "housenumber": "29"}
"Calle 39 No 1540" -> {"street": "Calle 39", "housenumber": "No 1540"}

## Attached Package
Within the attached zip, there are three packages attached:

1. Application package - this contains the java application jar file to parse the user entered address.
2. Source Code package - this contains the java application source code and unit tests.
3. JaCoCo package - this zip folder contains the jacoco library generated files.  

## Instructions to run the application 

1. To run the project directly from IDE - refer App.java class.	
2. Build a jar with 'Maven build' with Goals as 'clean install' or run from Command Prompt with 'mvn clean install' command.
3. Run project with following command: 'java -jar addressParser.jar'
4. Run the unit tests written with the maven command as 'mvn test'.
5. JaCoCo - Java code coverage library has been used to view the Unit Tests coverages - can view the unit test coverage report in JaCoCo -> index.html folder.

Unit Tests coverage : 100% -> Report generated using Jacoco. 

## Advantages

1. This is a well developed Java project with core OOPS concepts like Encapsulation which follows Single Responsibility Principle.
2. This Code currently supports European Address Parser functionality which can be extends further to support other formats easily as it's written using Factory Design Pattern.
3. Code Debugging and maintenance is easier than Using complex regex(regular expressions).

## Limitations

1. Application throws exception for few invalid cases which could be handled better. Few examples are
		 1) When address contains more than one comma. 	
		 2) Address does not have number in it. 
2. Code does not support other country address formats. Example : Indian addresses cannot be formated using this application as it does not have a standard format. 

 
