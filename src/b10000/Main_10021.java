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
		// �ּ� ����� C�� �����鼭, ��� ���� �����ϴµ� �ּ� ����� ��� �϶�.
		// ��Ŭ���� �Ÿ� ���� ���.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// ���� ���� n
		n = Integer.parseInt(st.nextToken());
		// �ּ� ��� c
		c = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Node(i, x, y));
		}
		
		// list ��ȸ�ϸ鼭 �� �� ���� �Ÿ��� ��Ŭ���� ������ ����Ͽ� ���� �� �� list�� ����.
		dist = new ArrayList<>();
		// Node���� num�� �Ÿ���, x�� from , y�� to��.
		for(int i=0; i<list.size()-1; i++) {
			for(int j=i+1; j<list.size(); j++) {
				Node cur = list.get(i);
				Node next = list.get(j);
				int distance = (int) (Math.pow(next.x-cur.x, 2) + Math.pow(next.y-cur.y, 2));
				if(distance<c) continue;
				dist.add(new Node(distance, i+1, j+1));
			}
		}
		
		// ����
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
		
		// �ּ� ���д� Ʈ���� Ȱ���Ͽ� �ּ� �� ( c �̻� ���� ����) ���ϱ�.
		int count = 0;
		long total = 0;
		// while �� �����鼭 ������ ���� ������ n-1 ���� �� ������ end�� ������ �ø�
		// n-1 �� �� �� c�� �������� �ʴ´ٸ� start�� end ��� ������ �ø�.
		
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
