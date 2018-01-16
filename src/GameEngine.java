package mindgame;

interface WinnerListener{
	public void onWon(int player);
}

public class GameEngine{
	static GameFrame frame;
	static int count = 0;
	static int currentTurn = Player.X;

	public static void moveBox(int init, int dest){
		GameFrame.boxes[dest].setValue(GameFrame.boxes[init].getValue());
		GameFrame.boxes[init].setValue(Player.NONE);
		GameFrame.boxes[init].update();
		GameFrame.boxes[dest].update();
		GameFrame.boxes[init].btn.setEnabled(true);
		GameFrame.selected = -1;
		changeTurn();
	}

	public static void addWinnerListener(GameFrame frame){
		GameEngine.frame = frame;
	}

	public static int checkWon(){
		for(int i=1;i<=2;i++){			//checking for X and O, X=1, O=2
			for(int j = 0; j<3; j++){	//checking in rows
				if(frame.boxes[j*3].getValue()==i && frame.boxes[j*3+1].getValue()==i && frame.boxes[j*3+2].getValue()==i){		
					return i;
				}
			}
			for(int j = 0; j<3; j++){	//checking in columns
				if(frame.boxes[j].getValue()==i && frame.boxes[j+3].getValue()==i && frame.boxes[j+6].getValue()==i){		
					return i;
				}
			}
			if(frame.boxes[0].getValue()==i && frame.boxes[4].getValue()==i && frame.boxes[8].getValue()==i){		//checking in main diagonal
				return i;
			}
			if(frame.boxes[2].getValue()==i && frame.boxes[4].getValue()==i && frame.boxes[6].getValue()==i){		//checking in secodary diagonal
				return i;
			}
		}
		return -1;			//if there is no winning condition
	}

	public static void changeTurn(){
		count++;
		if(currentTurn==Player.X){
			currentTurn=Player.O;
		}
		else{
			currentTurn=Player.X;	
		}

		int won = checkWon();
		if(won!=-1){						//if some player won
			frame.onWon(won);
		}
	}
}