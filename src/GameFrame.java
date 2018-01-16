package mindgame;

import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameFrame extends JFrame implements ActionListener{
	// JButton buttons[] = new JButton[9];
	Box boxes[] = new Box[9];
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
		setLayout(new GridLayout(3,3));
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(MindGame.width,MindGame.height);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		String btnId = ae.getActionCommand();
		Box current = boxes[Integer.parseInt(btnId)];

		if(current.isSet==false && Player.count<6){
			if(Player.currentTurn == Player.X){
				current.setValue(Box.X);
			}
			else{
				current.setValue(Box.O);	
			}
			Player.changeTurn();
			current.update();
		}

	}
	public void update(){
		for(int i=0;i<9;i++){

		}
	}
}