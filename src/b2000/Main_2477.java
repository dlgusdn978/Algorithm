package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2477 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		// 1,2 ³¢¸®, 3,4³¢¸®
		Queue<Integer> q = new ArrayDeque<>();
		int rMax = 0;
		int cMax = 0;
		
		for(int i=0; i<6; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			if(dir==1 || dir==2) {
				rMax = Math.max(rMax, dist);
			}else {
				cMax = Math.max(cMax, dist);
			}
			q.add(dist);
		}
		int res = 0;
		while(true) {
			int cur = q.poll();
			if((cur==rMax && q.peek()==cMax)||(cur==cMax && q.peek()==rMax)) {
				int next = q.poll();
				int total = cur*next;
				q.poll();
				int minR = q.poll();
				int minC = q.poll();
				int minTotal = minR*minC;
				res = total-minTotal;
				break;
			}else q.add(cur);
		}
		System.out.println(res*n);
	}

}
