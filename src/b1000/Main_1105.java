package b1000;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_1105 {

	public static void main(String[] args) {
		// �� �ڸ����� �ٸ��� 0��
		// �� �ڸ����� ������ �ڸ��� ���� ���ؼ� �� �� 8�� ��� +1��
		Scanner sc = new Scanner(System.in);
		String[] strs = sc.nextLine().split(" ");
		
		int count = 0;
		if(strs[0].length()==strs[1].length()) {
			for(int i=0; i<strs[0].length(); i++) {
				if(strs[0].charAt(i)==strs[1].charAt(i)) {
					if(strs[0].charAt(i)=='8') count++;
				}else break;
			}
		}
		System.out.println(count);
		
		

	}

}
