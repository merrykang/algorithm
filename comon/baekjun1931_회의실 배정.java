// import java.util.*;
// import java.io.*;

// public class Main {
//     public static int[][] times;
//     public static boolean[] visited;
//     public static void main(String[] args) throws IOException {
//         // 1. 입력값 받기
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());
//         times = new int[n][2];
//         for (int i=0; i<n; i++) {
//             StringTokenizer st = new StringTokenizer(br.readLine());
//             times[i][0] = Integer.parseInt(st.nextToken());
//             times[i][1] = Integer.parseInt(st.nextToken());
//         }

//         // 2. 종료 시간 오름 차순 -> 시작 시간 오름 차순 정렬
//         // 내림 차순이면 b를 앞에다가 적으면 됨
//         Arrays.sort(times, (a, b) -> {
//             if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
//             else return Integer.compare(a[0], b[0]);
//         });

//         // 3. 최대 회의 개수 구하기
//         int ans = 1;  // 첫 회의는 선택
//         int end = times[0][1];  // 첫 회의 종료 시간으로 초기화
//         for (int j=1; j<n; j++) {
//             if (times[j][0] >= end) {  // 회의 종료 시간이 현재 회의 시작시간보다 느리거나 같으면
//                 end = times[j][1];  // 종료 시간을 현재 회의 종료 시간으로 갱신
//                 ans++;  // 회의 개수 카운트
//             }
//         }
//         System.out.println(ans);
//     }
// }
// import java.util.*;
// import java.io.*;

// public class Main {
//     public static int[][] times;
//     public static boolean[] visited;
//     public static void main(String[] args) throws IOException {
//         // 1. 입력값 받기
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());
//         times = new int[n][2];
//         for (int i=0; i<n; i++) {
//             StringTokenizer st = new StringTokenizer(br.readLine());
//             for (int j=0; j<2; j++) times[i][j] = Integer.parseInt(st.nextToken());
//         }

//         // 2. 정렬
//         // Arrays.sort(times, (a, b) -> Integer.compare(a[1], b[1]));  // 문법 정리해야함 + 내림차순까지
//         Arrays.sort(times, (a, b) -> {
//             if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
//             else return Integer.compare(a[0], b[0]);
//         });
//         System.out.println("times: "+Arrays.deepToString(times));

//         int ans = 1;
//         int i =0;
//         int end = times[0][1];

//         for (int j=i+1; j<n; j++) {
//             if (times[j][0] >= end) {
//                 end = times[j][1];
//                 ans++;
//             }
//         }
//         System.out.println(ans);
//     }
// }
// import java.util.*;
// import java.io.*;

// public class Main {
//     public static int[][] times;
//     public static boolean[] visited;
//     public static void main(String[] args) throws IOException {
//         // 1. 입력값 받기
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());
//         times = new int[n][2];
//         for (int i=0; i<n; i++) {
//             StringTokenizer st = new StringTokenizer(br.readLine());
//             for (int j=0; j<2; j++) times[i][j] = Integer.parseInt(st.nextToken());
//         }

//         // 2. 정렬
//         Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));  // 문법 정리해야함 + 내림차순까지
//         // System.out.println("times: "+Arrays.deepToString(times));

//         // 3. dfs 호출
//         int cnt;
//         int ans = 0;
//         int end;
//         for (int i=0; i<n; i++) {
//             cnt  = 1;
//             end = times[i][1];
//             for (int j=i+1; j<n; j++) {
//                 if (times[j][0] < end) continue;
//                 else {
//                     cnt++;
//                     end = times[j][1];
//                 }
//             }
//             ans = Math.max(ans, cnt);
//         }
//         System.out.println(ans);
//     }
// }

// import java.util.*;
// import java.io.*;

// public class Main {
//     public static int[][] times;
//     public static boolean[] visited;
//     public static void main(String[] args) throws IOException {
//         // 1. 입력값 받기
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());
//         times = new int[n][2];
//         for (int i=0; i<n; i++) {
//             StringTokenizer st = new StringTokenizer(br.readLine());
//             for (int j=0; j<2; j++) times[i][j] = Integer.parseInt(st.nextToken());
//         }

//         // 2. 정렬
//         Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));  // 문법 정리해야함 + 내림차순까지
//         System.out.println("times: "+Arrays.deepToString(times));

//         // 3. dfs 호출
//         visited = new boolean[n];
//         int cnt;
//         int ans = 0;
//         for (int i=0; i<n; i++) {
//             cnt = 1;
//             if (!visited[i]) {
//                 visited[i] = true;
//                 int res = dfs(cnt, times[i][1]);
//                 System.out.println("res: "+res);
//                 ans = Math.max(ans, res);
//             }
//         }
//         System.out.println(ans);
//     }
//     public static int dfs(int cnt, int end) {
//         for(int i=0; i<times.length; i++) {
//             if(!visited[i] && end <= times[i][1]) {
//                 cnt++;
//                 visited[i] = true;
//                 dfs(cnt, times[i][1]);
//             }
//         }
//         return cnt;
//     }
// }