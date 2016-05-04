package my_package;

class Constants {
	public static String AI_TURN_WHITE = "Greedy AI play white";
	public static String AI_TURN_BLACK = "Greedy AI play black";
	public static String WHITE_PLAYER = "White";
	public static String BLACK_PLAYER = "Black";
	public static String NOT_TURN_BLACK = "Black player - not your turn";
	public static String NOT_TURN_WHITE = "White player - not your turn";
	public static String TURN_BLACK = "Black player - click place to put piece";
	public static String TURN_WHITE = "White player - click place to put piece";
	public static String getTopLabel(String color){
		return color == WHITE_PLAYER ? AI_TURN_BLACK:	AI_TURN_WHITE;
	}
}
