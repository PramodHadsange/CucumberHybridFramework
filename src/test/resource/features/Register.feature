Feature: Registration functionality

Scenario: User creates an account only with mandatory fields
Given User navigates to Register Account Page
When User enters the details into below fields
|firstName|Pramod                  |
|lastName |Hadsange                |
|telephone|1234567890              |
|password |12345                   |
And user selects privacy policy
And user clicks on continue button
Then User account get created successfully


Scenario: User creates an account only with all fields
Given User navigates to Register Account Page
When User enters the details into below fields
|firstName|Pramod                   |
|lastName |Hadsange                 |
|telephone|1234567890               |
|password |12345                    |
And User selects Yes for Newsletter
And user selects privacy policy
And user clicks on continue button
Then User account get created successfully

Scenario: User creates an duplicate account
Given User navigates to Register Account Page
When User enters the details into below fields with duplicate email
|firstName|Pramod                  |
|lastName |Hadsange                |
|email    |Phadsange20@gmail.com   |
|telephone|1234567890              |
|password |Swami@123               |
And User selects Yes for Newsletter
And user selects privacy policy
And user clicks on continue button
Then User should get proper warning about duplicate email

Scenario: User creates an account without filling details
Given User navigates to Register Account Page
When User dont enters the details into below fields
And user clicks on continue button
Then User gets proper warning message for every mandatory fields





