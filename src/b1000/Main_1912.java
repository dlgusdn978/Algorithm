package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1912 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];
        dp[1] = arr[1]; // ù ��° ���ҷ� �ʱ�ȭ

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]); // ���� ���Ҹ� �����ϴ� ���� ���� ���� �κ��տ��� �̾ �ϴ� ��� �� ū ���� ����
        }

        int maxSum = dp[1];
        for (int i = 2; i <= n; i++) {
            if (maxSum < dp[i]) {
                maxSum = dp[i];
            }
        }

        System.out.println(maxSum);
    }
}