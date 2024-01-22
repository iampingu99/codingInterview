package BruteForce.Permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6603 {

    public static StringBuilder sb = new StringBuilder();
    public static int K;
    public static int arr[];
    public static int S[];

    public static void combination(int depth, int base){
        if(depth == 6){
            for(int val : arr){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = base; i<K; i++){
            arr[depth] = S[i];
            combination(depth + 1, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if(K == 0) break;

            S = new int[K];
            arr = new int[6];
            for(int i = 0; i<K; i++){
                S[i] = Integer.parseInt(st.nextToken());
            }
            combination(0, 0);
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
