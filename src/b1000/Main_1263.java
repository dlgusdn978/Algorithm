package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1263 {

	static class Node{
		int duration;
		int end;
		public Node(int duration, int end) {
			this.duration = duration;
			this.end = end;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		List<Node> list = new ArrayList<>();
		
		int max = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int duration = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			max = Math.max(max, end);
			list.add(new Node(duration,end));
		}
		
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.end==o2.end ? o2.duration-o1.duration : o1.end-o2.end;
			}
		});
		int[] arr = new int[max+1];
		boolean flag = true;
		for(int i=0; i<list.size(); i++) {
			Node cur = list.get(i);

			int index = cur.end-1;
			int time = cur.duration;
			while(index>=0) {
				if(arr[index]==0) {
					arr[index]++;
					time--;
				}
				if(time==0) break;
				
				index--;
			}
			if(time>0) flag = false;
		}
		if(!flag) System.out.println(-1);
		else {
			int index = 0;
			for(int i=0; i<arr.length; i++) {
				if(arr[i]==1) {
					index = i;
					break;
				}
			}
			System.out.println(index);
		}
//		System.out.println(Arrays.toString(arr));

	}

}
