package my_package;


public class Board 
{
	public static void main(String args[])
	{
        Game white = new Game(Constants.WHITE_PLAYER);
        Game black = new Game(Constants.BLACK_PLAYER);
        white.isPlayingWith(black);
        black.isPlayingWith(white);
    }


}
