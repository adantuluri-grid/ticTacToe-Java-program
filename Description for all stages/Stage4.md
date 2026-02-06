# Description
Let's enhance our AI by adding a medium difficulty level. This AI will be more challenging to beat than the easy difficulty level, as it incorporates basic awareness of the game state. While its initial moves are still random, it follows a strategic set of rules to play more effectively.

When the AI plays at medium level, it focuses on winning whenever possible because of its first rule, or blocking the opponent's winning moves because of its second rule. This makes the game more engaging and competitive.

You can see these rules below.

Objectives
When the AI is playing at medium difficulty level, it makes moves based on the following rules:

Winning move: If the AI has two in a row and can win with one more move, it takes that move.
Blocking move: If the opponent has two in a row and can win with one more move, the AI blocks it.
Fallback move: If neither of the above applies, the AI makes a random move.
You should add a medium parameter so that you can play against this level. It should also be possible for AIs at different levels (easy and medium) to play against each other!

Like the previous stage, the possible states are:

Draw — when no side has three in a row, and the table is complete;
X wins — when there are three X's in a row (up, down, across, or diagonally);
O wins — when there are three O's in a row (up, down, across, or diagonally).
Also, ensure that the program handles invalid input gracefully. For example, if the start command is given without valid parameters, display the message Bad parameters!

Example
The example below shows how your program should work.
The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

Input command: > start user medium
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
Making move level "medium"
---------
|       |
|   X   |
| O     |
---------
Enter the coordinates: > 1 1
---------
| X     |
|   X   |
| O     |
---------
Making move level "medium"
---------
| X     |
|   X   |
| O   O |
---------
Enter the coordinates: > 3 3
---------
| X     |
|   X   |
| O X O |
---------
Making move level "medium"
---------
| X O   |
|   X   |
| O X O |
---------
Enter the coordinates: > 2 1
---------
| X O   |
| X X   |
| O X O |
---------
Making move level "medium"
---------
| X O   |
| X X O |
| O X O |
---------
Enter the coordinates: > 1 3
---------
| X O X |
| X X O |
| O X O |
---------
Draw

Input command: > start medium user
---------
|       |
|       |
|       |
---------
Making move level "medium"
---------
|       |
|       |
|   X   |
---------
Enter the coordinates: > 2 2
---------
|       |
|   O   |
|   X   |
---------
Making move level "medium"
---------
|       |
|   O   |
| X X   |
---------
Enter the coordinates: > 3 3
---------
|       |
|   O   |
| X X O |
---------
Making move level "medium"
---------
| X     |
|   O   |
| X X O |
---------
Enter the coordinates: > 2 1
---------
| X     |
| O O   |
| X X O |
---------
Making move level "medium"
---------
| X     |
| O O X |
| X X O |
---------
Enter the coordinates: > 1 3
---------
| X   O |
| O O X |
| X X O |
---------
Making move level "medium"
---------
| X X O |
| O O X |
| X X O |
---------
Draw

Input command: > exit