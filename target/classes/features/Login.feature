Feature: Login functionality

Scenario Outline:  Login with valid credentials
Given User navigates to login page
When User enters valid email address <username> into email field
And User enters valid password <password> into password field
And User clicks on Login button
Then User should get successfully logged in
Examples:
|username                  |password       |
|phadsange20@gmail.com     |Swami@123     |
|pramod.hadsange@gmail.com |Pramod@123    |
|pramod.hadsange1@gmail.com|Swami@123     |


Scenario: Login with invalid credentilas
Given User navigates to login page
When User enters invalid email address "phasa@123" into email field
And User enters invalid password "Swan@123" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with valid email and invalid password
Given User navigates to login page
When User enters valid email address "phadsange20@gmail.com" into email field
And User enters invalid password "Swan@123" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with invalid email and valid password 
Given User navigates to login page
When User enters valid email address "phads20@gmail.com" into email field
And User enters invalid password "Swami@123" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch


Scenario: Login without providing any credentials
Given User navigates to login page
When User dont enter email address into email field
And User dont enter password into password field 
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch







