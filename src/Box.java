package mindgame;

import javax.swing.JButton;

public class Box{
	static final int X = 1;
	static final int O = 2;
	static final int NONE = 0;

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
		currentValue = NONE;
		update();
	}

	public void update(){
		if(currentValue==NONE){
			btn.setText("");	
		}
		else if(currentValue==X){
			btn.setText("X");	
		}else if(currentValue==O){
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