package b4000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_4659 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 모음 최소 1개 이상
		// 모음 혹은 자음이 3연속 불가능
		// 같은 글자 연속 2번 불가능 (ee, oo 제외)
		
		String str = "";
		
		while(!(str = br.readLine()).equals("end")) {
			boolean flag = false;
			char prev = '.';
			int count = 0;
			for(int i=0; i<str.length(); i++) {
				char cur = str.charAt(i);
				if(checker(cur)) flag = true;
				if(checker(cur)!=checker(prev)) count = 1;
				else count++;
				if(count>2 || (cur==prev &&(cur !='e'&&cur!='o'))) {
					flag = false;
					break;
				}
				prev = cur;
			}
			if(flag) sb.append("<").append(str).append("> is acceptable.").append("\n");
			else sb.append("<").append(str).append("> is not acceptable.").append("\n");
		}
	System.out.println(sb.toString());	
	}

	static boolean checker(char cur) {
		if(cur=='a'||cur=='e'||cur=='i'||cur=='o'||cur=='u') return true;
		else return false;
	}
}
