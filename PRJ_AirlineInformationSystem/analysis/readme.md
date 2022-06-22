# Analysis

This directory is for all the analysis artefacts.  

In order to start  implementing we firstly have to Analyse the business and functional requirements of this project (Airline Information System). To do so we created some artefacts that are going to help us further designing the application
 -  User Stories - Understand the business requiremnets. helps to create use cases
 -  Data Dictionary - helps to understand some key terms used in this documentation and on the duration of the project
 -  Domain Model - helps to visualize the domain of the the project, what are the entities, relationships between them? 
 -  Use Case Descriptions - understand the use cases...how it should work the application
 -  Use Case Diagram - helps visualizing the use cases and the relationship between them and the actors
 -  Test Scenarios - helps with understanding how the system sould be tested in the implementation part
 -  Activity Diagram - helps visualising how use cases relate to each other/in which order a use case should be implemented
---
# User Stories

 ## Sales officer:

 -  As a sales officer I need to be able to register upcoming flights to provide customers with the latest possibilities and to start the sales process later.

 - As a sales officer I want to start the sales process for registered flights to sell as much as possible.

 - As a sales officer I want to be able to provide temporary price reductions to provide customers with offers they might be interested in.


 ## Sales employee:

 - As a sales employee I want to lookup available flights to be sure there are available flights for the customer.

 - As a sales employee I need to be able to create a booking for a flight for one or more customers
for a specific flight to reserve that fly.

 - As a sales employee i want to be able to add extra paid options as extra legroom, food, luggage and seats chosen to satisfy the customer's needs.



 ## Sales manager:

 - As a sales manager I want to get a statistical overview on the management dashboard to plan future sales strategies

 - As a sales manager I want to view total revenue numbers for each route to keep track of the business sucsess

 - As a sales manager i want to view the number of tickets sold in each class for a flight/route to plan future sales/marketing strategies.
 
  -  As a sales manager i want to view statistics on all paid options.

--- 

# Data Dictionary

| Entity | Description |
| --- | --- |
| Airplane | A flying vehicle that transports passengers.|
| Arrival | A specific place at which a airplane will arrive. |
| Account | An online formal business arrangement by which users can perform activities such as purchasing and searching tickets. There are three kinds of accounts in accordance  with the three user groups: sales Employee accounts, sales manager accounts and sales Officer accounts. |
| Aiport | An arrival or destination point of a flight. It is located in a country and a city and has a unique code (IATA). |
| Arrival Airport | The airport at which the flight ends |
| Airline | An organization providing a regular public service of air transport on one or more routes. |
| Arrival time| The moment at which a conveyance is scheduled to get to a given destination. |
| Booking | The act of reserving a flight in advance. |
| Class | is a quality of accommodation on public transport |
| Customer | A person who is on the receiving end of the sales operation. The one booking the flight.|
| Departure | A place at which a airplane will take off. |
| Departure airport | The airport from which the planes take off |
| Departure time | The exact time at which the plane takes off |
| Destination | The location of the airport in which the plane will land |
| Distance | the length of the space a plane needs to travel between departure and arrival |
| Date | The day of the month or year as specified by a number. | 
| Discount | a deduction from the usual cost of the booking price |
| Static discount | A discount that does not change.it remains the same. 10% price reduction for a limited period |
| Dynamic discount |A discount that varies depending on a factor |
| Dashboard | An overview of specific key information on one page |
| Flight | A route traveled with an aircraft |
| Flight number | The identification number of the flight   |
| Flight schedule | A schedule which displays arrival and departure times of all flights |
| Flight options | Extra privileges a user can pay for: extra legroom, food, extra luggage KGs and specific seat |
| Flight route | a way or course taken in getting from a starting point to destination |
| First name | The first name of a person. |
| Id number |A unique number assigned in order to help identify the object |
| In between stop |the break between two flights, flights belong to one booking |
| Key performance indicators (KPI)| KPIs are important indicators for the company which include total revenue numbers, number of tickets in each class, and statistics on all options sold. |
| Last name | The last name of a person. |
| Luggage capacity | The max amount of luggedge a plane can carry. |
| Luggage weight | The weight of a luggage that belongs to a user. At default the maximum is 20 kilograms, and with paid options this can be increased to 25 kilograms. |
| Management dashboard | Interface for sales managers which provides information such as total revenue numbers, number of tickets sold in each class, statistics on all options sold and flight status (information about cancellation etc.). |
| Passenger | A passenger is a person who intends to travel on a flight scheduled by the company |
| Password | A secret and encrypted combination of Signs that are needed to gain access to an account. Meant as a security measure. 50 characters at most. Alpha-numeric.|
| Route | A direct or indirect path from point A to point B, consisting of one or more flights. |
| Sales manager | A person who keeps a financial overview of different flights and sales numbers |
| Sales employee  | A person who works on sales, who sell bookings for specific flights |
| Sales officer | A person who registers all information about upcoming flights and initiates the sales process for already registered flights |
| Seat | A position where a passenger can sit in an airplane. |
| Seat Capacity | The max number of seats in an airplane during a flight. |
| Sales Officer | A person who needs to be able to register upcoming flights and start the sales process for registered flights. |
| Sales Employee | A person who wants to lookup available flights and create bookings for one or more persons for a specific flight. |
| Sales Manager | A person who wants to check the management dashboard for important KPIs. |
| Person | A person who is booking a flight from one place to another in an airplane. |
| Tickets | A major entity that can be bought by customers. They grant access to flights. The price varies due to several factors: luggage weight, flight duration, static and dynamic discounts on the price and also the quantity.|
| Time | It tells when a flight will departure |
| Timezone | It tells the local time for that area and its is defind with 3 characters for example CET |
| Total revenue | total revenue is the full amount of total sales. |

---


# Domain Model

 <img src = https://github.com/FontysVenlo/prj2-2022-prj2-2022-g13/blob/main/analysis/Domain%20model/FINAL.jpg>
 
 ---
 
# Use Case Descriptions

___

 | Name: | Register flight |
|-|-|
| Actor: | Sales officer |
| Description: | Sales officer wants to be able to register upcoming flights |
| Pre-condition: | 1. Actor is logged in <br> 2. Actor has permission to register a flight |
| Main success scenario: | 1. Actor clicks on register flight. <br>2. System returns the register flight page.<br>3. Actor fills in data required to register a flight. <br>4.System checks if all the information has been correctly fully filled.<br>5. System checks if the information entered matches an already registered flight<br>6. System registers the flight. |
| Result: | Actor has registered a flight successfully|
| Extensions: | - |
| Exceptions: | 4.0 System message: “NOT ALL FIELDS ARE FILLED IN!”.<br>4.1 system outputs error massages  where the information have been incorrectly added.<br> 4.2 go back to step 3 .<br>5.System message: “Flight is already registered” <br>5.1 go back to step 3 |
---
|Name|Sell Ticket|
|:-:|-|
| Actor |Sales Employee |  
|Description|Sales Employee sells ticket to a customer|
|Pre-condition|	Sales employee is logged in. there are registered flights|
|Scenario| 1. User selects sell tickets option <br> 2. system asks to <ins>create booking</ins>  <br> 3. User created booking <br> 4.system calculates price of booking <br> 5. System prints ticket info for created booking <br> 6. User sends ticket to customer for a surcharge| 
|Result| Employee sold ticket for created booking |
|Exception| 5. The received ticket is faulty <br> 2.1 User selects option for wrong ticket <br> 2.2 System goes back in creation process to change information for the booking <br> 2.3 User continues from step 3 after checking the booking |

 
 ___
 | Name | 		Create a booking |
|:-:|-| 
| Actor |		Sales Employee |  
|Description| 	Sales Employee creates a booking for  customer  |
|Pre-condition|The sales employee needs to be logged in <br> Flight needs to exist in the system|
|Scenario| 	1. System offers option to create a booking <br> 2. User selects option to create a booking  <br> 3.System asks to add flight/s br> 4. User <ins>Looks up flight</ins> & selects it/them<br> 5. system dysplays the selected flight and saves it to the booking/s <br> 6. User selects <ins>provide discount</ins> for entire booking <br>	7. System saves the provided discount <br> 8. User <ins>adds option</ins> to the booking and submits selection <br> 9. System saves created  booking<br> 10. User <ins>sells tickets <ins> to the customer |
|Result|		Employee created a booking for a customer  
|Exception| 	5. No discount <br> 5.1 System system selects no discount <br> 5.2 Go to step 8. |

___
 
| Name | Look up flight  |
|:-:|-|
| Actor | Sales Employee |
| Description | Sales Employee looks up flight information for a costumer to continue the booking proccess |   
| Pre-Condition | Sales Employee logged in. Registered flights available. the booking proccess started| 
| Scenario | 1.user selected look up flight option<br> 2. System shows all registered flightsbr> 3. user selects preffered flight<br> 4. system saves selected flight.|
| Result | Sales Employee found and selected a flight for the starde booking proccess |
| Exception |none|
| Extension |none|
 
---
 |Name|Add Option|
|:-:|-|
| Actor |Sales Employee |  
|Description|Sales Employee adds option to a booking|
|Pre-condition|	System offers additional options for the booking. user looged in. started procces for creating a booking|
|Scenario| 1. User selects add options option <br> 2.system displays available options(class,seatNr,extra legroom,food,luggage.NoOptions-random seat provided) <br> 3. User selects wanted options and submits  <br> 4. System confirms submission |
|Result| Employee added options for one or multiple flights for the ongoing booking creation|
|Exception| -|
___

| Name| Provide Discount| 
|:-:|-|
| Actor | Sales Officer |
| Description | Sales Officer reduces the price of a specific booking|  
| Pre-Condition | Sales Officer is logged in. exists at least one booking in process | 
| Scenario | 1.User selects Provide discount option<br> 2.system displays static and dynamic discounts<br> 3.user choose one provided discount <br> 4.system saves the discount to the started booking<br>5.user goes back to finish the started booking| 
| Result | The discount was provided for a booking |
| Exception | None | 
| Extension | none | 
 
 
---

 
 | Name: | Look at Revenue numbers |
|-|-|
| Actor: | Sales manager |
| Description: | - |
| Pre-condition: | Logged in as a Sales manager |
| Main success scenario: | 1.Actor opens Management Dashboard <br>2.System calculates revenue numbers from Sales and other Entities <br>3.System presents the Actor the Management Dashboard with the revenue numbers |
| Result: | Actor successfully opened Management Dashboard |
| Extensions: | 2a. Nothing to calculate with <br>1. System presents the Actor the Management Dashboard with default value |
| Exceptions: | - |

___
 
 |Name: | Inspect Statistics |
|-|-|
| Actor: | Sales Manager |
| Description: | Sales Manager wants to view the Statistics on the management board |
| Pre-condition | Sales Manager is logged in |
| Main success scenario: | 1. The sales Manager selects management board <br> 2. The system loads the management board <br> 3. The sales Manager chooses what statistic he/she wants to see <br> 4. The System loads the statistic for chosen selection |
| Extensions: | - |
| Exceptions: | 4. System Message: "No statistics to show" <br> 4a. End of use case |
 
---


 
| Use Case Name | view statistics | 
|:-:|-|
| Actors | Sales Manager |
| Description | Sales Manager wants to see the Management board | 
| Pre-Conditions |  | 
| Scenario | 1. Sales manager logs into the application<br> 2. System logs him in and displays start website<br> 3. Sales manager selects Management Board<br >4. System shows all key performance indicators<br> 5. Sales manager selects one key performance indicator<br> 6. System shows the results for the selected key performance indicator. |
| Result | The manager is informed about all flights and can give information about them. |
| Exceptions | Sales Manager can't Log-in, because of wrong userdata | 
|Extensions | Sales Manager can't see the Management Board because there is to less information about the flight | 
___
___
# Use Case Diagram

   <img src= https://github.com/FontysVenlo/prj2-2022-prj2-2022-g13/blob/main/analysis/Use%20Cases/UseCaseDiagramFInal.jpg>
 
 ---
 
# Test Scenarios


## Register Flight
| Step Number | Description |
|-|-|
|1|check system behaviour when valid required data is entered|
|2|check system behaviour when invalid required data is entered|
|3|check system behaviour when "Submit" button is pressed and all required data is not entered|
|4|check system behaviour when "Submit" button is pressed and all required data is  entered|
|5|check system behaviour when "cancel" button is pressed and all required data is not entered
|6| check system behaviour when "go Back" button is pressed |

 
 ## Register Flight
| Step Number | Description |
|-|-|
|1|Actor clicks on register flight option.|
|2|System returns the register flight page(form to complete with:airplaneID, arrival/departure airport,arrival date, arrival time, departure time, flight ID ).|
|3|check system behaviour when "Submit" button is pressed and all required data is not entered|
|4|check system behaviour when "Submit" button is pressed and all required data is  entered|
|5|check system behaviour when "cancel" button is pressed and all required data is not entered
|6| check system behaviour when "go Back" button is pressed |
 ___
 
|Name|Sell Ticket|
|:-:|-|
| Actor |Sales Employee |  
|Description|Sales Employee sells ticket to a customer|
|Pre-condition|	System confirmed booking of a flight and created tickets to sell|
|Scenario| 1. check system behaviour when user selects sell tickets option2. check system behaviour when user selects create booking  <br> 3.check system behaviour after user created booking <br> 4. check system behaviour when system provides ticket info for created booking <br> 5. check system behaviour when ticket sent | 
 |

 
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
<ins> Sales employee wants to lookup flight: </ins>

- Sales Employee Logs-in
- Sales Employee wants to look up sold flights
- The System displays all information about the flight

 |Name|Add Option|
|:-:|-|
| Actor |Sales Employee |  
|Description|Sales Employee adds option to a booking|
|Pre-condition|	System offers additional options for the booking
|Scenario| 1. System displays available tickets for additional options **(Ticket ID: xyz, Ticket ID: 123)** <br> 2. User selects ticket for which the options should be applied **(Ticket ID: 123)** <br> 3. System confirms selection and displays available options for the ticket **(Legroom, Luggage, Food)**  <br> 5. User selects desired options and submits **(Food)** <br> 6. System confirms submission and displays available tickets for options again **(Ticket ID: xyz, Ticket ID: 123)** <br>|
|Result| Employee added options for one or multiple tickets  
|Exception| -|
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
<ins> Sales manager wants to see Management board: </ins>

Sales Manager logs into the application with his credentials.  
System logs him in and displays the home screen.  
Sales Manager selects Management Board  
System shows all key performance indicators of the Management board  
Sales Manager selects view total revenues  
System shows all the revenues of the 30 days  

___
<ins> Sales Manager wants to view the sold tickets: </ins>

- Sales Manager logs-in
- System logs him in and gives access to homescreen
- Sales Manager selects flight
- Sales Manager selects sold tickets 
- System shows all ticktes that are sold


inspect statistics

___



 
# Activity Diagram

 <img src = https://github.com/FontysVenlo/prj2-2022-prj2-2022-g13/blob/main/analysis/ActivityDiagrams/Activity%20Diagram.svg>
 
 Updaded version: 
 
 <img src =https://github.com/FontysVenlo/prj2-2022-prj2-2022-g13/blob/main/analysis/ActivityDiagrams/FINAL_ActivityDIagram.jpg>
 
 
 ___
 
Go to  [Design](https://github.com/FontysVenlo/prj2-2022-prj2-2022-g13/tree/main/design)
