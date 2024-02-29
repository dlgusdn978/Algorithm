package b10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_10021 {

	static int n, c;
	static class Node{
		int num;
		int x;
		int y;
		public Node(int num, int x, int y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}
	static int[] parents;
	static List<Node> list, dist;
	public static void main(String[] args) throws IOException {
		// 최소 비용이 C를 넘으면서, 모든 밭을 연결하는데 최소 비용이 들게 하라.
		// 유클리드 거리 공식 사용.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 밭의 개수 n
		n = Integer.parseInt(st.nextToken());
		// 최소 비용 c
		c = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Node(i, x, y));
		}
		
		// list 순회하면서 각 밭 같의 거리를 유클리드 공식을 사용하여 연산 후 새 list에 넣음.
		dist = new ArrayList<>();
		// Node에서 num을 거리로, x는 from , y는 to로.
		for(int i=0; i<list.size()-1; i++) {
			for(int j=i+1; j<list.size(); j++) {
				Node cur = list.get(i);
				Node next = list.get(j);
				int distance = (int) (Math.pow(next.x-cur.x, 2) + Math.pow(next.y-cur.y, 2));
				if(distance<c) continue;
				dist.add(new Node(distance, i+1, j+1));
			}
		}
		
		// 정렬
		Collections.sort(dist, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.num-o2.num;
			}
		});
//		for(Node node : dist) {
//			System.out.println(node.x+" "+node.y+" "+node.num);
//		}
		
		makeSet();
		
		// 최소 스패닝 트리를 활용하여 최소 값 ( c 이상 조건 만족) 구하기.
		int count = 0;
		long total = 0;
		// while 문 돌리면서 선택한 밭의 개수를 n-1 개가 될 때까지 end의 범위를 늘림
		// n-1 개 일 때 c를 만족하지 않는다면 start와 end 모두 범위를 늘림.
		
		for(Node node : dist) {
			if(union(node.x, node.y)) {
				total+=node.num;
				if(++count==n-1) break;
			}
		}
		for(int i=count; i<dist.size(); i++) {
			if(total>=c) break;
			total+=dist.get(i).num;
		}
		System.out.println(total>=c && count==n-1 ? total : -1);
	}
	
	static void makeSet() {
		parents = new int[n+1];
		for(int i=1; i<=n; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int v1) {
		if(v1==parents[v1]) return v1;
		else return parents[v1] = findSet(parents[v1]);
	}
	
	static boolean union(int v1, int v2) {
		int aRoot = findSet(v1);
		int bRoot = findSet(v2);
		if(aRoot==bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
}
