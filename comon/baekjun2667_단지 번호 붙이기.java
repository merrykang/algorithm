// import java.util.*;
// import java.io.*;

// public class Main {
//     public static int n;
//     public static int[][] map;
//     public static boolean[][] visited;
//     public static List<Integer> housing = new ArrayList<>();
//     public static int houseCnt = 0;
//     public static int[] dx = {-1,1,0,0};
//     public static int[] dy = {0,0,-1,1};

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         // Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
//         // 아래처럼 br.readLine() 필요없는 부분에서 br.readLine() 을 호출하면 위와 같은 오류가 발생함
//         // StringTokenizer st = new StringTokenizer(br.readLine());
//         n = Integer.parseInt(br.readLine());
//         map = new int[n][n];
//         for (int i=0; i<n; i++) {
//             // Exception in thread "main" java.util.NoSuchElementException at java.base/java.util.StringTokenizer.nextToken(StringTokenizer.java:349)
//             // StringTokenizer는 기본적으로 공백을 기준으로 문자를 구분함
//             // 따라서 공백없이 입력이 주어진 경우 split으로 바로 배열로 만들든가,
//             // 아니면 문자 하나 하나를 처리할 수 있음
//             // StringTokenizer st = new StringTokenizer(br.readLine());
//             String line = br.readLine();
//             // for (int j=0; j<n; j++) map[i][j] = Integer.parseInt(st.nextToken(""));
//             // map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
//             for (int j=0; j<n; j++) map[i][j] = line.charAt(j) - '0';  // 문자 '0' → 정수 0
//         }
//         visited = new boolean[n][n];  // * 이 자체가 모든 값을 false로 초기화한 것
//         // System.out.println("visited: " + visited);
//         // 1. 이중 반복문 돌면서 dfs 호출
//         for (int i=0; i<n; i++) {
//             // 모든 (i, j)에 대해 무조건 dfs()를 호출하고 있음
//             // BUT 집이 있고(map[i][j] == 1) 방문하지 않은 경우만 탐색해야함
//             // 현재는 걍 dfs 호출하고 -> dfs 내부에서 visited 따짐. 
//             // 어쩐지 뭔가 dfs 호출 부분이 휑한 느낌이었음
//             // for (int j=0; j<n; j++) dfs(i, j);
//             for (int j=0; j<n; j++) {
//                 if(map[i][j]==1 && !visited[i][j]) {
//                     houseCnt = 1;  // houseCnt = 1로 시작하는 이유?
//                     visited[i][j] = true;
//                     dfs(i, j);
//                     housing.add(houseCnt);
//                 }
//             }
//         }
//         // 2. 정답 출력
//         int housingLen = housing.size();
//         // arrayList 정렬 방법
//         // 틀린 이유: 정렬 안 해서!, 
//         Collections.sort(housing);
//         System.out.println(housingLen);
//         for (int i=0; i<housingLen; i++) {
//             System.out.println(housing.get(i));
//         }
//     }

//     public static void dfs(int row, int col) {
//         // 상하좌우 돌면서 1이 있는지 판단
//         for (int i=0; i<4; i++) {
//             int curRow = row + dx[i];
//             int curCol = col + dy[i];
//             // 예외 처리: 지도를 벗어나면 이하 로직 수행하지 않음
//             if (curRow<0 || curCol<0 || curRow>n-1 || curCol>n-1) continue;
//             // 방문하지 않았다면
//             // 이 때 조건 검사하는건 curRow, curCol 인덱스 검사해야함
//             // 왜냐면 main 에서 row, col 인덱스는 이미 visited 따졌기 때문
//             if(map[curRow][curCol]==1 && !visited[curRow][curCol]) {
//                 visited[curRow][curCol] = true;
//                 // if (map[curRow][curCol] == 1) {
//                 houseCnt++;
//                 dfs(curRow, curCol);
//                 // }
//             }
//         }
//         // if (houseCnt == 0) {
//         //     housing.add(houseCnt);
//         //     return;
//         // }
//     }
// }
