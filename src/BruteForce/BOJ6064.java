package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(y == M) y = 0;

            int i;
            for(i = x; i <= lcm(N, M) ; i+= N){
                if(i % M == y) {
                    System.out.println(i);
                    break;
                }
            }
            if(i > lcm(N, M)) System.out.println("-1");
        }
    }

    public static int lcm(int a, int b){
        return a * b / gcd(a, b);
    }

    public static int gcd(int a, int b){
        int r;
        while((r = a % b) != 0){
            a = b;
            b = r;
        }
        return b;
    }
}
