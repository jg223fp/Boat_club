# Boatclub OO-Design
This document describes the design according to the requirements presented in assignment 2.

## Architectural Overview
The application uses the model-view-controller (MVC) architectural pattern. The view is passive and gets called from the controller. The view may only read information from the model, not directly change it.

## Detailed Design
### Class Diagram
<img src="/img/class-diagram.jpeg" width="900">

### Sequence Diagram
#### Start app and create member (SD)
<img src="/img/SD_startapp_createMember.jpeg" width="900">

#### Create member (SSD)
<img src="/img/SSD_createMember.jpeg" width="650">

#### Change member (SSD)
<img src="/img/SSD_changeMember.jpeg" width="650">