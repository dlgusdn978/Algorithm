package b4000;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_4949{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Character> s1;
		Stack<Character> s2;
		String str = "";
		while((str=br.readLine())!=null) {
			if(str.equals(".")) break;
			char[] chars = str.toCharArray();
			s1 = new Stack<Character>();
			s2 = new Stack<Character>();
			// 스택에 넣기
//			System.out.println(Arrays.toString(chars));
			for(int i=0; i<chars.length; i++) {
				char cur = chars[i];
				if(cur==')'||cur=='('||cur==']'||cur=='[') {
					s1.push(cur);
				}
			}
			// 스택에서 하나씩 꺼내서 괄호 일치하는지 비교
			
			boolean flag = true;
			int so = 0;
			int sc = 0;
			int bo = 0;
			int bc = 0;
			
			while(!s1.isEmpty()) {
				char cur = s1.pop();
				switch(cur) {
				case ')':
					s2.push(cur);
					sc++;
					break;
				case ']':
					s2.push(cur);
					bc++;
					break;
				case '(':
					if(s2.isEmpty()) {
						flag = false;
						break;
					}
					so++;
					char pre = s2.pop();
					if(pre!=')') flag = false;
					break;
				case '[':
					if(s2.isEmpty()) {
						flag = false;
						break;
					}
					bo++;
					char pre2 = s2.pop();
					if(pre2!=']') flag = false;
					break;
				}
			}
			if(so!=sc || bo!=bc) flag = false;
			if(flag) System.out.println("yes");
			else System.out.println("no");
			
		}

	}

}
