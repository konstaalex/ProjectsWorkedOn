## Table of Contents

- [Use Case](#usecase)
  - [Register flight with default period](#registerflight1)
  - [Register flight with custom period](#registerflight2)
- [Use Case Diagram](#usecasediagram)
- [Data Dictionary](#dataDictionary)
- [Test Scenario](#testscenario)
  -  [Registering a new flight with a flight number that already exists](#createflighttest1)
  -  [Registering a flight with incomplete information](#createflighttest2)
  -  [Registering a new flight with all valid information](#createflighttest3)
-  [Domain Model](#domainmodel)
-  [Use Case Diagram](#usecasediagram)
-  [Use Case Class Diagram](#usecaseclassdiagram)
-  [Sequance Diagram](#sequancediagram)




<h3>  <a name="usecase"></a>  Use Case </h3>

| Name: | ## This is the introduction <a name="registerflight1"> </a>   Register flight with default period |
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Actor: | Sales officer |
| Description | Sales officer is registering a new flight recruisevly with defaul period of 6 months |
| Pre-condition | Sales officer has access to the system, at least one airplane is registered in the system, at least two airports are registered in the system. |
| Scenario: | 1. User navigates through the system in order to create a new flight. <br> 2. System is providing for the user to input flight details. <br> 3. User fills in the details for the new flight : `flight number`, `aircraft type`, `departure airport`,`arrival airport`,`departure time`. <br> 4. System validates the information provided by the user. <br> 5. If there are no errors,the system saves the new flight to the database and shows a confirmation window. <br>|
| Results: | Sales officer registered one flight |
| Exceptions: |3. User enters incomplete or invalid information for the new flight and system displays an error message <br> 3.1. Use case ends here. <br> 4. System is checking if there are any conflicts ((`if the same flight is already registered`, `if the airport gates are available for that arrival time`,`if the airplane is available for the departure time and if it is in the same airport` ). If there is a conflict, the system will display an error message and the use case ends.| <br>

| Name: | <a name="registerflight2"></a> Register fligth with custom period|
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Actor: | Sales officer |
| Description | Sales officer is registering a new flight recruisevly with custom period|
| Pre-condition | Sales officer has access to the system, at least one airplane is registered in the system, at least two airports are registered in the system. |
| Scenario: | 1. User navigates through the system in order to create a new flight. <br> 2. System is providing for the user to input flight details. <br> 3. User fills in the details for the new flight : `flight number`, `aircraft type`, `departure airport`,`arrival airport`,`departure time`, customer period for shcedualing `departure time (based on the day like tuesday)`. <br> 4. System validates the information provided by the user. <br> 5. If there are no errors,the system saves the new flight to the database and shows a confirmation window. <br>|
| Results: | Sales officer registered one flight |
| Exceptions: |3. User enters incomplete or invalid information for the new flight and system displays an error message <br> 3.1. Use case ends here. <br> 4. System is checking if there are any conflicts (`if the same flight is already registered`, `if the airport gates are available for that arrival time`,`if the airplane is available for the departure time and if it is in the same airport` ). If there is a conflict, the system will display an error message and the use case ends.|**




<h3>  <a name="dataDictionary"></a>  Data dictonary related to the use case </h3>

| Entities | Definitions |
| --- | --- |
| Airplane | the thing that carries the passangers form A to B point, it has a Dutch `licence plates` that consists from `two random letters and four digits`. |
| Airport | is the place for the airplane to land in or take off in order to complete route or flight or to start the route or flight, airpots is identified by unique digits like `VNO`, it is place on earth and is having `longitude` and `latitude`. |
| Flight | is strictly planned path from a departure airport to an arrival airport for some period and having only one plane assigned, the flight code is consisting from `two letters`, `four digits`. By the flight code it is possible to identigy the flight path.|
| Sales officer | employee who is registering recursively flights which are stricktly planned.|




<h3>  <a name="testscenario"></a>  Test Scenario </h3>

| Name: | <a name="createflighttest1"></a>  Registering a new flight with a flight number that already exists |
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Aim | To verify if the system displays an error message when a sales officer tries to register a new flight with a flight number that already exists.|
| Scenario: |1. User navigates to the window in order to create a new flight. <br> 2. System provides a window for the user to input flight details. <br> 3. User fills in the flight details with flight number `KL2314` (an existing flight number in the system) and other valid information. <br> 4. System validates the information provided by the user. <br> 5. The system detects that there is already a flight registered with the same flight number `KL2314` and displays an error message.
| Results: | The system should display an error message indicating that the flight number already exists in the system.|

| Name: | <a name="createflighttest2"></a> Registering a flight with incomplete information|
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Aim | To verify if the system displays an error message when a sales officer tries to register a new flight with a flight number that already exists.|
| Scenario: |1. User navigates to the window in order to create a new flight. <br> 2. System provides a window for the user to input flight details. <br> 3. User fills in the following information: Departing airport: `LAX`, Arriving airport: `JFK`, Flight number: `KL1234`, `Departure time: 15:00`. <br> 4. System validates the information provided by the user. <br> 5. The system detects that the seat capacity is missing and displays an error message indicating that the seat field is required.
| Results: | The system should display an error message indicating that the flight number already exists in the system.|

| Name: | <a name="createflighttest3"></a> Registering a new flight with all valid information|
| ---- | ----------- |
|<img width=50/>|<img width=1000/>|
| Aim | To verify if the system successfully registers a new flight when all input information is valid.|
| Scenario: |	1. User navigates to the window in order to create a new flight. <br> 2. System provides a window for the user to input flight details. <br> 3. User fills in all required information correctly, including valid `flight number`, `airplane`, `departure and arrival airports`, `departure date`, and `departure time`. <br> 4. System validates the information provided by the user. <br> 5. The system successfully registers the new flight and shows a confirmation message.
| Results: | 	The system should register the new flight without any errors and display a confirmation message to the user.|


###<h3>  <a name="domainmodel"></a>  Domain model </h3>

![Domain model](https://github.com/FontysVenlo/prj2-2023-prj2-2023-08/blob/main/analysis/images/DomainModelfinal.jpg)

###<h3>  <a name="usecasediagram"></a>  Use case diagram </h3>
![Use case diagram](https://github.com/FontysVenlo/prj2-2023-prj2-2023-08/blob/main/analysis/images/UseDiagram.jpg)

###<h3>  <a name="usecaseclassdiagram"></a>  Use case Class Diagram </h3>
![Use case class diagram](https://github.com/FontysVenlo/prj2-2023-prj2-2023-08/blob/main/design/images/Create%20New%20Flight.jpg)

###<h3>  <a name="sequancediagram"></a>  Sequence Diagram </h3>
![Sequence Diagram](https://github.com/FontysVenlo/prj2-2023-prj2-2023-08/blob/main/design/sequenceDiagrams/SalesOfficerController_onCreateFlightButtonClicklast.jpg)
