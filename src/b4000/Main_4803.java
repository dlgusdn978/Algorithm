package b4000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4803 {

	static int trees;
	static List<Integer>[] list;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int count = 1;
		while(true) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			if(n==0 && m==0) break;
			
			trees = 0;
			
			list = new ArrayList[n+1];
			for(int i=1; i<=n; i++){
				list[i] = new ArrayList<Integer>();
			}
			
			visited = new boolean[n+1];
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
//				System.out.println(start+" "+end);
				list[start].add(end);
				list[end].add(start);
			}
			
			for(int i=1; i<=n; i++) {
				if(!visited[i]) {
					if(bfs(i)) {
						trees++;
					}
				}
			}
			
			if(trees>1) {
				System.out.println("Case "+count+": A forest of "+trees+" trees.");
			}else if(trees==1) {
				System.out.println("Case "+count+": There is one tree.");
			}else {
				System.out.println("Case "+count+": No trees.");
			}
			count++;
		}
		
		// �� ���� ���� �湮 üũ�� �ʿ���.
		
	}

	static boolean bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		Map<Integer, Integer> parent = new HashMap<Integer,Integer>();
		q.add(start);
		parent.put(start, -1);
		visited[start] = true;
//		System.out.println(start);
		// bfs Ž�� �����鼭 �ڽ� ��� Ž��.
		// �ڽ� ����� ������ 0�̶�� ����.
		// Ž�� �� �ϳ��� visited[i] = true ��� tree �� �ƴ�.
		// ��� �ڽ� ��� �� �ϳ��� 
		boolean checker = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next:list[cur]) {
				if(!visited[next]) {
					visited[next] = true;
					q.add(next);
					parent.put(next, cur);
				}else if(parent.get(cur)!=null && next != parent.get(cur)) {
					return false;
				}
			}
	
		}
		return true;
	}
}
