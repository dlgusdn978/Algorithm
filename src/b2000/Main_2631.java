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
		
		// dp 배열을 사용하여 LIS의 길이를 구한다.
        int[] dp = new int[n];
        int lengthOfLIS = 0;
        
        for (int i = 0; i < n; i++) {
            int pos = lowerBound(dp, lengthOfLIS, arr[i]);
            dp[pos] = arr[i];
            if (pos == lengthOfLIS) {
                lengthOfLIS++;
            }
        }
        // 최소로 옮겨야 하는 아이의 수는 전체 아이의 수 - LIS의 길이
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
