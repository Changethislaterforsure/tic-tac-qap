# tic-tac-qap

## Clean code
I will likely add this bit to a word doc since I dont know how to put screenshots in here.

## What it does, how it works.
This is a console based tic-tac-toe game. When the game is started it will display the empty grid and prompt the first player to enter grid coordinates then display the updated grid to reflect that selection before prompting the other player to do the same. To start the game simply enter the following line in the console: mvn -q exec:java -Dexec.args="X Y". Replace X and Y with your players names, not entering any name will default them to Player1 and Player2. 

But how does it work? Well, it uses an Enum called Marker to represent the state of each cell in the grid be that an X, an O or empty since these things would be constants. It uses a class called board to control the grid and the rules of the game such as detecting if the board is filled but no player has won and declaring a draw. It uses a player class to hold on to player data as well as what marker that player is assigned. It then has the game class which actually prints the grid and game text such as announcing the winner as well as handling who the current player is. Finally it has a main class which is the entry point for the game that accepts the players names via the args posted above and then starts the game. 

## Tests
The tests I use are fairly simple: they confirm a legal move occupies its correct cell on the grid, it confirms a win condition both by row and diagonal as well as confirming a draw. It also tests to make sure you cannot overwrite an already occupied cell on the grid, it tests to make sure a empty cell cannot be placed on the grid and it tests to make sure a player cannot put their marker out of bounds by entering a value greater than the size of the grid.  I would like to explain the empty marker test further as you may be thinking to yourself "but since the player is ASSIGNED X or O their marker cant be empty!" and that is true, the empty test is designed so that if a bug appears or some mistake is made while editing the code that causes a player to not be assigned their marker correctly it is caught. 


## Dependencies and Sources
I used Maven to manage everything, my first time using it as I previously was just manually inserting a jar file so this took a little bit of googling and rewatching lectures. There is Junit 5 for writing tests, the mavin surefire plugin which runs all my tests when executing and the mavin exec plugin which lets me launch the game through mavin without having to compile. 

## Difficulties
I somewhat spoiled it during the previous entry, all of last semester we were not required to use mavin I was just slapping in a jar file and calling it a day so I found the workflow that mavin prefers really odd and confusing. I also had dental surgery on the 17th of september and have had basically every complication listed on the consent form which has made doing homework very difficult but my dentsit was not willing to sign anything excusing me from any more school so. 