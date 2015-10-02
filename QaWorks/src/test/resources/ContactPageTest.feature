@ContactPage
 Feature: Sent a message to QAWorks
 			 
    @ValidData
    Scenario: Complete required fields with valid data
    	Given I open QAWorks page
    	When I type my name "Radu" and email "radu@yopmail.com"
    	And type a message "QAWorks Hello world"
    	Then a confirmation message is displayed "Your message was sent successfully"
    	 
    @InvalidData	 
    Scenario Outline: I'm trying to send a message, but I type invalid dada for required fiels
      	Given I open QAWorks page
 		When I type <Name> and <Email> and <Message>
 		Then an error message is displayed <ExpectedErrorMessage>
 
   Examples: The following queries will be executed
   	| Name      | Email				| Message     	| ExpectedErrorMessage			|
	|           | radu@yopmail.com	|Hello World	|Your name is required			|
	|Radu		|					|Hello World	|An Email address is required	|
	|Radu		|radu@yopmail.com	|				|Please type your message		|
	|Radu	    | myInvalidMail		|HelloWorld		|Invalid Email Address			|

	