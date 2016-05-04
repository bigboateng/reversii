package my_package;

import javax.swing.JButton;

public class GameButton extends JButton{
	private static final long serialVersionUID = 1453504952420599700L;
	public boolean canClick = true;
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
