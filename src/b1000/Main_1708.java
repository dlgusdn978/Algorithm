package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1708 {

	static class Node{
		long x;
		long y;
		public Node(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
	static List<Node> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());

		// 조건
		// 1. 직선 상에 점이 여러 개 존재할 경우 양 끝 점만 count => 기울기 계산 후 경로 상에 있는 점 제거.
		// 2. ccw 사용해서 반시계방향으로 회전하는 경우만 찾기.
		
		list = new ArrayList<Node>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list.add(new Node(x, y));
		}
		// start 는 list.get(0);
		Node root = list.get(0);
		for(int i=1; i<list.size(); i++) {
			if(list.get(i).y<root.y) {
				root = list.get(i);
			}else if(list.get(i).y==root.y) {
				if(list.get(i).x<root.x) {
					root = list.get(i);
				}
			}
		}
		
		
		find(root);
		
		
	}

	static void find(Node root) {
		Stack<Node> stack = new Stack<>();
		
		Collections.sort(list, new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				int res = CCW(root, o1, o2);
				
				if(res>0) {
					return -1;
				}else if(res<0) {
					return 1;
				}else {
					long dist1 = dist(root, o1);
					long dist2 = dist(root, o2);
					
					if(dist1>dist2) {
						return 1;
					}
				}
				return -1;
			}
		});
		
		stack.push(list.get(0));
		stack.push(list.get(1));
		
		for(int i=2; i<list.size(); i++) {
			Node next = list.get(i);
			while(stack.size()>1) {
				Node second = stack.pop();
				Node first = stack.peek();
				
				if(CCW(first, second, next)>0) {
					stack.push(second);
					break;
				}
			}
			stack.push(next);
		}
		System.out.println(stack.size());
	}
	static int CCW(Node first, Node second, Node next) {
		long val = ((second.x-first.x)*(next.y-second.y) - (second.y-first.y)*(next.x-second.x));
		if(val<0) {
			return -1;
		}else if(val>0) {
			return 1;
		}else {
			return 0;
		}
	}
	static long dist(Node o1, Node o2) {
		return (long)((o2.x-o1.x)*(o2.x-o1.x)+(o2.y-o1.y)*(o2.y-o1.y));
	}
}