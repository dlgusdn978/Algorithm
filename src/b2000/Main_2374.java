package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Stack;

public class Main_2374 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		// 스택에서 다음으로 꺼내는 수가 현재 수보다 크다면 add 연산 수행?
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
	
		Stack<Integer> s = new Stack<>();
		int max = 0;
		BigInteger cnt = new BigInteger("0");
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			max = Math.max(max, num);
			
			if(s.isEmpty()) {
				s.push(num);
				continue;
			}
			
			if(s.peek()<num) {
				BigInteger res = add(s, num);
				cnt = cnt.add(res);
			}
			s.push(num);
		}
		
		cnt = cnt.add(add(s, max));
		System.out.println(cnt);
	}

	static BigInteger add(Stack<Integer> s, int num) {
		BigInteger temp = new BigInteger("0");
		while(!s.isEmpty() && s.peek()<num) {
			int cur = s.pop();
			int next = s.isEmpty() ? num : Math.min(s.peek(), num);
			temp = temp.add(BigInteger.valueOf(next).subtract(BigInteger.valueOf(cur)));
		}
		return temp;
	}
}
