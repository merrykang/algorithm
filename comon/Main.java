import java.util.*;
import java.io.*;

/**
 * Exception in thread "main" java.util.NoSuchElementException
 * 
 */
public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        boolean[] s = new boolean[21];  // 1<=x<=20

        while (m-- > 0) {
            String[] cal = br.readLine().split(" ");
            String op = cal[0];
            if (op.equals("all")) {  // 숫자가 있는 것을 true
                for (int i=1; i<=20; i++) s[i] = true;
            } else if (op.equals("empty")){  // 숫자가 없는 것을 false로 표현
                for (int i=1; i<=20; i++) s[i] = false;
            } else if (op.equals("add")) {
                int x = Integer.parseInt(cal[1]);
                s[x] = true;
            } else if (op.equals("remove")) {
                int x = Integer.parseInt(cal[1]);
                s[x] = false;
            } else if (op.equals("toggle")) {
                int x = Integer.parseInt(cal[1]);
                s[x] = !s[x];  // s[x]의 flag를 거꾸로 표현
            } else {
                int x = Integer.parseInt(cal[1]);
                sb.append(s[x] ? "1\n" : "0\n");
            }
        }
        System.out.println(sb);
    }
}

// import java.util.*;
// import java.io.*;

// public class Main {
// public static int ans = 0; // 이렇게 public static 으로 선언한 변수들이 효율적인지도 따져서 정리해야
// 할듯
// public static boolean[][] visited;
// public static int[][] maze;
// public static int[] dx = {-1,1,0,0};
// public static int[] dy = {0,0,-1,1};
// public static Queue<int[]> q = new LinkedList<>();
// public static int n;
// public static int m;

// public static void main(String[] args) throws IOException {
// // 1. 2차원 배열 그래프 입력 받기
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// StringTokenizer st = new StringTokenizer(br.readLine());
// n = Integer.parseInt(st.nextToken());
// m = Integer.parseInt(st.nextToken());
// visited = new boolean[n][m];
// maze = new int[n][m];
// for (int i=0; i<n; i++) { // 공백 없는 문자열 입력 주의
// // st = new StringTokenizer(br.readLine());
// String line = br.readLine();
// for (int j=0; j<m; j++) maze[i][j] = line.charAt(j) - '0'; // 정수 0 빼면 안 됨
// }
// // System.out.println(Arrays.deepToString(maze));

// // 2. bfs 호출
// System.out.println(bfs(0,0));
// }

// public static int bfs(int startX, int startY) { // 리턴 조건 좀 더 빨리 작성해야 하나? 언제
// 리턴해야 하지?
// q.offer(new int[]{startX, startY});
// visited[startX][startY] = true;

// while(!q.isEmpty()) {
// int[] curr = q.poll();
// int x = curr[0];
// int y = curr[1];
// for (int i=0; i<4; i++) {
// int nx = x+dx[i];
// int ny = y+dy[i];
// if (nx>=0 && ny>=0 && nx<n && ny<m) { // 인덱스 주의
// if (!visited[nx][ny] && maze[nx][ny] == 1) {
// visited[nx][ny] = true;
// // ans++; // 이건 단순 방문 횟수를 세는 것. 거리를 누적해야 함
// maze[nx][ny] = maze[x][y] + 1;
// q.offer(new int[]{nx, ny});
// }
// }
// }
// }
// return maze[n-1][m-1];
// // return ans;
// }
// }

// import java.util.*;
// import java.io.*;

// public class Main {
// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// StringTokenizer st = new StringTokenizer(br.readLine());
// int n = Integer.parseInt(st.nextToken());
// int m = Integer.parseInt(st.nextToken());

// // 1. 포켓몬 도감 정보를 (인덱스, 명칭)의 쌍으로 map으로 받기
// Map<Integer, String> poketmons = new HashMap<>();
// Map<String, Integer> reversePoketmons = new HashMap<>();
// for (int i=1; i<=n; i++) {
// String temp = br.readLine();
// poketmons.put(i, temp); // map에는 add 메서드가 없고 put만 있다!
// reversePoketmons.put(temp, i);
// }
// System.out.println(reversePoketmons);

// // 2. 포켓몬의 번호 또는 이름 출력
// for (int i=0; i<m; i++) {
// String poketmon = br.readLine();
// int isNum = isNumeric(poketmon);
// int foundKey = -1;
// if(isNum != 0) System.out.println(poketmons.get(isNum));
// else {
// // 맵에서 값으로 인덱스 찾는 방법
// // Q. 시간 초과 줄이는 방법?
// // for (Map.Entry<Integer, String> entry : poketmons.entrySet()) {
// // if (entry.getValue().equals(poketmon)) {
// // foundKey = entry.getKey();
// // break;
// // }
// // }
// System.out.println(reversePoketmons.get(poketmon));
// }
// }
// }

// public static int isNumeric(String str) {
// try {
// return Integer.parseInt(str);
// } catch (NumberFormatException e) {
// return 0;
// }
// }
// }

// import java.util.*;
// import java.io.*;

// public class Main {
// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// StringTokenizer st = new StringTokenizer(br.readLine());
// int n = Integer.parseInt(st.nextToken());
// int m = Integer.parseInt(st.nextToken());

// // 1. 나무 높이 배열 입력 받기
// st = new StringTokenizer(br.readLine());
// int[] trees = new int[n];
// for (int i=0; i<n; i++) trees[i] = Integer.parseInt(st.nextToken());

// // 2. 배열 평균 구하여 탐색
// long avg = Math.round(Arrays.stream(trees).average().orElse(0));
// // System.out.println(avg);
// }
// }

// import java.util.*;
// import java.io.*;

// public class Main {
// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// int n = Integer.parseInt(br.readLine());

// for (int i=1; i<=n; i++) {
// int temp = i;
// String iStr = String.valueOf(i);
// for (int j=0; j<iStr.length(); j++) temp += iStr.charAt(j) - '0';
// if (n==temp) {
// System.out.println(i);
// return;
// }
// }
// System.out.println(0);
// }
// }

/**
 * 백준 11659 두 수의 합
 */

// import java.util.*;
// import java.io.*;

// public class Main {
// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// StringTokenizer st = new StringTokenizer(br.readLine());
// int n = Integer.parseInt(st.nextToken());
// int m = Integer.parseInt(st.nextToken());
// String[] nums = br.readLine().split(" ");

// // 2. 누적 합 구하기
// int[] cumulSum = new int[n];
// for (int i=0; i<n; i++) {
// if(i==0) cumulSum[i] = Integer.parseInt(nums[i]); // 인덱스 에러 방지: 더 간단히 할 수 있는
// 방법 있나?
// else cumulSum[i] = cumulSum[i-1] + Integer.parseInt(nums[i]);
// }
// // System.out.println("cumulSum: "+Arrays.toString(cumulSum));

// // 3. a번째 수부터 b번째 수까지 합을 출력
// while (m-->0) {
// st = new StringTokenizer(br.readLine());
// int a = Integer.parseInt(st.nextToken()) - 1; // 인덱스화 시켜줌
// int b = Integer.parseInt(st.nextToken()) - 1;
// if (a==0) System.out.println(cumulSum[b]); // 예외 1: 첫 번째 수부터 합을 구해야 한다면:
// b(누적합 구해야 하는 끝)의 위치에 있는 값이 답
// else if (a==b) System.out.println(cumulSum[b] - cumulSum[b-1]); // 예외 1: 시작과
// 끝이 같다면: 그 자리 값 - 그 전 자리 값이 답
// else System.out.println(cumulSum[b] - cumulSum[a-1]); // 일반: 끝 값 - 시작의 전 값
// }
// }
// }