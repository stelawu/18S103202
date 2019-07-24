import java.io.*;
import java.util.Scanner;

public class Action{
	int playerid;
	public Position src, dest;
	public Action(int inputid){
		playerid = inputid;
	}
	public int put(Position p, Player player){  //放置棋子
		if(select(p) == 0){
			if(playerid == 1){
				Piece new_piece = new Piece("白", player, 1);
				p.put(new_piece);
				player.history += "put "+ new_piece.color + new_piece.name + "\033[0m on ("+p.x+", " + p.y +")\n";
				System.out.println("put success！");
				return 1;
			}
			else{
				Piece new_piece = new Piece("黑",player, 2);
				p.put(new_piece);
				System.out.println("put success！");
				player.history += "put "+ new_piece.color + new_piece.name + "\033[0m on ("+p.x+", " + p.y +")\n";
				return 1;
			}
		}
		System.out.printf("put fail:位置(%d, %d)已有棋子，为"+p.p.color+"%s\033[0m\n", p.x, p.y, p.p.name);
		return 0;
	}
	public int take(Position p, Player player){ //提子
		if(select(p)==0){
			System.out.printf("take fail:位置(%d, %d)没有棋子\n", p.x, p.y);
			return 0;
		}
		else if(p.p.belongto == playerid){
			System.out.printf("take fail:位置(%d, %d)不是对方棋子不可以提\n", p.x, p.y);
			return 0;
		}
		else{
			System.out.println(p.p.name);	
			System.out.println(p.p.player.total);	
			player.history += "take "+ p.p.color + p.p.name + "\033[0m from ("+p.x+", " + p.y +")\n";	
			p.p.player.total--;		
			p.remove();

			System.out.println("take success！");
			return 1;
		}
		
		
	}
	public int move(Position src, Position dest, Player player){ //move
		if(select(src) == 1){
			if(src.p.belongto != playerid){
				System.out.println("move fail:不是你的棋子,不可以移动\n");
				return 0;
			}
			else if(select(dest) == 1){
				System.out.printf("move fail:位置(%d, %d)已被"+dest.p.color+"%s占用\033[0m\n", dest.x, dest.y, dest.p.name);
				return 0;
			}
			else{
				player.history += "move "+ src.p.color + src.p.name + "\033[0m from ("+src.x+", " + src.y +") to ("+dest.x + ", "+dest.y+")\n";
				dest.put(src.p);
				src.remove();
				System.out.println("move success!");
				return 1;
				
			}
			
	
		}
		System.out.printf("move fail:位置(%d, %d)没有棋子\n", src.x, src.y);
		return 0;

	}
	public int eat(Position src, Position dest, Player player){  //eat
		if(select(src) == 1){
			if(src.p.belongto != playerid){
				System.out.println("eat fail:不是你的棋子,不可以操作\n");
				return 0;
			}
			else if(select(dest) == 0){
				System.out.printf("eat fail:位置(%d, %d)没有棋子\n", dest.x, dest.y);
				return 0;
			}
			else if(dest.p.belongto == playerid){
				System.out.printf("eat fail:位置(%d, %d)是你自己的棋子\n", dest.x, dest.y);
				return 0;
			}
			else{
				player.history += "eat " +dest.p.color + dest.p.name+ "\033[0m("+dest.x + ", " + dest.y + ") use " + src.p.color + src.p.name+"\033[0m("+ src.x +", " + src.y + ")\n";
				dest.p.player.total--;				
				dest.put(src.p);
				src.remove();
				System.out.println("eat success!");
				return 1;
			}
			
	
		}
		System.out.printf("eat fail:位置(%d, %d)没有棋子\n", src.x, src.y);
		return 0;
	}		
	public int select(Position p){ //查询
		if(p.flag == 1) return 1;
		else return 0;
	}

}
