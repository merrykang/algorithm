import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 최소힙을 이용하기 위한 우선순위 큐 정의
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> {
                    int absA = Math.abs(a);
                    int absB = Math.abs(b);
                    // 절댓값이 같으면 수직선상 원래 값이 작은 수를, 그렇지 않은 경우 절댓값이 작은 수를 리턴
                    return absA == absB ? a - b : absA - absB;
                });

        // n줄에 걸쳐 우선순위 큐에 삽입 or sb에 정답을 append
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            // 배열이 비어 있는데 절댓값이 가장 작은 값을 출력하라고 하였으므로 0 출력
            // 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거
            if (x == 0)
                sb.append(pq.isEmpty() ? 0 : pq.poll()).append('\n');
            else
                pq.offer(x); // 배열에 x를 추가하여 정렬
        }
        System.out.println(sb);
    }
}

// import java.util.*;
// import java.io.*;

// public class Main {
// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// int n = Integer.parseInt(br.readLine());
// StringBuilder sb = new StringBuilder();

// // 최소힙을 이용하기 위한 우선순위 큐 정의
// PriorityQueue<Integer> pq = new PriorityQueue<>(
// (a, b) -> {
// int absA = Math.abs(a);
// int absB = Math.abs(b);
// // 절댓값이 같으면 수직선상 원래 값이 작은 수를, 그렇지 않은 경우 절댓값이 작은 수를 리턴
// return absA == absB ? a - b : absA - absB;
// }
// );

// // n줄에 걸쳐 우선순위 큐에 삽입 or sb에 정답을 append
// while (n-->0) {
// int x = Integer.parseInt(br.readLine());
// if (x==0) {
// if (pq.isEmpty()) sb.append(0+"\n"); // 배열이 비어 있는데 절댓값이 가장 작은 값을 출력하라고 하였으므로
// 0 출력
// else sb.append(pq.poll()+"\n"); // 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거
// } else {
// pq.offer(x); // 배열에 x를 추가하여 정렬
// }
// }
// System.out.println(sb);
// }
// }