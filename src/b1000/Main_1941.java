package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main_1941 {

	static char[][] arr;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static boolean[][] visit;
	static List<int[]> startPoint;
//	static int total;
	static Set<String> set;
	public static void main(String[] args) throws IOException {
		// dfs �ε� �湮�ߴ� ������ �ٽ� �湮�ص� �Ǵ� ����
		// visit üũ �� ���� ��ġ ���� true��� count�� ������ �ʾƵ� ��.
		// count�� 7 �̻� �ߺ� �湮 ���� 25 �̻��̶�� ������
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ���̵�� : �밢�� �̵�? bfs
		
		// ���� s ��ǥ�� �������� ������ ��� Ǯ dfs ������
		startPoint = new ArrayList<int[]>();
		arr = new char[5][5];
		visit = new boolean[5][5];
		set = new HashSet<String>();
		for(int i=0; i<5; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j=0; j<temp.length; j++) {
				if(temp[j]=='S') {
					int[] s = {i, j};
					startPoint.add(s);
				}
			}
			arr[i] = temp;
		}
		
		// start ����Ʈ���� dfs
		// dfs ���� ��ǥ Ž�� �� for(i �� ���� 4�̻��̸� ��� ��ġ ���� ���Ž��)
		
		for(int i=0; i<startPoint.size(); i++) {
			int[] temp = startPoint.get(i);
			visit[temp[0]][temp[1]] = true;
			dfs(temp[0], temp[1], 1, 0, 0);
			visit[temp[0]][temp[1]] = false;
		}
		System.out.println(set.size());
	}

	static void dfs(int r, int c, int s, int y, int dubVisit) {
		if(s+y==7) {
			if(s>y) {
				addSet();
//				for(boolean[] a : visit) {
//					for(boolean b : a) {
//						System.out.print(b+" ");
//					}
//					System.out.println();
//				}
//				System.out.println();
//				total++;
			}
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			// 4�̻� if��
			if(nr>=0 && nr<5 && nc>=0 && nc<5) {
				if(!visit[nr][nc]) {
					visit[nr][nc] = true;
					dfs(nr, nc, arr[nr][nc]=='S' ? s+1 : s, arr[nr][nc]=='S' ? y : y+1, dubVisit);
					visit[nr][nc] = false;
				}else {
					if(s+y>dubVisit) {
						dfs(nr, nc, s, y, dubVisit+1);
					}
				}
				
				
			}
		}
	}

	static void addSet() {
		String str = "";
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(visit[i][j]) {
					str+=i;
					str+=j;
				}
			}
		}
		set.add(str);
	}
}
