// import java.util.*;
// import java.io.*;

// public class Main {
//     static int n;
//     static int m;
//     static int[][] scores;
//     static boolean[][] visited;
//     static int cnt = 0;
//     static int ans = Integer.MIN_VALUE;
//     // 상하좌우: 현재 좌표 (x, y)를 기준으로 상하좌우로 한 칸 이동할 때의 "변화량"
//     static int[] dx = {-1,1,0,0};  
//     static int[] dy = {0,0,-1,1};

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         n = Integer.parseInt(st.nextToken());
//         m = Integer.parseInt(st.nextToken());
//         visited = new boolean[n][m];
//         scores = new int[n][m];
//         for (int i=0; i<n; i++) {
//             st = new StringTokenizer(br.readLine());
//             for (int j=0; j<m; j++) scores[i][j] = Integer.parseInt(st.nextToken());
//         }
//         // 완전 탐색(dfs)
//         for (int i=0; i<n; i++) {
//             for (int j=0; j<m; j++) {
//                 visited[i][j] = true;  // 현재 위치 (i, j)를 방문했다고 표시하여 dfs 중복 방문을 방지
//                 // 이 좌표를 시작점으로 테트로미노 모양을 만들기 위해 깊이 4까지 탐색
//                 // 현재 행과 열 | 처음 사방 탐색 시작하니까 sum은 현재 사각형의 수 | 처음 사방 탐색 시작하니까 현재 탐색한 사각형 개수
//                 dfs(i, j, scores[i][j], 1);  
//                 // 다음 위치에서 처음부터 4개 도형 따져야 하므로 방문 상태 초기화
//                 // 즉 탐색이 끝났으므로 다른 시작점에서도 이 칸을 쓸 수 있도록 복구!
//                 visited[i][j] = false;  
//             }
//         }
//         System.out.println(ans);
//     }

//     public static void dfs(int row, int col, int sum, int cnt) {  // 매개 변수 이렇게 선언하는 이유: sum은 dfs 호출하면서 누적합 구해서 최댓값 구할 때 쓸 것임, cnt는 4개이면 리턴해야 해서 필요
//         // 종료 조건: 4개 사각형 탐색한 경우, 점수 최댓값을 계산하고 종료
//         if (cnt==4) {
//             ans = Math.max(ans, sum);  // score에 해당하는 sum을 dfs 호출하면서 바로 계산하고 리턴해버림. 즉 dfs 내에서만 사용하기 때문에 별도로 변수 선언할 필요는 없음
//             return;
//         }
//         // 상하좌우 탐색: 이 반복문과 '현재 row와 col 선언'은 세트
//         for (int i=0; i<4; i++) {
//             int curRow = row + dx[i];
//             int curCol = col + dy[i];
//             // 예외: 범위 벗어난 경우 다음 로직 수행X
//             if (curRow < 0 || curRow >= n || curCol < 0 || curCol >= m) continue;
//             if (!visited[curRow][curCol]) {  // 이미 row, col에 대한 visited 배열 체크는 main 에서 호출할 때 수행했으므로 현재는 curRow, curCol만 체크하면 됨
//                 // 보라색 테트로미노인 경우: 갈림길에서 한 번 더 dfs 호출해주어야함
//                 visited[curRow][curCol] = true;
//                 if (cnt == 2) dfs(row, col, sum+scores[curRow][curCol], cnt+1);
//                 dfs(curRow, curCol, sum+scores[curRow][curCol], cnt+1);
//                 visited[curRow][curCol] = false;
//             }
//         }
//     }
// }


// import java.util.*;
// import java.io.*;

// public class Main {
//     static int n;
//     static int m;
//     static int[][] scores;
//     static boolean[][] visited;
//     static int cnt = 0;
//     static int ans = Integer.MIN_VALUE;
//     // 상하좌우: 현재 좌표 (x, y)를 기준으로 상하좌우로 한 칸 이동할 때의 "변화량"
//     static int[] dx = {-1,1,0,0};  
//     static int[] dy = {0,0,-1,1};

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         n = Integer.parseInt(st.nextToken());
//         m = Integer.parseInt(st.nextToken());
//         visited = new boolean[n][m];
//         scores = new int[n][m];
//         for (int i=0; i<n; i++) {
//             st = new StringTokenizer(br.readLine());
//             for (int j=0; j<m; j++) scores[i][j] = Integer.parseInt(st.nextToken());
//         }
        
//         for (int i=0; i<n; i++) {
//             for (int j=0; j<m; j++) {
//                 visited[i][j] = true;  
//                 dfs(i, j, scores[i][j], 1);  // 현재 행과 열 | 처음 사방 탐색 시작하니까 sum은 현재 사각형의 수 | 처음 사방 탐색 시작하니까 현재 탐색한 사각형 개수
//                 visited[i][j] = false;  // 다음 위치에서 처음부터 4개 도형 따져야 하므로 방문 상태 초기화
//             }
//         }
//         System.out.println(ans);
//     }

//     public static void dfs(int row, int col, int sum, int cnt) {  // 매개 변수 이렇게 선언하는 이유: sum은 dfs 호출하면서 누적합 구해서 최댓값 구할 때 쓸 것임, cnt는 4개이면 리턴해야 해서 필요
//         // 종료 조건: 4개 사각형 탐색한 경우, 점수 최댓값을 계산하고 종료
//         if (cnt==4) {
//             ans = Math.max(ans, sum);  // score에 해당하는 sum을 dfs 호출하면서 바로 계산하고 리턴해버림. 즉 dfs 내에서만 사용하기 때문에 별도로 변수 선언할 필요는 없음
//             return;
//         }
//         // 상하좌우 탐색: 이 반복문과 '현재 row와 col 선언'은 세트
//         for (int i=0; i<4; i++) {
//             // 현재 row와 col 선언
//             int curRow = row + dx[i];
//             int curCol = col + dy[i];
//             // 예외: 범위 벗어난 경우 다음 로직 수행X
//             if (curRow < 0 || curRow >= n || curCol < 0 || curCol >= m) continue;
//             if (!visited[curRow][curCol]) {  // 이미 row, col에 대한 visited 배열 체크는 main 에서 호출할 때 수행했으므로 현재는 curRow, curCol만 체크하면 됨
//                 // 보라색 테트로미노인 경우: 갈림길에서 한 번 더 dfs 호출해주어야함
//                 // 아래 로직이 보라색 테트로미노가 아닌 경우의 로직과 중복되는듯 보임
//                 // 그러나 양자는 재귀 호출 위치가 5다름: count == 2일 때는 solve(row, col, ...) → 원래 좌표 고정한채로 상하좌우 탐색하는 수 더하기 / 그 외에는 solve(curRow, curCol, ...) → 이동하면서 탐색
//                 if (cnt == 2) {
//                     visited[curRow][curCol] = true;
//                     dfs(row, col, sum+scores[curRow][curCol], cnt+1);
//                     visited[curRow][curCol] = false;
//                 }
//                 visited[curRow][curCol] = true;
//                 dfs(curRow, curCol, sum+scores[curRow][curCol], cnt+1);
//                 visited[curRow][curCol] = false;
//             }
//         }
//     }
// }
