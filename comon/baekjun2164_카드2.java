/**
 * 두 번째 문풀
 */
// import java.util.*;
// import java.io.*;

// public class Main {
//     public static void main(String[] args) throws IOException {
//         // 1. 입력 처리
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());

//         // 2. 큐 초기화
//         Queue<Integer> q = new LinkedList<>();  // 기본적인 큐 선언 문법
//         for (int i=1; i<=n; i++) q.offer(i);  // 반복문 돌며 1~n 자연수를 큐에 삽입

//         // 2. 큐를 돌며 카드 동작 반복
//         // 불필요한 flag 삭제: 걍 한 세트 반복 시, 한 번 버림 + 맨 뒤로 옮기기 수행하면 됨
//         // boolean isPolled = false;  // 카드를 바닥에 버렸는지 판단하는 flag
//         while (q.size() > 1) {
//             q.poll();
//             q.offer(q.poll());
//             // int current = q.poll();
//             // if(isPolled) {  // 이전에 카드를 바닥에 버렸음 = 현재에는 카드를 제일 밑으로 옮길 차례
//             //     q.offer(current);  // 현재 카드를 제일 밑으로 옮기고
//             //     isPolled = false;  // flag를 false로 수정하여 다음에는 카드를 바닥에 버릴 수 있도록 함
//             // } else isPolled = true;  // 현재 카드를 바닥에 버릴 차례: 이미 위에서 poll 했으므로 flag만 true로 수정
//         }
//         System.out.println(q.poll());  // 마지막 원소를 출력만 하고 제거할 필요는 없기 때문에 peek 사용
//     }
// }

/**
 * 첫 번째 문풀
 */
// import java.util.*;
// import java.io.*;

// public class Main {
//     public static void main(String[] args) throws IOException {
//         // 1. 반복문을 수행할 큐 선언
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());
//         Queue<Integer> q = new LinkedList<>();  // 기본적인 큐 선언 문법
//         for (int i=1; i<=n; i++) q.offer(i);  // 반복문 돌며 1~n 자연수를 큐에 삽입

//         // 2. 큐를 돌며 카드 동작 반복
//         boolean isPolled = false;  // 카드를 바닥에 버렸는지 판단하는 flag
//         while (q.size() > 1) {
//             int current = q.poll();
//             if(isPolled) {  // 이전에 카드를 바닥에 버렸음 = 현재에는 카드를 제일 밑으로 옮길 차례
//                 q.offer(current);  // 현재 카드를 제일 밑으로 옮기고
//                 isPolled = false;  // flag를 false로 수정하여 다음에는 카드를 바닥에 버릴 수 있도록 함
//             } else isPolled = true;  // 현재 카드를 바닥에 버릴 차례: 이미 위에서 poll 했으므로 flag만 true로 수정
//         }
//         System.out.println(q.poll());  // 마지막 원소 출력
//     }
// }