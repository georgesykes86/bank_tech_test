Bank Tech Test
==============

Summary
-------

A Java app that provides the functionality for a basic bank account with the ability to
make deposits and withdrawals as well as printing a statement that will contain details of these transactions.
Each transaction will detail the date it was made the amount that has either been credited or debited from the account
and the subsequent balance.


Specification
-------------

#### Requirements

* Deposits and withdrawals.
* Account statement (date, amount, balance) printing.
* Data can be kept in memory (it doesn't need to be stored to a database or anything).

#### Acceptance criteria

Given a client makes a the following transactions:
 * A deposit of 1000 on 10-01-2012
 * A deposit of 2000 on 13-01-2012
 * A withdrawal of 500 on 14-01-2012
 
When she prints her bank statement then she would see...

```$xslt
date || credit || debit || balance
14/01/2012 || || 500.00 || 2500.00
13/01/2012 || 2000.00 || || 3000.00
10/01/2012 || 1000.00 || || 1000.00
```

Getting started
--------------

####Installation


This application has been designed to be built with Maven to simplify the build process and
include all necessary dependencies. If you do not have Maven installed it is recommended you
do so by following the guidelines [here](http://maven.apache.org/).

* Clone the repository
* Navigate to the top level of the directory using the command line  ``` cd bank_tech_test ```

####How to use

The app does not have a command line interface so the source code must be changed between 
runs to alter the output.

The entry point for the application can be found in the BankRunner.java file and the
run instructions are detailed with the RunApp method.

![Imgur](https://i.imgur.com/SDNXEnI.png?1)

Once you are ready to run the app then:
* Compile the app ```mvn package```
* Run the app ```java -cp target/bank_tech_test-1.0-SNAPSHOT.jar com.makersacademy.banktechtest.BankRunner```

If you are using an IDE such as Intellij then you can open the repository in the IDE and use the 
inbuilt run commands.

Approach
--------

####Methodology
The ambition for this app was to create well encapsulated classes that were able to interact through
clear messages. Where appropriate I have tried to use dependency injection to allow classes to be
isolated from the context.

The image below shows the UML diagram which was generated before starting the project and developed as
parts of the implementation required change.

![Imgur](https://i.imgur.com/anZGuCp.jpg)

####Technologies
The app was made using Java 8 functionality and Maven as the build tool. Testing was performed using
JUnit 5 combined with Mockito as a mocking library.

####Testing
The development process followed a TDD approach with the development of feature tests to assess the 
end to end functionality and unit tests to test each of the components in isolation.

The tests can be run from the command line using ```mvn test```

Further Information
-------------------

####Areas for development
* Add command line interface that allows the user to interact with the application
* Integration of currency types
* Alternative printing options
* Filtering of transactions by date or amount
* Currently the Tranasaction date is stored as a string but this may be better as a Date that
 gets turned to a string during printing.
 
