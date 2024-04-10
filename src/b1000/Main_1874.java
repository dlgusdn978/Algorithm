package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1874 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// ���� ����
		int n = Integer.parseInt(br.readLine());

		Stack<Integer> s = new Stack<>();
		
		int[] arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int index = 1;
		int num = 1;
		boolean flag = true;
		while(num<=n) {
			// num�� �ִ� �⺻ ����
			s.push(num++);
			sb.append("+").append("\n");
//			System.out.println(arr[index]+" "+s.peek());
			// arr[index] ���� top�� �ٸ� ������ ����
			if(arr[index]==s.peek()) {
				while(!s.isEmpty()&& index<=n && arr[index]==s.peek()) {
//					System.out.println(" ���� �� : "+arr[index]+" "+s.peek());
					s.pop();
					index++;
					sb.append("-").append("\n");
				}
			}
			
		}
//		System.out.println(s.size());
		System.out.println(s.size()==0  ? sb.toString() : "NO");
		
	}

}
