package mindgame;

import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class GameFrame extends JFrame implements ActionListener,WinnerListener{
	static Box boxes[] = new Box[9];
	static int selected = -1;
	GameFrame(){
		init();
	}

	public void init(){
		for(int i=0;i<9;i++){
			boxes[i] = new Box();
			boxes[i].btn.addActionListener(this);
			boxes[i].btn.setActionCommand(Integer.toString(i));
			add(boxes[i].btn);
		}
		GameEngine.addWinnerListener(this);
		setLayout(new GridLayout(3,3));
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(MindGame.width,MindGame.height);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		String btnStr = ae.getActionCommand();
		int btnId = Integer.parseInt(btnStr);
		Box current = boxes[btnId];

		if(GameEngine.count<6){								//before 6 steps
			if(current.isSet==false){
				if(GameEngine.currentTurn == Player.X){
					current.setValue(Player.X);
				}
				else{
					current.setValue(Player.O);	
				}
				current.update();
				GameEngine.changeTurn();
			}
		}
		else{
			if(current.getValue()==GameEngine.currentTurn){							//selected the box to move
				if(selected!=-1 && current.getValue()==GameEngine.currentTurn){
					boxes[selected].btn.setEnabled(true);
				}
				selected = btnId;
				current.btn.setEnabled(false);
			}
			else if(current.getValue()==Player.NONE && selected!=-1 && Box.isValid[selected][btnId]){				//moving box condition
				GameEngine.moveBox(selected,btnId);
			}
		}
	}

	public void onWon(int player){
		if(player==Player.X){
			JOptionPane.showMessageDialog(this, "The winner is Player X !!!");
		}
		else{
			JOptionPane.showMessageDialog(this, "The winner is Player O !!!");	
		}
	}
}