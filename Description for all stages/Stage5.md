# Description
Congratulations, you've almost reached the finish line! In this stage, you'll transform the AI into a formidable opponent by implementing the hard difficulty level.

Unlike the medium difficultly level, where the AI just looks one move ahead to see an immediate win or prevent an immediate loss, the hard difficulty level uses a more advanced strategy. At hard difficulty level, AI can look two moves ahead, three moves ahead, and even further. That is, it evaluates the entire game tree by simulating all possible moves, looking multiple steps ahead. It can calculate all possible moves that might be played during the game, and choose the best move based on the assumption that its opponent will also play perfectly. So, it doesn't rely on the mistakes of its opponent and plays the game flawlessly from start to finish, regardless of the opponent's skill level!

This advanced decision-making is powered by the minimax algorithm. It's a recursive brute-force algorithm that maximizes the AI's advantage while minimizing the opponent's chances of winning. Minimax is not just for Tic-Tac-Toe. You can use it with any other game where two players make alternate moves, such as chess.

Objectives
In this last stage, you need to:

Implement the hard difficulty level using the minimax algorithm.
Add the hard parameter to enable games against this level.
Ensure that the AI plays optimally, making it a challenging opponent.
Like the previous stage, the possible states are:

Draw — when no side has three in a row, and the table is complete;
X wins — when there are three X's in a row (up, down, across, or diagonally);
O wins — when there are three O's in a row (up, down, across, or diagonally).
Also, ensure that the program handles invalid input gracefully. For example, if the start command is given without valid parameters, display the message Bad parameters!

The minimax algorithm can be conceptually tricky, especially for beginners, as it involves recursion. To help you understand it, here are some recommended resources:

Video-based explanations:
"Tic Tac Toe AI with Minimax Algorithm" by The Coding Train
"Algorithms Explained – minimax and alpha-beta pruning" by Sebastian Lague
"Mega-R3. Games, Minimax, Alpha-Beta" from MIT OpenCourseWare
Text-based explanations:
"How to make your Tic Tac Toe game unbeatable by using the minimax algorithm" on freeCodeCamp.org
"Case Study on Tic-Tac-Toe Part 2: With AI" from Nanyang Technological University
"Tic Tac Toe - Creating Unbeatable AI" on Medium
Feel free to explore these or other resources to find the explanation that resonates best with you. Developing this skill of seeking and understanding resources is invaluable as you progress in your software development career.

Example
The example below shows how your program should work.
The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

Input command: > start hard user
---------
|       |
|       |
|       |
---------
Making move level "hard"
---------
|       |
| X     |
|       |
---------
Enter the coordinates: > 2 2
---------
|       |
| X O   |
|       |
---------
Making move level "hard"
---------
|   X   |
| X O   |
|       |
---------
Enter the coordinates: > 3 2
---------
|   X   |
| X O   |
|   O   |
---------
Making move level "hard"
---------
| X X   |
| X O   |
|   O   |
---------
Enter the coordinates: > 3 1
---------
| X X   |
| X O   |
| O O   |
---------
Making move level "hard"
---------
| X X X |
| X O   |
| O O   |
---------
X wins

Input command: > exit