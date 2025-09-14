# SwiggyJavaAutomation
This website has been tested with Selenium and Java.
##
- Launching the Swiggy website  
- Searching for restaurants  
- Selecting food items and adding them to the cart  
- Entering delivery address details  
- Proceeding to the payment page (without actual payment)  
- Validating correct navigation and user interface elements  

Tech Stack  

- Programming Language: Java  
- Automation Tool: Selenium WebDriver  
- Build Tool: Maven  
- Dependency Manager: WebDriverManager   

## Project Structure  
Swiggy-Automation/  
│── src/main/java/ 
      testingOfSwiggy.java
│── pom.xml               # Selenium  
-->
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.35.0</version>
</dependency>
 



## Setup & Execution Steps  

1. Clone the repository  
   git clone https://github.com/<your-username>/swiggy-automation.git  
   cd swiggy-automation  

2. Install dependencies  
   Make sure you have:  
   - Java (JDK 8 or above)  
   - Maven installed  


3. Run the tests  
   mvn test  



##Demo Video  

Click Here to Watch Execution  

Key Highlights  

- No hardcoded driver paths (uses WebDriverManager)  
- The code is modular and reusable  
- Easily executable on any new system  
