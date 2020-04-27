package smallsix;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class UsersDAO {
	private static final String DB_FILE = "E:\\Git\\Program\\web\\smallSix.txt";
	
	public static boolean check(String username){
		boolean flag=false;
		try {
			Scanner cin=new Scanner(new File(DB_FILE));
			while(cin.hasNextLine()){
				String [] toks=cin.nextLine().trim().split("\\s+");
				if(toks[0].equalsIgnoreCase(username)){
					flag=true;
					break;					
				}				
			}
			cin.close();	
		} catch (FileNotFoundException e) {
			flag=false;
		}
		return flag;
		
	}
	public static boolean check(String username,String password){
		boolean flag=false;
		try {
			Scanner cin=new Scanner(new File(DB_FILE));
			while(cin.hasNextLine()){
				String [] toks=cin.nextLine().trim().split("\\s+");
				if(toks[0].equalsIgnoreCase(username)){
					if(toks[1].equals(password)){						
						flag=true;					
					}else{
						flag=false;
					}
					break;					
				}				
			}
			cin.close();	
		} catch (FileNotFoundException e) {
			flag=false;
		}
		return flag;

		
	}

	public static void main(String[] args) {

	}
	public static boolean register(String username, String password) {
		if(check(username))
			return false;
		try {
			PrintWriter fw = new PrintWriter(new FileWriter(DB_FILE, true));
			fw.println(String.format("%-32s %-32s",username,password));
			fw.close();
			return true;			

		} catch (IOException e) {
			return false;
		}
	
	}
}
