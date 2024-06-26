package b1000;

import java.util.Scanner;

public class Main_1033 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		String res = "";
		for(int i=1; i<str.length()-1; i++) {
			for(int j=i+1; j<str.length(); j++) {
				String temp = "";
				temp += getSubstring(str, 0, i);
				temp += getSubstring(str, i, j);
				temp += getSubstring(str, j, str.length());
				if(res.length()==0) res = temp;
				else {
					if(res.compareTo(temp)>0) res = temp; 
				}
			}
			
		}
		System.out.println(res);
	}

	static String getSubstring(String str, int start, int end) {
		StringBuilder sb = new StringBuilder();
		sb.append(str.substring(start, end));
		return sb.reverse().toString();
	}
}
