package mindgame;

public class Player{
	static final int X = 1;
	static final int O = 2;

	static int count = 0;
	static int currentTurn = X;

	public static void changeTurn(){
		count++;
		if(currentTurn==X){
			currentTurn=O;
		}
		else{
			currentTurn=X;	
		}
	}
}