# AIConnect3

## Disclaimer:
- This is a project done for intro to artificial intelligence that uses alpha beta pruning to decide the best move for the computer
- toward the bottom I explain the algorithm in more depth
## Rules Of The Game:
- Try to get 3 in a row (not more then 3 or will lose points)
- each player takes turn to put piece down 
- end of game which ever player has more 3 in a rows wins the gaame  

## How to run in cmdline:
`<path to downloaded folder> java -jar .\Connect3.jar 2 A2Q1RandomPlayer A2Q1RandomPlayer`  
What will print in Commandline:  
Calling AI for player 1  
My player player 1 move: 5  
Calling AI for player 2  
My player player 2 move: 1  
Calling AI for player 1  
My player player 1 move: 1  
Calling AI for player 2  
My player player 2 move: 4  
Calling AI for player 1  
My player player 1 move: 3  
Calling AI for player 2  
My player player 2 move: 6  
Calling AI for player 1  
My player player 1 move: 0  
Calling AI for player 2  
My player player 2 move: 6  
Calling AI for player 1  
My player player 1 move: 6  
Calling AI for player 2  
My player player 2 move: 4  
Calling AI for player 1  
My player player 1 move: 3  
Calling AI for player 2  
My player player 2 move: 6  
Calling AI for player 1  
My player player 1 move: 3  
Calling AI for player 2  
My player player 2 move: 0  
Calling AI for player 1  
My player player 1 move: 5  
Calling AI for player 2  
My player player 2 move: 4  
Calling AI for player 1  
My player player 1 move: 4  
Calling AI for player 2  
Will timeout in...  

## Player:
is called A2Q1RandomPlayer.
It can consistently defeat a random player 1v1 using an alpha beta pruning algorithm.

## Description of AI: 
My Ai uses alpha beta pruning first by calling the minimax(recursive function) which takes in the starting depth of the tree, the game itself, the board we will be manipulating, as well as whos turn it currently is. So for the base case it checks whether the tree has reached a certain depth or not which it then returns the score of that board. 

My whole algorithm is based off of the returning of a board object which has a char[][] board, the move, and the score of that board. From there we can calculate the best score and then a global instance variable at the root checks for the move at the root which is the best move. The score is based on the built in function that states that a great state for the Ai is one where its score is increased and a bad state is one which allows the other player to GET points the next turn. 

If the base case is not satisfied then it continues to check if this is a maximizing or minimizing node and based on that is able to set the current "best" to certain values. If its a maximizing value then its set to arbiturary big number like -10000 if minimizing then 10000. From there it generates all the possible states of the current Board and stores them in an ArrayList which holds board objects that contain the char[][] board itself as well as the column we placed a new piece in. 

Also, we can check each of these newly generated states to see, in the case of the maximizing node, which returns the highest value and in the case of the minimizing node which returns the lowest value. If the algorithm sees that, for the max side, the value obtained is greater in comparison to its sibling then it knows to stop and prune the rest because the node itself is a max node so if its value is greater then its sibling already it does not matter what other values are also greater because they will not get picked as the min node by the parent(which is a min Board).\

The same goes for the min Node but it is able to prune when it knows any other min score is lower that meaning if it is lower then it will not be passed on and such that move will not be executed. After going through the chosen depth it returns the best move currently available to the player and makes it the Ai play that move. The further down the Ai is able to see ie the greater the depth the better the move that will be made.
