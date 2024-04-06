package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_2504 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String str = br.readLine();

		Stack<String> s = new Stack<>();
		
		// s의 값을 하나씩 빼면서 temp에 저장, 임시 변수에 기록
		// 오른쪽 괄호를 꺼내다가 왼쪽 괄호를 꺼내게 되면, 마지막 임시 변수에 저장된 괄호와 세트가 되는지 비교
		// 세트라면 숫자로 변환, 아니라면 종료
		
		for(int i=0; i<str.length(); i++) {
			s.push(str.substring(i, i+1));
		}
		 
//		for(String a : s) {
//			System.out.println(a);
//		}

		Stack<String> temp = new Stack<>();

		while(!s.isEmpty()) { 
//			System.out.println(s.size()+" "+temp.size());
			String cur = s.pop();
			switch(cur) {
			case ")":
				temp.push(cur);
				break;
			case "]":
				temp.push(cur);
				break;
			case "(":
				int count = 0;
				boolean checker = false;
				while(!temp.isEmpty() && !checker) {
					String pre = temp.pop();
					if(pre.equals(")")) checker = true;
					else if(pre.equals("]")) break;
					else count += Integer.parseInt(pre);
				}
				if(!checker) {
					System.out.println(0);
					return;
				}
				temp.push(String.valueOf(count==0 ? 2 : count*2));
				break;
			case "[":
				int count2 = 0;
				boolean checker2 = false;
				while(!temp.isEmpty() && !checker2) {
					String pre = temp.pop();
					if(pre.equals(")")) break;
					else if(pre.equals("]")) checker2 = true;
					else count2+= Integer.parseInt(pre);
				}
				if(!checker2) {
					System.out.println(0);
					return;
				}
				temp.push(String.valueOf(count2==0 ? 3 : count2*3));
				break;
			default:
				temp.push(cur);
				break;
			}
			
		}
		int sum = 0;
		for(String a : s) {
			if(a.equals(")") || a.equals("]")||a.equals("(")||a.equals("[")) {
				System.out.println(0);
				return;
			}
			sum+=Integer.parseInt(a);
		}
		for(String a : temp) {
			if(a.equals(")") || a.equals("]")||a.equals("(")||a.equals("[")) {
				System.out.println(0);
				return;
			}
			sum+=Integer.parseInt(a);
		}
		System.out.println(sum);
	}

}
