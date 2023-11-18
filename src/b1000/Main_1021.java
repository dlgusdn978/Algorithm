package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_1021 {

	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(st.nextToken());
		
		st= new StringTokenizer(br.readLine());
		
		int[] el = new int[m];
		for(int i=0; i<m; i++) {
			el[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		
		for(int i=1; i<=n; i++) {
			q.add(i);
		}
		int total = 0;
		for(int i=0; i<m; i++) {
			int count = 0;
			boolean flag = false;
			
			while(true) {
				int cur = q.poll();
				if(el[i]==cur) break;
				count ++;
				q.add(cur);
			}
			count = count<=q.size()-count ?  count : q.size()-count+1;
			total += count;
		}
		System.out.println(total);
	}

}
