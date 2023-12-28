package Math;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2609 {

    /**
     * 재귀함수를 사용한 최대 공약수
     */
    public static int recursiveGCD(int a, int b){
        int r = a % b;
        if(r != 0) return recursiveGCD(b, r);
        else return b;
    }

    /**
     * 반복문을 사용한 최대 공약수
     */
    public static int interactiveGCD(int a, int b){
        int r;
        while((r = a % b) != 0){
            a = b;
            b = r;
        }
        return b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int gcd = A > B ? interactiveGCD(A, B) : interactiveGCD(B, A);
        int lcm = A * B / gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }
}
