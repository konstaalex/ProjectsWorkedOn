## **Name:** SRS
**Introduction**
This document specifies the requirements for an intelligent traffic control system developed for Traffic Control International Inc. (TLI).

**Scope**:
Due to time limitations this project will be limited to the implementation of a single light control system. Crossings, basic control and intelligent control are not within scope of this project.
  


**User groups:** 
- Traffic participant: All people who make use of the road, whether by car or by     walking.
- Traffic light: The main entity which the system controls.


**Requirements:**
- focus on maintainability and extensibility (usage of design patterns)
- stepwise feature extension by an agile approach with weekly sprints and customer demonstrations
- 1. Control of a single pedestrian light showing red and green
    a) Typical pedestrian light behaviour: RED -> GREEN -> RED
    b) Extended pedestrian light behaviour: RED -> GREEN -> GREEN BLINKING -> RED
- 2. Control of a single traffic light showing red, green and yellow



**Data dictionary:**
- Traffic light: A single traffic light having a shape and a behaviour.
- Traffic light behaviour: The behaviour of how and when a traffic light changes     signals.
- Traffic light shape: The shape in which the traffic light signals are displayed.
- Road: the area between two sidewalks which traffic participants use.

**User stories:**
   **Traffic participant:**
    - As a traffic participant, I want to safely cross the road so I won’t hit a         pedestrian or cars.
    - As a traffic participant,I do not want to have long waiting times.
    **Traffic light:**
    - As a traffic light I want to be able to show a light behaviour : red-green-         red , so that the traffic users know when to cross and when not to cross.
    - As a traffic light I want to be able to display my traffic signals in a             varitude of shapes.










**Use case diagram**

**Use case descriptions**

Control of a single pedestrian light behaviour:

**Actor**: pedestrian light/ pedestrian?
**Description**: Pedestrian wants to cross a street safely making use of a pedestrian light
**Pre-condition:** the pedestrian light is functional
**Main success scenario:**  
1. a pedestrian lets the system know that he wants to cross a street
2. the pedestrian light changes its light behaviour from red to green ( -- after      some time-- make it extendable )
3. the system lets the green light open enough for

**Result:** Pedestrian can cross the street

**Actor:** Traffic light
**Description:** Traffic light does one state-cycle
**Pre-condition:** Current state is red, Behaviour of traffic light is ‘Standard traffic light behaviour (Germany)’
**Scenario:**
1. Traffic light behaviour waits a pre-determined amount of time
2. Traffic light behaviour changes state to yellow
3. Traffic light changes color to yellow
4. Traffic light behaviour waits a pre-determined amount of time
5. Traffic light behaviour changes state to green
6. Traffic light changes color to green
7. Traffic light behaviour waits a pre-determined amount of time
8. Traffic light behaviour changes state to yellow
9. Traffic light changes color to yellow
10. Traffic light behaviour waits a pre-determined amount of time
10. Traffic light behaviour changes state to red
11. Traffic light changes color to red
**Result:** Traffic light successfully did one cycle through it’s states
