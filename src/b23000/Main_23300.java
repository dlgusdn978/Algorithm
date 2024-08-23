package b23000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_23300 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		// 가능 웹 페이지 수
		int n = Integer.parseInt(st.nextToken());
		// 수행하는 작업 수
		int q = Integer.parseInt(st.nextToken());
		
		Stack<Integer> backward = new Stack<Integer>();
		Stack<Integer> forward = new Stack<Integer>();
		
		int cur = -1;
		for(int i=0; i<q; i++) {
			st = new StringTokenizer(br.readLine());
			String oper = st.nextToken();
			
			switch(oper) {
			case "B":
				if(backward.isEmpty()) continue;
				forward.add(cur);
				cur = backward.pop();
				break;
			case "F":
				if(forward.isEmpty()) continue;
				backward.add(cur);
				cur = forward.pop();
				break;
			case "A":
				int num = Integer.parseInt(st.nextToken());
				if(cur!=-1) backward.add(cur);
				cur = num;
				forward.clear();
				break;
			case "C":
				List<Integer> list = new ArrayList<Integer>();
				while(!backward.isEmpty()) {
					int backPage = backward.pop();
					if(list.isEmpty()) list.add(backPage);
					else if(list.get(list.size()-1)!=backPage) list.add(backPage);
				}
				while(!list.isEmpty()) {
					backward.add(list.remove(list.size()-1));
				}
				break;
			}
		}
		sb.append(cur).append("\n");
		sb.append(getStackValue(backward));
		sb.append("\n");
		sb.append(getStackValue(forward));
		
		System.out.println(sb.toString());
	}
	
	static String getStackValue(Stack<Integer> s) {
		StringBuilder sb = new StringBuilder();
		if(s.isEmpty()) sb.append(-1);
		else {
			while(!s.isEmpty()) {
				sb.append(s.pop()+" ");
			}
		}
		return sb.toString();
	}
}
