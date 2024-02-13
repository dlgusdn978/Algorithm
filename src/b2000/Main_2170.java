package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2170 {

	static class Node{
		int start;
		int end;
		public Node(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());

		List<Node> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new Node(start, end));
			
			
		}
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.start-o2.start;
			}
		});
//		for(Node a : list) {
//			System.out.println(a.start+" "+a.end);
//		}
		int start = 0;
		int end = 0;
		int sum = 0;
		//start end 값 가지고
		// 반복문 돌려서
		// 다음 원소의 start가 이전 원소의 end 값보다 작다면
		// 다음 원소의 start 를 이전 원소의 end로 갱신하고, 그 차이 값을 더함.
		for(int i=0; i<n; i++) {
			Node cur = list.get(i);
//			System.out.println(sum);
			if(i==0) {
				start = cur.start;
				end = cur.end;
				sum += end-start;
			}else {
				if(cur.start>end) {
					start = cur.start;
					end = cur.end;
					sum += end-start;
				}else if(cur.start<=end && cur.end>end) {
					sum += cur.end-end;
					end = cur.end;
				}else {
					continue;
				}
			}
		}
		System.out.println(sum);
	}

}
