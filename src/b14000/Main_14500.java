package b14000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_14500 {

	static class Node{
		int x1, y1,  x2, y2,  x3, y3,  x4, y4;
		public Node(int x1, int y1, int x2, int y2 ,int x3, int y3 ,int x4, int y4) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
			this.x3 = x3;
			this.y3 = y3;
			this.x4 = x4;
			this.y4 = y4;
		}
	}
	static List<Node> list;
	public static void main(String[] args) throws IOException {
		// 미리 대칭 혹은 회전 모양을 만들어 둬야 하나?
		// 가장 왼쪽 위에 있는 원소를 (0, 0) 에 두고
		// 나머지 원소들을 상대적인 위치에 배치.
		// 배열 탐색 시 나머지 모든 원소들까지 순회하며 배열의 내부에 있는 값인 것이 확인된다면 모든 원소 값 더하기.
		// 이후 max 값 비교
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		list = new ArrayList<>();
		addFirstType(list);
		addSecondType(list);
		addThirdType(list);
		addFourthType(list);
		addFifthType(list);
		// 일자형
		int max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {

				for(int k=0; k<list.size(); k++) {
					Node cur = list.get(k);
					int sum = 0;
					if(checker(cur, arr, i, j)) {
						sum += arr[cur.x1+i][cur.y1+j];
						sum += arr[cur.x2+i][cur.y2+j];
						sum += arr[cur.x3+i][cur.y3+j];
						sum += arr[cur.x4+i][cur.y4+j];

						max = Math.max(max, sum);
					}
				}
			}
		}
		System.out.println(max);
	}
	public static boolean checker(Node cur, int[][] arr, int i, int j) {
		boolean flag = false;
		if(cur.x1+i>=0 && cur.x1+i<arr.length && cur.y1+j>=0 && cur.y1+j<arr[0].length && cur.x2+i>=0 && cur.x2+i<arr.length && cur.y2+j>=0 && cur.y2+j<arr[0].length &&
				cur.x3+i>=0 && cur.x3+i<arr.length && cur.y3+j>=0 && cur.y3+j<arr[0].length && cur.x4+i>=0 && cur.x4+i<arr.length && cur.y4+j>=0 && cur.y4+j<arr[0].length) {
			flag = true;
		}
		return flag;
	}
	//일자형
	public static void addFirstType(List<Node> list) {
		//가로 
		list.add(new Node(0, 0, 0, 1, 0, 2, 0, 3));
		//세로
		list.add(new Node(0, 0, 1, 0, 2, 0, 3, 0));
	}
	//사각형
	public static void addSecondType(List<Node> list) {
		list.add(new Node(0, 0, 0, 1, 1, 0, 1, 1));
	}
	//ㄴ자형
	public static void addThirdType(List<Node> list) {
		// 회전
		list.add(new Node(0, 0, 1, 0, 2, 0, 2, 1));
		list.add(new Node(0, 0, 0, 1, 0, 2, 1, 0));
		list.add(new Node(0, 0, 0, 1, 1, 1, 2, 1));
		list.add(new Node(0, 0, 0, 1, 0, 2, -1, 2));
		// 대칭
		list.add(new Node(0, 0, 0, 1, -1, 1, -2, 1));
		list.add(new Node(0, 0, 1, 0, 1, 1, 1, 2));
		list.add(new Node(0, 0, 0, 1, 1, 0, 2, 0));
		list.add(new Node(0, 0, 0, 1, 0, 2, 1, 2));
	}
	public static void addFourthType(List<Node> list) {
		// 회전
		list.add(new Node(0, 0, 1, 0, 1, 1, 2, 1));
		list.add(new Node(0, 0, 0, 1, -1, 1, -1, 2));
		// 대칭
		list.add(new Node(0, 0, 0, 1, -1, 1, 1, 0));
		list.add(new Node(0, 0, 0, 1, 1, 1, 1, 2));
	}
	public static void addFifthType(List<Node> list) {
		// 회전
		list.add(new Node(0, 0, 0, 1, 0, 2, 1, 1));
		list.add(new Node(0, 0, 0, 1, -1, 1, 1, 1));
		list.add(new Node(0, 0, 1, 0, 1, -1, 1, 1));
		list.add(new Node(0, 0, 1, 0, 1, 1, 2, 0));
	}
}
