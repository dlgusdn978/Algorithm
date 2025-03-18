package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2564 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// 블록 위치 구하기
		// 블록 간 최소 거리 구하기.
		// 사각형을 하나의 직선으로 펴서, 1차원 좌표상에 나타내기.
		// 북쪽 좌표 -> 왼쪽 경계로부터 거리. 1번
		// 동쪽 좌표 -> 가로 길이 + 위쪽 경계로부터 거리. 4번
		// 남쪽 좌표 -> 가로 길이 + 세로 길이 + (가로길이 - 왼쪽 경계로부터 거리). 2번
		// 서쪽 좌표 -> 가로길이 * 2 + 세로 길이 + (세로 길이 - 위쪽 경계로부터 거리). 3번
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		// 일직선의 길이 2*r+2*c;
		int[] arr = new int[2*r+2*c];
		
		// 상점의 개수 n
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			arr[getCor(dir, dist, r, c)] = i+1;
		}
		st = new StringTokenizer(br.readLine());
		// 현재 위치
		int curDir = Integer.parseInt(st.nextToken());
		int curDist = Integer.parseInt(st.nextToken());
		int curCor = getCor(curDir, curDist, r, c);
		
		int resDist = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==0) continue;
			// 정방향 거리 비교
			int dist1 = Math.abs(curCor-i);
			// 역방향 거리 비교
			int min = Math.min(curCor, i);
			int max = Math.max(curCor, i);
			int dist2 = Math.abs(arr.length-max+min);
			
			resDist += Math.min(dist1, dist2);
		}
		System.out.println(resDist);
	}

	
	static int getCor(int dir, int dist, int r, int c) {
		int cor = 0;
		if(dir==1) {
			cor = dist;
		}else if(dir==2) {
			cor = r + c + (r - dist);
		}else if(dir==3) {
			cor = (r*2) + c + (c - dist);
		}else {
			cor = r + dist;
		}
		return cor;
	}
}
