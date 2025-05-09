

// import java.io.*;
// import java.util.*;

// public class Main {
//     static int n;
//     static int[][] graph;
//     static boolean[] visited;

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         n = Integer.parseInt(br.readLine());
//         graph = new int[n][n];

//         for (int i = 0; i < n; i++) {
//             StringTokenizer st = new StringTokenizer(br.readLine());
//             for (int j = 0; j < n; j++) {
//                 graph[i][j] = Integer.parseInt(st.nextToken());
//             }
//         }

//         StringBuilder sb = new StringBuilder();
//         for (int i = 0; i < n; i++) {
//             visited = new boolean[n];
//             dfs(i);  // i에서 시작해 모든 노드 방문
//             for (int j = 0; j < n; j++) {
//                 sb.append(visited[j] ? "1 " : "0 ");
//             }
//             sb.append("\n");
//         }

//         System.out.print(sb);
//     }

//     public static void dfs(int current) {
//         for (int next = 0; next < n; next++) {
//             if (graph[current][next] == 1 && !visited[next]) {
//                 visited[next] = true;
//                 dfs(next);
//             }
//         }
//     }
// }

// import java.util.*;
// import java.io.*;

// public class Main {
//     // static int[][] ans;
//     static int n;
//     static int[][] graph;
//     static boolean[] visited;
//     static boolean isRoad;
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st;
//         n = Integer.parseInt(br.readLine());
//         graph = new int[n][n];
//         for (int i=0; i<n; i++) {
//             st = new StringTokenizer(br.readLine());
//             for (int j=0; j<n; j++) graph[i][j] = Integer.parseInt(st.nextToken());
//         }
//         // System.out.println(Arrays.deepToString(graph));

//         // 1. bfs 호출: 정점 i에서 j로 가는 길이 있는지 체크
//         // ans = new int[n][n];
//         StringBuilder sb = new StringBuilder();
//         for (int i=0; i<n; i++) {
//             for (int j=0; j<n; j++) {
//                 visited = new boolean[n];  // 무한 재귀 호출 방지
//                 isRoad = false;
//                 dfs(i, j);
//                 sb.append(isRoad ? "1 " : "0 ");
//                 // System.out.println("isRoad: " +isRoad);
//                 // if (isRoad == true) sb.append(1+" ");
//                 // else sb.append(0+" ");
//             }
//             sb.append('\n');
//         }
//         System.out.println(sb);
//     }
//     /**
//      * StackOverflowError 런타임 에러 발생함
//      * 이유: 무한 재귀 호출
//      *  - 위 코드는 목적지에 도착하면 isRoad = true를 설정하지만, 그 다음 return 이후에도 다른 반복문 루프를 타고 다시 재귀 호출이 발생할 수 있어요
//      *  - 또한, 이미 방문한 노드를 재방문하는 "방문 체크"가 없음으로 인해 무한히 같은 노드를 반복 탐색 가능
//      */
//     /**
//      * i==j인 경우 항상 0이 되는 문제
//      * 이는 자기 자신으로의 경로 탐색을 DFS로 처리할 때 종종 발생함: gpt 보고 해결 방법 정리해
//      * 이러한 경우 때문에 워셜-플로이드 탐색? 해야함
//      */
//     public static void dfs (int row, int target) {  // column 보다는 찾는 값이므로 target이 보다 맞는 명칭
//         if (isRoad) return;  // 무한 재귀 호출 방지
//         visited[row] = true;
//         for (int j=0; j<n; j++) {
//             // System.out.println("row: "+row);
//             // System.out.println("column: "+column);
//             // System.out.println("j: "+j);
//             // System.out.println("graph[row][j]: "+graph[row][j]);
//             if (graph[row][j]==1 && !visited[j]) {  // 무한 재귀 호출 방지; 왜 next라고 표현?
//                 if(j==target) {
//                     // System.out.println("여기 들어옴");
//                     isRoad = true;
//                     return;
//                 }
//                 // } else {
//                 dfs(j, target);  // Q. j == target 이어도 호출? 왜?
//                 // }
//             }
//         }
//         // return;
//         // return false;
//     }
// }