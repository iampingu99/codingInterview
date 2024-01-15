package BruteForce.Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1248 {

    public static int N;
    public static char c[][]; //입력으로 주어지는 문자
    public static int arr[]; //결과

    public static void permutation(int depth){
        if(depth == N){
            for(int val : arr){
                System.out.print(val + " ");
            }
            System.exit(0);
        }

        for(int i = -10; i<=10; i++){
            arr[depth] = i;
            if(check(depth)) {
                permutation(depth + 1);
            }
        }
    }

    public static boolean check(int depth){
        int sum = 0;
        for(int i = depth; i>=0; i--){
            sum += arr[i];
            if(c[i][depth] == '+' && sum <= 0) return false;
            else if(c[i][depth] == '-' && sum >= 0) return false;
            else if(c[i][depth] == '0' && sum != 0) return false;
        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        c = new char[N][N];
        arr = new int[N];

        String line = br.readLine();
        int index = 0;
        for(int i = 0; i<N; i++){
            for(int j = i; j<N; j++){
                c[i][j] = line.charAt(index++);
            }
        }
        permutation(0);
    }
}
