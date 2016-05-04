package my_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GameButton extends JButton{
	public int x;
	public int y;
	public GameButton(String name){
		super(name);
	
	}
	
	public void setCoordinate(int x, int y){
		this.x = x;
		this.y = y;
	}
	

}
