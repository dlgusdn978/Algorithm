package b3000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_3986 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		int count = 0;
		// 단어 갯수만큼 반복.
		for(int i=0; i<n; i++) {
			Stack<String> s = new Stack<>();
			String str = br.readLine();
			for(int j=0; j<str.length(); j++) {
				String cur = str.substring(j, j+1);
				if(s.empty()) s.push(cur);
				else {
					if(s.peek().equals(cur)) {
						while(!s.empty() && s.peek().equals(cur)) s.pop();
					}else {
						s.push(cur);
					}
				}
			}
			if(s.size()==0) count++;
		}
		System.out.println(count);
	}

}
