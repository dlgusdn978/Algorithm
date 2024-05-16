package b12000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_12789 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = 1;
		
		Stack<Integer> s = new Stack<>();
		
		boolean flag = true;
		for(int i=0; i<n; i++) {
			int num = arr[i];
			
			if(num==count) {
				count++;
			}else {
				while(!s.isEmpty() && s.peek()==count) {
					s.pop();
					count++;
				}
				s.push(num);
			}
		}
		while(!s.isEmpty()) {
			if(s.peek()==count) {
				s.pop();
				count++;
			}else break;
		}
		System.out.println(s.isEmpty() ? "Nice" : "Sad");
		

	}

}
