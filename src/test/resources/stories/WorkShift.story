Narrative:
As a user
I want to make sure that all functionality on Work Shifts page as expected

Lifecycle:
Before:
Given I am on the login page of application
And I login to application with username 'admin' and password 'admin123'
And I go to Work Shifts page

Scenario: AC-1 Check that by default General and Twilight work shifts types are shown on work shifts page
Meta: @regression @newTask
Then Check that rows with values General, Twilight in WorkShift column are shown by default


Scenario: AC-2 Check that Work Shift field on Add work shift model requiired
Meta: @regression @newTask
When I click on Add Work Shift button
And I click on Save button in Add Work Shift window
Then I check that Required error message is shown under Work Shift field

Scenario: AC-3 Check that value in Hours Per Day field calculated propertly
Meta: @regression @newTask
When I click on Add Work Shift button
When I using time picker set 10 : 50 value into From filed
When I using time picker set 18 : 20 value into To filed
Then I check that 7.50 value calculated in Hours Per Day field
When I using time picker set 8 : 05 value into From filed
When I using time picker set 20 : 25 value into To filed
Then I check that 12.33 value calculated in Hours Per Day field

