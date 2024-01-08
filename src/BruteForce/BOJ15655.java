package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15655 {

    public static StringBuilder sb = new StringBuilder();
    public static int N, M;
    public static int base[];
    public static boolean visited[];

    public static void permutationASC(int depth, int r){
        if(depth == M){
            for(int i = 0; i<N; i++){
                if(visited[i]) sb.append(base[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = r; i<N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            permutationASC(depth + 1, i + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        base = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++){
            base[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(base);

        permutationASC(0, 0);

        System.out.println(sb);
    }
}
