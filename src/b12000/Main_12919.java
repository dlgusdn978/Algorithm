package b12000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_12919 {

	static String s, t;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		s = br.readLine();
		
		t = br.readLine();
		
		// 1. StringBuilder 에 넣고 뒤집어서 b추가... 
		
		recursive(t);
		System.out.println(flag ? 1 : 0);
	}

	static void recursive(String temp) {
		if(temp.length()==s.length()) {
			if(temp.equals(s)) {
				flag = true;
			}
			return;
		}
		// baba 이고, a와 같은지 확인.
		
		if(temp.charAt(0)=='B') {
			StringBuilder sb = new StringBuilder(temp);
			sb.reverse();
			recursive(sb.substring(0, sb.length()-1));
		}
		if(temp.charAt(temp.length()-1)=='A') {
			recursive(temp.substring(0, temp.length()-1));
		}
	}
}
