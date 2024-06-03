package b25000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_25187 {
    static int[] parent;
    static int[] cleanCount;
    static int[] dirtyCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 물탱크의 수
        int m = Integer.parseInt(st.nextToken()); // 파이프의 수
        int q = Integer.parseInt(st.nextToken()); // 방문 횟수

        parent = new int[n + 1];
        cleanCount = new int[n + 1];
        dirtyCount = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            int waterType = Integer.parseInt(st.nextToken());
            if (waterType == 1) {
                cleanCount[i] = 1;
            } else {
                dirtyCount[i] = 1;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            union(u, v);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int k = Integer.parseInt(br.readLine());
            int root = find(k);
            if (cleanCount[root] > dirtyCount[root]) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.print(sb.toString());
    }

    static int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]); // path compression
        }
        return parent[x];
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootY] = rootX;
            cleanCount[rootX] += cleanCount[rootY];
            dirtyCount[rootX] += dirtyCount[rootY];
        }
    }
}