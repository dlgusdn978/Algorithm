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
		// ��� ���ڸ� stack�� �ִ´�.
		// ���ÿ��� ��� ���� �����鼭 ���� ���� ���� ã�´�.
		// ���ÿ��� ��� ���Ҹ� ������ ���ϰ� ���� ���� ���� ã����, ���� ���� �ٽ� ���ÿ� �ִ´�.
		// �ִ� ���� ���� ���� ����� ���� �ʰ� k-1
		// k==0 �̶�� ���̻� ������ �ʰ� �� ����.
		// ��� ���ڸ� �ٽ� ������� ������ reverse sort
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		s = new Stack<>();
		
		// ������ ���� n
		n = Integer.parseInt(st.nextToken());
		// ���� ���� ���� k
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
			// ���� ���� ���� ���� ������ Ŭ �� ���� �� ���� ����. k-1
			// ���� ���� ���� ���� ������ ���� �� ���� ���� ���� ��. k-1 
			int cur = temp.pop();
			while(!s.isEmpty() && s.peek()<cur && k>0) {
				s.pop();
				k--;
			}
			s.push(cur);
		}
		
	}

}
