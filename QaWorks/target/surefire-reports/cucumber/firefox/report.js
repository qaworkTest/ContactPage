$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("ContactPageTest.feature");
formatter.feature({
  "id": "sent-a-message-to-qaworks",
  "tags": [
    {
      "name": "@ContactPage",
      "line": 1
    }
  ],
  "description": "",
  "name": "Sent a message to QAWorks",
  "keyword": "Feature",
  "line": 2
});
formatter.before({
  "duration": 5583028543,
  "status": "passed"
});
formatter.scenario({
  "id": "sent-a-message-to-qaworks;complete-required-fields-with-valid-data",
  "tags": [
    {
      "name": "@ValidData",
      "line": 4
    }
  ],
  "description": "",
  "name": "Complete required fields with valid data",
  "keyword": "Scenario",
  "line": 5,
  "type": "scenario"
});
formatter.step({
  "name": "I open QAWorks page",
  "keyword": "Given ",
  "line": 6
});
formatter.step({
  "name": "I type my name \"Radu\" and email \"radu@yopmail.com\"",
  "keyword": "When ",
  "line": 7
});
formatter.step({
  "name": "type a message \"QAWorks Hello world\"",
  "keyword": "And ",
  "line": 8
});
formatter.step({
  "name": "a confirmation message is displayed \"Your message was sent successfully\"",
  "keyword": "Then ",
  "line": 9
});
formatter.match({
  "location": "QAworksTestsImpl.i_open_QAWorks_page()"
});
formatter.result({
  "duration": 3966647723,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Radu",
      "offset": 16
    },
    {
      "val": "radu@yopmail.com",
      "offset": 33
    }
  ],
  "location": "QAworksTestsImpl.i_type_my_name_and_email(String,String)"
});
formatter.result({
  "duration": 1025298366,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "QAWorks Hello world",
      "offset": 16
    }
  ],
  "location": "QAworksTestsImpl.type_a_message(String)"
});
formatter.result({
  "duration": 210247762,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Your message was sent successfully",
      "offset": 37
    }
  ],
  "location": "QAworksTestsImpl.a_confirmation_message_is_displayed(String)"
});
formatter.result({
  "duration": 6260461554,
  "status": "failed",
  "error_message": "java.lang.AssertionError: Confirmation message not displayed expected [true] but found [false]\r\n\tat org.testng.Assert.fail(Assert.java:94)\r\n\tat org.testng.Assert.failNotEquals(Assert.java:494)\r\n\tat org.testng.Assert.assertTrue(Assert.java:42)\r\n\tat googleTest.QAworksTestsImpl.a_confirmation_message_is_displayed(QAworksTestsImpl.java:51)\r\n\tat ✽.Then a confirmation message is displayed \"Your message was sent successfully\"(ContactPageTest.feature:9)\r\n"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 1050954654,
  "status": "passed"
});
});