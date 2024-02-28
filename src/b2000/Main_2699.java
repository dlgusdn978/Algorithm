package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2699 {

	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int n;
	static List<Node> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int tc = Integer.parseInt(br.readLine());
		
		//for문 입력할 곳.
		for(int i=0; i<tc; i++) {
		// 격자점의 수 n
		n = Integer.parseInt(br.readLine());
	
		// 초기 좌표
		int rootX = Integer.MIN_VALUE;
		int rootY = Integer.MIN_VALUE;
		
		list = new ArrayList<>();
		int count = 0;
		while(true) {
			if(count>=n) break;
			if(count%5==0) st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(rootY<y) {
				rootX = x;
				rootY = y;
			}else if(rootY==y) {
				if(x<rootX) {
					rootX = x;
					rootY = y;
				}
			}
			
			list.add(new Node(x, y));
			count++;
		}
		
//		for(Node node : list) {
//			System.out.println(node.x+" "+node.y);
//		}
		Node root = new Node(rootX, rootY);
		find(root);
		}
	}

	static void find(Node root) {
//		System.out.println(root.x+" "+root.y);

		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				int res = ccw(root, o1, o2);
				
				if(res>0) return -1;
				else if(res<0) return 1;
				else {
					int dist1 = dist(root, o1);
					int dist2 = dist(root, o2);
					
					if(dist1>dist2) return 1;
					
				};
				return -1;
			}
		});
		
//		System.out.println();
//		for(Node node : list) {
//			System.out.println(node.x+" "+node.y);
//		}
		
		Stack<Node> s = new Stack<Node>();

		s.push(root);
		for(int i=0; i<n; i++) {
			if(list.get(i).x==root.x && list.get(i).y==root.y) continue;
//			System.out.println(list.get(i).x+" "+list.get(i).y+"?");
			while(s.size()>1) {
				Node end = s.pop();
				Node start = s.peek();
				
				int res = ccw(start, end, list.get(i));
				
				if(res>0) {
					s.push(end);
					break;
				}
			}
			s.push(list.get(i));
		}
		System.out.println(s.size());
		for(Node node : s) {
			System.out.println(node.x+" "+node.y);
		}

		
	}
	static int ccw(Node start, Node end, Node next) {
		// start와 end, end와 next의 벡터를 구하고,
		Node v1 = new Node(end.x-start.x, end.y-start.y);
		Node v2 = new Node(next.x-end.x, next.y-end.y);
		
		// ad-bc;
		int res = (v1.x*v2.y)-(v1.y*v2.x);
		// 양수일 때 반시계
		if(res>0) return -1;
		else if(res<0) return 1;
		else return 0;
	}
	static int dist(Node start, Node end) {
		return (end.x-start.x)*(end.x-start.x)+(end.y-start.y)*(end.y-start.y);
	}
}
