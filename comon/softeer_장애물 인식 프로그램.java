// /**
//  * 세번째 문풀
//  */
// import java.io.*;
// import java.util.*;

// public class Main {
//     static boolean[][] visited;;
//     /**
//         제거. 재귀 함수의 리턴 값을 곧바로 blockSizes에 추가
//         > 이유: 재귀 호출마다 전역 변수를 수정하는 방식은 버그 발생 가능성이 증가하고 함수의 독립성이 약해지기 때문
//     */
//     // static int blockSize = 0;
//     static int[] dx = {-1,1,0,0};  // 상하좌우 탐색
//     static int[] dy = {0,0,-1,1};
//     static int n;
//     static int[][] map;
    
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         n = Integer.parseInt(br.readLine());
//         map = new int[n][n];
//         visited = new boolean[n][n];

//         // 1. map에 값 입력 받기
//         for (int i=0; i<n; i++) {
//             String[] tempMap = br.readLine().split("");  // 공백 없이 주어지는 입력 처리
//             for (int j=0; j<n; j++) map[i][j] = Integer.parseInt(tempMap[j]);  
//         }

//         // 2. 돌면서 재귀 함수 호출: n^2으로 완전 꼼꼼히 돌면서 호출
//         List<Integer> blockSizes = new ArrayList<>();
//         for (int i=0; i<n; i++) {
//             for (int j=0; j<n; j++) {
//                 if(map[i][j]==1 && !visited[i][j]) {// 새로운 블록을 발견한 경우
//                     // blockSize = 0;
//                     // dfs(i, j);
//                     // blockSizes.add(blockSize);  // 블록 크기 저장
//                     blockSizes.add(dfs(i, j));  // 블록 크기 저장
//                 }
//             }
//         }
        
//         // 3. 정답 출력
//         Collections.sort(blockSizes);
//         System.out.println(blockSizes.size());  // 블록 개수 출력
//         for (int size : blockSizes) System.out.println(size);  // 블록 내 장애물 개수 출력
//     }

//     // public static void dfs(int x, int y) {
//     public static int dfs(int x, int y) {
//         // 1. 종료 조건: 이미 방문한 곳이라면 종료
//         // if(visited[x][y]) return;
//         // 2. 현재 상태 처리: 방문 체크 및 블록 크기 증가
//         visited[x][y] = true;
//         int size = 1;  // 현재 위치 포함한 블록 크기 (초기값 1)
//         // blockSize++;
//         // 3. 다음 상태 호출: 4방향 탐색
//         for (int i=0; i<4; i++) {
//             // 배열 범위 체크 & 방문 체크 & 장애물(1)인지 확인
//             int nx = x + dx[i];
//             int ny = y + dy[i];
//             if (nx>=0 && nx <n && ny>=0 && ny<n && !visited[nx][ny] && map[nx][ny]==1) size += dfs(nx, ny);
//         }
//         return size;
//     }
// }



/**
 * 두 번째 문풀
 */
// import java.io.*;
// import java.util.*;

// public class Main {
//     static boolean[][] visited;;
//     static int blockSize = 0;
//     static int[] dx = {-1,1,0,0};  // 배열 선언 및 초기화가 동시에 이루어질 때에는 대괄호가 아니라 중괄호!
//     static int[] dy = {0,0,-1,1};
//     static int n;
//     static int[][] map;
    
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         n = Integer.parseInt(br.readLine());  // dfs 에서 쓰게 static 변수로 선언
//         /** Q. 사방 탐색 위한 크기를 마련해야 하나?
//             A. n+2로 크기를 늘리는 것은 필요하지 않다.
//             현재 코드에서 map의 크기를 [n+2][n+2]로 설정한 이유는 사방 탐색 시 경계를 벗어나는 것을 방지하기 위해 여유 공간을 두는 것으로 보임.
//             하지만 이 방법은 불필요하며, 일반적인 경계 체크 방식을 사용하는 것이 더 적절함.
//             > 따라서 배열 크기를 [n][n]으로 변경 ([n+2][n+2] 필요 없음)
//             > 경계 체크를 0 ≤ nx < n 방식으로 수정
//             > map[i+1][j+1] 대신 map[i][j]를 직접 사용하여 인덱싱 일관성 유지
//         */
//         // map = new int[n+2][n+2];
//         map = new int[n][n];
//         // visited = new boolean[n+2][n+2];
//         visited = new boolean[n][n];

//         // 1. map에 값 입력 받기
//         for (int i=0; i<n; i++) {
//             String[] tempMap = br.readLine().split("");
//             for (int j=0; j<n; j++) {
//                 /** Q. java.util.NoSuchElementException: br.readLine()을 호출했을 때, 해당 줄에 n개의 숫자가 포함되지 않았을 경우
//                     Q. nextToken() 으로 split 되지 않는 경우일까?
//                     A. yes. StringTokenizer는 기본적으로 공백(띄어쓰기, 탭 등)을 기준으로 토큰을 나누기 때문에, 연속된 숫자로 된 문자열(1110111)을 st.nextToken()으로 파싱하면 오류가 발생할 수 있어.
//                     > 입력값은 공백 없이 주어졌기 때문에 st.nextToken() 에서 위와 같은 오류가 발생했던 것
//                 */
//                 map[i][j] = Integer.parseInt(tempMap[j]);  
//             }
//         }

//         // 2. 돌면서 재귀 함수 호출: n^2으로 완전 꼼꼼히 돌면서 호출
//         // dfs(1,1);
//         // while (cx<=n && cy<=n) {
//         //     dfs(cx, cy);  // Q. 어떻게 호출해야 하지?
//         // }
//         // System.out.println("blockSize: "+blockSize);
//         /**
//             Q. 7: dfs 한 번 돌린거야. 그럼 이걸 몇번 반복 해야해?
//             A. 결국 map(지도)의 각 원소를 돌면서 조건 따져야해
//         */
//         List<Integer> blockSizes = new ArrayList<>();
//         for (int i=0; i<n; i++) {
//             for (int j=0; j<n; j++) {
//                 // if(map[i+1][j+1]==1 && !visited[i+1][j+1]) {// 새로운 블록을 발견한 경우
//                 if(map[i][j]==1 && !visited[i][j]) {// 새로운 블록을 발견한 경우
//                     blockSize = 0;
//                     dfs(i, j);
//                     /**
//                         Q. 왜 7,5,1,1,1 이런 식으로 추가되지?
//                         A. 범위를 잘못 설정했기 때문. 첫 번째 문풀 때 n+2개씩 한 변에 두었으므로 0=< ~ =<n까지 포함되도록 해야함
//                     */
//                     blockSizes.add(blockSize);  // 블록 크기 저장
//                 }
//             }
//         }
//         // 3. 정답 출력
//         Collections.sort(blockSizes);
//         System.out.println(blockSizes.size());  // 블록 개수 출력
//         for (int size : blockSizes) System.out.println(size);  // 블록 내 장애물 개수 출력
//     }

//     public static void dfs(int x, int y) {
//         // 1. 종료 조건: 이미 방문한 곳이라면 종료
//         if(visited[x][y]) return;
//         // 2. 현재 상태 처리: 방문 체크 및 블록 크기 증가
//         visited[x][y] = true;
//         blockSize++;
//         // 3. 다음 상태 호출: 4방향 탐색
//         for (int i=0; i<4; i++) {
//             // 배열 범위 체크 & 방문 체크 & 장애물(1)인지 확인
//             int nx = x + dx[i];
//             int ny = y + dy[i];
//             /**
//                 Q. 범위가 이렇게 되는 이유?
//                 A. 첫 번째 문풀 시에는 n+2를 하나의 변으로 두었으므로 0 ~ n을 경계를 포함해서 범위로 두었어야 함(그림 그리기)
//                 > 그러나 두 번째 문풀 때는 n을 하나의 변으로 두었으므로 0 ~ n-1을 경계를 포함해서 범위로 두었어야 함
//             */
//             // if (nx>=0 && nx <= n && ny>=0 && ny<=n && !visited[nx][ny] && map[nx][ny]==1) dfs(nx, ny);
//             if (nx>=0 && nx <n && ny>=0 && ny<n && !visited[nx][ny] && map[nx][ny]==1) dfs(nx, ny);
//         }
//     }
// }


/**
 * 첫 번째 문풀
 */
// import java.io.*;
// import java.util.*;

// public class Main {
//     static boolean[][] visited;;
//     static int blockSize = 0;
//     static int blockNum = 0;
//     static int[] dx = {-1,1,0,0};
//     static int[] dy = {0,0,-1,1};
//     static int n;
//     static int[][] map;
    
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         // StringTokenizer st = new StringTokenizer(br.readLine());
//         n = Integer.parseInt(br.readLine());  // dfs 에서 쓰게 static 변수로 선언
//         // int n = Integer.parseInt(st.nextToken());
//         map = new int[n+2][n+2];  // 사방 탐색 위한 크기를 마련해야 하나?  // dfs 에서 쓰게 static 변수로 선언
//         visited = new boolean[n+2][n+2];  // 사방 탐색 위한 크기를 마련해야 하나?  // dfs 에서 쓰게 static 변수로 선언

//         // 1. map에 값 입력 받기
//         for (int i=0; i<n; i++) {
//             // StringTokenizer st = new StringTokenizer(br.readLine());
//             String[] tempMap = br.readLine().split("");
//             for (int j=0; j<n; j++) {
//                 // java.util.NoSuchElementException: br.readLine()을 호출했을 때, 해당 줄에 n개의 숫자가 포함되지 않았을 경우
//                 // nextToken() 으로 split 되지 않는 경우일까?
//                 map[i+1][j+1] = Integer.parseInt(tempMap[j]);  
//             }
//         }

//         // 2. 돌면서 재귀 함수 호출: n^2으로 완전 꼼꼼히 돌면서 호출
//         // dfs(1,1);
//         // while (cx<=n && cy<=n) {
//         //     dfs(cx, cy);  // Q. 어떻게 호출해야 하지?
//         // }
//         // System.out.println("blockSize: "+blockSize);  // 7: dfs 한 번 돌린거야. 그럼 이걸 몇번 반복 해야해?
//         List<Integer> blockSizes = new ArrayList<>();
//         for (int i=0; i<n; i++) {
//             for (int j=0; j<n; j++) {
//                 if(map[i+1][j+1]==1 && !visited[i+1][j+1]) {// 새로운 블록을 발견한 경우
//                     blockSize = 0;
//                     dfs(i+1, j+1);
//                     blockSizes.add(blockSize);  // 블록 크기 저장 // 왜 7,5,1,1,1 이런 식으로 추가되지?
//                 }
//             }
//         }
//         // 3. 정답 출력
//         // System.out.println("blockSizes: "+blockSizes);
//         Collections.sort(blockSizes);
//         System.out.println(blockSizes.size());  // 블록 개수 출력
//         for (int size : blockSizes) System.out.println(size);  // 블록 내 장애물 개수 출력
        
//     }

//     public static void dfs(int x, int y) {
//         // 1. 종료 조건: 이미 방문한 곳이라면 종료
//         if(visited[x][y]) return;
//         // 2. 현재 상태 처리: 방문 체크 및 블록 크기 증가
//         visited[x][y] = true;
//         blockSize++;
//         // 3. 다음 상태 호출: 4방향 탐색
//         for (int i=0; i<4; i++) {
//             // 배열 범위 체크 & 방문 체크 & 장애물(1)인지 확인
//             int nx = x + dx[i];
//             int ny = y + dy[i];
//             // 범위가 이렇게 되는 이유 체크 해야함
//             if (nx>=0 && nx <= n && ny>=0 && ny<=n && !visited[nx][ny] && map[nx][ny]==1) dfs(nx, ny);
//         }
//     }
// }