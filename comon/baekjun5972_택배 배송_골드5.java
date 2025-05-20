import java.util.*;
import java.io.*;

class Edge {
    int to, food;
    public Edge(int to, int food) {
        this.to = to;
        this.food = food;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 인접 리스트 그래프에 값 주입하기
        List<List<Edge>> graph = new ArrayList<>();
        for (int i=0; i<=n; i++) graph.add(new ArrayList<>());  // 노드(헛간) 수 만큼 리스트 만들기
        for (int i=0; i<m; i++) {  // 간선 수 만큼 돌면서
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int food = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Edge(end, food));  // 해당 노드에 연결된 간선의 끝, 가중치(비용)을 주입
            graph.get(end).add(new Edge(start, food));  // 양방향 처리 꼭 해야함
        }

        // 다익스트라 메서드 호출
        System.out.print(dijkstra(graph, n));
    }

    public static int dijkstra (List<List<Edge>> graph, int n) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.food));
        pq.add(new Edge(1, 0));

        // pq에 원소가 있을 동안 돌면서
        // 비용이 현재 dist에 저장된 값보다 크다면: 이미 최소 비용으로 dist에 업데이트 된 것이므로 continue
        // 작다면: 새로운 비용 값을 구해서 dist에 저장된 값과 비교하여 최소 비용 업데이트
        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            int now = cur.to;
            int cost = cur.food;

            if (cost > dist[now]) continue;

            for (Edge next : graph.get(now)) {
                int newCost = next.food + dist[now];
                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    pq.add(new Edge(next.to, newCost));
                }
            }
        }
        return dist[n];
    }
}
