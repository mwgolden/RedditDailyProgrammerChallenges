package challenge241_easy;

import java.util.HashMap;
import java.util.Set;

public class UnicodeChess {
	
	private HashMap<String, String> fenDict;
	private String board;
	
	public UnicodeChess() {
		fenDict = new HashMap<String, String>();
		fenDict.put("r", "\u265C");
		fenDict.put("n", "\u265E");
		fenDict.put("b", "\u265D");
		fenDict.put("q", "\u265A");
		fenDict.put("k", "\u265B");
		fenDict.put("p", "\u265F");
		fenDict.put("R", "\u2656");
		fenDict.put("N", "\u2658");
		fenDict.put("B", "\u2657");
		fenDict.put("Q", "\u2655");
		fenDict.put("K", "\u2654");
		fenDict.put("P", "\u2659");
		fenDict.put("s", "\u25A0"); //black square
		fenDict.put("S", "\u25A1"); //white square
		
		board = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";
	}
	
	public void displayBoard() {
		
		
	}

	public static void main(String[] args) {
		
		
		UnicodeChess uc = new UnicodeChess();
		
	}

}
