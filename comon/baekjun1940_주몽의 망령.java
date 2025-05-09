// // 백준 문제임. 제목은 확인해봐야함

// import java.io.*;
// import java.util.*;

// public class Main {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());
//         int m = Integer.parseInt(br.readLine());
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         ArrayList<Integer> materials = new ArrayList<>();
//         while (n-- > 0) {
//             materials.add(Integer.parseInt(st.nextToken()));
//         }
//         // System.out.println("materials: "+ materials);

//         int ans = 0;
//         for (int material : materials) {
//             if (materials.contains(m-material)) {
//                 // System.out.println(m - material);
//                 ans++;
//             }
//         }
//         System.out.println(ans/2);  // 중복 제거
//     }
// }