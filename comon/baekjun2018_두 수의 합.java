/**
 * 투포인터로 풀기
 */
// import java.util.*;
// import java.io.*;

// public class Main {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());

//         // int start=1;
//         // Q. 왜 자기 자신을 포함하는 카운트는 세지 않아?
//         int cnt=0;  // 자기 자신을 카운트 하는 횟수는 포함하고 시작
//         int sum=1; 
//         int start=1; // 투포인터 구조상 start와 end 가 있어야 하는 것 같음
//         int end=1;  

//         while(end<=n) {  // end 포인터가 n을 넘지 않는 동안 수행
//             if (sum<n) {
//                 end++;
//                 sum+=end;  // 현재 end 값을 sum에 추가
//             } else if (sum>n) {
//                 sum -= start; // start 값을 sum에서 제거하고 다음 탐색 진행
//                 start++;
//             } else {  // sum==n인 경우
//                 cnt++;
//                 sum -= start;  // start 값을 sum에서 제거하고 다음 탐색 진행
//                 start++;
//             }
//         }
//         System.out.println(cnt);

//         // for (int i=1; i<n; i++) {  // 다시 2부터 시작 안 해서 문제
//         //     System.out.println("sum: "+sum);
//         //     for (int j=i; j<n; j++) {
//         //         sum+=j;
//         //         if(sum==n) {
//         //             cnt++;
//         //             sum=0;
//         //             break;
//         //             // start+=1;
//         //         } else if (sum>n) {
//         //             sum=0;
//         //             break;
//         //             // start+=1;
//         //         }
//         //     }
//         // }
//         // System.out.println(cnt);
//     }
// }

// import java.util.*;
// import java.io.*;

// public class Main {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());

//         /**
//          * 아래 코드는 투포인터로 풀지 않아 시간 초과 발생
//          */
//         // int start=1;
//         int cnt=1;  // 자기 자신을 카운트 하는 횟수는 포함하고 시작
//         int sum=0;  
//         for (int i=1; i<n; i++) {  // 다시 2부터 시작 안 해서 문제
//             System.out.println("sum: "+sum);
//             for (int j=i; j<n; j++) {
//                 sum+=j;
//                 if(sum==n) {
//                     cnt++;
//                     sum=0;
//                     break;
//                     // start+=1;
//                 } else if (sum>n) {
//                     sum=0;
//                     break;
//                     // start+=1;
//                 }
//             }
//         }
//         System.out.println(cnt);
//     }
// }