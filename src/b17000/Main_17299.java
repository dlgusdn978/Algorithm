package b17000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_17299 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		// ���� 2��
		// ���� 1���� �ϳ��� ���鼭 ����2�� TOP ���ҿ� ��.
		// ���� 2�� TOP ���Ҵ� �ش� ���ÿ��� ���� ���� ��.
		// ���� 1������ ������ ����2�� TOP�� �� ũ�� �׳� ���
		// �װ� �ƴ϶�� ����2 TOP�� ��� ����.
		
		int n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		int[] count = new int[1000001];
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			count[num] += 1;
		}
		
		int[] res = new int[n];
		Stack<Integer> s = new Stack<>();
		for(int i=arr.length-1; i>=0; i--) {
			while(!s.isEmpty()) {
				int top = s.pop();
				if(count[arr[i]]<count[top]) {
					res[i] = top;
					s.push(top);
					break;
				}
			}
			if(s.isEmpty()) {
				res[i] = -1;
			}
			s.push(arr[i]);
		}
		for(int i=0; i<res.length; i++) {
			sb.append(res[i]).append(" ");
		}
		System.out.println(sb.toString());
		
		
		
	}

}
