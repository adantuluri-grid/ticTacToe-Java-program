# Description

It's time to make things more interesting by adding some game variations. What if you want to play against a friend instead of the AI? How about watching a match between two AIs if you get tired of playing? Additionally, the user should have the option to choose whether they go first or second when playing against the AI.

At the end of each match (after the result is displayed), the user should also have the option to quit the game.

Objectives
Your tasks for this stage are:

Write a menu loop, which can interpret two commands:
start: Begins a new game with the specified players for X and O.
exit: Ends the program.
Implement the start command to take two parameters specifying who will play as X and who will play as O. The possible values for each parameter are:
user: A human player.
easy: An AI player at the easy difficulty level. In later stages, you will add the medium and hard AI difficulty levels.
The first parameter determines who will play as X. The second parameter determines who will play as O. For example:
start easy easy: Both players are AIs at the "easy" difficulty level.
start easy user: The AI (easy) plays as X, and the user plays as O.
start user easy: The user plays as X, and the AI (easy) plays as O.
start user user: Both players are human
Handle incorrect input: If the user enters invalid parameters, display the message Bad parameters! and return to the menu.
Add the exit command: This command should terminate the program immediately.
Like the previous stage, the possible states are:

Draw — when no side has three in a row, and the table is complete;
X wins — when there are three X's in a row (up, down, across, or diagonally);
O wins — when there are three O's in a row (up, down, across, or diagonally).
Example
The example below shows how your program should work.
The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

Input command: > start
Bad parameters!
Input command: > start easy
Bad parameters!
Input command: > start easy easy
---------
|       |
|       |
|       |
---------
Making move level "easy"
---------
|       |
|     X |
|       |
---------
Making move level "easy"
---------
|       |
| O   X |
|       |
---------
Making move level "easy"
---------
|       |
| O   X |
|     X |
---------
Making move level "easy"
---------
|       |
| O   X |
|   O X |
---------
Making move level "easy"
---------
|       |
| O X X |
|   O X |
---------
Making move level "easy"
---------
|     O |
| O X X |
|   O X |
---------
Making move level "easy"
---------
| X   O |
| O X X |
|   O X |
---------
X wins

Input command: > start easy user
---------
|       |
|       |
|       |
---------
Making move level "easy"
---------
|       |
|       |
|     X |
---------
Enter the coordinates: > 2 2
---------
|       |
|   O   |
|     X |
---------
Making move level "easy"
---------
|   X   |
|   O   |
|     X |
---------
Enter the coordinates: > 3 1
---------
|   X   |
|   O   |
| O   X |
---------
Making move level "easy"
---------
|   X X |
|   O   |
| O   X |
---------
Enter the coordinates: > 2 3
---------
|   X X |
|   O O |
| O   X |
---------
Making move level "easy"
---------
| X X X |
|   O O |
| O   X |
---------
X wins

Input command: > start user user
---------
|       |
|       |
|       |
---------
Enter the coordinates: > 3 1
---------
|       |
|       |
| X     |
---------
Enter the coordinates: > 2 2
---------
|       |
|   O   |
| X     |
---------
Enter the coordinates: > 2 1
---------
|       |
| X O   |
| X     |
---------
Enter the coordinates: > 3 2
---------
|       |
| X O   |
| X O   |
---------
Enter the coordinates: > 1 1
---------
| X     |
| X O   |
| X O   |
---------
X wins

Input command: > exit