# PRJ2 - Airline Information System

The purpose of this repository is to document our project work.

## Structure

 - [Analysis](/analysis) - For all analysis artefacts
   - [User Stories](https://github.com/FontysVenlo/prj2-2022-prj2-2022-g13/blob/main/analysis/User%20stories.md)
   - [Data Dictionary](https://github.com/FontysVenlo/prj2-2022-prj2-2022-g13/blob/main/analysis/DataDictionary.md)
   - [Domain Model](https://github.com/FontysVenlo/prj2-2022-prj2-2022-g13/tree/main/analysis/Domain%20model)
   - [Use Case Descriptions](https://github.com/FontysVenlo/prj2-2022-prj2-2022-g13/blob/main/analysis/Use%20Cases/UseCaseDescription.md)
   - [Use Case Diagram](https://github.com/FontysVenlo/prj2-2022-prj2-2022-g13/blob/main/analysis/Use%20Cases/Use%20Case%20Diagram4.jpg)
   - [Test Scenarios](https://github.com/FontysVenlo/prj2-2022-prj2-2022-g13/blob/main/analysis/Use%20Cases/TestScenarios.md)
   - [Activity Diagram](https://github.com/FontysVenlo/prj2-2022-prj2-2022-g13/blob/main/analysis/ActivityDiagrams/Activity%20Diagram.svg)
 - [Design](/design) - For all design artefacts
   - [Class Diagram](https://github.com/FontysVenlo/prj2-2022-prj2-2022-g13/blob/main/design/Class%20Diagram/class%20diagramregisterFlight.jpeg)
   - [Sequence Diagrams](https://github.com/FontysVenlo/prj2-2022-prj2-2022-g13/tree/main/design/Sequence%20Diagrams)
   - [Database Design](https://github.com/FontysVenlo/prj2-2022-prj2-2022-g13/tree/main/design/Database)
 - [Implementation](/implementation) - For the implementation of the Airline Information System
   - [Assembler](https://github.com/FontysVenlo/prj2-2022-prj2-2022-g13/tree/main/implementation/AIS-G13/Assembler)
   - [BusinessLogic](https://github.com/FontysVenlo/prj2-2022-prj2-2022-g13/tree/main/implementation/AIS-G13/BusinessLogic)
   - [GUI](https://github.com/FontysVenlo/prj2-2022-prj2-2022-g13/tree/main/implementation/AIS-G13/GUI)
   - [Persistence](https://github.com/FontysVenlo/prj2-2022-prj2-2022-g13/tree/main/implementation/AIS-G13/Persistence)
 - [Project Management](/project-management) - For all project management related artefacts, e.g. meetings outcomes, retrospectives, screenshots, minutes, planning.
 - [Project Board](https://github.com/FontysVenlo/prj2-2022-prj2-2022-g13/projects/1)


## Project 2 case: flight ticket sales  
This document is to be used as a starting point for your analysis process. On purpose, it 
only provides a high-level overview on the requirements. With the support of your tutor, 
you need to further refine your requirements for this project. 
 
Within this project you are going to work for an airline company. In a nutshell, you need 
to build an application to support the sales of flight tickets. 
 
First, a sales officer needs to be able to register upcoming flights and start the sales 
process for registered flights. Additionally, it must be possible to enable temporary 
price reductions. Discounts can be static (e.g. 10% price reduction for a limited period of 
time), as well as dynamic (e.g. based on the number of sun hours at the destination, on 
the day before the booking is made – this needs to be retrieved from an external API, 
feel free to choose one). 
 
Second, your future application needs to allow sales employees to lookup available 
flights and create bookings for one or more persons for a specific flight. A booking can 
have (paid) options concerning extra legroom, food, luggage and seats chosen. Prices 
need to be calculated by the software and depend on the chosen options, class, 
availability of seats in that class, applicable discounts and the number of days left before 
the flight departs. You can assume another application is used for the payment process. 
Please note that the airline company works with multiple sales employees. Hence, the 
application needs to cope with concurrent users, potentially trying to book limited seats 
for the same flight. 
 
Finally, sales managers are only going to love your work if you include a management 
dashboard.  The dashboard needs to present important management key performance 
indicators. For example, for each route sales managers want to view total revenue 
numbers, number of tickets sold in each class, and statistics on all options sold. 

**Summary**

Within the employees we have several roles as employees.
-	Sales officer
-	Sales employee
-	Sales manager
	___
 Sales officer:
 
A Sales Officer should be able to:
*	Register upcoming flights.
*	Start the sales process for registered flights
*	Enable temporary price reduction. 
    * Discount can be static (E.g. 10% reduction for limited time)
    * Discount can be dynamic (E.g. based on number of sun hours at the destination, on the day before the booking is made – this needs to be retrieved from an external API.)
___
 Sales Employee:
 
A Sales Employee should be able to:
*	Lookup available flights
*	Create bookings for one or more persons.
  *	Booking can have (paid) options like, extra legroom, food, luggage and seats chosen.
  *	Prices need to be calculated by the software and depend on the chosen options, class, availability of the seats in that class, applicable discounts and the number of days left before the flight departs.
*	There are multiple Sales Employees. The application needs to cope with concurrent users, potentially trying to book limited seats for the same flight.
___
Sales Manager:

A Sales Manager needs:
*	A management dashboard.
*	Important management key performance indicators
*	for each route, sales managers want to view total revenue numbers, number of tickets sold in each class, and statistics on all options sold.


GO TO [Analysis](/analysis) 
