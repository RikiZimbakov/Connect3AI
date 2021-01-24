import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;


//miniclass take creates a board object that
//will be used to return proper value in alpha beta pruning
class Board
{
	char[][] newState;
	int move;
	int score;

	Board(char[][] nState, int nmove,int nscore)
	{
	    newState = nState;
	    move = nmove;
	    score = nscore;
	}
}


public class A2Q1RandomPlayer implements A2Q1AI
{
    static int holdbest;//used to return proper move value
    public int move(A2Q1GameI game)
    {
	int move;

	char curr = (char) (game.currentPlayer() + '0');
	move = minimax2(0,game,new Board(game.board(),0,game.score(curr,game.board())),-10000,10000,curr);
	//move = minimax2(0,game,new Board(fakeBoard,0,game.score(curr,fakeBoard)),-10000,10000,curr);

	return holdbest;
    }

    public String toString()
    {
	return "The destroyer"; //what I named my AI player
    }
    

    //method that creates a deep copy of char array and returns it
    public static char[][] deepCopy(char[][]copy)
    {
	char[][] current = new char[copy.length][copy[0].length];
	for (int i = 0; i < copy.length; i++)
	{
	    for (int j = 0; j < copy[i].length; j++)
		current[i][j] = copy[i][j];
	}
	    
	return current;
    }

    
    
    //generates all the variations of a current board being passed in and returns
    //an arraylist of all the possible boards
    //the char it takes in is used to determine which players turn it is
    public static ArrayList<Board> generateStates2(char[][] howGood,A2Q1GameI score,char player)
    {
	
	ArrayList<Board> checker = new ArrayList<Board>();
	char[][] check = Arrays.copyOf(howGood, howGood.length);
	
	int row;
	int col;
	int everyCol = check[0].length;
	for (row = check.length - 1; row >= 0; row--)
	{

	    if (everyCol > 0)//so only valid states are returned
	    {
		for (col = check[row].length - 1; col >= 0; col--)
		{
		    int temp = row;
		    while (check[temp][col] != ' ' && (temp != 0))
		    {		
			temp--;
		    }
		    if (check[temp][col] == ' ')
		    {
			char[][] new_state = deepCopy(check);
			new_state[temp][col] = player;//adds the value to that current spot
			checker.add(new Board(new_state,col,score.score('1',new_state)));//adds this new state to the arraylist

		    }
		    everyCol--;
		}
	    }

	}
	
	return checker;
	
    }
    
    // Returns optimal value for
    // current player (Initially called
    // for root and maximizer)

    
    public static void printBoard2(Board board)
    {
	System.out.println(new String(new char[board.newState.length * 2]).replace('\0', '-'));
	for (int i = 0; i < board.newState.length; i++)
	{
	    for (int j = 0; j < board.newState[i].length; j++)
	    {
		System.out.print(board.newState[i][j] + " ");
	    }
	    System.out.println();
	}
	System.out.println(new String(new char[board.newState.length * 2]).replace('\0', '-'));
    }

    // Returns optimal value for
    // current player (Initially called for root and maximizer)
    static int minimax2(int depth, A2Q1GameI score, Board workingBoard, int alpha, int beta,char currentPlayer)
    {
	// Terminating condition. i.e
	// leaf node is reached
	if (depth == 4)
	{
	    return workingBoard.score;
	}
	    

	if (currentPlayer == '1')
	{
	    
	    int best = -10000;

	    // Recur for left and
	    // right children
	    
	    ArrayList<Board> maxStates = generateStates2(workingBoard.newState,score,currentPlayer);
	   
	    for (int j = 0; j < maxStates.size(); j++)
	    {
		int val = minimax2(depth + 1,score, maxStates.get(j), alpha, beta,'2');				
				
		best = Math.max(best, val);
		
		if(depth == 0 && best > alpha)
		{
		    System.out.println("i made it here!");
		    holdbest = maxStates.get(j).move;
		}
		alpha = Math.max(alpha, best);

		
		// Alpha Beta Pruning
		if (beta <= alpha)
		{
		    break;
		}
		    
	    }
	    return best;
	} else
	{
	    
	    int bestMin = 10000;

	    // Recur for left and
	    // right children
	    ArrayList<Board> minStates = generateStates2(workingBoard.newState,score,currentPlayer);
	    for (int i = 0; i < minStates.size(); i++)
	    {
		int val = minimax2(depth + 1, score, minStates.get(i), alpha, beta,'1');
		bestMin = Math.min(bestMin, val);
		
		//attempts to check if depth 		
		beta = Math.min(beta, bestMin);
		
		// Alpha Beta Pruning
		if (beta <= alpha)
		{
		    break;
		}
		    
	    }
	    return bestMin;
	}
    }
     
}
