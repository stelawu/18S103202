import java.io.*;
import java.util.Scanner;

public class Player{
	public String name;
	public int total = 0;
	public int id;
	public String history = "";
	public Player(String inputname, int inputsize, int inputid){
		name = inputname;
		if(inputsize == 8) total = 16;
		if(inputsize == 18) total = 0;
		id = inputid;
	}
	public int action(Game G){
		int actionid;
		Action todo = new Action(id);
		System.out.println("\033[2;3m\n请输入操作对应的编码：\n1.put(for go)\n2.move\n3.take\n4.eat\n5.select(不占用本轮走棋机会)\n6.计算双方总棋子数(不占用本轮走棋机会)\n7.end\n8.bypass\033[0m");
		Scanner sc = new Scanner(System.in);
		actionid = sc.nextInt();
		int x, y, x1, y1, x2, y2, flag =0;
		Position srcp, destp, p;
		switch(actionid){
			case 1:
				System.out.println("请输入棋子放入坐标x,y --中间空格):");
				x = sc.nextInt();
				y = sc.nextInt();
				destp = G.board.game_board[x][y];
				flag = todo.put(destp,this);
				if(flag == 1) total++;
				break;
			case 2:
				System.out.println("请输入移动棋子初始和目的坐标，x1, y1和x2, y2 --中间空格:");
				x1 = sc.nextInt();
				y1 = sc.nextInt();
				x2 = sc.nextInt();
				y2 = sc.nextInt();
				srcp = G.board.game_board[x1][y1];
				destp = G.board.game_board[x2][y2];
				flag = todo.move(srcp, destp, this);
				break;
			case 3:
				System.out.println("请输入提子位置坐标x,y --中间空格:");
				x = sc.nextInt();
				y = sc.nextInt();
				p = G.board.game_board[x][y];
				flag = todo.take(p, this);	
				break;
			case 4:
				System.out.println("请输入吃子的源和目标的位置x1, y1和x2, y2 --中间空格:");
				x1 = sc.nextInt();
				y1 = sc.nextInt();
				x2 = sc.nextInt();
				y2 = sc.nextInt();
				srcp = G.board.game_board[x1][y1];
				destp = G.board.game_board[x2][y2];
				flag = todo.eat(srcp, destp, this);
				break;
			case 5:
				System.out.println("请输入要查找的棋格情况坐标x,y --中间空格:");
				x = sc.nextInt();
				y = sc.nextInt();
				destp = G.board.game_board[x][y];
				flag = todo.select(destp);
				if(flag == 0) System.out.printf("位置(%d, %d)没有棋子\n", x, y);
				else{
					System.out.printf("位置(%d, %d)的棋子是"+destp.p.color+"%s\033[0m\n", x, y, destp.p.name);
				}
				break;
			case 6:
				System.out.println(G.player1.name+"的剩余棋子数："+G.player1.total);
				System.out.println(G.player2.name+"的剩余棋子数："+G.player2.total);
				break;
			case 7:
				System.out.println("\033[1;34mPlayer1:" + G.player1.name + "\033[0m\n" + G.player1.history);	
				System.out.println("\033[1;33mPlayer2:" + G.player2.name + "\033[0m\n"+ G.player2.history);				
				System.exit(0);
				break;
			case 8:
				return 0;
		}
		if(flag == 1 && (actionid == 1 || actionid == 2 || actionid == 3 || actionid == 4))
			return 0;
		else return 1;

	}



}
