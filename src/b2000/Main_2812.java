package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2812 {

	static int n, k;
	static Stack<Integer> s;
	public static void main(String[] args) throws IOException {
		// 모든 숫자를 stack에 넣는다.
		// 스택에서 모든 수를 꺼내면서 가장 작은 수를 찾는다.
		// 스택에서 모든 원소를 꺼내어 비교하고 가장 작은 수를 찾으면, 꺼낸 수를 다시 스택에 넣는다.
		// 넣는 수가 가장 작은 수라면 넣지 않고 k-1
		// k==0 이라면 더이상 비교하지 않고 다 넣음.
		// 모든 숫자를 다시 순서대로 꺼내어 reverse sort
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		s = new Stack<>();
		
		// 숫자의 개수 n
		n = Integer.parseInt(st.nextToken());
		// 빼낼 수의 개수 k
		k = Integer.parseInt(st.nextToken());
		
		String num = br.readLine();
		for(int i=0; i<n; i++) {
			s.push(num.charAt(i)-48);
		}
		find();
		
		for(int a : s) {
			sb.append(a);
		}
		sb.setLength(sb.length()-k);
		System.out.println(sb.toString());
	}
	
	static void find() {
		Stack<Integer> temp = new Stack<>();
		
		while(!s.isEmpty()) {
			temp.push(s.pop());
		}
		while(!temp.isEmpty()) {
//			System.out.println("??");
//			System.out.println(temp.size());
			// 먼저 넣은 수가 현재 수보다 클 때 현재 수 넣지 않음. k-1
			// 먼저 넣은 수가 현재 수보다 작을 때 먼저 넣은 수를 뺌. k-1 
			int cur = temp.pop();
			while(!s.isEmpty() && s.peek()<cur && k>0) {
				s.pop();
				k--;
			}
			s.push(cur);
		}
		
	}

}
