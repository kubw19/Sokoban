# Sokoban
Inside the app you can play some basic levels and you can also crate your own levels(but remember that game does not check if level is solvable).
## Creating level
While cerating new levels you need to add at least one target(red dot), one box and exactly one Starting position for player(you cannot add two, if you try to add second one first will disappear).
You don't have to add any walls but remember that walls are base of any level without them it will be so boring...
Created levels are saved in folder ..................... 
## Structure of level
Format of saved level is:
* x;y - starting position for player
* T;x;y - position of target (there may be more of those)
* W;x;y - position of Wall/Brick (there may be more of those)
* B;x;y - position of Box (there must be exactly as many of those as Targets)

## JavaDocs
https://kubw19.github.io/graNaJTP/
