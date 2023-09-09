| Name: | Dutch Traffic Light Behaviour |
|-|-|
| Actor: |  Traffic Light Operator|
| Description: | The ability to switch dutch traffic light signals  |
| Pre-condition: | Has an initial state |
| Main success scenario: | 1. Actor receives request to show signal <br> 2. System displays initial signal (RED) <br> 3. actor receives request to update <br>4. System displays next signal (GREEN) <br> 5. actor receives request to update <br> 6. System displays next signal (YELLOW) <br> 7. actor receives request to update <br> 8. go back to step 2 |
| Result: | The light switched the signal successfully (RED - YELLOW - GREEN) |
| Extensions: | - |
| Exceptions: | - |

| Name: | German Traffic Light Behaviour |
|-|-|
| Actor: |  Traffic Light Operator |
| Description: | The ability to switch german traffic light signals  |
| Pre-condition: | Has an initial state |
| Main success scenario: | 1. Actor receives request to show signal <br> 2. System displays initial signal (RED) <br> 3. actor receives request to update <br>4. System displays next signal (RED-YELLOW) <br> 5. actor receives request to update <br> 6. System displays next signal (GREEN) <br> 7. actor receives request to update <br>8. system displays next signal (YELLOW) <br>9. go back to step 2 |
| Result: | The light switched the signal successfully (RED - RED_YELLOW - GREEN - YELLOW) |
| Extensions: | - |
| Exceptions: | - |

| Name: | German Pedestian Light Behaviour |
|-|-|
| Actor: | Traffic Light Operator |
| Description: | The ability to switch german pedestrian light signals  |
| Pre-condition: | Has an initial state |
| Main success scenario: | 1. Actor receives request to show signal <br> 2. System displays initial signal (RED) <br> 3. actor receives request to update <br>4. System displays next signal (GREEN)<br>5. actor receives request to update <br>6. Go back to step 2 |
| Result: | The light switched the signal successfully (RED-GREEN) |
| Extensions: | - |
| Exceptions: | - |

| Name: | Dutch Pedestian Light Behaviour |
|-|-|
| Actor: |  Traffic Light Operator |
| Description: | The ability to switch dutch pedestrian light signals  |
| Pre-condition: | Has an initial state |
| Main success scenario: | 1. Actor receives request to show signal <br> 2. System displays initial signal (RED) <br> 3.actor receives request to update <br>4. System displays next signal (GREEN) <br>5. actor receives request to update <br> 6. System displays next signal (GREEN BLINKING) <br>7. actor receives request to update  <br>8. go back to step 2 <br>|
| Result: | The light switched the signal successfully |
| Extensions: | - |
| Exceptions: | - |

 Name: | Simple pedestrian crossing |
|-|-|
| Actor: | Traffic Light Operator|
| Description: | The ability to show a simple pedestrian crossing with two pedestrian lights  |
| Pre-condition: | Have a working pedestrian light |
| Main success scenario: | 1. system displays same initial light for both pedestrian lights<br> 2. the crossing gets updated<br> 3. both pedestrian lights show the next signal together (they have the same signal ) <br> 4. the crossing gets updated<br> 5. go back to step 1  |
| Result: | The behaviours are shown on console  |
| Extensions: | - |
| Exceptions: | - |

| Name: | Console interface |
|-|-|
| Actor: | Traffic Light Operator|
| Description: | The ability to see how the application works in different scenarios  |
| Pre-condition: | There are pedestrian lights and traffic lights  |
| Main success scenario: | 1. System displays list of available functions to choose from <br> 2. Actor chooses on of the functions <br> 3. system ask which behaviour to display<br> 4. Actor chooses one behaviour. <br> 5. System displays functions with intended behaviour   |
| Result: | The behaviours are shown on console (traffic light, pedestrian light, crossing, etc.) |
| Extensions: | - |
| Exceptions: | - |

