package algorithm.bruteforce;

public class S5_4673 {

    static boolean[] visit = new boolean[10001];

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 10000; i++) {
            selfNum(i);
        }

        for (int i = 1; i <= 10000; i++) {
            if (!visit[i]) {
                sb.append(i + "\n");
            }
        }

        System.out.println(sb);
    }

    static void selfNum(int n) {
        int sum = n;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        if (sum > 10000) {
            return;
        }

        if (!visit[sum]) {
            visit[sum] = true;
            selfNum(sum);
        }
    }
}
