package mindgame;

import javax.swing.JButton;

public class Box{
	static final Boolean isValid[][]=
	{{false,true,false,true,true,false,false,false,false},
	{true,false,true,true,true,true,false,false,false},
	{false,true,false,false,true,true,false,false,false},
	{true,true,false,false,true,false,true,true,false},
	{true,true,true,true,false,true,true,true,true},
	{false,true,true,false,true,false,false,true,true},
	{false,false,false,true,true,false,false,true,false},
	{false,false,false,true,true,true,true,false,true},
	{false,false,false,false,true,true,false,true,false}};

	public JButton btn;
	Boolean isSet;
	int currentValue;
	public Box(){
		isSet = false;
		btn = new JButton();
		currentValue = Player.NONE;
		update();
	}

	public void update(){
		if(currentValue==Player.NONE){
			btn.setText("");	
		}
		else if(currentValue==Player.X){
			btn.setText("X");	
		}else if(currentValue==Player.O){
			btn.setText("O");	
		}
	}

	public int getValue(){
		return currentValue;
	}

	public void setValue(int x){
		isSet = true;
		currentValue = x;
	}
}