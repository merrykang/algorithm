/**
 * 세 번째 문풀: 코드 깔끔하게 쓰기
 */

import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[][] map, distance;
    public static boolean[][] visited;  // 방문 여부 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        distance = new int[n][m];
        visited = new boolean[n][m];
        int startX = -1; int startY = -1;  // 걍 초기화 이렇게 고급지게 하기

        // map에 데이터 입력 받기 
        // 목표 지점 발견하면 인덱스 저장
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                int cur = Integer.parseInt(st.nextToken());
                map[i][j] = cur;
                if (cur == 2) {
                    startX = i; startY = j;
                }
            }
        }

        // bfs 호출하여 목표 지점부터 탐색
        bfs(startX, startY);

        // 최단 거리 배열 원소를 출력 형식으로 바꾸기
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (!visited[i][j] && map[i][j]==1) sb.append("-1 ");
                else sb.append(distance[i][j]+" ");
            }
            sb.append("\n");  // 하나의 행 다 돌고 줄 바꿈 append 하면 깔끔
        }
        System.out.print(sb);
    }

    public static void bfs(int x, int y) {  // 주석에서 목표 지점이라는 것을 밝혔으니 매개 변수는 얌전하게 가자
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        // 시작 지점 원소 큐에 담고, 방문 처리
        q.add(new int[]{x, y});  // 탐색 대상 원소 큐에 담기
        visited[x][y] = true;  // 목표 지점 원소는 방문한 것으로 침
        distance[x][y] = 0;

        // 최단 거리 구하기
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0]; int cy = cur[1];  // (cx, cy) 와 (nx, ny) 짝꿍 맞추기 위해 설정
            for (int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (0<=nx && nx<n && 0<=ny && ny<m) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        distance[nx][ny] = distance[cur[0]][cur[1]] + 1;
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;  // 현재 원소는 맨 처음 target 포함해서 이미 방문 처리 된 것이므로, (nx, ny)를 방문 처리 해야함. 이 때 map[nx][ny] = 0 이면 방문 처리할 필요 없으므로 방문 처리 할 필요 있는 위치에서만 확실하게 !
                    }
                }
            }
        }
    }
}

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
