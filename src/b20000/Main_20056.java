package b20000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_20056 {

	static int n, m, k;
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	static ArrayList<Fire>[][] arr;
	static ArrayList<Fire> list;
	static class Fire{
		int r;
		int c;
		int mass;
		int speed;
		int dist;
		public Fire(int r, int c, int mass, int speed, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.mass = mass;
			this.speed = speed;
			this.dist = dist;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// nxn 행렬
		n = Integer.parseInt(st.nextToken());
		// m 파이어볼 개수
		m = Integer.parseInt(st.nextToken());
		// k 이동 횟수
		k = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[n+1][n+1];
		
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=n; j++) {
				arr[i][j] = new ArrayList<Fire>();
			}
		}
		list = new ArrayList<Fire>();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			arr[r][c].add(new Fire(r, c, m, s, d));
			list.add(new Fire(r, c, m, s, d));
		}
		
		for(int l=0; l<k; l++) {
			move();
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(arr[i][j].size()>=2) {

						merge(i, j);
					}
				}
			}
			initList();
		}
		int count = 0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(arr[i][j].size()>0) {
					for(Fire fire : arr[i][j]) {

						count+=fire.mass;
					}
				}
			}
		}
		System.out.println(count);
	}

	
	static void move() {
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				arr[i][j] = new ArrayList<Fire>();
			}
		}
		
		for(Fire fire : list) {
			fire.r = fire.r+dr[fire.dist]*(fire.speed%n);
			fire.c = fire.c+dc[fire.dist]*(fire.speed%n);
			
			if(fire.r>n) fire.r %=n;
			if(fire.r<=0) fire.r = n-Math.abs(fire.r);
			if(fire.c>n) fire.c %= n;
			if(fire.c<=0) fire.c = n-Math.abs(fire.c);
			
			arr[fire.r][fire.c].add(fire);
		}
		
		
	}
	
	static void merge(int r, int c) {
		int totalMass =0;
		int totalSpeed = 0;
		int totalCount = 0;
		int totalDist = 0;
		boolean odd = true;
		boolean even = true;
		for(Fire fires : arr[r][c]) {
			totalMass+= fires.mass;
			totalSpeed += fires.speed;
			totalCount++;
			if(fires.dist %2 == 0) {
				odd = false;
			}else {
				even = false;
			}
		}
		arr[r][c] = new ArrayList<>();
		if(totalMass/5<=0) return;
		
		if(odd||even) {
			for(int i=0; i<4; i++) {
				arr[r][c].add(new Fire(r, c, totalMass/5, totalSpeed/totalCount, 2*i));
			}
		}else {
			for(int i=0; i<4; i++) {
				arr[r][c].add(new Fire(r, c, totalMass/5, totalSpeed/totalCount, 2*i+1));
			}
		}
	}
	static void initList() {
		list = new ArrayList<>();
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(arr[i][j].size()>0) {
					for(Fire fire : arr[i][j]) {
						list.add(fire);
					}
				}
			}
		}
	}
}
