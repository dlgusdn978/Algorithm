package b14000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
public class Main_14713 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1. 전체 문장에서 각 앵무새들의 단어가 순서대로 나오는지만 확인하면 되는 것 x
		// 2. 스택같은 느낌으로..
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		List<Queue<String>> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			Queue<String> q = new ArrayDeque<>();
			for(String word : br.readLine().split(" ")) {
				q.offer(word);
			}
			list.add(q);
		}
		
		String[] sentence = br.readLine().split(" ");
		
		for(String word : sentence) {
			boolean flag = false;
			
			for(Queue<String> w : list) {
				if(!w.isEmpty() && w.peek().equals(word)) {
					w.poll();
					flag = true;
					break;
				}
			}
			if(!flag) {
				System.out.println("Impossible");
				return;
			}
		}
		
		for(Queue<String> w : list) {
			if(!w.isEmpty()) {
				System.out.println("Impossible");
				return;
			}
		}
		System.out.println("Possible");
	}

}
