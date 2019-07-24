import java.io.*;
import java.util.Scanner;

public class MyChessAndGoGame{
	public static void main(String []args)
	{
		Game G=null;
		Scanner sc = new Scanner(System.in);
		int inputtypeover = 0;
		while(inputtypeover == 0){
			System.out.println("Choose chess or go?");
			String type = sc.next();   //type indicates chess or go
			if(type.equals("chess")){
				inputtypeover = 1;
				G = new Chess("chess");		//初始化棋盘为chess 
			}
			else if (type.equals("go")){
				inputtypeover = 1;
				G = new Go("go");		//初始化棋盘为go 
			}
		}		
		G.print();//输出初始棋盘

		System.out.println("Please enter the names of player1 and player2:");		
		String player1name = sc.next();
		String player2name = sc.next();
		G.setplayer(player1name, player2name);  //创建两个玩家对象
		int flag_end = 0;
		
		while(flag_end == 0){
			int flag_keep_turn = 1;
			System.out.printf("\033[0m\033[1;34m--------------------------\nPlayer1(white):%10s\n--------------------------\033[0m\n", G.player1.name);
			while(flag_keep_turn ==1){
				flag_keep_turn = G.player1.action(G);
			}
			G.print();
			flag_keep_turn = 1;
			System.out.printf("\033[0m\033[1;33m--------------------------\nPlayer2(black):%10s\n--------------------------\033[0m\n", G.player2.name);
			while(flag_keep_turn == 1){
				flag_keep_turn = G.player2.action(G);
			}
			G.print();
		}
		

	}



}
