import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

public class Main {
    static int[] board = new int[101];
    static int[] visited = new int[101];
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 게임판 초기화 및 뱀, 사다리 값 입력
        for (int i = 1; i <= 100; i++) {
            board[i] = i;
        }
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            board[start] = end;
        }
        // System.out.println(Arrays.toString(board));

        // 정답 출력
        System.out.println(bfs());
    }
    
    public static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        visited[1] = 0;
        q.add(1);
        // int[] initIdx = { 1, 2, 3, 4, 5, 6 };
        // q.add(initIdx);

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 1; i <= 6; i++) {
                int next = now + i;
                next = board[next];
                if (next > 100) {
                    continue;
                }
                if (visited[next] == 0 && next != 1) {
                    visited[next] = visited[now] + 1;
                    q.add(next);
                }
                if (next == 100) {
                    return visited[100];
                }
                    
                
            }
            // System.out.println("cnt: " + cnt);
            // for (int[] item : q) {
            //     System.out.println("item: " + Arrays.toString(item));
            // }
            // cnt++;
            // int[] nowIdx = q.poll();
            // int[] nextIdx = new int[6];
            // for (int i = 0; i < 6; i++) {
            //     int nowValue = board[nowIdx[i]];
            //     visited[nowValue] = cnt;
            //     int nextValue = nowValue + 6;
            //     if (nextValue >= 100) {
            //         return cnt;
            //     } else {
            //         nextIdx[i] = nowValue + 6;
            //     }
            // }
            // q.add(nextIdx);
        }
        return -1;
    }
}

/**
첫 번째 문풀
*/
public class Main {
    static int[] board = new int[101];
    static int[] visited = new int[101];
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 게임판 초기화 및 뱀, 사다리 값 입력
        for (int i = 1; i <= 100; i++) {
            board[i] = i;
        }
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            board[start] = end;
        }
        // System.out.println(Arrays.toString(board));

        // 정답 출력
        System.out.println(bfs());
    }
    
    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        int[] initIdx = { 1, 2, 3, 4, 5, 6 };
        q.add(initIdx);

        while (!q.isEmpty()) {
            // System.out.println("cnt: " + cnt);
            // for (int[] item : q) {
            //     System.out.println("item: " + Arrays.toString(item));
            // }
            cnt++;
            int[] nowIdx = q.poll();
            int[] nextIdx = new int[6];
            for (int i = 0; i < 6; i++) {
                int nowValue = board[nowIdx[i]];
                visited[nowValue] = cnt;
                int nextValue = nowValue + 6;
                if (nextValue >= 100) {
                    return cnt;
                } else {
                    nextIdx[i] = nowValue + 6;
                }
            }
            q.add(nextIdx);
        }
        return cnt;
    }
}
