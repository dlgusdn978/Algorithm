package b13000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13335 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		Queue<Integer> move = new ArrayDeque<>();
		
		st = new StringTokenizer(br.readLine());
		int curWeight = 0;
		int time = 0;
		for(int i=0; i<n; i++) {
			
			int curTruck = Integer.parseInt(st.nextToken());
			while(true) {
				if(move.isEmpty()) {
					move.add(curTruck);
					curWeight += curTruck;
					time++;
					break;
				}else if(move.size()==w) {
					curWeight -= move.poll();
				}else {
					if(curWeight+curTruck<=l) {
						move.add(curTruck);
						curWeight +=curTruck;
						time++;
						break;
					}else {
						move.add(0);
						time++;
					}
				}
			}
		}
		
		time += w;
		System.out.println(time);
	}

}
