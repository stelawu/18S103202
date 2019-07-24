import java.io.*;
import java.util.Scanner;

//Game 棋类
public class Game{
	public String name;
	public int size = 0;
	public Board board;
	public Player player1, player2;
	public Game(String inputname){
		name = inputname;
	}

	public void setplayer(String play1n, String play2n){
		player1.name = play1n;
		player2.name = play2n;
	}



	public void print()
	{
		System.out.printf("\033[0m\033[44;37m%s\033[0m", "+");
		for(int k = 0; k < size; k++){
				System.out.printf("\033[0m\033[44;37m%s\033[0m", "---+");
		}		
		System.out.println();
		for(int i = 0; i < size; i++){
			System.out.printf("\033[0m\033[44;37m%s\033[0m", "|");
			for(int j = 0; j < size; j++){
				if(board.game_board[i][j].name.equals("X"))
					System.out.printf( board.game_board[i][j].color+"%2s\033[0m\033[44;37m%2s\033[0m", board.game_board[i][j].name, "|");
				else
					System.out.printf(board.game_board[i][j].color + "%-2s\033[0m\033[44;37m%s\033[0m", board.game_board[i][j].name, "|");
			}
			System.out.println();
			if(i != size-1) System.out.printf("\033[0m\033[44;37m%s\033[0m", "|");
			for(int k = 0; i != size-1 && k < size; k++){
				System.out.printf("\033[0m\033[44;37m%s\033[0m", "---|");
			}
			if(i != size-1) System.out.printf("\033[0m\n");
	
		}
		System.out.printf("\033[0m\033[44;37m%s\033[0m", "+");
		for(int k = 0; k < size; k++){
				System.out.printf("\033[0m\033[44;37m%s\033[0m", "---+");
		}		
		System.out.println();
	}

}

