package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2841 {

	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int lineCount = Integer.parseInt(st.nextToken());
		int pratCount = Integer.parseInt(st.nextToken());

		List<Stack<Integer>> list = new ArrayList<>();
		for(int i=0; i<7; i++) {
			list.add(new Stack<Integer>());
		}
		int count = 0;
		for(int i=0; i<lineCount; i++) {
			st = new StringTokenizer(br.readLine());
			int line = Integer.parseInt(st.nextToken());
			int prat = Integer.parseInt(st.nextToken());
			
			Stack<Integer> cur = list.get(line);
			
			while(!cur.isEmpty() && cur.peek()>prat) {
				cur.pop();
				count++;
			}
			if(!cur.isEmpty() && cur.peek()==prat) continue;
			cur.push(prat);
			count++;
		}
		System.out.println(count);
	}

}
