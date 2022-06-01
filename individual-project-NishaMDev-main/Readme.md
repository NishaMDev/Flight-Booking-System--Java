# individual-project-NishaMDev

## INSTRUCTIONS TO RUN THE APPLICATION:

Needs Java 12 installed in the system that is running the program.

### INSTRUCTIONS TO RUN THE JAR FILE:
* Open Command Prompt in the main directory - Go to individual-project-NishaMDev.
Run below commands in the sequence to install the maven project –

  
    mvn compile

    mvn clean install

* Run the following command in the command prompt:
  

    mvn exec:java -Dexec.mainClass=test.RunClient -Dexec.args="\<Path to Input Data\>  \<Path to Flight details to populate DB\>"

* For Example:

  1. For Input File 1: -
  

    mvn exec:java -Dexec.mainClass=test.RunClient -Dexec.args="InputFile.csv  flights.csv"

  2. For Input File 2: -
    
    mvn exec:java -Dexec.mainClass=test.RunClient -Dexec.args="InputFile1.csv  flights.csv"

  3. For Input File 3: -
  
    mvn exec:java -Dexec.mainClass=test.RunClient -Dexec.args="InputFile2.csv  flights.csv"

  4. For Input File 4: -
    
    mvn exec:java -Dexec.mainClass=test.RunClient -Dexec.args="InputFile3.csv  flights.csv"

  5. For Input File 5: -
        
    mvn exec:java -Dexec.mainClass=test.RunClient -Dexec.args="InputFile4.csv  flights.csv"

*	Output files will be created in the directory as the files provided as arguments to run the command.

## INTRODUCTION:

We will build a flight booking application using at least three design patterns. The application should maintain an internal, static database (inventory of flight details) (this may be developed using HashMap’s and/or other built-in Java Data structures). This means once we re-run the program, the changes to the data would not persist. We will provide the data that has to be maintained. The data will contain the following tables and fields:

Table 1: Flights
* Category (Economy, Premium Economy, Business)
* Flight number
* The available Seats of each category
* Price of each seat
* Arrival City
* Departure City

## DESIGN PATTERN(S):

* Singleton
* Factory
*	Chains of Responsibility

### SINGLETON:
* It is creational design pattern that lets you ensure that a class has only one instance, while providing the global access point to this instance.
* This pattern is used to build the database for the application. Only the Database class is used as part of this pattern.
* Whenever an instance of the database is needed, the getInstance() method is called so that only one instance of the object can be reused.

  <img height="350" width="700" alt="image" src="https://user-images.githubusercontent.com/89233753/164509029-0e9a3840-cb44-48b1-8822-f0bdb30ef4ec.png">

### FACTORY:
* It is a creational design pattern that provides an interface for creating objects in a superclass but allows subclasses to alter the type of objects that will be created.

* We have used this pattern to output when an order is processed. The following files are as part of this pattern implementation:
- Interface OutputFile
- Class CheckoutFile
- Class ErrorFile

* When the respective concrete handler figures out the output should be a checkout file or error file, we will create an object of OutputFile. The FileReader class is used to read and create files in the application.

  <img height="400" width="700" alt="image" src="https://user-images.githubusercontent.com/89233753/164509056-8ec2c19e-3a69-4f70-97d2-85aeec845ca3.png">


### CHAINS OF RESPONSIBILITY:
* It is a behavioral design pattern that lets you pass requests along a chain of handlers. Upon receiving a request, each handler decided either to process the request or to pass it to the next handler in the chain.
* We have used this design pattern to determine if the order can be processed correctly or not. The following files are used in this pattern:

    - Interface ValidationHandler
    - Class FlightPresenceValidation
    - Class FlightSeatValidation.
    - Class CardValidation

* Before we verify the order can be processed or not, ValidationHandler object is created and will be passed on from one Handler to another using the same.

  <img height="400" width="700" alt="image" src="https://user-images.githubusercontent.com/89233753/164509107-7f80b18d-ec3d-4313-8cdf-9d9217023651.png">

