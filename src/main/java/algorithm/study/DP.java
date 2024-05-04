package algorithm.study;

/**
 * 동적 계획법
 * - 작은 문제들을 풀면서 그 결과를 저장해 나아가면서 전체 문제 해결
 *
 * 조건
 * - 최적 부분 구조(작은 문제의 최적해를 이용하여 큰 문제의 최적해 구함)
 * - 중복 부분 문제(작은 문제를 해결할 때 반복적으로 같은 문제 해결)
 */
public class DP {
    static int[] dp = new int[100];

    public static void main(String[] args) {
        int n = 7;
        System.out.println("TopDown example: fibonacci(" + n + "): " + TopDown_fib(n));
        System.out.println("BottomUp example: fibonacci(" + n + "): " + BottomUp_fib(n));
    }

    /**
     * Top-Down 방식
     * - 재귀적으로 호출하여 문제를 해결하는 방식
     * - 작은 문제들의 결과값을 저장하여 동일한 계산을 반복하지 않음
     */
    public static int TopDown_fib(int n) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = TopDown_fib(n - 1) + TopDown_fib(n - 2);
        return dp[n];
    }

    /**
     * Bottom-Up 방식
     * - 작은 문제부터 해결하여 큰 문제까지 해결하는 알고리즘 방식
     * - 이전에 계산한 부분 문제의 결과를 저장해두고 나중에 같은 부분 문제가 나타날 때 다시 계산하지 않고 저장된 값 사용
     * - 재귀 방식이 아닌 반복문을 통해서 해결
     */
    public static int BottomUp_fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n];
    }
}
