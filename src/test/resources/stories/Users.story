Narrative:
As a user
I want to make sure that all functionality on Users page works as expected

Lifecycle:
Before:
Given I am on the login page of application
And I login to application with username 'admin' and password 'admin123'
And I go to Users page

Scenario: AC-1 Check corectness of filtering #1
Meta: @regression
When I open filter users window
And filter users by Employee Name Alice Duval
And I click on the Search button in Filter Users window
Then record is shown with following parameters:
| Username | User Role(s)                    | Employee Name | Status  | Region |
| alice    | Default ESS, Default Supervisor | Alice Duval   | Enabled |        |

Scenario: AC-2 Filter by Status 'Disabled' and check that Employee with name Cassidy Hope is NOT shown in the search result
Meta: @regression @newTask
When I open filter users window
Then Filter user by Status with option Disabled
When I click on the Search button
Then I check that employee with name Cassidy Hope is NOT shown in the search result

Scenario: AC-3 Filter by Admin Role 'Global Admin' and check that Employee with name Cecil Bonaparte is shown in the search result
Meta: @regression @newTask
When I open filter users window
Then Filter user by Admin Role with option Global Admin
When I click on the Search button
Then I check that employee with name Cecil Bonaparte is shown in the search result


Scenario: AC-4 Check that values saved after closing filter users window
Meta: @regression @newTask @debug
When I open filter users window
Then Filter user by Status with option Disabled
Then Filter user by Admin Role with option Global Admin
When I click on the Search button
And I open filter users window
Then Check that previously entered values saved in Status and Admin Role selects