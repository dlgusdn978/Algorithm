package b11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11812 {

	static long n;
	static int  k, q;
	static int[] depths;
	static int[] parents;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// n개의 노드로 이루어진
		n = Long.parseLong(st.nextToken());
		// k진 트리를 구성할 것.
		k = Integer.parseInt(st.nextToken());
		// q 쌍의 개수
		q = Integer.parseInt(st.nextToken());
//		
//		depths = new int[n+1];
//		parents = new int[n+1];
		sb = new StringBuilder();
//		makeTree(1, 1, 0);
		for(int i=0; i<q; i++) {
			st = new StringTokenizer(br.readLine());
			long firstNode = Long.parseLong(st.nextToken());
			long secondNode = Long.parseLong(st.nextToken());
			
			if(k==1) {
				sb.append(Math.abs(firstNode-secondNode)+"\n");
				continue;
			}
			long cnt = 0;
			
			while(firstNode!=secondNode) {
				long max = Math.max(firstNode, secondNode);
				secondNode = Math.min(firstNode, secondNode);
				firstNode = (max-2)/k+1;
				cnt++;
			}
			sb.append(cnt+"\n");
//			getDistance(firstNode, secondNode);
		}
		System.out.println(sb.toString());
		
	}

//	static void makeTree(long cur, int depth, long parent) {
//		depths[cur] = depth;
//		parents[cur] = parent;
//		
//		for(int i=0; i<k; i++) {
//			int next=k*cur+1-i;
//			if(next<=n) makeTree(next, depth+1, cur);
//		}
//	}
//	static void getDistance(long first, long second) {
//		int firstDepth = depths[first];
//		int secondDepth = depths[second];
//		int distance = 0;
//		while(firstDepth<secondDepth) {
//			second = parents[second];
//			secondDepth--;
//			distance++;
//		}
//		while(firstDepth>secondDepth) {
//			first = parents[first];
//			firstDepth--;
//			distance++;
//		}
//		while(first!=second) {
//			first = parents[first];
//			second = parents[second];
//			distance++;
//			distance++;
//		}
//		sb.append(distance).append("\n");
//	}
}
