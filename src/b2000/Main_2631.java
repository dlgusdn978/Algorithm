package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main_2631 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// dp �迭�� ����Ͽ� LIS�� ���̸� ���Ѵ�.
        int[] dp = new int[n];
        int lengthOfLIS = 0;
        
        for (int i = 0; i < n; i++) {
            int pos = lowerBound(dp, lengthOfLIS, arr[i]);
            dp[pos] = arr[i];
            if (pos == lengthOfLIS) {
                lengthOfLIS++;
            }
        }
        // �ּҷ� �Űܾ� �ϴ� ������ ���� ��ü ������ �� - LIS�� ����
        int result = n - lengthOfLIS;
        System.out.println(result);

	}
	private static int lowerBound(int[] dp, int length, int key) {
        int low = 0;
        int high = length;
        
        while (low < high) {
            int mid = (low + high) / 2;
            if (dp[mid] < key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        return low;
    }
}
