package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16194 {

    public static int N;
    public static int P[];
    public static int dp[];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        dp = new int[N+1];
        P = new int[N+1];
        for(int i = 1; i<=N; i++){
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i<=N; i++){
            dp[i] = P[i];
            for(int j = 1; j<=i; j++){
                dp[i] = Math.min(dp[i], dp[i-j] + P[j]);
            }
        }

        System.out.println(dp[N]);
    }
}
