

// import java.io.*;
// import java.util.*;

// public class Main {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());
//         // 티셔츠
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         int[] shirts = new int[6];
//         // for (int i=0; i<6; i++) shirts.add(Integer.parseInt(st.nextToken()));
//         for (int i=0; i<6; i++) shirts[i] = Integer.parseInt(st.nextToken());
//         st = new StringTokenizer(br.readLine());
//         int t = Integer.parseInt(st.nextToken());
//         int p = Integer.parseInt(st.nextToken());
//         int tBundle = 0;
//         for (int i=0; i<6; i++) {
//             // int sNum = Integer.parseInt(st.nextToken());
//             if (shirts[i] % t == 0) tBundle += shirts[i] / t;
//             else tBundle += (shirts[i] / t + 1);
//         }
//         System.out.println(tBundle);
//         System.out.println(n/p+" "+n%p);
//     }
// }