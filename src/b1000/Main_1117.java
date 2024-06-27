package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1117 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// �ʺ�
		long w = Long.parseLong(st.nextToken());
		// ����
		long h = Long.parseLong(st.nextToken());
		// ���� ��ġ
		long f = Long.parseLong(st.nextToken());
		// ���� ���� Ƚ��
		long c = Long.parseLong(st.nextToken());

		// ��ǥ��
		long x1 = Long.parseLong(st.nextToken());
		long y1 = Long.parseLong(st.nextToken());
		long x2 = Long.parseLong(st.nextToken());
		long y2 = Long.parseLong(st.nextToken());

		// f ���� r/2���� ũ�ٸ� f=r-f
		if(f>w/2) f= w-f;
		// �� ��ǥ�� 1 ä��.
//		int[][] arr = new int[h][w];
//		for(int i=0; i<h; i++) {
//			Arrays.fill(arr[i], 1);
//		}
		// (1,1) ~ (2,3)
		long area = w*h;
		long colored = 0;

		if(f<=x1) {
			colored = (x2-x1)*(y2-y1)*(c+1);
		}else if(f<x2) {
			colored = (y2-y1)*(c+1)*( (f-x1)*2+(x2-f) );
		}else {
			colored = (x2-x1)*(y2-y1)*(c+1)*2;
		}
		System.out.println(area-colored);

	}

	
}
