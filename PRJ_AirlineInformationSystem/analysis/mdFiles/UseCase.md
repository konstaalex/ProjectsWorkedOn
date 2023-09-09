# Table of contents
1. [Sales Officer](#salesofficer)<br/>
    1.1. [Create static discount](#creatediscountstatic) <br/>
    1.2. [Create dynamic discount](#creatediscountdynamic) <br/>
    1.3. [Registering flight](#registerflight) <br/>
    1.4. [Edit discount](#editdiscount) <br/>
    1.5. [Remove discount](#removediscount) <br/>
    1.6. [Edit flight](#editflight) <br/>
    1.7. [Edit route](#editroute) <br/> 
     1.8. [Remove flight](#cancelflight) <br/>
    1.9   [Cancel route](#cancelroute) <br/>
2. [Sales Manager](#salesmanager)<br/>
    2.1. [View dashboard](#dashboard) <br/>
3. [Sales Employee](#salesemployee)<br/>
    3.1. [Create booking](#createbooking) <br/>
    3.2. [Remove booking](#removebooking) <br/>
    3.3. [Modify booking](#editBooking) <br/>
    3.4. [Searching booking](#searchingbooking) <br/>
    3.5. [Look up flight](#searchflight) <br/>
    3.6. [Registering route](#registerroute) <br/>


<h3>  <a name="salesofficer"></a>  Sales officer </h3>

| Name: | <a name="creatediscountstatic"></a> Provide static discount |
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Actor: | Sales officer |
| Description | Sales officer provides a static discount |
| Pre-condition | Sales officer has access to the system <br/> Flight or route needs to exist in the system  |
| Scenario: | 1. User is [looking- up for a flight](#searchflight) and selects a flight or route. <br> 2. System confirms selection for choosing either static or dynamic discount. <br> 3. User selects the type of the discount (in this case static).  <br/> 4. System confirms the `amount` that should be applied. <br> 5. User enters the `amount` of the discount to be applied for the flight or route. <br> 6. System subtracts price by the discount amount on the selected route or flight. <br> 7. Sales officer confirms the change. <br/> 8. System updates the current price.|
| Results: | Static discount is applied for a flight or a route |
| Exceptions: | 5. User enters invalid amount - system displays an error message <br> 5.1. Use case ends here. <br> 7. User decides not to confirm the change, the system displays a message informing that no changes were made.<br> 8. System fails to update the current price, the system displays an error message. |
| Extensions: |1.1 User selects the [Edit discount](#editdiscount).  <br/> 1.2 User continues with the [Edit discount](#editdiscount) use case. <br/> 1.1 User selects the [Remove discount](#removediscount).  <br/> 1.2 User continues with the [Remove discount](#removediscount) use case. <br/> |


| Name: | <a name="creatediscountdynamic"></a> Provide dynamic discount |
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Actor: | Sales officer |
| Description | Sales officer provides a dynamic discount |
| Pre-condition | Sales officer has access to the system <br/> Flight or route needs to exist in the system <br/>  |
| Scenario: | 1. User navigates in the system in order to create discount <br> 2. System confirms selection for choosing either static or dynamic discount. <br> 3. User selects the type of the discount (in this case dynamic). <br> 4. System connects to the external API and retrieves available discounts for the selected flight or route. <br> 5. System displays available discounts to the sales officer. <br> 6. Sales officer selects a discount and confirms the selection. <br> 7. System subtracts the price by the selected discount amount on the selected route or flight. <br> 8. Sales officer confirms the change. <br> 9. System updates the current price.|
| Results: | Dynamic discount is applied for a flight or a route|
| Exceptions: | 4. System fails to connect to the external API, the system displays an error message. <br> 5. No discounts are available for the selected flight or route, the system displays a message informing the sales officer. <br> 6. Sales officer cancels the selection, the use case ends here. <br> 8. Sales officer decides not to confirm the change, the system displays a message informing that no changes were made. <br> 9. System fails to update the current price, the system displays an error message.
| Extensions: |1.1 User selects the [Edit discount](#editdiscount).  <br/> 1.2 User continues with the [Edit discount](#editdiscount) use case. <br/> 1.1 User selects the [Remove discount](#removediscount).  <br/> 1.2 User continues with the [Remove discount](#removediscount) use case. <br/> |


| Name: | <a name="registerflight"></a>  Registering flight |
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Actor: | Sales officer |
| Description | Sales officer is registering one flight |
| Pre-condition | Sales officer has access to the system |
| Scenario: | 1. User navigates through the system in order to create a new flight. <br> 2. System is providing for the user to input flight details. <br> 3. User fills in the details for the new flight : `flight number`, `aircraft type`, `seat capacity`,`departure time`,`arrival time`. <br> 4. System validates the information provided by the user. <br> 5. If there are no errors, the system saves the new flight to the database and shows a confirmation window. <br>|
| Results: | Sales officer registered one flight |
| Exceptions: |3. User enters incomplete or invalid information for the new flight and system displays an error message <br> 3.1. Use case ends here. <br> 4. System is checking if there are any conflicts (if a flight with the same number or departure/arrival airports already exists). If there is a conflict, the system will display an error message and the use case ends.|


| Name: | <a name="editdiscount"></a> Edit discount |
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Actor: | Sales officer |
| Description | Sales officer is editing discount |
| Pre-condition | Sales officer has access to the system <br> discount exists for an existing flight or route  |
| Scenario: | 1. User navigates to the "Discounts" section of the application. <br/> 2. System shows discounts that already are active on the existing flight or route. <br> 3. User selects the discount to be modified and applies the amount to be changed. <br> 4. System validates the new discount amount and updates it. |
| Results: | Sales officer edited an existing discount|
| Post - condition | Any customers who qualify for the updated discount will receive it on their next purchase.|
| Exceptions: | 3. The system detects invalid discount information and displays an error message. <br/> 3.1. Use case ends here. |

| Name: | <a name="removediscount"></a> Remove discount|
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Actor: | Sales officer |
| Description | Sales officer is removing a discount |
| Pre-condition | Sales officer has access to the system <br> There are existing discounts in the system that the sales officer can delete |
| Scenario: | 1. User navigates to remove discounts. <br> 2. System shows all the available discounts. <br> 3. User selects the discount that should be deleted. <br> 4. System confirms if the discount should be deleted. <br> 5. System deletes the discount. |
| Results: | Sales officer deletes an existing discount.|
| Exceptions: | 4. Sales officer cancels the removal of the discount. <br> 4.1. Use case ends here.|


| Name: | <a name="editflight"></a>  Edit flight |
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Actor: | Sales officer |
| Description | Sales officer is editing a flight |
| Pre-condition | Sales officer has access to the system <br> There are existing flights in the system that can be edited |
| Scenario: | 1.User select the flight that needs to be edited. <br> 2. User navigates to edit an existing flight. <br> 3. System displays a form with the current details of the flight (the departure or arrival airports, flight number, departure time, seats, etc) <br> 4. User modifies the details of the flight. <br> 5. System validates the new information provided by the user. <br> 6. System updates the informations provided by the user.|
| Results: | Sales officer edited an existing flight|
| Exceptions: | 4. User enters incomplete or invalid information for the updated flight. <br> 4.1 System displays an error message. <br> 4.2 Use case returns to step 3. <br> 5. System is checking if there are any conflicts with the new flight details, such as conflicts with existing flights or departure/arrival airports. <br> 5.1 If there is a conflict, the system will display an error message and the use case returns to step 4.|

 Name: | <a name="editroute"></a>  Edit route|
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Actor: | Sales officer |
| Description | Sales officer is editing a route |
| Pre-condition | Sales officer has access to the system <br> There are existing routes in the system that can be edited|
| Scenario: | 1. User selects the route that needs to be edited. <br> 2. User navigates to edit routes. <br> 3. System shows the list of existing routes. <br> 4. User selects the route to be modified. <br> 5. System displays a form with the current details of the selected route (route name, departure and arrival airports, and the flights included in the route). <br> 6. User makes the demanded changes to the route details (change the route name / adding or removing flights). <br> 7. System validates the new information provided by the user. <br> 8. System saves the updated route.|
| Results: | Sales officer edited an existing route details|
| Exceptions: | 7. System detects conflicts with existing routes in the database, such as routes with overlapping flight times or the same flight numbers <br> 7.1 The system alerts the user and provides options for resolving the conflict (choosing a different flight / adjusting the departure or arrival times). <br> 7.2 Use case returns to step 6.|

 Name: |<a name="cancelflight"></a> Remove flight |
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Actor: | Sales officer |
| Description | Sales officer removes an existing flight|
| Pre-condition | Sales officer has access to the system & Flights are registered |
| Scenario: | 1. User selects the flight to remove. <br> 2. System checks if any tickets are booked for this flight. <br> 3. If no tickets are booked, the flight is then removed from the Database. <br> 4. If tickets are booked, the system informs the user that the flight cannot be removed and customers will receive a full refund. <br> 5. System updates database and the flight will no longer be in the database.	|
| Results: | Sales officer is removing flight which was registered|
| Exceptions: |2. System detects tickets are booked for the selected flight and informs the user that the flight cannot be removed but customers will receive a full refund. <br> 3. System removes the flight from the database, and the flight will no longer be in the Database. <br> 4. Use case ends here.|

| Name: |<a name="cancelroute"></a> Cancel route |
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Actor: | Sales officer |
| Description | Sales officer cancels an existing route |
| Pre-condition |condition	Sales officer has access to the system <br> There are existing routes in the database|
| Scenario: | 1. User selects the route to be cancelled. <br> 2. System displays a confirmation message to the user, informing them that all tickets booked on this route will be cancelled and refunded. The message asks the user to confirm the cancellation. <br> 3. If the user confirms the cancellation, the system checks for any conflicts with existing flights or routes, such as overlapping flight times or the same flight numbers. If a conflict is found, the system alerts the user and provides options for resolving the conflict, such as choosing a different flight or adjusting the departure or arrival times. <br> 4. The system cancels the route and refunds all tickets for the cancelled route. <br> 5. System shows a confirmation message to the user that the route has been cancelled and all tickets have been refunded.|
| Results: | Sales officer is removing route which was already registered|
| Exceptions: |2. If the user declines the cancellation, the system returns to the route selection screen. <br> 4. If there are any errors during the cancellation process, such as failure to refund a ticket, the system alerts the user and provides options for resolving the issue. <br> 4.1. Use case returns to step 5.|



<h3>  <a name="salesmanager"></a> Sales Manager </h3>

| Name | <a name="dashboard"></a>	View Dashboard |
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Actor | Sales Manager |
| Description | Sales Manager view the Dashboard |
| Pre-condition | Sales Manager has an updated Dashboard |
| Scenario | 1.Actor opens the Dashboard. <br> 2.Actor log-in into account using his username and password. <br> 3.System checks if the account information of the Actor are correct. <br> 4.Actor selects the Dashboard that he wants to examine (seats, revenue, ticket sales, profit, flights, how many buyers bought extra options, etc). <br> 5.System shows the Actor the selected Dashboard. <br> 6. Actor can examine the Dashboard.
| Result | Sales Manager has successfully examined the Dashboard. |
| Exceptions | 3.System informs actor that the account informations are wrong. <br> 3.1 The Actor is redirected to insert the account informations again. <br> 4.System informs actor that there are no available Dashboards. <br> 4.1 Use case ends here. |


<h3> <a name="salesemployee"></a> Sales employee </h3>

| Name | 	<a name="createbooking"></a> 	Create a booking |
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Actor |		Sales Employee |  
|Description| 	Sales Employee creates a booking for  customer  |
|Pre-condition|Sales employee has access to the system <br> Flight or route needs to exist in the system
|Scenario| 1.User selected flight and number of passengers<br>	2. User selected create booking option<br> 3.System checks for seat availability and offers option to add passenger(s) if there are free seats. <br> 4. System confirms selected flight and displays booking creation form.(first name, last name,passport number and extra options: legroom, food, luggage)<br>5. User fills out passenger(s) form and submits.<br> 6. System confirms submission of passenger(s).<br> 7. System confirms submission and displays an overview of given input. <br> 8. System displays that input was registered.|
|Result| Employee created a booking for a customer |
|Exceptions| 3. If there are no available seats on the selected flight, the system displays an error message.<br> 3.1 User goes back to step 1. if he has to choose a different flight.<br>3.1.1. if the user does not have to choose a different flight, use case ends here.<br/>  5. User submits incomplete or invalid information on the booking form, the system displays an error message. <br> 4.1. Use case ends here.|
|Extentions| - |

| Name: | <a name="editBooking"></a>  Modify booking |
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Actor: | Sales Employee |
| Description | Sales Employee edits an existing booking |
| Pre-condition | Sales employee has access to the system and the booking to be modified exists|
| Scenario: |1. User selected to modify a booking. <br> 2.  User modifies the details they want to change and submits the form. <br> 3. System validates the modified information and checks if the selected flight is still available for the specified departure time.<br> 4.System saves the modified booking . <br> 5. User confirms the changes made by reviewing the updated booking details. |
| Results: | 	Sales employee modified an existing booking for a buyer or passenger  |
| Exceptions: | 2. User submits incomplete or invalid information on the booking form, the system displays an error message. <br> 2.1. Use case ends here. <br> 3.1. If the selected flight is no longer available for the specified departure time, the system displays an error message and prompts the user to select a different flight or adjust the departure time. <br> 3.1. Use case returns to step 2.|    
 

| Name: | <a name="removebooking"></a>  Remove booking |
| ---- | ----------- |
 |<img width=50/>|<img width=1000/>|
| Actor: | Sales employee |
| Description | Sales Employee removes an existing booking |
| Pre-condition | Sales employee has access to the system <br> Booking is existing |
| Scenario: | 1. User types passport number to remove a booking.<br> 2. User clicks remove button. <br> 3. System processes the removal of the booking. <br> 4. System removes the booking from the system and confirms it.|
| Results: | Sales employee successfully removes the booking|
| Exceptions: | - |

    

| Name: | <a name="searchingbooking"></a>  Search Booking |
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Actor: | Sales employee |
| Description | Sales Employee searches for an existing booking|
| Pre-condition | Sales employee has access to the system <br> bookings are already in the system |
| Scenario: |1. User navigates through the system for searching a booking. <br> 2. User enters booking number, customer name, or flight details for the desired booking. <br> 3. System searches the database and displays a list of matching bookings. <br> 4. User selects the desired booking from the list. <br> 5. System displays the booking information for the selected booking.|
| Results: | Sales employee successfully finds booking|
| Exeptions: | 2. User enters an incorrect booking number, customer name or flight details, the system displays an error message.<br> 2.1. Use case ends here. <br> 3. System cannot find any matching booking in the system, the system displays an error message.<br> 3.1. Use case ends here. <br> 4. System displays modifying and removing option for the existing bookings. <br> Use case ends here|
|Extentions|5.a. User selects to [remove booking](#removebooking)<br>5.b User selects to [modify booking](#editBooking) |


| Name: | <a name="searchflight"></a>  Look-up for a flight   |
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Actor: | Sales employee or Sales officer|
| Description | Sales Employee or Sales Officer searching one or more flights |
| Pre-condition | Sales employee has access to the system <br> Flights are registered in the system |
| Scenario: |	1. User navigates through the system to search for a flight. <br> 2. User enters `departure` and `arrival airport`, `travel date`  <br> 3. System searches the database and displays a list of available flights matching the search criteria. <br> 4. User selects the desired flight from the list. <br> 5. System displays the flight information for the selected flight.|
| Results: | Sales employee or Sales officer finds the flight.|
| Exceptions: | 2. User enters an incorrect airport code or travel date/time format, the system displays an error message.<br> 2.1. Use case ends here. <br> 3. System cannot find any matching flight in the system, the system displays an error message.<br> 3.1. Use case ends here. |
|Extention: | 5.a. User is selecting to [Create booking](#createbooking) <br> 5.b.User is selecting to [Create route](#createroute)|


| Name: | <a name="registerroute"></a>  Registering route |
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Actor: | Sales Employee |
| Description | Sales Employee is registering route |
| Pre-condition | Sales Employee has access to the system <br> Flights should be already be registered|
| Scenario: | 1. User navigates through the system in order to create a new route for a flight. <br> 2. System provides a form for the user to input details for the new route, including the `route name` and `route id` and `flight numbers`. <br> 3. User selects `two or more flights` from the available flights in the database to include in the new route. <br> 4. System validates the information provided by the user, checking for errors such as missing or invalid data, and checks if the selected flights are compatible. <br> 5. If the information is valid, the system saves the new route to the database and shows a confirmation window. If there are errors, the system displays an error message to the user.|
| Results: | Sales Employee registered a new route |
| Exceptions: |	3. User selects flights that are not compatible with each other system displays an error message.<br> 3.1. Use case stays at step 2. <br> 4. System checks for conflicts with existing routes in the database, such as routes with overlapping flight times or non compatible airports. If a conflict is found, the system alerts the user and informs the user about this conflict.<br> 4.1. At step 2, user enters valid information <br> 5. System saves the new route to the database and shows a confirmation window to the user.|
