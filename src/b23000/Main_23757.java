package b23000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_23757 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> present = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			present.add(Integer.parseInt(st.nextToken()));
		}
		
		Queue<Integer> child = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<m; i++) {
			child.add(Integer.parseInt(st.nextToken()));
		}
		
		while(!child.isEmpty()) {
			int curChild = child.poll();
			int curPresent = present.poll();
//			System.out.println(curChild+" "+curPresent);
			if(curPresent>curChild) {
				present.add(curPresent-curChild);
			}else if(curPresent<curChild) {
				System.out.println(0);
				return;
			}
		}
		System.out.println(1);
	}

}
