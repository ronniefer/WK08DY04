public class TicTacToeClass
{
	// Instance Variables
	private char[][] board;
	private int turns;

	// Constructors
	public TicTacToeClass()
	{
		board = new char[3][3];
		turns = 0;

		for ( int r=0; r<3; r++ )
			for ( int c=0; c<3; c++ )
				board[r][c] = ' ';
	}

	// Accessor Methods
	public boolean isWinner( char p )
	{
		int threeToWin = 0;
		int cy = 0; 
		
		// Check for 3 in a row - Horizontal
		for ( int r=0; r<3; r++ ) {
			for ( int c=0; c<3; c++ ) {
				if (board[r][c] == p) {
					threeToWin++;
				} else {
					threeToWin = 0;
					break;
				}
			}
			if (threeToWin == 3) {
				return true;
			}
		}
		
		threeToWin = 0;
			
		// Check for 3 in a row - Vertical
		for ( int c=0; c<3; c++ ) {
			for ( int r=0; r<3; r++ ) {
				if (board[r][c] == p) {
					threeToWin++;
				} else {
					threeToWin = 0;
					break;
				}
			}
			if (threeToWin == 3) {
				return true;
			}
		}
		
		threeToWin = 0;
		
		// Check for 3 in a row - Diagonal A
		for ( int x=0; x<3; x++ ) {
									
			if (board[x][x] == p) {
				threeToWin++;
			} 
			
			if (threeToWin == 3) {
				return true;
			}
		}
		
		threeToWin = 0;
		
		// Check for 3 in a row - Diagonal B
		for ( int r=2; r>-1; r-- ) {
			
			if (board[r][cy] == p) {
				threeToWin++;
			} 
			
			cy++;
			
			if (threeToWin == 3) {
				return true;
			}
		}
		
		return false;
	}

	public boolean isFull()
	{
		if (numTurns() == 9) {
			return true;
		} else {
			return false;
		}		
	}

	public boolean isCat()
	{
		if (isFull() && !isWinner('X') && !isWinner('O')) {
			return true;
		}
		
		return false;	
	}

	public boolean isValid( int r, int c )
	{
		if ( 0 <= r && r <= 2 && 0 <= c && c <= 2 )
			return true;
		else
			return false;
	}

	public int numTurns()
	{
		return turns;
	}

	public char playerAt( int r, int c )
	{
		if ( isValid(r,c) )
			return board[r][c];
		else
			return '@';
	}

	public void displayBoard()
	{
		System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
		System.out.println("    --+-+--");
		System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
		System.out.println("    --+-+--");
		System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
		System.out.println("     0 1 2 ");
	}

	// Modifiers
	public void playMove( char p, int r, int c )
	{
		board[r][c] = p;
		turns++;
	}

}
