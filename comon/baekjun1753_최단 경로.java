import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int to, wt;
    public Node (int to, int wt) {
        this.to = to;
        this.wt = wt;
    }

    // 우선순위 큐를 선언할 때 comparingInt를 사용하지 않기 위해 오버라이딩
    @Override
    public int compareTo(Node n) {
        return Integer.compare(this.wt, n.wt);
    }

    // 코드 짜며 콘솔 확인용
    // public String toString() {
    //     return "to: "+to+", "+"wt: "+wt;
    // }
}

public class Main {
    static int n;
    static int start;
    static List<List<Node>> graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        // 인접 리스트 초기화
        // 정점(노드)과 각 정점에 연결된 간선 정보 입력
        // 간선이 양방향이라는 근거가 없으므로 단방향으로 그래프 만들기
        graph = new ArrayList<>();
        for (int i=0; i<=n; i++) graph.add(new ArrayList<>());
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int wt = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, wt));
        }

        // 다익스트라 메서드 호출
        dijkstra();

        // 삼항 연산자 이용하여 최단 거리 출력
        for (int i=1; i<=n; i++) {
            System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
            // if (dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            // else System.out.println(dist[i]);
        }
    }

    public static void dijkstra() {
        // 최단거리 배열 만들고 초기화
        // 시작점을 제외하고, 가장 큰 정수로 초기화
        // 시작점의 거리는 0
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        // for (int i=1; i<=n; i++) dist[i] = Integer.MAX_VALUE;
        dist[start] = 0;

        // 우선순위 큐 선언
        // 최단 거리 배열에 업데이트 할 시작 큐 삽입
        // 시작 큐는 무엇으로 지정해야 하는지?
        // PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.wt));
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        // 최단 거리 업데이트
        // 이미 현재 원소(now)의 거리 > 최단 거리 배열에 업데이트 된 거리라면, 더이상 업데이트 하지 않아도 되므로 continue (방문 배열 대신 이 조건문 사용)
        // 그 외의 경우, graph를 돌며 최단 거리 업데이트
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int nowTo = now.to;
            int nowDist = now.wt;

            // System.out.println("now: "+now);

            if (nowDist > dist[nowTo]) continue;

            for (Node next : graph.get(nowTo)) {
                int newDist = nowDist + next.wt;
                if (dist[next.to] > newDist) {
                    dist[next.to] = newDist;
                    pq.add(new Node(next.to, newDist));
                }
            }
        }
    }
}

/**
 * 첫 번째 문풀
 */

// import java.util.*;
// import java.io.*;

class Edge {
    int to, wt;
    public Edge (int to, int wt) {
        this.to = to;
        this.wt = wt;
    }
    // public String toString() {
    //     return "to: "+to+", "+"wt: "+wt;
    // }
}

public class Main {
    static int n;
    static int start;
    static List<List<Edge>> graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // int n = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // int start = Integer.parseInt(br.readLine());
        start = Integer.parseInt(br.readLine());

        // 그래프 만들고 값 주입
        // 정점(노드)과 각 정점에 연결된 간선 주입
        // 간선이 양방향이라는 근거가 없으므로 단방향으로 그래프 만들기
        // List<List<Edge>> graph = new ArrayList<>();
        graph = new ArrayList<>();
        for (int i=0; i<=n; i++) graph.add(new ArrayList<>());
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int wt = Integer.parseInt(st.nextToken());
            // System.out.println("from: "+from+"to: "+to+"wt: "+wt);
            graph.get(from).add(new Edge(to, wt));
        }

        // 다익스트라 메서드 호출
        dijkstra();

        // 정답 출력
        for (int i=1; i<=n; i++) {
            if (dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }

    public static void dijkstra() {
        // 최단거리 배열 만들고 초기화
        // 시작점을 제외하고, 가장 큰 정수로 초기화
        // 시작점의 거리는 0
        // int[] dist = new int[n+1];
        dist = new int[n+1];
        for (int i=1; i<=n; i++) dist[i] = Integer.MAX_VALUE;
        dist[start] = 0;
        // System.out.println("dist: "+Arrays.toString(dist));

        // 우선순위 큐 선언
        // 최단 거리 배열에 업데이트 할 시작 큐 삽입
        // 시작 큐는 무엇으로 지정해야 하는지?
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.wt));
        pq.add(new Edge(start, 0));

        // 최단 거리 업데이트
        // 이미 현재 원소(now)의 거리 > 최단 거리 배열에 업데이트 된 거리라면, 더이상 업데이트 하지 않아도 되므로 continue (방문 배열 대신 이 조건문 사용)
        // 그 외의 경우, graph를 돌며 최단 거리 업데이트
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            int nowTo = now.to;
            int nowDist = now.wt;

            // System.out.println("now: "+now);

            if (nowDist > dist[nowTo]) continue;

            for (Edge next : graph.get(nowTo)) {
                // int newDist = nowDist + dist[nowTo];
                int newDist = nowDist + next.wt;
                // System.out.println("next: "+next);
                // System.out.println("newDist: "+newDist);
                if (dist[next.to] > newDist) {
                    dist[next.to] = newDist;
                    pq.add(new Edge(next.to, newDist));
                }
            }
        }
    }
}