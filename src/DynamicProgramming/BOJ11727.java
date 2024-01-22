package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11727 {

    public static int N;
    public static int dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[1001];

        dp[1] = 1;
        dp[2] = 3;

        for(int i = 4; i<=N; i++){
            dp[i] = (dp[i-1] + (dp[i-2] * 2)) % 10007;
        }

        System.out.println(dp[N]);
    }
}
