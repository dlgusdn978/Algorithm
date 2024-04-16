package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1863 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		
		int n = Integer.parseInt(br.readLine());
		
		// ���� ������ ũ�ų� ������ �׳� ���ÿ� �ֱ�.
		// ���� ������ ������ ���� ���� ���� ������ ���ÿ��� ��� ���� �� COUNT +1
		
		Stack<Integer> s = new Stack<Integer>();

		int count = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			int temp = -1;
			while(!s.isEmpty() && s.peek()>h) {
				int cur = s.pop();
				if(temp!=cur) {
					count++;
					temp = cur;
				}
			}
			s.push(h);
		}
//		System.out.println("? "+count);
		int pre = 0;
		while(!s.isEmpty()) {
			int cur = s.pop();
//			System.out.println(cur);
			if(cur!=pre && cur!=0) {
				pre = cur;
				count++;
			}
		}
//		System.out.println();
//		for(int a : s) {
//			System.out.println(a);
//		}
//		
//		System.out.println();
		System.out.println(count);
//		System.out.println(s.size());
	}

}
