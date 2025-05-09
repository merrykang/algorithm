// public class baekjun7568_덩치 {
    
// }

// /**
//  * 두 번째 문풀
//  */
// import java.util.*;
// import java.io.*;

// public class Main {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());
        
//         /**개선: Comparator를 사용하여 정렬한 후 순위를 계산하는 방식으로 변경 > 시간 복잡도가 O(NlogN)으로 줄어듦*/
//         StringTokenizer st;
//         // 1. 몸무게, 키 값 받기
//         // int[][] bodys = new int[n][2];  // 2차원 배열 자료 받기
//         List<int[]> bodys = new ArrayList<>();  // 2차원 배열 자료 받기: List 내에 배열을 받을 수 있다. 직접 원소 접근 하기 위해 배열 및 List 사용함
//         for(int i=0; i<n; i++) {
//             st = new StringTokenizer(br.readLine());
//             // bodys[i][0] = Integer.parseInt(st.nextToken());
//             // bodys[i][1] = Integer.parseInt(st.nextToken());
//             int w = Integer.parseInt(st.nextToken());
//             int h = Integer.parseInt(st.nextToken());
//             bodys.add(new int[]{w, h, i});  // 인덱스를 함께 저장 > 이 문법 무엇인지 정리
//         }

//         // 2. 몸무게 내림차순, 키 내림차순 정렬
//         bodys.sort((a, b) -> {
//             if (a[0]==b[0]) return b[1] - a[1];  // 몸무게 같으면 키 내림차순
//             return b[0] - a[0]; // 기본적으로 몸무게 내림차순
//         });

//         // 3. 순위 계산
//         // int cnt = 0;
//         int[] ranks = new int[n];
//          for (int i=0; i<n; i++) {
//             // cnt = 0;
//             int rank = 1;  // cnt+1 처럼 1 더해서 add 하지 말고 초기값을 1로 두기
//             // System.out.println(bodys[i]);  // 이렇게 출력했을 때 자료 위차 값만 나오는 이유?
//             for (int j=0; j<n; j++) {
//                 if (bodys.get(i)[0] < bodys.get(j)[0] && bodys.get(i)[1] < bodys.get(j)[1]) rank++;  // 기준 키가 현재 값의 키보다 작으면 카운트 (몇 번째 덩치인지 카운트)
//                 // if(bodys[i][0] < bodys[j][0] && bodys[i][1] < bodys[j][1]) cnt++;
//             }
//             ranks[bodys.get(i)[2]] = rank;  // 원래 인덱스 위치에 순위 값을 저장
//             // sb.append(cnt+1+" ");
//         }

//         // 4. 결과 출력
//         StringBuilder sb = new StringBuilder();
//         for (int rank:ranks) sb.append(rank+" ");
//         System.out.println(sb);
//     }
// }

// /**
//  * 첫 번째 문풀
//  */
// import java.util.*;
// import java.io.*;

// public class Main {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());
//         StringTokenizer st;
//         // List<Integer, Integer> bodys = new ArrayList<>();  // 인수 2개를 List에 저장할 수 없음
//         // String[] bodys = new String[n];
//         // 1. 몸무게, 키 값 받기
//         int[][] bodys = new int[n][2];  // 2차원 배열 자료 받기
//         for(int i=0; i<n; i++) {
//             st = new StringTokenizer(br.readLine());
//             bodys[i][0] = Integer.parseInt(st.nextToken());
//             bodys[i][1] = Integer.parseInt(st.nextToken());
//         }
//         // System.out.println("bodys:" + Arrays.deepToString(bodys));

//         // 2. 1번째 값 꺼내서 2차원 배열 순회 
//         int cnt = 0;
//         StringBuilder sb = new StringBuilder();
//         for (int i=0; i<n; i++) {
//             cnt = 0;
//             // System.out.println(bodys[i]);  // 이렇게 출력했을 때 자료 위차 값만 나오는 이유?
//             for (int j=0; j<n; j++) {
//                 if(bodys[i][0] < bodys[j][0] && bodys[i][1] < bodys[j][1]) cnt++;
//             }
//             sb.append(cnt+1+" ");
//         }
//         System.out.println(sb);
//     }
// }