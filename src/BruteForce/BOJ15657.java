package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15657 {

    public static StringBuilder sb = new StringBuilder();
    public static int N,M;
    public static int[] base;
    public static int[] arr;

    public static void duplicatePermutationASC(int depth, int r){
        if(depth == M){
            for(int val : arr){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = r; i<N; i++){
            arr[depth] = base[i];
            duplicatePermutationASC(depth+1, i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        base = new int[N];
        arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            base[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(base);
        duplicatePermutationASC(0, 0);
        System.out.println(sb);
    }
}
