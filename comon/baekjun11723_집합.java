/**
 * HashSet으로 풀이
 */

 public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Set<Integer> s = new HashSet<>();

        while (m-- > 0) {
            String[] cal = br.readLine().split(" ");
            String op = cal[0];
            if (op.equals("all")) {
                s = new HashSet<>();
                for (int i=1; i<=20; i++) s.add(i);
            } else if (op.equals("empty")){
                s = new HashSet<>();
            } else if (op.equals("add")) {
                int x = Integer.parseInt(cal[1]);
                s.add(x);
            } else if (op.equals("remove")) {
                int x = Integer.parseInt(cal[1]);
                s.remove(x);
            } else if (op.equals("toggle")) {
                int x = Integer.parseInt(cal[1]);
                if (s.contains(x)) s.remove(x);
                else s.add(x);
            } else {
                int x = Integer.parseInt(cal[1]);
                sb.append(s.contains(x) ? "1\n" : "0\n");
            }
        }
        System.out.println(sb);
    }
}

/**
 * 배열로 풀이
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
