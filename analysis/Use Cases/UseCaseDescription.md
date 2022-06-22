<ins> **Use Case Descriptions** </ins>
___
| Name | 		Create a booking |
|:-:|-| 
| Actor |		Sales Employee |  
|Description| 	Sales Employee creates a booking for  customer  |
|Pre-condition|The sales employee needs to be logged in(optional) <br> Flight needs to exist in the system
|Scenario| 	1. System offers option to create a booking <br> 2. User selects option to create a booking  <br> 3. System checks if a flight was already selected <br> 4. System confirms selected flight and displays booking creation form <br> 5. User fills out booking form and submits <br> 6. System confirms submission and offers additional options for the booking <br>	7. User <ins>adds option</ins> to the booking and submits selection <br> 8. System confirms submission and displays an overview of given input <br> 9. User checks with Customer entered information and confirms input <br> 10. System displays that input was registered and outputs Tickets to sell <br> 11. User <ins>sells tickets <ins> to the customer|
|Result|		Employee created a booking for a customer  
|Exception| 	3. A flight was not selected yet <br> 3.1 System directs user to flight selection <br> 3.2 User must <ins>look up a flight</ins> and confirm <br> 3.3 System checks for free Space in selected flight and allows further creation if there are vacant seats|

___
|Name|Add Option|
|:-:|-|
| Actor |Sales Employee |  
|Description|Sales Employee adds option to a booking|
|Pre-condition|	System offers additional options for the booking
|Scenario| 1. System displays available tickets for additional options <br> 2. User selects ticket for which the options should be applied <br> 3. System confirms selection and displays available options for the ticket  <br> 5. User selects desired options and submits <br> 6. System confirms submission and displays available tickets for options again <br>|
|Result| Employee added options for one or multiple tickets  
|Exception| -|
___
|Name|Sell Ticket|
|:-:|-|
| Actor |Sales Employee |  
|Description|Sales Employee sells ticket to a customer|
|Pre-condition|	System confirmed booking of a flight and created tickets to sell|
|Scenario| 1. System hands created ticket to User and asks for correct output of ticket <br> 2. User receives ticket and confirms correct output  <br> 3. System continues selling process, displaying total price of the booking and asking for given money <br> 4. User enters amount of money provided by the customer and confirms <br> 5. System calculates difference between the price and payment and offers option to finish payment <br> 6. User finishes payment process by confirming payment <br> 7. System finishes buyment process and displays booking creation and flight search option| 
|Result| Employee added options for one or multiple tickets  
|Exception| 2. The received ticket is faulty <br> 2.1 User selects option for wrong ticket <br> 2.2 System goes back in creation process to change information for the booking <br> 2.3 User continues from step 2 after amending the booking |
___
<ins> Sales Employee books a flight </ins>

Name: Sales Employee books a flight  
Actor: Sales Employee  
Description: Sales Emloyee books a flight for a costumer  
Pre-Condition: A costumer wants to book a flight  
Scenario:
1. A Customer wants to book a flight and gives the sales employee the information
2. Sales employee looks if the flight is available or not
3. System shows all flights which are similar to the search
4. Sales employee is picking the searched flight
5. System asks for information to the booking
6. Sales employee gives the requested information and ends the booking
7. System saves the information and gives a booking ID

Result: Sales Employee booked a flight  
Exception: Flight is already booked out  
Extension: Sales Employee can't book a flight because it is booked out  

___
<ins> Sales Employee looks up flight information </ins>

Name: Sales Employee looks up flight information  
Actor: Sales Employee  
Description: Sales Employee looks up flight information for him or a costumer   
Pre-Condition: Sales Employee or a costumer wants to get informations to a flight  
Scenario:
1. Sales Employee searches for the flight he want to get information of
2. System shows all results of the search
3. Sales Employee clicks on the flight from which he wants the information off
4. System shows all informations of the selected flight

Result: Sales Employee found the informations of the flight  
Exception: The system could not find the searched flight  
Extension: Sales Employee can't look up flight information if the flight doesn't exist  
___
<ins> Register upcoming flights </ins>

Name: Register upcoming flights  
Actors: Sales Officer  
Description: Sales Officer registers new upcoming flights to the application  
Pre-Conditions: Sales Officer has new flights to register  
Scenario:	
1. Sales Officer logs into the application.
2. System logs him in and displays home screen.
3. Sales Officer selects flights.
4. System shows list of all flights.
5. Sales Officer clicks on add upcoming flight.
6. System offers possibility to add new flight to the list.
7. Sales Officer enters the data for the upcoming flight and confirms it.
8. System adds the new flight to the list of all flights.

Result: A new upcoming Flight is added to the application  
Exceptions: None  
Extensions: None  
___
<ins> Sales manager wants to see Managementboard </ins>

Use Case Name: Sales manager wants to see Managementboard  
Actors: Sales Manager  
Description: Sales Manager wants to see the Management  
Pre-Conditions:  
Scenario: 
1. Sales manager logs into the application.
2. System logs him in and displays start website.
3. Sales manager selects Management Board.
4. System shows all key performance indicators.
5. Sales manager selects one key performance indicator.
6. System shows the results for the selected key performance indicator.

Result: The manager is informed about all flights and can give information about them.  
Exceptions: Sales Manager can't Log-in, because of wrong userdata  
Extensions: Sales Manager can't see the Management Board because there is to less information about the flight.  
___
<ins> Flight Price Reductions </ins>

Name: Flight Price Reductions  
Actor: Sales Officer  
Description: Sales Officer reduces the price of a specific Ticket, requested from the sales employee.  
Pre-Condition: The sales employee made a request for a reduction of a price. Sales Officer is logged in  
Scenario:
1. Sales Officer wants to see the listed request.
2. The system displays all request which are not processed yet.
3. Sales Officer chooses a request.
4. System shows all details from the request.
5. Sales Officer chooses the option "request granted".
6. The system forwards the confirmation to the sales employee.
7. System displays a notification, that confirmation was successful.

Result: The reduction of the Price was granted.  
Exception: None  
Extension:  

5a. Sales Officer chooses the option "request denied".  
6. The system forwards the rejection to the sales employee.  
7. System displays a notification, that rejection was successful.
___
<ins> Sales Employee chooses pay option for Customer </ins>

Use Case Name: Customer wants to pay in a certain way for a flight  
Actors: Sales Employee, Customer  
Description: -None-  
Pre-Conditions: Sales Employee is logged in.  
Scenario:
1. Sales Employee selects a flight. (Input)
2. System displays the details of the flight. (Output)
3. Sales Employee chooses the booking option. (Input)
4. System displays the Paying-Options (Output)
5. Sales Employee chooses a Paying-Option (Input)
6. System asks to confirm the choise. (Output)
7. Sales Employee confirms his/her choise. (Input)

Result: Systems shows a message of an successful Booking-Process. Flight is booked. (Output)  
Exceptions:  
1. Sales Employee can't Log-in, because of wrong userdata.
2. The payment of the flight isn't successful due to an unvalid bank-account.
3. The flight isn't avaible anymore, because all seats of the plane are already occupied.
___

<br>

| Name: | Look at Revenue numbers |
|-|-|
| Actor: | Sales manager |
| Description: | - |
| Pre-condition: | Logged in as a Sales manager |
| Main success scenario: | 1.Actor opens Management Dashboard <br>2.System calculates revenue numbers from Sales and other Entities <br>3.System presents the Actor the Management Dashboard with the revenue numbers |
| Result: | Actor successfully opened Management Dashboard |
| Extensions: | 2a. Nothing to calculate with <br>1. System presents the Actor the Management Dashboard with default value |
| Exceptions: | - |

<br>

|Name: | Inspect Statistics |
|-|-|
| Actor: | Sales Manager |
| Description: | Sales Manager wants to view the Statistics on the management board |
| Pre-condition | Sales Manager is logged in |
| Main success scenario: | 1. The sales Manager selects management board <br> 2. The system loads the management board <br> 3. The sales Manager chooses what statistic he/she wants to see <br> 4. The System loads the statistic for chosen selection |
| Extensions: | - |
| Exceptions: | 4. System Message: "No statistics to show" <br> 4a. End of use case |
