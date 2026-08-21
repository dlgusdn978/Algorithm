package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1753 {
    static class Node implements Comparable<Node>{
        int end;
        int weight;
        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }


        @Override
        public int compareTo(Node o) {
            return this.weight-o.weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] VEInfo = br.readLine().split(" ");
        int v = Integer.parseInt(VEInfo[0]);
        int e = Integer.parseInt(VEInfo[1]);
        // 시작 정점 k
        int k = Integer.parseInt(br.readLine());

        List<Node>[] list = new List[v+1];
        for(int i=0; i<v+1; i++){
            list[i] = new ArrayList<Node>();
        }

        // 정점, 간선 정보
        for(int i=0; i<e; i++){
            String[] info = br.readLine().split(" ");
            int from = Integer.parseInt(info[0]);
            int to = Integer.parseInt(info[1]);
            int weight = Integer.parseInt(info[2]);

            list[from].add(new Node(to, weight));
        }
        // 초기화
        int[] distance = new int[v+1];
        boolean[] isVisited = new boolean[v+1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<Node>();

        // 시작 노드 설정
        pq.add(new Node(k, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(isVisited[cur.end]) continue;
            isVisited[cur.end] = true;
            // 현재 위치까지의 경로 비용 + 다음 지역까지의 간선 비용 < 다음 지역 최소 경로 비용 인 경우
            // 간선 비용 갱신
            for(Node next : list[cur.end]){
                if(distance[next.end] > distance[cur.end] + next.weight){
                    distance[next.end] = distance[cur.end] + next.weight;
                    // pq에 출발지로부터 next 정점까지의 누적 최단거리 정보 입력
                    pq.add(new Node(next.end, distance[next.end]));
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for(int i=1; i<v+1; i++){
            if(distance[i]==Integer.MAX_VALUE) sb.append("INF");
            else sb.append(distance[i]);

            sb.append("\n");
        }
        System.out.println(sb.toString().trim());

    }
}
