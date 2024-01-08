package BruteForce.NM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15654 {

    public static StringBuilder sb = new StringBuilder();
    public static int N, M;
    public static int arr[];
    public static boolean visited[];
    public static int base[];

    public static void permutation(int depth){
        if(depth == M){
            for(int val : arr){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i = 0; i<N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            arr[depth] = base[i];
            permutation(depth + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        base = new int[N];
        arr = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            base[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(base);
        permutation(0);
        System.out.println(sb);
    }
}
