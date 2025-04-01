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
		// 1. ��ü ���忡�� �� �޹������� �ܾ ������� ���������� Ȯ���ϸ� �Ǵ� �� x
		// 2. ���ð��� ��������..
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
