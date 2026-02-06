# Description
Now it's time to make a working game, so let's create our first opponent! In this version of the program, the user will be playing as X, and the computer will be playing as O at easy level. This will be our first small step towards creating the AI!

Let's design it so that at this level the computer makes random moves. This should be perfect for people who have never played the game before!

If you want, you could make the game even simpler by including a difficulty level where the computer never wins. Feel free to create this along with the easy level if you like, but it won't be tested.

Objectives
In this stage, you should implement the following:

Display an empty table when the program starts.
The user plays first as X, and the program should ask the user to enter cell coordinates.
Next, the computer makes its move as O, and the players then move in turn until someone wins or the game results in a draw.
Print the final outcome at the very end of the game.
The possible states are:

Draw — when no side has three in a row, and the table is complete;
X wins — when there are three X's in a row (up, down, across, or diagonally);
O wins — when there are three O's in a row (up, down, across, or diagonally).
Like in the previous stage, if the user provides invalid coordinates, the program should repeat the request until valid numbers representing an empty cell on the table are supplied.

Example
The example below shows how your program should work.
The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

---------
|       |
|       |
|       |
---------
Enter the coordinates: > 2 2
---------
|       |
|   X   |
|       |
---------
Making move level "easy"
---------
| O     |
|   X   |
|       |
---------
Enter the coordinates: > 3 3
---------
| O     |
|   X   |
|     X |
---------
Making move level "easy"
---------
| O     |
| O X   |
|     X |
---------
Enter the coordinates: > 3 1
---------
| O     |
| O X   |
| X   X |
---------
Making move level "easy"
---------
| O     |
| O X O |
| X   X |
---------
Enter the coordinates: > 3 2
---------
| O     |
| O X O |
| X X X |
---------
X wins