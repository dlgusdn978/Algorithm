package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1946 {


	static class Node implements Comparable<Node>{
		int r;
		int in;
		public Node(int r, int in) {
			super();
			this.r = r;
			this.in = in;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.r-o.r;
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		for(int c=0; c<n; c++){
			int m = Integer.parseInt(br.readLine());
			
			int count = 1;
			
			ArrayList<Node> list = new ArrayList<>();
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int in = Integer.parseInt(st.nextToken());
				list.add(new Node(r, in));
			}
			
			Collections.sort(list);
			
			int min = list.get(0).in;
			for(int i=1; i<m; i++) {
				if(list.get(i).in<min) {
					count++;
					min = list.get(i).in;
				}
			}
			System.out.println(count);
		}
		
	}

}
