package b15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15683 {

	static int n, m, cctvNum;
	static int[][] arr;
	static boolean[][] visit;
	static boolean[][] clone;
	static List<CCTV> list;
	static List<Area> areaList;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1 ,0};
	static int min = Integer.MAX_VALUE;
	static class CCTV{
		int r;
		int c;
		int num;
		public CCTV(int r, int c, int num) {
			this.r = r;
			this.c = c;
			this.num = num;
		}
	}
	// ���� ����� ���� ��ġ�� ��Ÿ���� ����.
	static class Area{
		int r;
		int c;
		int num;
		int dir;
		public Area(int r, int c, int num, int dir) {
			this.r = r;
			this.c = c;
			this.num = num;
			this.dir = dir;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// ��
		n = Integer.parseInt(st.nextToken());
		// ��
		m = Integer.parseInt(st.nextToken());
		// cctv ��ġ ����Ʈ
		list = new ArrayList<>();
		areaList = new ArrayList<>();
		arr = new int[n][m];
		clone = new boolean[n][m];
		// �迭 �Է�
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				int temp = Integer.parseInt(st.nextToken());
				arr[i][j] = temp;
				// cctv ��ġ�� ���ù��� ����.
				if(temp!=0 && temp!=6) {
					if(temp==5) {
						continue;
					}
					list.add(new CCTV(i, j, temp));
					cctvNum++;
					
				}
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j]==5) {
					CCTV5(i, j, 0);
				}
			}
		}

		dfs(0, 0);
		
		
		// Ǯ�� ����
		// 1. cctv list �� �ִ� ��� ���Ҹ� ���� �� 4���� Ž��
		// 2. �� ������ ���� ������ ���ο� list �� ���, list�� ũ�� = cctv �� ���� ������ �� ���� Ž��
		// 2-1. 6�� ������ �� return
		// 3.  0�� ������ ���� ���� ����� ���� ���.
		// 4. ���� �ݺ�.
	
		System.out.println(min);
	}

	static void dfs(int index, int count) {
		if(count==cctvNum) {
			// ��� cctv �� ���� ������ ���������Ƿ�
			// �湮üũ �����ϸ鼭 �簢���� Ȯ��.
			checkArea();
			return;
		}

		for(int j=0; j<4; j++) {
			areaList.add(new Area(list.get(index).r, list.get(index).c, list.get(index).num, j));
			dfs(index+1, count+1);
			areaList.remove(areaList.size()-1);
		}
		
	}
	
	static void checkArea() {
		visit = new boolean[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				visit[i][j] = clone[i][j];
			}
		}
		for(int i=0; i<areaList.size(); i++) {
			// cctv�� ��ȣ�� ���⿡���� ���� �ٸ� ó�� ���ֱ�
			Area cur = areaList.get(i);
			// cctv ��ȣ
			int num = cur.num;
			// cctv ���� ����
			int dir = cur.dir;
			
			switch(num) {
			case 1:
				CCTV1(cur.r, cur.c, dir);
				break;
			case 2:
				CCTV2(cur.r, cur.c, dir);
				break;
			case 3:
				CCTV3(cur.r, cur.c, dir);
				break;
			case 4:
				CCTV4(cur.r, cur.c, dir);
				break;
			case 5:
				break;
			default:
				break;
			}
		}
		findBlindSpot();
	}
	
	static void CCTV1(int r, int c, int dir) {
		visit[r][c] = true;
		if(dir%4==0) {
			for(int i=c; i<m; i++) {
				if(arr[r][i]==6) break;
				else visit[r][i] = true;
			}
		}else if(dir%4==1) {
			for(int i=r; i<n; i++) {
				if(arr[i][c]==6) break;
				else visit[i][c] = true;
			}
		}else if(dir%4==2) {
			for(int i=c; i>=0; i--) {
				if(arr[r][i]==6) {
					break;
				}else {
					visit[r][i] = true;
				}
			}
		}else {
			for(int i=r; i>=0; i--) {
				if(arr[i][c]==6) {
					break;
				}else {
					visit[i][c] = true;
				}
			}
		}
	}
	static void CCTV2(int r, int c, int dir) {
		// 2�� �������� Ž��
		// 0, 2
		// 1, 3
		// dir, dir+2;
		visit[r][c] = true;
		// cctv �¿� or ����Ž��
		if(dir%2==0) {
			//�¿� Ž��
			// ���� Ž��
			for(int i=c; i>=0; i--) {
				if(arr[r][i]==6) {
					break;
				}else {
					visit[r][i] = true;
				}
			}
			// ���� Ž��
			for(int i=c; i<m; i++) {
				if(arr[r][i]==6) break;
				else visit[r][i] = true;
			}
		}else {
			// ���� Ž��
			// �� Ž��
			for(int i=r; i>=0; i--) {
				if(arr[i][c]==6) {
					break;
				}else {
					visit[i][c] = true;
				}
			}
			// �� Ž��
			for(int i=r; i<n; i++) {
				if(arr[i][c]==6) break;
				else visit[i][c] = true;
			}
		}
	}
	
	static void CCTV3(int r, int c, int dir) {
		visit[r][c] = true;
		if(dir%4==0) {
			// �� ��
			for(int i=c; i<m; i++) {
				if(arr[r][i]==6) break;
				else visit[r][i] = true;
			}
			for(int i=r; i<n; i++) {
				if(arr[i][c] ==6) break;
				else visit[i][c] = true;
			}
		}else if(dir%4==1) {
			// �� ��
			for(int i=r; i<n; i++) {
				if(arr[i][c]==6) break;
				else visit[i][c] = true;
			}
			for(int i=c; i>=0; i--) {
				if(arr[r][i]==6) break;
				else visit[r][i]  =true;
			}
			
		}else if(dir%4==2) {
			// �� ��
			for(int i=c; i>=0; i--) {
				if(arr[r][i]==6) break;
				else visit[r][i] = true;
			}
			for(int i=r; i>=0; i--) {
				if(arr[i][c]==6) break;
				else visit[i][c] = true;
			}
		}else {
			// �� ��
			for(int i=r; i>=0; i--) {
				if(arr[i][c]==6) break;
				else visit[i][c] = true;
			}
			for(int i=c; i<m; i++) {
				if(arr[r][i]==6) break;
				else visit[r][i] = true;
			}
		}
	}
	static void CCTV4(int r, int c, int dir) {
		visit[r][c] = true;
		if(dir%4==0) {
			// �� �� ��
			for(int i=c; i<m; i++) {
				if(arr[r][i]==6) break;
				else visit[r][i] = true;
			}
			for(int i=r; i<n; i++) {
				if(arr[i][c]==6) break;
				else visit[i][c] = true;
			}
			for(int i=c; i>=0; i--) {
				if(arr[r][i]==6) break;
				else visit[r][i]  =true;
			}
		}else if(dir%4==1) {
			// �� �� ��
			for(int i=r; i<n; i++) {
				if(arr[i][c]==6) break;
				else visit[i][c] = true;
			}
			for(int i=c; i>=0; i--) {
				if(arr[r][i]==6) break;
				else visit[r][i]  =true;
			}
			for(int i=r; i>=0; i--) {
				if(arr[i][c]==6) break;
				else visit[i][c] = true;
			}
		}else if(dir%4==2) {
			// �� �� ��
			for(int i=c; i>=0; i--) {
				if(arr[r][i]==6) break;
				else visit[r][i]  =true;
			}
			for(int i=r; i>=0; i--) {
				if(arr[i][c]==6) break;
				else visit[i][c] = true;
			}
			for(int i=c; i<m; i++) {
				if(arr[r][i]==6) break;
				else visit[r][i] = true;
			}
		}else {
			// �� �� ��
			for(int i=r; i>=0; i--) {
				if(arr[i][c]==6) break;
				else visit[i][c] = true;
			}
			for(int i=c; i<m; i++) {
				if(arr[r][i]==6) break;
				else visit[r][i] = true;
			}
			for(int i=r; i<n; i++) {
				if(arr[i][c]==6) break;
				else visit[i][c] = true;
			}
		}
	}
	static void CCTV5(int r, int c, int dir) {
		clone[r][c] = true;
		// �� �� �� ��
		for(int i=r; i>=0; i--) {
			if(arr[i][c]==6) break;
			else clone[i][c] = true;
		}
		for(int i=c; i<m; i++) {
			if(arr[r][i]==6) break;
			else clone[r][i] = true;
		}
		for(int i=r; i<n; i++) {
			if(arr[i][c]==6) break;
			else clone[i][c] = true;
		}
		for(int i=c; i>=0; i--) {
			if(arr[r][i]==6) break;
			else clone[r][i]  =true;
		}
	}
	
	
	
	static void findBlindSpot() {
		int count = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!visit[i][j] && arr[i][j]==0) count++;
			}
		}
		min = Math.min(min, count);
//		if(visit[4][2]) print();
//		for(Area a : areaList) {
//			System.out.print("("+a.r+","+a.c+")"+a.dir+" ");
//		}
//		System.out.println();
//		print();
//		
//		System.out.println();
	}
	static void print() {
		for(boolean[] a : visit) {
			for(boolean b : a) {
				System.out.print(b+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
