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
	// 감시 방향과 현재 위치를 나타내는 정보.
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
		
		// 행
		n = Integer.parseInt(st.nextToken());
		// 열
		m = Integer.parseInt(st.nextToken());
		// cctv 위치 리스트
		list = new ArrayList<>();
		areaList = new ArrayList<>();
		arr = new int[n][m];
		clone = new boolean[n][m];
		// 배열 입력
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				int temp = Integer.parseInt(st.nextToken());
				arr[i][j] = temp;
				// cctv 위치와 감시방향 정보.
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
		
		
		// 풀이 순서
		// 1. cctv list 에 있는 모든 원소를 조합 및 4방향 탐색
		// 2. 각 원소의 방향 정보를 새로운 list 에 담고, list의 크기 = cctv 의 갯수 성립할 때 방향 탐색
		// 2-1. 6을 만났을 때 return
		// 3.  0의 개수가 가장 적은 경우의 수를 기록.
		// 4. 과정 반복.
	
		System.out.println(min);
	}

	static void dfs(int index, int count) {
		if(count==cctvNum) {
			// 모든 cctv 의 감시 방향이 정해졌으므로
			// 방문체크 수행하면서 사각지대 확인.
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
			// cctv의 번호와 방향에따라 각각 다른 처리 해주기
			Area cur = areaList.get(i);
			// cctv 번호
			int num = cur.num;
			// cctv 감시 방향
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
		// 2개 방향으로 탐색
		// 0, 2
		// 1, 3
		// dir, dir+2;
		visit[r][c] = true;
		// cctv 좌우 or 상하탐색
		if(dir%2==0) {
			//좌우 탐색
			// 좌측 탐색
			for(int i=c; i>=0; i--) {
				if(arr[r][i]==6) {
					break;
				}else {
					visit[r][i] = true;
				}
			}
			// 우측 탐색
			for(int i=c; i<m; i++) {
				if(arr[r][i]==6) break;
				else visit[r][i] = true;
			}
		}else {
			// 상하 탐색
			// 상 탐색
			for(int i=r; i>=0; i--) {
				if(arr[i][c]==6) {
					break;
				}else {
					visit[i][c] = true;
				}
			}
			// 하 탐색
			for(int i=r; i<n; i++) {
				if(arr[i][c]==6) break;
				else visit[i][c] = true;
			}
		}
	}
	
	static void CCTV3(int r, int c, int dir) {
		visit[r][c] = true;
		if(dir%4==0) {
			// 우 하
			for(int i=c; i<m; i++) {
				if(arr[r][i]==6) break;
				else visit[r][i] = true;
			}
			for(int i=r; i<n; i++) {
				if(arr[i][c] ==6) break;
				else visit[i][c] = true;
			}
		}else if(dir%4==1) {
			// 하 좌
			for(int i=r; i<n; i++) {
				if(arr[i][c]==6) break;
				else visit[i][c] = true;
			}
			for(int i=c; i>=0; i--) {
				if(arr[r][i]==6) break;
				else visit[r][i]  =true;
			}
			
		}else if(dir%4==2) {
			// 좌 상
			for(int i=c; i>=0; i--) {
				if(arr[r][i]==6) break;
				else visit[r][i] = true;
			}
			for(int i=r; i>=0; i--) {
				if(arr[i][c]==6) break;
				else visit[i][c] = true;
			}
		}else {
			// 상 우
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
			// 우 하 좌
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
			// 하 좌 상
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
			// 좌 상 우
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
			// 상 우 하
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
		// 상 우 하 좌
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
