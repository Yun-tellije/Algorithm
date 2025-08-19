import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        TreeSet<Problem> set = new TreeSet<>(((o1, o2) -> {
            if (o1.level == o2.level) {
                return o1.num - o2.num;
            }
            return o1.level - o2.level;
        }));
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            set.add(new Problem(p, l));
            map.put(p, l);
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if (s.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());

                if (x == 1) {
                    sb.append(set.last().num).append("\n");
                } else {
                    sb.append(set.first().num).append("\n");
                }
            } else if (s.equals("add")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());

                set.add(new Problem(p, l));
                map.put(p, l);
            } else if (s.equals("solved")) {
                int p = Integer.parseInt(st.nextToken());
                int l = map.get(p);

                set.remove(new Problem(p, l));
                map.remove(p);
            }
        }

        System.out.println(sb);
    }

    static class Problem {
        int num;
        int level;

        public Problem(int num, int level) {
            this.num = num;
            this.level = level;
        }
    }
}
