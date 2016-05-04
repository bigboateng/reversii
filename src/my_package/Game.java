package my_package;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Game extends JFrame{
	/*
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * Array to store buttons
	 */
	ArrayList<JButton> buttonArray = new ArrayList<>();
	
	/*
	 * Opponent Object 
	 */
	private Game opponent = null;
	
	/*
	 * boolean to check if its current player's turn
	 */
	private boolean isTurn;
	
	/*
	 * label at top to say stuff
	 */
	JLabel label = new JLabel();
	
	String player;
	/*
	 * Constructor of Game class - sets up the game
	 */
	
	/*
	 * Board state 
	 */
	
	String[][] boardState = new String[8][8];
	
	public Game(String p){
		
        super("Reversi -" + p + " Player");
        player = p;
        /*
         * set who's turn it is 
         */
        isTurn = player == Constants.BLACK_PLAYER? true : false;
        /*
         * play
         */
        if(isTurn && player==Constants.BLACK_PLAYER){
        	label.setText(Constants.TURN_BLACK);
        }else{
        	label.setText(Constants.NOT_TURN_WHITE);
        }
        setSize(320,360);
        setLayout(new BorderLayout());
        add(label, BorderLayout.PAGE_START);
        GridLayout buttonsGridLayout = new GridLayout(8,8);
        JPanel panel2 = new JPanel(buttonsGridLayout);
        add(panel2, BorderLayout.CENTER);
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
						if(isTurn){
							if(b.hasBeenPlayed){
								System.out.println("This has already been played");
							}else{
								b.setText("O");
								opponent.opponentClicked(buttonArray.indexOf(b));
								changeTurns();
								opponent.changeTurns();
								b.hasBeenPlayed = true;
							}
						}else{
							System.out.println("Not your turn");
						}
					}
            	});
        		b.setName(i + ","+ j);
        		panel2.add(b);
        	}
        }
        
        JButton button = new JButton(Constants.getTopLabel(player));
        add(button, BorderLayout.PAGE_END);
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
	}
	
	public void isPlayingWith(Game opponent){
		this.opponent = opponent;
	}
	
	public void opponentClicked(int index){
		GameButton b = (GameButton)buttonArray.get(index);
		b.setText("X");
		b.hasBeenPlayed = true;
	}
	
	public void changeTurns(){
		isTurn = !isTurn;
		if(player == Constants.WHITE_PLAYER){
			label.setText(label.getText() == Constants.TURN_WHITE? Constants.NOT_TURN_WHITE:Constants.TURN_WHITE);
		}else{
			label.setText(label.getText() == Constants.TURN_BLACK? Constants.NOT_TURN_BLACK:Constants.TURN_BLACK);
		}
	}


	


}
