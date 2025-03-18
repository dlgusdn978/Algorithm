package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2564 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// ��� ��ġ ���ϱ�
		// ��� �� �ּ� �Ÿ� ���ϱ�.
		// �簢���� �ϳ��� �������� �켭, 1���� ��ǥ�� ��Ÿ����.
		// ���� ��ǥ -> ���� ���κ��� �Ÿ�. 1��
		// ���� ��ǥ -> ���� ���� + ���� ���κ��� �Ÿ�. 4��
		// ���� ��ǥ -> ���� ���� + ���� ���� + (���α��� - ���� ���κ��� �Ÿ�). 2��
		// ���� ��ǥ -> ���α��� * 2 + ���� ���� + (���� ���� - ���� ���κ��� �Ÿ�). 3��
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		// �������� ���� 2*r+2*c;
		int[] arr = new int[2*r+2*c];
		
		// ������ ���� n
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			arr[getCor(dir, dist, r, c)] = i+1;
		}
		st = new StringTokenizer(br.readLine());
		// ���� ��ġ
		int curDir = Integer.parseInt(st.nextToken());
		int curDist = Integer.parseInt(st.nextToken());
		int curCor = getCor(curDir, curDist, r, c);
		
		int resDist = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==0) continue;
			// ������ �Ÿ� ��
			int dist1 = Math.abs(curCor-i);
			// ������ �Ÿ� ��
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
