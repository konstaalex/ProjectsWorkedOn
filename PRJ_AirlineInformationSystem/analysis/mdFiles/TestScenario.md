# Table of contents
1. [Sales Officer](#salesofficer)
   - [Test for discounts](#testcreatediscountstatic)
      - [Test for providing static discount](#test1)
      - [Test 1: for dynamic discount](#test2)
      - [Test 2: for dynamic discount with invalid input](#test3)
      - [Test 3: Provide dynamic discount with no connection to the external API](#dynamicdiscounttest)
   - [Test for registering flight](#testregisterflight)
     - [Test 1: Register a new flight with valid information](#createflighttest1)
     - [Test 2: Attempt to register a new flight with incomplete or invalid information](#createflighttest2)
     - [Test 3: Registering a new flight with a flight number that already exists](#createflighttest3)
     - [Test 4: Registering a new flight with the same departure and arrival airports as an existing flight ](#createflighttest4)
     - [Test 5: Registering a new flight with the same departure and arrival airports as an existing flight ](#createflighttest5)
   - [Test for editing a flight](#testeditflight)
      - [Test 1: Edit a flight with valid information](#editflighttest1) 
      - [Test 2: Edit a flight with invalid information](#editflighttest2) 
      - [Test 3: Edit is conflict with existing flights](#editflighttest3)
      - [Test 4: While editing flight -  no changes where made](#editflighttest4)            
    - [Test for editing a route](#testeditroute)
      - [Test 1: Edit a route with valid information](#editroutetest1) 
      - [Test 2: Edit a route with invalid information](#editroutetest2) 
      - [Test 3: Edit in conflict with existing routes](#editroutetest3)
      - [Test 4: While editing route - no changes were made](#editroutetest4)
    - [Test for remove discount](#testremovediscount)
      - [Test 1: Remove a discount](#removediscounttest1)
      - [Test 2: Remove a discount from a flight or route that does not exist](#removediscounttest2)
      - [Test for remove Flight](#removeflight)
      - [Test 1: Removes a selected flight from the database](#removeflight)
2. [Sales Employee](#salesemployee)
   - [Test for create booking](#testscreatebooking)
      - [Test 1: Create booking for one flight, one passanger, no options with valid information](#test1CB)
      - [Test 2: Create booking for one flight, one passanger, no options with incomplete or invalid information](#test2CB)
      - [Test 3: Create booking for a route(multiple linked flights),multiple passangers, extra options, with valid information.](#test3CB)
      - [Test 4: Create booking for a flight that has no seats available](#test4CB)
      - [Test 5: Create booking for a flight when the buyer is not the passanger](#test5CB)
      
   - [Test for remove booking](#removebooking)
   - [test for modify booking](#modifybooking)
      - [Test1: Modify booking with valid data](#modifybooking)
      - [Test2: Modify booking with invalid data](#test2modifyb)
    

   - [Test for Creating Route](#CreateRoute)
        - [Test 1: Create Route consisting of flights Positive](#createroutetest1)
        - [Test 2: Create Route with an invalid flight number Negative](#createroutetest2)
        - [Test 3: Create Route for connectable flights (Issue with time interval) Negative](#createroutetest3)
        - [Test 4: Create Route for not connectable flights (Issue with time interval) Positive](#createroutetest4)
        - [Test 5: Create Route for not connectable flights (Issue with airports) Negative](#createroutetest5)
        - [Test 6: Create Route for not connectable flights (Issue with airports) Positive](#createroutetest6)
         


3. [Sales Manager](#salesmanager)
      - [Test 1: Examine Dashboard](#examinedashboardtest1)
      - [Test 2: Examine an older version of the Dashboard](#examinedashboardtest2)
      



<h3>  <a name="testcreatediscountstatic"></a>  Testing scenarios for creating discounts </h3>


| Name: | <a name="test1"></a> Provide static discount |
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Name | Sales officer provides a static discount **(20% discount)** to  **(from Amsterdam to Dubai)** |
| Scenario: | 1. User is [looking- up for a flight](#searchflight) and selects a flight or route. **(from Amsterdam to Dubai)** <br> 2. System confirms selection and gives a window for choosing either static or dynamic discount. <br> 3. User selects the type of the **static discount**. <br/> 4. System confirms and gives a window for the amount that should be applied. <br> 5. User enters **20%** of the discount to be applied for the route **AMS - DXB**.  <br> 6. System subtracts price by the discount amount on the selected route **AMS - DXB** <br> 7. Sales officer confirms the change. <br/> 8. System updates the current price.|
| Results: | Static discount is applied for a flight or a route **(20% discount on the route from Amsterdam to Dubai)** |


| Name: | <a name="test3"></a> Provide static discount with invalid input |
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Aim: | System detects invalid inputs as "unknown characters" |
| Scenario: | 1. User is [looking- up for a flight](#searchflight) and selects a flight or route. **(from Amsterdam to Dubai)** <br> 2. System confirms selection and gives a window for choosing either static or dynamic discount. <br> 3. User selects the type of the **static discount**. <br/> 4. System confirms and gives a window for the amount that should be applied. <br> 5. User enters **-20%** of the discount to be applied for the route **AMS - DXB**.  <br> 6. System acknowledges the input and displays an error. |
| Results: | Static discount is not applied and the System displays an error "unknown characters" |


| Name: | <a name="test2"></a> Provide dynamic discount |
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Scenario: | 1. User is [looking- up for a flight](#searchflight) and selects a flight or route **(from Frankfurt to New Delhi)**. <br> 2. System confirms selection and gives a window for choosing either static or dynamic discount. <br> 3. User selects the type of the **dynamic discount** . <br> 4. System connects to the external API and retrieves available discounts for the selected route **FRA - DEL**. <br> 5. System displays available discounts to the sales officer **(5%, 10%, 15%)**. <br> 6. Sales officer selects a discount **(10%)** and confirms the selection. <br> 7. System subtracts the price by the selected discount amount on the selected route  **FRA - DEL**. <br> 8. Sales officer confirms the change. <br> 9. System updates the current price.|
| Results: | Dynamic discount is applied for a flight or a route **(10% discount on the route from Frankfurt to New Delhi)**|


| Name: | <a name="dynamicdiscounttest"></a> Provide dynamic discount with no connection to the external API |
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Scenario: | 1. User is [looking- up for a flight](#searchflight) and selects a flight or route **(from Paris to Melbourne)**. <br> 2. System confirms selection and gives a window for choosing either static or dynamic discount. <br> 3. User selects the type of the **dynamic discount** . <br> 4. System tries to connect to the external API and retrieves available discounts for the selected route **PAR - MLB**. <br> 5. System displays an error.|
| Results: | Dynamic discount is not provided, no connection to the external API|

<h3>  <a name="testregisterflight"></a>  Testing scenario register flight </h3>

| Name: | <a name="createflighttest1"></a> Registering a new flight with valid information |
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Name | Sales officer creates a new flight with valid input |
| Scenario: | 1. User navigates to the window in order to create a new flight. <br> 2. System is providing a window for the user to input flight details. <br> 3. User fills in **LAX** departing airport, arriving airport **JFK**, flight number **AA0011**, departure time **15:00**, seat capacity **150**.<br> 4. System validates the information provided by the user. <br> 5. If there are no errors, the system saves the new flight to the database and shows a confirmation window.|
| Results: | Sales officer registered one flight with valid input|

| Name: | <a name="createflighttest2"></a> Registering a flight with incomplete information |
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Aim | To verify if the system displays an error message when a sales officer tries to register a new flight with incomplete information.|
| Scenario: |1. User navigates to the window in order to create a new flight. <br> 2. System is providing a window for the user to input flight details. <br> 3. User fills in **LAX** departing airport, arriving airport **JFK**, flight number **AA0011**, departure time **15:00**. <br> 4. System validates the information provided by the user. <br> 5. The system displays an error message indicating that **seat capacity is missing**.|
| Results: | The system should display an error message indicating that the seat field is required.|

| Name: | <a name="createflighttest3"></a>  Registering a new flight with a flight number that already exists |
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Aim | To verify if the system displays an error message when a sales officer tries to register a new flight with a flight number that already exists.|
| Scenario: |1. User navigates to the window in order to create a new flight. <br> 2. System is providing a window for the user to input flight details. <br> 3. User fills in the flight details with flight number **AA0011** and other valid information. <br> 4. System validates the information provided by the user. <br> 5. The system detects that there is already a flight registered with the same flight number **AA0011** and displays an error message..|
| Results: | The system should display an error message indicating that the flight number already exists in the system.|

| Name: | <a name="createflighttest4"></a>   Registering a new flight with the same departure and arrival airports as an existing flight |
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Aim | To verify if the system displays an error message when a sales officer tries to register a new flight with the same departure and arrival airports as an existing flight.|
| Scenario: |1. User navigates to the window in order to create a new flight. <br> 2. System is providing a window for the user to input flight details. <br> 3. User fills in **LAX** departing airport, arriving airport **JFK**, flight number **AA0011**, departure time **15:00**, seat capacity **150**. <br> 4. System validates the information provided by the user. <br> 5. The system detects that there is already a flight with the same departure and arrival airports and displays an error message.|
| Results: | The system should display an error message indicating that a flight with the same departure and arrival airports already exists in the system.|

| Name: | <a name="createflighttest5"></a>   Registering a new flight with a seating capacity that exceeds the maximum allowed by aircraft |
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Aim | To verify if the system displays an error message when a sales officer tries to register a new flight with a seating capacity that exceeds the maximum allowed.|
| Scenario: |1. User navigates to the window in order to create a new flight. <br> 2. System is providing a window for the user to input flight details. <br> 3. User fills in **JFK** departing airport, arriving airport **LAX**, flight number **AA0011**, departure time **12:00** and enters the seating capacity as **500**. <br> 4. System validates the information provided by the user. <br> 5. The system displays an error message indicating that the seating capacity entered exceeds the maximum allowed.|
| Results: | The system should display an error message indicating that the seating capacity should be **150** but was **500**.|

<h3>  <a name="testeditflight"></a>  Testing scenario for editing a flight </h3>

| Name: | <a name="editflighttest1"></a>  Valid input update |
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Aim | To verify if the system can successfully update a flight with valid information.|
| Scenario: |	1. User selects a flight to edit. <br> 2. User modifies the flight details `departure time`, `arrival time`, `seats` with valid information. <br> 3. The system validates the new information and updates the flight details.|
| Results: | The flight information is successfully updated in the system.|

| Name: | <a name="editflighttest2"></a>  Invalid input update |
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Aim | To verify if the system can successfully display error message with invalid information.|
| Scenario: |1. User selects a flight to edit. <br> 2. User modifies the flight details with invalid information entering an incorect amout of seats `500`. <br> 3. The system displays an error message as a plane can carry only `200` seats and prompts the user to correct the information.|
| Results: | System displays an eror message.|


| Name: | <a name="editflighttest3"></a>  Conflict with existing flights |
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Aim | 	To verify if the system can handle conflicts with existing flights when updating a flight.|
| Scenario: |	1. User selects a flight to edit. <br> 2. User modifies the flight details with a `new departure time` - `15:00` that conflicts with an existing flight from the same gates at the same time `15:00`. <br> 3. The system displays an error message indicating the conflict.|
| Results: | 	The flight information is not updated as system detected the conflict between flights.|

| Name: | <a name="editflighttest4"></a>  No changes where made |
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Aim | 	.|
| Scenario: |	1. User selects a flight to edit. <br> 2. User does not make any changes to the flight details. <br> 3. The system does not update the flight information.|
| Results: |The flight information remains unchanged in the system.|

<h3>  <a name="testeditroute"></a>  Testing scenario for editing a route </h3>

| Name: | <a name="editroutetest1"></a>  Edit a route |
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Aim | 	To verify if the system can successfully update a route with valid information.|
| Scenario: |	1. User selects a route to edit. <br> 2. User modifies the route details `departure time`, `arrival time`, `seats` with valid information. <br> 3. The system validates the new information and updates the route details.|
| Results: | The route information is successfully updated in the system.|

| Name: | <a name="editroutetest2"></a>  Invalid input update |
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Aim | To verify if the system can successfully display error message with invalid information.|
| Scenario: | 1. User selects a route to edit. <br> 2. User modifies the route details with invalid information entering an incorecct amout of seats `500`. <br> 3. The system displays an error message as a plane can carry only `200` seats and prompts the user to correct the information.|
| Results: | System displays an eror message.|

| Name: | <a name="editroutetest3"></a>  Conflict with existing routes |
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Aim | 	To verify if the system can handle conflicts with existing routes when updating a route.|
| Scenario: |	1. User selects a route to edit. <br> 2. User modifies the route details with a `new departure time` - `15:00` that conflicts with an existing route from the same gates at the same time `15:00`. <br> 3. The system displays an error message indicating the conflict.|
| Results: | The route information is not updated as system detected the conflict between routes.|

| Name: | <a name="editroutetest4"></a>  No changes where made |
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Aim | 	The user just cancel the changes for the route.|
| Scenario: |	1. User selects a route to edit. <br> 2. User does not make any changes to the route details. <br> 3. The system does not update the route information.|
| Results: | The route information remains unchanged in the system.|

| Name: | <a name="removediscounttest1"></a>  Remove discount from a flight/route |
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Aim | 	The user removes a discount from a chosen flight or route.|
| Scenario: |	1. User selects a flight or route to remove the discount from. <br> 2. System shows all the flights and routes that have discounts applied. <br> 3. The user selects one or multiple flights/routes to remove the discount from. <br> 4. System removes the discount(s).|
| Results: | The discount(s) has been removed.|

| Name: | <a name="removediscounttest2"></a>  Remove discount from a chosen flight/route that does not exist |
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Aim | 	The user removes a discount from a chosen flight or route that does not exist.|
| Scenario: |	1. User selects a flight or route to remove the discount from. <br> 2. System shows all the flights and routes that have discounts applied. <br> 3. The user does not find the specific flight or route to remove the discount from.|
| Results: | The discount(s) of the non existent flight or route does not exist.|

<h3>  <a name="editbooking"></a>  Sales employee </h3>

| Name: | <a name="editbooking"></a> Modify existing booking |
| ---- | ----------- |
| Aim: | Sales employee modify existing booking |
| Scenario: | 1. System shows a list of all bookings. <br> 2. User selects a booking. <br> 3. System shows the name,seat and all options the passenger has for the current booking. <br> 4. User selects name,seat or any option to change for the passanger. <br> 5. System checks if the change(s) is possible. <br> 6. System indicates if the change(s) is possible. <br>  7. System saves the modified change(s). |
| Result: | A booking is modified. |
| Extensions: | 6a System indicates the change(s) is possible. <br>   6.1 The change(s) will be then updated. <br>  6b System indicates the change(s) isn't possible. <br>  6.1 The actor has to select another option. |
<h2>  <a name="testsctreatebooking"></a> Tests for create booking: 
<h3>  <a name="testcreatebooking"></a>  Test scenario for creating booking for one flight, one passanger, no extra options with valid information </h3>

| Name: | <a name=test1CB></a>Create booking for one flight, one passanger, no extra options with valid information |
|----|-----------|
| Scenario: | 1. User selects to create booking option.<br> 2. System checks for seat availability and offers option to create a booking if there are free seats.<br> 3. System confirms selected flight and displays passenger creation form(first name & last name and passport nr. of all passangers, choise boxes for extra options)<br> 4. User fills out booking form and submits.(number of passagers:1, Alex, Constantinescu, passport nr: 1234567,no legroom,luggage,food)<br> 5. System confirms submission and displays an overview of given input: 1 passanger- Alex Constantinescu,for date 27.05.2023, time 10:30 local hour, flight: AMS-OTP, no extra options,passport nr: 1234567,auto generated seat nr:10 <br>9. System displays that input was registered.  |
| Result:| the user created a booking for one passanger and no extra options.|


 <h3>  <a name="test2CB"></a> Create booking for one flight, one passanger, no options with incomplete or invalid information  </h3>

|Name: |<a name=test2CB></a>Create booking for one flight, one passanger, no options with incomplete or invalid information|
|----|-----------|
|Scenario: | 1.User selects to create booking option. <br> 2. System checks for seat availability and offers option to create a booking if there are free seats.<br> 3. User selects option to create a booking for the looked up flight.<br> 4. System confirms selected flight and displays booking creation form(number of passangers,first name & last name of all passangers)<br> 5. User fills out booking form and submits.(number of passagers:1, Alex)<br> 6. System displays an error message for not having last name.|
|Result: |booking is not created.|
   
<h3>  <a name="test3CB"></a>Create booking for a route(multiple linked flights),multiple passangers, extra options, with valid information.   </h3>

|Name: |<a name="test3CB"></a>Create booking for a route(multiple linked flights),multiple passangers, extra options, with valid information.|
|----|-----------|
|Scenario: |1.User selects to create booking option. <br> 2. System checks for seat availability and offers option to create a booking if there are free seats.<br> 5. User selects option to create a booking for the looked up route.(OTP-AMS-JFK)<br> 3. System confirms selected route and displays booking creation form(number of passangers,first name & last name of all passangers)<br> 4. User fills out booking form and submits.(number of passagers:2, Alex, Constantinescu, Alexia Constantinescu)<br> 5. System confirms submission and offers additional options for the booking as: extra legroom, food, luggage and seats chosen<br>6. User selects extra options: extra legroom, food included, extra 20 kg luggage, chosen seats(19a,19b) <br> 7. System confirms submission and displays an overview of given input: 2 passangers- Alex Constantinescu,Alexia Constantinescu for date 27.05.2023, time 10:30 local hour, route: OTP-AMS-JFK,with extra options:extra legroom, food included, extra 20 kg luggage, chosen seats(19a,19b).<br>8. User check entered information and confirms input.<br>9. System displays that input was registered(and outputs ticket to sell).|
|Result: |booking was created successfully for two persons, a route and extra options|
   
<h3>  <a name="test4CB"></a>Create booking for a flight with no seats availability.   </h3>
   
|Name: |<a name="test4CB"></a>Create booking for a flight with no seats availability|
|----|-----------|
|Scenario: | 1. User selects option to go on the create booking window. <br> 2. System dispplays the create booking window that provides look up flight function. <br> 3. user has access to look up a flight or route for date 27.05.2023, time 10:30 local hour, OTP-EIN.<br> 4. System checks for seat availability and offers option to create a booking if there are free seats.<br>5. The system displays an error message because flight does not have any free seats.|
|Result: |booking for flight OTP-EIN was not created because of no avialble seats|


<hr3> <a name="testscreateroute"></a> Create Route. </hr3>

<hr3> <a name="createroutetest1"></a> Create Route with valid flight numbers. </hr3>

|Name:|Create Route with valid flight numbers|
|----|-----------|
| Aim | Verify if the system can save the route properly with valid flight numbers.|
| Scenario: |1. User clicks on Create Route pop up. <br> 2. User enters route name and route id with valid information, and flight numbers with valid information : `“KL1234,KL4567”`. <br> 3. User clicks on save route. <br> 4.System saves route|
| Results: | System displays a message that says that route has been saved successfully.|

<hr3> <a name="createroutetest2"></a> Create Route with invalid flight numbers. </hr3>

|Name:|Create Route with invalid flight numbers|
|----|-----------|
| Aim | Verify if the system can display an error message for invalid flight numbers.|
| Scenario: |1. User clicks on Create Route pop up. <br> 2. User enters route name and route id with valid information, and flight numbers with invalid information : `“KL1234,KL456”`. <br> 3. User clicks on save route. <br> 4.System can not save route|
| Results: | System displays an error message.|

<hr3> <a name="createroutetest3"></a> Create Route with invalid airport connection. </hr3>

|Name:|Create Route with invalid airport connection|
|----|-----------|
| Aim | Verify if the system can display an error message for invalid airport connections.|
| Scenario: |1. User clicks on Create Route pop up. <br> 2. UUser enters route name and route id with valid information, and flight numbers with invalid information : `“KL0101,KL0404”  KL0101 goes EIN-MUC , KL0404 goes BCN-FRA`. <br> 3. User clicks on save route. <br> 4.System can not save route|
| Results: | System displays an error message.|

<hr3> <a name="createroutetest4"></a> Create Route with valid airport connection. </hr3>

|Name:|Create Route with valid airport connection|
|----|-----------|
| Aim | Verify if the system can save the route properly with valid airport connections.|
| Scenario: |1. User clicks on Create Route pop up. <br> 2. User enters route name and route id with valid information, and flight numbers with invalid information : `“KL0101,KL0202”  KL0101 goes EIN-BCN , KL0202 : BCN-CUN, KL0303 CUN-FRA`. <br> 3. User clicks on save route. <br> 4.System can saves route|
| Results: | System displays a message that says that route has been saved successfully.|

<hr3> <a name="createroutetest5"></a> Create Route with invalid time interval between flights. </hr3>

|Name:|Create Route with invalid time interval between flights|
|----|-----------|
| Aim | Verify if the system can display an error message for invalid time interval between flights.|
| Scenario: |1. User clicks on Create Route pop up. <br> 2. User enters route name and route id with valid information, and flight numbers with invalid information : `“KL0101,KL0202”  KL1234 goes 12:00-14:00 , KL5678: 13:30, KL8910: 16:00-18:00`. <br> 3. User clicks on save route. <br> 4.System can not save the route|
| Results: | System displays an error message.|

<hr3> <a name="createroutetest6"></a> Create Route with valid time interval between flights. </hr3>
|Name:|Create Route with valid time interval between flights|
|----|-----------|
| Aim | Verify if the system can save the route successfully for flights with valid time interval between flights.|
| Scenario: |1. User clicks on Create Route pop up. <br> 2. User enters route name and route id with valid information, and flight numbers with invalid information : `“KL0101,KL0202”  KL1234 goes 10:00-11:00 , KL5678: 14:30-15:30, KL8910: 18:00-22:00`. <br> 3. User clicks on save route. <br> 4.System saves the route|
| Results: | System displays a message that says that route has been saved successfully.|










   
 <hr3> <a name="removebooking"></a> Remove booking. </hr3>
 
 |Name:|Remove booking with more than 14 passengers in a flight|
 |----|-----------|
 |Scenario:|1.User inserts passportnumber to remove a bookimg.<br>2.System checks for valid input (more than 14 bookings in a flight).<br>3. System removes the booking from the system and confirms it.|
|Result:|removal of booking succsessful|

 <hr3> <a name="removebooking1"></a> Remove booking. </hr3>
 
|Name:|Remove booking with less than 15 passengers on a flight|
 |----|-----------|
 |Scenario:|1.User inserts passport number.<br>2.System checks for number of passengers in the flight.<br>3. System confirms the are less than 15 passengers in a flight.<br>4. System throws exception "Cannot delete passenger. Number of passengers in booking is less than 15.".|
|Result:|removal of booking unsuccsessful|
   
 <hr3> <a name="modifybooking"></a> Modify booking with valid data. </hr3>

|Name:|Modify booking with valid data|
|----|-----------|
|Scenario:|1. User selected to modify a booking.<br>2. User modifies the number of passangers from 2 to one,keeps only Alex Consta, 2c,001221.<br>3. System validates the modified information and checks if the selected flight is still available for the specified departure time.<br>4.System saves the modified booking |
|Result:| Modify booking with valid data completed. |
   
  <hr3>  Modify booking with invalid data. </hr3>
   
 |Name: |<a name="test2modifyb"></a> Modify booking with invalid data|
 |----|-----------|
 |Scenario: |1. User selected to modify a booking.<br>2. User modifies the number of passangers from 2 to one,keeps only Alex Consta, 2c,-123.<br>3. User submits incomplete or invalid information on the booking form, the system displays an error message.<br>4. Use case ends here|
 |Result:|booking could not be changed.|

 
   
<h3>  <a name="examinedashboard"></a>  Sales manager </h3>

| Name: | <a name="examinedashboardtest1"></a> Examine Dashboard |
| ---- | ----------- |
| Aim: | Sales manager examine dashboard in order to see the total revenue. |
| Scenario: |	1. User opens the dashboard to check the total revenue. <br> 2. User checks all the options selected based on the seats numbers. <br> 3. The system shows the total revenue based on the options.|
| Result: | The dashboard is sucessfully examined.|

| Name: | <a name="examinedashboardtest2"></a> Examine an older version of the Dashboard. |
| ---- | ----------- |
| Aim: | Sales manager examines an old version of a dashboard. |
| Scenario: |	1. User opens the dashboard to check the total revenue <br> 2. User is checking an old version of the dashboard, showing an older revenue based on the selected options. <br> 3. The system shows the old revenue based on the options. |
| Result: | An older version of the dashboard was examined.|

<hr3> <a name="removeflight"></a> Remove Flight </hr3>

|Name:|Remove Flight|
|----|-----------|
|Scenario:|1.User selected to remove a flight from the flight table view.<br>2. User uses the *remove selected flights* button.<br>3. System checks for the flight, if it exists in the database.<br>4. System removes the flight from the database and prints the line "selected flight has been removed".|
|Result:|removal of Flight succsessful|

Remove Flight with booked tickets on a flight
|Name:|Cannot remove Flight with booked tickets (positive values)|
|----|-----------|
| Aim | Verify that the system will detect the booked tickets on the selected flight.|
| Scenario: |1. User selects a flight. <br> 2. User then clicks on the "simulate tickets" button. <br> 3. User then clicks on "remove flight" button. <br> 4.System checks if the Flight has tickets booked on it. <br> 5. System detects the tickets and does not allow the flight to be removed from the database.|
| Results: | System displays a message that says Tickets have been booked for said flight.| 

Remove Flight without booked tickets on a flight
|Name:|Can remove Flight without booked tickets (negative values)|
|----|-----------|
| Aim | Verify that the system will detect the booked tickets and see there are none on the selected flight.|
| Scenario: |1. User selects a flight. <br> 2. User then clicks on "remove flight" button. <br> 3. System checks if the Flight has tickets booked on it. <br> 4. System detects that there are no tickets booked for the flight. <br> 5. System then removes the flight from the database.<br> |
| Results: | System displays a message that says Flight has been removed from the database.|

Remove Flight without booked tickets on a flight does not throw custom excpetion
|Name:|Can remove Flight with booked tickets (does not throw custom exception)|
|----|-----------|
| Aim | Verify that the system will detect the booked tickets and see there are none on the selected flight and not throw the custom exception.|
| Scenario: |1. User selects a flight. <br> 2. User then clicks on "remove flight" button. <br> 3. System checks if the Flight has tickets booked on it. <br> 4. System detects that there are no tickets booked for the flight. <br> 5. System then removes the flight from the database.<br> |
| Results: | System displays a message that says Flight has been removed from the database and does not throw the custom exception (HasBookedTicketsException).|

Remove Flight with booked tickets on a flight does throw custom excpetion
|Name:|Can remove Flight with booked tickets (does throw custom exception)|
|----|-----------|
| Aim | Verify that the system will detect the booked tickets and see there are none on the selected flight and not throw the custom exception.|
| Scenario: |1. User selects a flight. <br> 2. User then clicks on "remove flight" button. <br> 3. System checks if the Flight has tickets booked on it. <br> 4. System detects that there are tickets booked for the flight. <br> 5. System does not removes the flight from the database.<br> 6.System Displays custom exception (HasBookedTicketException) "the selected Flight has tickets booked for it" |
| Results: | System displays a message that says Flight cannot be removed from the database and throws the custom exception (HasBookedTicketsException).|

Remove Flight: inserts Tickets into database
|Name:|Can insert 1 ticket for the selected flight in the database|
|----|-----------|
| Aim | Verify that the system will add 1 ticket to the selected flight.|
| Scenario: |1. User selects a flight. <br> 2. User then clicks on "simulate tickets" button. <br> 3. System adds 1 ticket to the selected flight. <br> 4. System inserts the value of 1 ticket into the selected flight in the database. <br> 5. System displays success window, "1 ticket has been added for the selected flight". |
| Results: | System displays a message that says 1 ticket has been added into the selected flight, into the database.|

Remove Flight: regardless if a flight has selected tickets, can still be deleted using the RegardlessRemove method
|Name:|Regardless if tickets are on a selected Flight it will be removed from the database|
|----|-----------|
| Aim | Verify that the system will delete the selected flight with the regardlessRemove button.|
| Scenario: |1. User selects a flight. <br> 2. User then clicks on "simulate tickets" button. <br> 3. System adds 1 ticket to the selected flight. <br> 4. System inserts the value of 1 ticket into the selected flight in the database. <br> 5. System displays success window, "1 ticket has been added for the selected flight". <br> 6. User then clicks on the button "Remove selected Flight (even with tickets)". <br> 7. System calls the regardlessRemoveFlight method and removes the selected flight with tickets from the database. |
| Results: | System successfully removes a selected flight even with tickets, using the RegardlessWithTickets method.|
   
<hr3> <a name=""></a> Get All Flights. </hr3>

|Name:|Display All Flights|
|----|-----------|
|Scenario:|1.User selected to remove a flight from the flight table view.<br>2. System displays a tableview of Flights.<br>3. User can see the Tablieview with all Flights.|
|Result:|All Flights from the database are visisble to the user.|   
