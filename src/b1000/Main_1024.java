package b1000;

import java.util.Scanner;

public class Main_1024 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        sc.close();
        
        for (int length = l; length <= 100; length++) {
            int start = n / length - (length - 1) / 2;
            if (start < 0) continue;
            
            int sum = length * (2 * start + length - 1) / 2;
            if (sum == n) {
                for (int i = 0; i < length; i++) {
                    System.out.print((start + i) + " ");
                }
                System.out.println();
                return;
            }
        }
        
        // 적절한 수열을 찾지 못한 경우
        System.out.println(-1);

	}

}
