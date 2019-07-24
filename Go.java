import java.io.*;
import java.util.Scanner;


//Go围棋
public class Go extends Game{
	
	public Go(String inputname){
		super(inputname);
		
		board = new Board(18);
		size = 18;
		player1 = new Player("A", size,1);
		player2 = new Player("b", size,2);	
		board.initboard_go();
	}
	

}
