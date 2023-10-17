package b3000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_3584 {

	static List<Integer>[] nodeList;
	static boolean[] haveParent;
	static int[] parents, depth;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// 1~n 까지의 배열 생성
		// true 체크. 있으면 그게 루트 노드
		
		// 타고타고 들어가. 일치하는 수 찾아
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; t++) {
			int num = Integer.parseInt(br.readLine());
			
			parents = new int[num+1];
			depth = new int[num+1];
			nodeList = new ArrayList[num+1];
			haveParent = new boolean[num+1];
			for(int i=1; i<=num; i++) {
				nodeList[i] = new ArrayList<>();
			}
			for(int i=0; i<num-1; i++) {
				st = new StringTokenizer(br.readLine());
				
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				
				nodeList[parent].add(child);
				haveParent[child] = true;
			}
			
			int rootNode = 0;
			// 부모 노드 찾기.
			for(int i=1; i<=num; i++){
				if(!haveParent[i]) {
					rootNode = i;
					break;
				}
			}
			
			makeTree(rootNode, 1, 0);
			
			st = new StringTokenizer(br.readLine());
			
			int firstNode = Integer.parseInt(st.nextToken());
			int secondNode = Integer.parseInt(st.nextToken());
			
			lca(firstNode, secondNode);
		}
	}
	static void makeTree(int cur, int height, int parent) {
		depth[cur] = height;
		parents[cur] = parent;
		for(int next : nodeList[cur]) {
			if(next != parent) {
				makeTree(next, height+1, cur);
			}
		}
	}
	static void lca(int first, int second) {
		int firstHeight = depth[first];
		int secondHeight = depth[second];
		
		while(firstHeight>secondHeight) {
			first = parents[first];
			firstHeight--;
		}
		while(firstHeight<secondHeight) {
			second = parents[second];
			secondHeight--;
		}
		while(first!=second) {
			first = parents[first];
			second = parents[second];
		}
		System.out.println(first);
	}
}
