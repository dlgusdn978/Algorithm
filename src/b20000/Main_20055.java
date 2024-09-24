package b20000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20055 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] durability = new int[2*n];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<2*n; i++) {
			durability[i] = Integer.parseInt(st.nextToken());
		}
		Queue<Integer> robots = new ArrayDeque<>();
		int phase = 1;
		int count = 0;
		int start = 0;
		int end = n-1;
		while(true) {
			start = start-1>=0 ? start-1 : 2*n-1;
			end = end-1>=0 ? end-1 : 2*n-1;

			while(robots.contains(end)) {
				robots.remove(end);
			}
			move(durability, robots, n, end);
			addRobot(durability, robots, start);
			if(checker(durability, k)) break;
			phase++;
		
		}
		System.out.println(phase);
	}

	static boolean checker(int[] durability, int k) {
		int count = 0;
		for(int a : durability) {
			if(a==0) count++;
		}
//		System.out.println("count : "+count+" k : "+ k);
		if(count>=k) return true;
		return false;
	}
	static void addRobot(int[] durability, Queue<Integer> robots, int start) {
		
		if(durability[start]>0 ) {
			robots.add(start);
			durability[start]--;
		}
	}
	static void move(int[] durability, Queue<Integer> robots, int n, int end) {
		for(int i=0; i<robots.size(); i++) {
			int cur = robots.poll();
			int next = cur+1 > 2*n-1 ? 0 : cur+1;
//			System.out.println(next);
			if(!robots.contains(next) && durability[next]>0) {
				durability[next]--;
				robots.add(next);
			}else robots.add(cur);
		}
		while(robots.contains(end)) {
			robots.remove(end);
		}
		
	}
	
}
