package my_package;


public class Board 
{
	public static void main(String args[])
	{
        Game white = new Game("White");
        Game black = new Game("Black");
        white.isPlayingWith(black);
        black.isPlayingWith(white);
    }


}
