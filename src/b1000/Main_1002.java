package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1002 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; t++) {
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			// �� �߽ɰ��� �Ÿ��� �� �� �������� ũ�� �� ��
			// �߽ɰ��� �Ÿ� > ������ �� => 0
			// �߽ɰ��� �Ÿ� = ������ �� => 1
			// �߽ɰ��� �Ÿ� < ������ �� => 2
			
			// �߽ɰ��� �Ÿ�
			double distance = Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
//			System.out.println(distance);
			if(x1==x2 && y1==y2) {
				if(distance == Math.abs(r1-r2)) {
					System.out.println(-1);
				}else {
					System.out.println(0);
				}
	 		}else {
				if(distance>Math.abs(r1-r2) && distance<r1+r2) System.out.println(2);
				else if(distance==Math.abs(r1-r2) || r1+r2==distance) System.out.println(1);
				else System.out.println(0);
			}

		}

	}

}
