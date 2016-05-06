package my_package;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.JButton;

public class GameButton extends JButton implements Runnable{
	private static final long serialVersionUID = 1453504952420599700L;
	public boolean canClick = true;
	public int x;
	public int y;
	public Game whoPlayed = null;
	public boolean hasBeenPlayed = false;
	protected Color fillColor;
	public GameButton(String name){
		super(name);
	}
	
	public void setCoordinate(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	

	@Override
	protected void paintComponent(Graphics graphic) {
		// TODO Auto-generated method stub
			Graphics2D g = (Graphics2D)graphic;
			g.setStroke(new BasicStroke(5));
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 40, 40);
			g.setColor(Color.GREEN);
			g.fillRect(1,1,39,39);
			g.setColor(fillColor);
			if(hasBeenPlayed){
				g.fillOval(10, 10, 20, 20);
			}
			
	}
	
	public void redrawSelf(){
		EventQueue.invokeLater(this);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		repaint();
	}
	
	
	public void setColor(Color fillcolor){
		fillColor = fillcolor;
		redrawSelf();
	}

}