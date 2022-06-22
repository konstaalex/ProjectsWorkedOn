<ins> Test Scenario Register Upcoming Flight: </ins>

1. Sales Officer logs into the application with his credentials.
2. System logs him in and displays the home screen.
3. Sales Officer selects flights.
4. System shows list of all flights.
5. Sales Officer clicks on add upcoming flight.
6. System shows input form to add new flight.
7. Sales Officer inputs Data for a new flight from New York to Las Vegas,  
StartTime: 9:00, StartDestination: NewYork, ArrivalTime: 15:00, ArrivalDestination: Las Vegas,  
NumberOfSeats: 250 (200 Economy class, 50 First class), no extra paid options
8. System adds the new flight to the list.

# Register Flight
| Step Number | Description |
|-|-|
|1|check system behaviour when valid required data is entered|
|2|check system behaviour when invalid required data is entered|
|3|check system behaviour when "Submit" button is pressed and all required data is not entered|
|4|check system behaviour when "Submit" button is pressed and all required data is  entered|
|5|check system behaviour when "cancel" button is pressed and all required data is not entered
|6| check system behaviour when "go Back" button is pressed |

___
<ins> Test Scenario provide discount: </ins>

1. Sales Officer Logs-in  
2. Sales Officer wants to see the listed request.  
3. The system displays all request which are not processed yet.  
4. Sales Officer chooses a request about a discount of 5%.  
5. System shows that the discounts applies to 2 Persons.  
6. Sales Officer chooses the option "request granted".  
7. The system forwards the confirmation to the sales employee who tells the costumer the updated price.  
8. System displays a notification, to the Sales Officer that confirmation was successful.

___
<ins> Test Scenario Book a Flight: </ins>

1. Worker Logs-in
2. Worker wants to look up available flights
3. The System displays available flights
4. Worker selects a flight, so he can book
5. System asks Worker for informations on the booking
6. Worker enters in all asked Data
7. System saves all Data
8. Worker ends the booking
9. The booking is beeing completed by the system and it returns the booking ID

___
<ins> Sales manager wants to see Management board: </ins>

Sales Manager logs into the application with his credentials.  
System logs him in and displays the home screen.  
Sales Manager selects Management Board  
System shows all key performance indicators of the Management board  
Sales Manager selects view total revenues  
System shows all the revenues of the 30 days  

___
<ins> Sales employee wants to lookup flight: </ins>

- Sales Employee Logs-in
- Sales Employee wants to look up sold flights
- The System displays all information about the flight

add option

sell tickets

look at revenue numbers

___
<ins> Sales Manager wants to view the sold tickets: </ins>

- Sales Manager logs-in
- System logs him in and gives access to homescreen
- Sales Manager selects flight
- Sales Manager selects sold tickets 
- System shows all ticktes that are sold


inspect statistics

___


| Name | 		Create a booking |
|:-:|-| 
| Actor |		Sales Employee |  
|Description| 	Sales Employee creates a booking for a customer  |
|Pre-condition|	Customer wants to book a flight and gave information to Employee
|Scenario| 	1. System offers options to create a booking or look up a flight **(Create Booking, Flight List)** <br> 2. User selects option to create a booking **(Create Booking)** <br> 3. System checks if a flight was already selected **(true or false)** <br> 4. System confirms selected flight and displays booking creation form **(Amount of Tickets, Seat Position, Class, Flight)** <br> 5. User fills out booking form and submits **(2, 13/14, Business Class, F-32)** <br> 6. System confirms submission and offers additional options for the booking **(Extra luggage, Legroom, Food)** <br>	7. User <ins>adds option</ins> to the booking and submits selection **(Legroom, Food)** <br> 8. System confirms submission and displays an overview of given input **(2 Tickets, Business Class, Seat 13/14, <br> Flight F-32, Options: Food, Legroom)** <br> 9. User checks with Customer entered information and confirms input **(Register Booking)** <br> 10. System displays that input was registered and outputs Tickets to sell <br> 11. User <ins>sells tickets <ins> to the customer|
|Result|		Employee created a booking for a customer  
|Exception| 	3. A flight was not selected yet <br> 3.1 System directs user to flight selection <br> 3.2 User must <ins>look up a flight</ins> and confirm <br> 3.3 System checks for free Space in selected flight and allows further creation if there are vacant seats|

___
|Name|Add Option|
|:-:|-|
| Actor |Sales Employee |  
|Description|Sales Employee adds option to a booking|
|Pre-condition|	System offers additional options for the booking
|Scenario| 1. System displays available tickets for additional options **(Ticket ID: xyz, Ticket ID: 123)** <br> 2. User selects ticket for which the options should be applied **(Ticket ID: 123)** <br> 3. System confirms selection and displays available options for the ticket **(Legroom, Luggage, Food)**  <br> 5. User selects desired options and submits **(Food)** <br> 6. System confirms submission and displays available tickets for options again **(Ticket ID: xyz, Ticket ID: 123)** <br>|
|Result| Employee added options for one or multiple tickets  
|Exception| -|
___
|Name|Sell Ticket|
|:-:|-|
| Actor |Sales Employee |  
|Description|Sales Employee sells ticket to a customer|
|Pre-condition|	System confirmed booking of a flight and created tickets to sell|
|Scenario| 1. System hands created ticket to User and asks for correct output of ticket **("Ticket Correct ?", i.e. printed Tickets)** <br> 2. User receives ticket and confirms correct output **(Buttton: Yes)**  <br> 3. System continues selling process, displaying total price of the booking and asking for given money **(Total price: 256€, field to enter given Money)** <br> 4. User enters amount of money provided by the customer and confirms **(Given Money 260€, Button: "Enter" to continue)** <br> 5. System calculates difference between the price and payment and offers option to finish payment **(Change: 4€, Button: Finish Payment)** <br> 6. User finishes payment process by confirming payment **(Press Button: "Finish Payment")** <br> 7. System finishes buyment process and displays booking creation and flight search option **(Button: "Create  Booking", Button: "Search for Flight")** | 
|Result| Employee added options for one or multiple tickets  
|Exception| 2. The received ticket is faulty <br> 2.1 User selects option for wrong ticket <br> 2.2 System goes back in creation process to change information for the booking <br> 2.3 User continues from step 2 after amending the booking |
