package BruteForce.Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9095 {

    public static StringBuilder sb = new StringBuilder();
    public static int T,N;
    public static int count;

    public static int relationRecursion(int n){
        if(n == 1 || n == 2) return n; //1 , 11 2
        if(n == 3) return 4; //111 21 12 3
        return relationRecursion(n-1) + relationRecursion(n-2) + relationRecursion(n-3);
    }

    public static void recursion(int n){
        if(n == 0) count = 0;
        if(n > N) return;
        if(n == N){
            count++;
            return;
        }
        recursion(n + 1);
        recursion(n + 2);
        recursion(n + 3);
    }

    public static void backTracking(int n){
        if(n == 0) count = 0;
        if(n == N) {
            count++;
            return;
        }

        for(int i = 1; i<=3; i++){
            if(n > N) return;
            backTracking(n + i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        while(T-->0){
            N = Integer.parseInt(br.readLine());
//            recursion(0);
//            sb.append(count).append('\n'); //재귀함수 사용

//            backTracking(0);
//            sb.append(count).append('\n'); //백트래킹 사용
            sb.append(relationRecursion(N)).append('\n'); //점화식 재귀함수 사용
        }

        System.out.println(sb);
    }
}
