package b2000;

import java.util.Scanner;

public class Main_2744 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		str.toLowerCase();

		String temp = "";
		for(int i=0; i<str.length(); i++) {
			char cur = str.charAt(i);
			if(cur-0>=65 && cur-0<=90){
				temp+=str.substring(i, i+1).toLowerCase();
			}else if(cur-0>=97 && cur-0<=122) {
				temp+=str.substring(i, i+1).toUpperCase();
			}
		}
		System.out.println(temp);
		
	}

}
