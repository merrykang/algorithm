// // public class baekjun2606_바이러스 {
    
// // }

// /**
//  *  3차 문풀
//  *  cnt 계산 방식 주의할 것!
//  * 
//  */

//  import java.io.*;
// import java.util.*;

// /**
//  * index out of bounds 뜸. 왜?
//  * 후보는 graph랑 visited밖에 없음
//  * 
//  */
// public class Main {
//     static List<List<Integer>> graph = new ArrayList<>();
//     static boolean[] visited;
//     // static int cnt=0;
    
//     public static void main(String[] args) throws IOException {
//         // 1. 변수 선언
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st;
//         int num = Integer.parseInt(br.readLine());
//         int chain = Integer.parseInt(br.readLine());
//         visited = new boolean[num+1]; // num을 그대로 넣을거니까 인덱스 + 1개 크기만큼 필요
//         for (int i=0; i<=num; i++) graph.add(new ArrayList<>());

//         // 2. 양쪽으로 간선 추가
//         while (chain -- > 0) {
//             st = new StringTokenizer(br.readLine());
//             int a= Integer.parseInt(st.nextToken());
//             int b= Integer.parseInt(st.nextToken());
//             graph.get(a).add(b);
//             graph.get(b).add(a);
//         }

//         // 3. 탐색 시작 (핵심 로직)
//         // int ans = dfs(1);
//         System.out.println(dfs(1)-1);
//     }

//     public static int dfs(int node) {
//         int cnt = 1;
//         visited[node] = true;
//         for (int next : graph.get(node)) {
//             if (!visited[next]) {
//                 // cnt++; 
//                 cnt += dfs(next);  // 결국 하나의 깊이마다 탐색이 끝났을 때 cnt가 더해지는 것임
//             }
//         }
//         return cnt;
//     }
// }

// /**
//  * 2차 문풀
//  */

// /**
//  * index out of bounds 뜸. 왜?
//  * 후보는 graph랑 visited밖에 없음
//  * 
//  */
// // public class Main {
// //     static List<List<Integer>> graph = new ArrayList<>();
// //     static boolean[] visited;
// //     static int cnt=0;
    
// //     public static void main(String[] args) throws IOException {
// //         // 1. 변수 선언
// //         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// //         StringTokenizer st;
// //         int num = Integer.parseInt(br.readLine());
// //         int chain = Integer.parseInt(br.readLine());
// //         visited = new boolean[num+1]; // num을 그대로 넣을거니까 인덱스 + 1개 크기만큼 필요
// //         for (int i=0; i<=num; i++) graph.add(new ArrayList<>());

// //         // 2. 양쪽으로 간선 추가
// //         while (chain -- > 0) {
// //             st = new StringTokenizer(br.readLine());
// //             int a= Integer.parseInt(st.nextToken());
// //             int b= Integer.parseInt(st.nextToken());
// //             graph.get(a).add(b);
// //             graph.get(b).add(a);
// //         }

// //         // 3. 탐색 시작 (핵심 로직)
// //         int ans = dfs(1);
// //         System.out.println(ans);
// //     }

// //     public static int dfs(int node) {
// //         visited[node] = true;
// //         for (int next : graph.get(node)) {  // 현재 노드를 인덱스로 연결된 컴퓨터를 찾고
// //             if (!visited[next]) {  // 그 컴퓨터가 방문하지 않은 것이라면
// //                 cnt++;  // 개수 체크
// //                 dfs(next);  // 그 컴퓨터를 다음 노드로 dfs 탐색 시작
// //             }
// //         }
// //         return cnt;
// //     }
// // }

// /**
//  * 1차 문풀
//  * 
//  * index out of bounds 뜸. 왜?
//  * 후보는 graph랑 visited밖에 없음 : graph
//  * 
//  * 아예 틀림. 왜?  A. 양방향 그래프(간선)인데 한 방향만 저장됨
//  * > Q. 그런데 (2, 5) 연결이 체크 되면 (5,2) 연결은 체크할 필요 없는거 아니야? 굳이 체크해야해? 
//  * > A. (2,5)만 추가하면 graph.get(5)에는 2가 없어서 탐색이 끊길 가능성이 있음. 즉, dfs(5)가 실행될 때 2로 돌아갈 길이 존재하지 않음!
//  * > 또한 양방향 추가해도 비효율적이지 않음: (2,5)와 (5,2) 둘 다 저장해도, 중복 탐색은 발생하지 않음. "이미 탐색한 노드"는 visited[] 배열이 걸러줌
//  * > 걍 양방향 탐색은 둘 다 값 할당한다고 외우기
//  * > GPT: 그래프에서 "무방향"일 때는 항상 graph.get(a).add(b)와 graph.get(b).add(a)를 모두 추가하는 것이 원칙!
//  * 
//  */
// // public class Main {
// //     static List<List<Integer>> graph = new ArrayList<>();  // Q. 왜 타입을 arrayList로 선언하지 않는지?  A. 필요할 때 List에서 LinkedList, ArrayList로 쉽게 변경 가능. 즉 인터페이스로 선언하면 코드 유지 보수성 높아짐
// //     static boolean[] visited;
// //     static int cnt=0;
// //     public static void main(String[] args) throws IOException {
// //         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// //         StringTokenizer st;
// //         int num = Integer.parseInt(br.readLine());
// //         int chain = Integer.parseInt(br.readLine());
// //         visited = new boolean[num+1]; // num을 그대로 넣을거니까 인덱스 + 1개 크기만큼 필요

// //         // 간선 추가
// //         for (int i=0; i<=num; i++) graph.add(new ArrayList<>());
// //         while (chain -- > 0) {
// //             st = new StringTokenizer(br.readLine());
// //             int a= Integer.parseInt(st.nextToken());
// //             int b= Integer.parseInt(st.nextToken());
// //             // graph.add(new ArrayList<>());
// //             graph.get(a).add(b);
// //             graph.get(b).add(a);
// //         }
// //         System.out.println("graph: "+graph);

// //         // 탐색 시작
// //         int ans = dfs(1);
// //         System.out.println(ans);  // System.out.println(dfs(1)); 하면 리턴되는 수마다 출력해서 너무 많이 출력됨
// //     }

// //     public static int dfs(int node) {
// //         // int ans = 0;
// //         visited[node] = true;
// //         System.out.println("탐색 순서: "+ node);
// //         for (int next : graph.get(node)) {
// //             if (!visited[next]) {
// //                 cnt++;  // Q. 왜 여기에 ++ 입력하면 답이 2인지 A. 계속 ans 가 초기화됨
// //                 dfs(next);
// //             }
// //         }
// //         return cnt;
// //     }
// // }