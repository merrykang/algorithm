// import java.util.*;
// import java.io.*;

// // 3차원 좌표를 표현하는 클래스
// class Tomato {
//     int z, x, y;

//     public Tomato(int z, int x, int y) {
//         this.z = z;
//         this.x = x;
//         this.y = y;
//     }
// }

// public class Main {
//     static int m, n, h;
//     static int[][][] tomatoes;
//     static int[] dx = {-1, 1, 0, 0, 0, 0};
//     static int[] dy = {0, 0, -1, 1, 0, 0};
//     static int[] dz = {0, 0, 0, 0, -1, 1};
//     static Queue<Tomato> q = new LinkedList<>();

//     public static void main(String[] args) throws IOException {
//         // 입력
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         m = Integer.parseInt(st.nextToken());
//         n = Integer.parseInt(st.nextToken());
//         h = Integer.parseInt(st.nextToken());

//         tomatoes = new int[h][n][m];
//         for (int z = 0; z < h; z++) {
//             for (int x = 0; x < n; x++) {
//                 st = new StringTokenizer(br.readLine());
//                 for (int y = 0; y < m; y++) {
//                     int value = Integer.parseInt(st.nextToken());
//                     tomatoes[z][x][y] = value;
//                     if (value == 1) {
//                         q.add(new Tomato(z, x, y)); // 익은 토마토 위치 저장
//                     }
//                 }
//             }
//         }

//         // 결과 출력
//         System.out.println(bfs());
//     }

//     private static int bfs() {
//         while (!q.isEmpty()) {
//             Tomato t = q.poll();

//             for (int i = 0; i < dx.length; i++) {
//                 int nz = t.z + dz[i];
//                 int nx = t.x + dx[i];
//                 int ny = t.y + dy[i];

//                 if (inRange(nz, nx, ny) && tomatoes[nz][nx][ny] == 0) {
//                     tomatoes[nz][nx][ny] = tomatoes[t.z][t.x][t.y] + 1;
//                     q.add(new Tomato(nz, nx, ny));
//                 }
//             }
//         }

//         int max = 0;
//         for (int z = 0; z < h; z++) {
//             for (int x = 0; x < n; x++) {
//                 for (int y = 0; y < m; y++) {
//                     if (tomatoes[z][x][y] == 0) {
//                         return -1; // 하나라도 안 익은 토마토가 있으면 실패
//                     }
//                     max = Math.max(max, tomatoes[z][x][y]);
//                 }
//             }
//         }

//         return (max == 1) ? 0 : max - 1; // 초기 익은 토마토가 1이었으므로 -1
//     }

//     private static boolean inRange(int z, int x, int y) {
//         return 0 <= z && z < h && 0 <= x && x < n && 0 <= y && y < m;
//     }
// }

// import java.util.*;
// import java.io.*;

// // 큐에서 3차원 배열을 표현하기 위해 정의
// class PointXYZ {
//     int height;  //층
//     int row;  //행
//     int col;  //열

//     public PointXYZ(int z, int x, int y) {
//         this.height = z;
//         this.row = x;
//         this.col = y;
//     }
// }

// public class Main {
//     public static int m;
//     public static int n;
//     public static int h;
//     public static int[][][] tomatoes;
//     public static int[] dx = {-1,1,0,0,0,0};
//     public static int[] dy = {0,0,-1,1,0,0};
//     public static int[] dz = {0,0,0,0,-1,1};
//     public static Queue<PointXYZ> q = new LinkedList<>();
//     public static void main(String[] args) throws IOException {
//         // 1. 토마토 상자 익힘 정보 초기화
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         m = Integer.parseInt(st.nextToken());
//         n = Integer.parseInt(st.nextToken());
//         h = Integer.parseInt(st.nextToken());
//         tomatoes = new int[h][n][m];  // [층][행][열] 로 초기화
//         for (int k=0; k<h; k++) {  //층
//             for (int i=0; i<n; i++) {  //행
//                 st = new StringTokenizer(br.readLine());
//                 for (int j=0; j<m; j++) {  //열
//                     int cur = Integer.parseInt(st.nextToken());
//                     tomatoes[k][i][j] = cur;
//                     if (tomatoes[k][i][j] == 1) q.add(new PointXYZ(k, i, j));  // 익은 토마토의 층행열 정보를 큐에 추가
//                 }
//             }
//         }
//         // System.out.println(Arrays.deepToString(tomatoes));
//         // System.out.println(q);

//         // 2. bfs 호출
//         System.out.println(bfs());

//     }

//     private static int bfs() {
//         while(!q.isEmpty()) {
//             PointXYZ cur = q.poll();
//             int height = cur.height;
//             int row = cur.row;
//             int col = cur.col;
//             // System.out.println("height: "+height);
//             // System.out.println("row: "+row);
//             // System.out.println("col: "+col);

//             // 상하좌우위아래 탐색
//             for (int i=0; i<6; i++) {
//                 int curZ = height + dz[i];
//                 int curX = row + dx[i];
//                 int curY = col + dy[i];
//                 // System.out.println("curZ: "+curZ);
//                 if (curZ>=0 && curX>=0 && curY>=0 && curZ<h && curX<n && curY<m) {  // 토마토 상자 경계 내에 있는 토마토들만 유효
//                     // System.out.println("tomatoes[curZ][curX][curY]: "+tomatoes[curZ][curX][curY]);
//                     if (tomatoes[curZ][curX][curY] == 0) {  // 아직 익지 않은 토마토라면
//                         // System.out.println("tomatoes[curZ][curX][curY] == 0 들어옴");
//                         q.add(new PointXYZ(curZ, curX, curY));  // 큐에 추가하여 다음에 조건 검사
//                         tomatoes[curZ][curX][curY] = tomatoes[height][row][col]+1;  // 현재 토마토 값에 1 더함
//                     }
//                 }
//             }
//             // System.out.println("tomatoes: "+ Arrays.deepToString(tomatoes));
//         }
//         // tomatoes 배열의 최댓값 구하기
//         int ans = Integer.MIN_VALUE;
//         for (int k=0; k<h; k++) {  //층
//             for (int i=0; i<n; i++) {  //행
//                 for (int j=0; j<m; j++) {  //열
//                     // System.out.println("tomatoes[k][i][j]: "+tomatoes[k][i][j]);
//                     if (tomatoes[k][i][j] ==0) return -1;  // 익은 정도를 검사하였는데도 0이 있다면 익지 못 하는 토마토가 있는 것이므로 -1 리턴
//                     if (tomatoes[k][i][j] > ans) ans = tomatoes[k][i][j];
//                 }
//             }
//         }
//         if (ans == 1) return 0;  // 최댓값이 1이라면 이미 모두 익은 토마토였으므로 전부 익는데 걸린 일 수는 0일
//         else return ans - 1;
//     }
// }