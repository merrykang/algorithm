/**
 * 두 번째 문풀: 틀렸다고 나옴
 * 원인: 원래 갈 수 있는 땅인 부분 중에서 도달할 수 없는 위치는 -1을 출력 한다는 문제를 꼼꼼히 안 읽음
 * 도달할 수 없는 땅은 사방이 0인 것: 카운트 해서 4이면 sb.append(-1)
 */

import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int m;
    public static int[][] map;
    public static int[][] distance;  // 최단 거리 배열
    public static boolean[][] visited;  // 방문 여부 배열
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        distance = new int[n][m];
        visited = new boolean[n][m];
        int[] target = new int[2];

        // map에 데이터 입력 받기 
        // 목표 지점 발견하면 인덱스 저장
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                int cur = Integer.parseInt(st.nextToken());
                map[i][j] = cur;
                if (cur == 2) {
                    target[0] = i;
                    target[1] = j;
                }
            }
        }

        // bfs 호출
        bfs(target[0], target[1]);

        // 최단 거리 배열 원소를 출력 형식으로 바꾸기
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (!visited[i][j] && map[i][j]==1) sb.append("-1 ");
                else sb.append(distance[i][j]+" ");
                if (j == m-1) sb.append("\n");
            }
        }
        System.out.print(sb);
    }

    public static void bfs(int tarX, int tarY) {
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        // 시작 지점 원소 큐에 담고, 방문 처리
        q.add(new int[]{tarX, tarY});  // 탐색 대상 원소 큐에 담기
        visited[tarX][tarY] = true;  // 목표 지점 원소는 방문한 것으로 침
        distance[tarX][tarY] = 0;

        // 최단 거리 구하기
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            // int cnt = 0;
            for (int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (0<=nx && nx<n && 0<=ny && ny<m) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        distance[nx][ny] = distance[cur[0]][cur[1]] + 1;
                        q.add(new int[]{nx, ny});
                    }
                    // } else if (!visited[nx][ny] && map[nx][ny] == 0) {  // 이 조건 쓰면 안 되는 이유 
                    //     cnt++;
                    // }
                    visited[nx][ny] = true;  // 현재 원소는 맨 처음 target 포함해서 이미 방문 처리 된 것이므로, (nx, ny)를 방문 처리 해야함
                }
            }
            // if (cnt == 4) distance[cur[0]][cur[1]] = -1;
        }
    }
}

/**
 * 첫 번째 문풀: 메모리 초과
 * 해결 방법1: visited[cur[0]]][cur[1]] = true; 이 아니라 visited[nx][ny] = true;
 * 해결 방법2: else distance[nx][ny] = 0; 삭제, 어차피 초기화는 0으로 되어서 값 업데이트 안 되면 0임
 */

public class Main {
    public static int n;
    public static int m;
    public static int[][] map;
    public static int[][] distance;  // 최단 거리 배열
    public static boolean[][] visited;  // 방문 여부 배열
    public static StringBuilder sb = new StringBuilder();
    // public static int[] dx = {-1,1,0,0};
    // public static int[] dy = {0,0,-1,1};
    // public static int[] target = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        distance = new int[n][m];
        visited = new boolean[n][m];
        int[] target = new int[2];

        // map에 데이터 입력 받기 
        // 목표 지점 발견하면 인덱스 저장
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                int cur = Integer.parseInt(st.nextToken());
                map[i][j] = cur;
                if (cur == 2) {
                    target[0] = i;
                    target[1] = j;
                }
            }
        }
        // System.out.println("map: "+Arrays.deepToString(map));
        // System.out.println("target: "+Arrays.toString(target));

        // bfs 호출
        bfs(target[0], target[1]);

        // 최단 거리 배열 원소를 출력 형식으로 바꾸기
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                sb.append(distance[i][j]+" ");
                if (j == m-1) sb.append("\n");
            }
        }
        System.out.print(sb);
    }

    public static void bfs(int tarX, int tarY) {
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        // 시작 지점 원소 큐에 담고, 방문 처리
        q.add(new int[]{tarX, tarY});  // 탐색 대상 원소 큐에 담기
        visited[tarX][tarY] = true;  // 목표 지점 원소는 방문한 것으로 침
        distance[tarX][tarY] = 0;

        // 최단 거리 구하기
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (0<=nx && nx<n && 0<=ny && ny<m) {
                    if (!visited[nx][ny]) {
                        if (map[nx][ny] == 1) {
                            distance[nx][ny] = distance[cur[0]][cur[1]] + 1;
                            q.add(new int[]{nx, ny});
                        } else distance[nx][ny] = 0;
                        visited[cur[0]][cur[1]] = true;
                    }
                }
            }
        }
    }
}
