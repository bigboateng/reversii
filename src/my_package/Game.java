package my_package;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.text.html.HTMLDocument.Iterator;

public class Game extends JFrame{
	
	ArrayList<JButton> buttonArray = new ArrayList<>();
	int x,y = 0;
	
	private Game opponent = null;
	
	
	public Game(String player){
        super("Reversi -" + player + " Player");
        setSize(320,320);
        GridLayout gridLayout = new GridLayout(8,8);
        setLayout(gridLayout);
        for(int i=0;i<8;i++){
        	for(int j=0;j<8;j++){
        		String e = Integer.toString(i);
        		String x = Integer.toString(j);
        		final GameButton b = new GameButton(e +"," + x); 
            	buttonArray.add(b);
            	b.setCoordinate(i, j);
            	b.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						b.setText("O");
					}
            		
            	});
        		b.setName(i + ","+ j);
        		add(b);
        	}
        }
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
	}
	
	public void isPlayingWith(Game opponent){
		this.opponent = opponent;
	}
	
	public void opponentClicked(int x, int y){
		buttonArray.get(x+y).setText("O");
	}
	
	public void somethingClicked(int i, int j){
		this.opponent.opponentClicked(i,j);
	}

	


}
