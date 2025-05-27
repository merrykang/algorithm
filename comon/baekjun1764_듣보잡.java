import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 1. 듣도 못 한 사람을 TreeSet으로 받음
        Set<String> notHeard = new HashSet();
        while (n --> 0) {
            notHeard.add(br.readLine());
        }
        // 2. 듣도 보도 못 한 사람 찾기
        TreeSet<String> ans = new TreeSet<>();
        while (m-->0) {
            String name = br.readLine();
            if (notHeard.contains(name)) ans.add(name);
        }
        // 3. 정답 출력
        System.out.println(ans.size());
        for (String name : ans) System.out.println(name);
    }
}

// public class Main {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         int n = Integer.parseInt(st.nextToken());
//         int m = Integer.parseInt(st.nextToken());

//         // 1. 듣도 못 한 사람을 TreeMap으로 받음
//         TreeMap<String, Integer> notHeard = new TreeMap<>();
//         while (n --> 0) {
//             notHeard.put(br.readLine(), 0);
//         }
//         // 2. 듣도 보도 못 한 사람 찾기
//         TreeSet<String> ans = new TreeSet<>();
//         while (m-->0) {
//             String now = br.readLine();
//             if (notHeard.get(now) == null) continue;
//             else ans.add(now);
//         }
//         // 3. 정답 출력
//         System.out.println(ans.size());
//         for (String i : ans) System.out.println(i);
//     }
// }