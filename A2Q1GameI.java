public interface A2Q1GameI {
   public char[][] board();//what the board looks like
   public int score(char player);//score for the current player
   public int score(char player, char[][] board);//different board try to move and calculate score based on that move
   public int millisLeft();//how many seconds you have left to make a move
   public int currentPlayer();//which players turn it is
   public int players();//the amount of players playing
}

