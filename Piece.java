import java.io.*;
import java.util.Scanner;

public class Piece implements Cloneable{
	public String name = "+"; //该棋子名称
	public String color; //color
	public int belongto = -1;
	public Player player;
	public Piece(String inputname, Player playerin, int i){
		name = inputname;
		player = playerin;
		if(i == 2){
			color = "\033[44;30m";}
		if(i == 1) color = "\033[44;37m";
		belongto = i;
	}
	public Object clone(){
		Piece p = null;
		try{
			p = (Piece)super.clone();
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		return p;
	}

}
