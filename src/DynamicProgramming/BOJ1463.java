package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1463 {

    public static int N;
    public static Integer dp[];

    public static int topDown(int num){
        if(dp[num] == null) {
            if(num % 6 == 0) dp[num] = Math.min(topDown(num / 3), Math.min(topDown(num / 2), topDown(num - 1))) + 1;
            else if (num % 3 == 0) dp[num] = Math.min(topDown(num / 3), topDown(num - 1)) + 1;
            else if (num % 2 == 0) dp[num] = Math.min(topDown(num / 2), topDown(num - 1)) + 1;
            else dp[num] = topDown(num - 1) + 1;
        }
        return dp[num];
    }

    public static void bottomUp(){
        for(int i = 2; i<=N; i++){
            dp[i] = dp[i-1] + 1;
            if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
            if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new Integer[N+1];
        dp[0] = 0;
        dp[1] = 0;

//        System.out.println(topDown(N)); //topDown
        bottomUp();
        System.out.println(dp[N]); //bottomUP
    }
}
