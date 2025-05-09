

// import java.io.*;
// import java.util.*;

// public class Main {

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         int n = Integer.parseInt(st.nextToken());
//         int m = Integer.parseInt(st.nextToken());
//         Map<String, String> info = new HashMap<>();
//         while (n-->0) {
//             st = new StringTokenizer(br.readLine());
//             String site = st.nextToken();
//             String pwd = st.nextToken();
//             info.put(site, pwd);
//         }
//         // System.out.println("info"+info);
//         //2. 정답 출력
//         StringBuilder sb = new StringBuilder();
//         while(m-->0) {
//             sb.append(info.get(br.readLine())+'\n');
//         }
//         System.out.println(sb);
//     }
// }
