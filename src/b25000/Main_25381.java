package b25000;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main_25381 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		Queue<Integer> q1 = new ArrayDeque<>();
		Queue<Integer> q2 = new ArrayDeque<>();
		
		int count = 0;
		
		for(int i=0; i<str.length(); i++) {
			char cur = str.charAt(i);
			if(cur=='A') {
				q1.add(i);
			}else if(cur=='B') {
				q2.add(i);
			}else {
				if(!q2.isEmpty() && q2.peek()<i) {
					q2.poll();
					count++;
				}
			}
		}
		
		Map<String, Integer> map = new HashMap<>();
		map.values();
		while(!q1.isEmpty() && !q2.isEmpty()) {
			if(q1.peek()<q2.peek()) {
				count++;
				q1.poll();
				q2.poll();
			}else {
				q2.poll();
			}
		}
		System.out.println(count);
			
	}

}
