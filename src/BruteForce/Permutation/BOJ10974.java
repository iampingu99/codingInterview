package BruteForce.Permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10974 {

    public static StringBuilder sb = new StringBuilder();
    public static int N;
    public static int arr[];
    public static boolean visited[];

    public static void permutation(int depth){
        if(depth == N){
            for(int val : arr){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = 1; i<=N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            arr[depth] = i;
            permutation(depth + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        visited = new boolean[N+1];

        permutation(0);

        System.out.println(sb);
    }

}
