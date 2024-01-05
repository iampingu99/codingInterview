package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649 {

    public static StringBuilder sb;
    public static boolean[] visited;
    public static int[] arr;

    public static void sequence(int depth, int n, int m){
        if(depth == m){
            for(int i = 0; i<m; i++){
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i = 0; i<n; i++){
            if(visited[i]) continue;
            visited[i] = true;
            arr[depth] = i+1;
            sequence(depth+1, n, m);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N];

        sequence(0, N, M);
        System.out.println(sb);
    }
}
