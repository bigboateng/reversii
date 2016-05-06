package my_package;

import java.awt.BorderLayout;
import java.awt.Color;
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
	GameButton buttonArray[][] = new GameButton[8][8];
	
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
	
	int board[][] = new int[8][8];

	int NOT_MY_STATE;
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
        
        NOT_MY_STATE = player == Constants.BLACK_PLAYER ? Constants.WHITE_STATE:Constants.BLACK_STATE;
        
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
            	buttonArray[i][j] = b;
            	b.setCoordinate(i, j);
            	b.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						if(isTurn){
							if(b.hasBeenPlayed){
								System.out.println("This has already been played");
							}else{
								b.hasBeenPlayed = true;
								createCircle(b.x, b.y, player);
								opponent.opponentClicked(b.x, b.y);
								changeTurns();
								opponent.changeTurns();
								if(player == Constants.WHITE_PLAYER){
									board[b.x][b.y] = Constants.WHITE_STATE;
								}else{
									board[b.x][b.y] = Constants.BLACK_STATE;
								}
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
        
        for (int i=0; i < 8; i++)
        	   for (int j=0; j < 8; j++)
        	      board[i][j] = Constants.BLANK;

    	board[3][3] = Constants.WHITE_STATE;
    	createCircle(3,3, Constants.WHITE_PLAYER);
    	board[3][4] = Constants.BLACK_STATE;
    	createCircle(3,4, Constants.BLACK_PLAYER);
    	board[4][3] = Constants.BLACK_STATE;
    	createCircle(4,3, Constants.BLACK_PLAYER);
    	board[4][4] =  Constants.WHITE_STATE;
    	createCircle(4,4, Constants.WHITE_PLAYER);
    	buttonArray[3][3].hasBeenPlayed = true;
      	buttonArray[3][4].hasBeenPlayed = true;
      	buttonArray[4][3].hasBeenPlayed = true;
      	buttonArray[4][4].hasBeenPlayed = true;
        JButton button = new JButton(Constants.getTopLabel(player));
        add(button, BorderLayout.PAGE_END);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
	}
	
	public void isPlayingWith(Game opponent){
		this.opponent = opponent;
		
	}
	
	public void opponentClicked(int x, int y){
		buttonArray[7-x][7-y].hasBeenPlayed = true;
		createCircle(Math.abs(7-x), Math.abs(7-y), opponent.player);
		System.out.println(Math.abs(7-x) + "," + Math.abs(7-y));
	}
	
	public void changeTurns(){
		isTurn = !isTurn;
		if(player == Constants.WHITE_PLAYER){
			label.setText(label.getText() == Constants.TURN_WHITE? Constants.NOT_TURN_WHITE:Constants.TURN_WHITE);
		}else{
			label.setText(label.getText() == Constants.TURN_BLACK? Constants.NOT_TURN_BLACK:Constants.TURN_BLACK);
		}
	}
	
	public void createCircle(int x, int y, String Who){
		GameButton b = (GameButton)buttonArray[x][y];
		if(Who == Constants.BLACK_PLAYER){
			b.setColor(Color.BLACK);
		}else{
			b.setColor(Color.WHITE);
		}
	}
	
	public boolean isAValidMove(int x, int y){
		//check top
		boolean shouldContinue = true;
		boolean found = false;
		int h =0;
		while(shouldContinue){
			System.out.println("h=" + h);
			if(board[x-h][y] == NOT_MY_STATE){
				h++;
				if(h == 7){
					shouldContinue = false;
					found = false;
				}
			}else{
				if(h > 1){
					shouldContinue = false;
					found =  true;
				}else{
					shouldContinue = false;
					found =  false;
				}
			}
		}
		return found;
	}
}
